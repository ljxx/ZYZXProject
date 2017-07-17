package com.ylx.zyzxproject.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/17  下午3:19
 * <p/>
 * 描 述：获取设备信息
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class DeviceUtils {

    private static String mRegistrationID = ""; //推送的信息id

    // 获取设备信息
    public static String getOsInfo(Context mContext) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("os", "android");
            obj.put("osv", getOSVersion());
            obj.put("deviceToken", mRegistrationID);
            obj.put("appVer", getAppVersion(mContext));
            obj.put("make", getVendor());
            obj.put("model", getModel());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj.toString();
    }

    /**
     * @return the OS version
     */
    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppVersion(Context mContext) {
        String version = "0.0.0";
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return version;
    }


    public static String getVendor() {
        return Build.BRAND;
    }

    // 获得设备型号
    public static String getModel() {
        return Build.MODEL;
    }



}
