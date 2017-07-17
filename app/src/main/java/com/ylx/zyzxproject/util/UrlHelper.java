package com.ylx.zyzxproject.util;

import android.provider.Settings;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.ylx.zyzxproject.MyAppcation;
import com.ylx.zyzxproject.http.HttpResource;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import it.sauronsoftware.base64.Base64;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/17  下午3:07
 * <p/>
 * 描 述：url 请求头的加密
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class UrlHelper {

    public static final String BANNER_URL = "pub/@focus";

    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization";
    public static final String HTTP_HEADER_ZHAO_DEVICEID = "X-Zhao-DeviceId";
    public static final String HTTP_HEADER_ZHAO_APPID = "X-Zhao-AppId";
    public static final String HTTP_HEADER_ZHAO_USERID = "X-Zhao-UserId";
    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_HEADER_ZHAO_OSINFO = "X-Zhao-OSInfo";
    public static final String HTTP_HEADER_CHARSET = "charset";
    public static final String HTTP_CONTENT_TYPE_VALUE = "application/json";
    public static final String HTTP_CHARSET_VALUE = "utf-8";

    private String TAG = "UrlHelper";
    private MyAppcation app;
    private String mark = "";
    private String url;
    private String method;

    public UrlHelper(MyAppcation app, String pathUrl, String method) {
//        this.mark = mark;
        this.url = pathUrl;
        this.method = method;
        this.app = app;
    }

    /**
     * 请求URL
     *
     * @return
     */
    public String getHttpUrl() {
        if(TextUtils.isEmpty(mark)) {
            return this.url;
        }
        String rootUrl = null;
        rootUrl = HttpResource.getResource(mark);
        String httpUrl = rootUrl;
        if(!TextUtils.isEmpty(url)) {
            httpUrl += "/" + url;
        }
        Log.i(TAG, "httpUrl:" + httpUrl);
        return httpUrl;
    }

    /**
     * 加密URL
     *
     * @return
     */
    private String getSecretUrl() {
        String http = "";
        int startIndex = 0;
        int endIndex = -1;
        try {
            String[] https = getHttpUrl().split("//");
            if(https.length > 1){
                http = https[1];
                startIndex = http.indexOf("/");
                endIndex = http.indexOf("?");
                if(startIndex==-1)
                    startIndex=0;
                if (endIndex == -1) {
                    endIndex = http.length();
                }
                Log.i(TAG, http.substring(startIndex, endIndex));
                return http.substring(startIndex, endIndex);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 进行加密的部分
     *
     * @return
     */
    private String getStringToSign() {
        String StringToSign = method + "\n" + "" + "\n" + getSecretUrl() + "\n"
                + getDeviceId();
        Log.i(TAG, "stringToSign:" + method + ":" + getSecretUrl() + ":"
                + getDeviceId());
        return StringToSign;
    }

    /**
     * 认证加密后数据
     *
     * @param key
     * @param data
     * @return
     */
    private String getBaseAndHma(String key, String data) {
        try {
            byte[] secret = key.getBytes("UTF-8");
            SecretKey skey = new SecretKeySpec(secret, "HMACSHA1");
            Mac mac = Mac.getInstance("HMACSHA1");
            mac.init(skey);
            byte[] sdata = data.getBytes("UTF-8");
            byte[] secreData = mac.doFinal(sdata);
            return new String(Base64.encode(secreData)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String getAuthori() {
        return "ZHAO" + " " + app.APP_ID + ":"
                + getBaseAndHma(app.APP_KEY, getStringToSign());
    }

    /**
     * 获取设备id
     * @return
     */
    public String getDeviceId() {
        String id = Secure.getString(app.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return id;
    }

    /**
     * 获取登录用户userId
     * @return
     */
    public String getUserId() {
        return app.userId;
    }

    /**
     * 获取设备信息
     * @return
     */
    public String getOsInfo() {
        return DeviceUtils.getOsInfo(app);
    }

    public Map<String, String> getHttpHeaderMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put(HTTP_HEADER_AUTHORIZATION, getAuthori());
        map.put(HTTP_HEADER_ZHAO_DEVICEID, getDeviceId());
        map.put(HTTP_HEADER_ZHAO_APPID, app.APP_ID);
        map.put(HTTP_HEADER_ZHAO_USERID, app.userId);
        map.put(HTTP_HEADER_CONTENT_TYPE, HTTP_CONTENT_TYPE_VALUE);
        map.put(HTTP_HEADER_ZHAO_OSINFO, getOsInfo());
        map.put(HTTP_HEADER_CHARSET, HTTP_CHARSET_VALUE);

        LogUtil.i("=====请求头=====" + new Gson().toJson(map));

        return map;
    }

}
