package com.ylx.zyzxproject.http;

import android.util.Log;

import com.ylx.zyzxproject.api.ApiService;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.bean.SearchBean;

import java.util.List;
import java.util.Map;

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
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
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

    public Call<SearchBean> getSearch(Map<String, String> map){
        return retrofit.create(ApiService.class).getSearchData(map);
    }
}
