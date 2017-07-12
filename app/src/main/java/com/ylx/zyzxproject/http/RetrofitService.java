package com.ylx.zyzxproject.http;

import com.ylx.zyzxproject.api.ApiService;
import com.ylx.zyzxproject.bean.BannerBean;

import java.util.List;

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
    private static final String baseUrl = "http://192.168.16.105:8080/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public Call<List<BannerBean>> getBanner(){
        return retrofit.create(ApiService.class).getBannerData();
    }
}
