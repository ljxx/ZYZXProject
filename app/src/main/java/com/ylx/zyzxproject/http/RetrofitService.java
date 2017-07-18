package com.ylx.zyzxproject.http;

import android.util.Log;

import com.ylx.zyzxproject.api.ApiService;
import com.ylx.zyzxproject.bean.AccountBean;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.LoginBean;
import com.ylx.zyzxproject.bean.QueryAccountMarKBean;
import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.bean.SearchBean;
import com.ylx.zyzxproject.bean.SendMessageBean;
import com.ylx.zyzxproject.bean.ValidateRegisterBean;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/12  上午11:07
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class RetrofitService {
    private String mRootUrl;
    Retrofit retrofit;

    public RetrofitService(){}
    public RetrofitService(String rootUrl){
        this.mRootUrl = rootUrl + "/";
        retrofit = new Retrofit.Builder()
                .baseUrl(mRootUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClicent())
                .build();
    }

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.i("RetrofitLog","retrofitBack = "+message);
        }
    });

    private OkHttpClient getOkHttpClicent(){
        X509TrustManager xtm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");

            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }





        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
//                .hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).
//                        sslSocketFactory(sslContext.getSocketFactory())
                .build();
        return okHttpClient;
    }

    /**
     * 获取resource文件
     * @return
     */
    public Call<ResourceBean> getResource(){
        return retrofit.create(ApiService.class).getResource();
    }

    /**
     * 获取banner图
     * @param mHeaders
     * @return
     */
    public Call<List<BannerBean>> getBanner(Map<String, String> mHeaders){
        return retrofit.create(ApiService.class).getBannerData(mHeaders);
    }

    /**
     * 获取搜索数据，传递多个参数&&&&
     * @param map
     * @return
     */
    public Call<SearchBean> getSearch(Map<String, String> map){
        return retrofit.create(ApiService.class).getSearchData(map);
    }

    /**
     * 获取账户角标数据
     * @param mHeaders
     * @return
     */
    public Call<QueryAccountMarKBean> getQueryAccountMark(Map<String, String> mHeaders){
        return retrofit.create(ApiService.class).getQueryAccountMarKData(mHeaders);
    }

    /**
     * 获取账户信息
     */
    public Call<AccountBean> getAccount(Map<String, String> mHeaders){
        return retrofit.create(ApiService.class).getAccountData(mHeaders);
    }

    /**
     * 登录
     */
    public Call<LoginBean> login(Map<String, String> mHeaders, String userName, String password){
        return retrofit.create(ApiService.class).login(mHeaders, userName, password);
    }

    /**
     * 发送验证码
     */
    public Call<SendMessageBean> sendMessageBeanCall(Map<String, String> mHeaders, String message){
        return retrofit.create(ApiService.class).sendMessage(mHeaders, message);
    }

    /**
     * 验证用户名是否注册
     */
    public Call<ValidateRegisterBean> validateRegister(Map<String, String> mHeaders, String nickName){
        return retrofit.create(ApiService.class).validateRegister(mHeaders, nickName);
    }
}
