package com.ylx.zyzxproject.http;

import com.ylx.zyzxproject.api.ApiService;
import com.ylx.zyzxproject.bean.ResourceBean;

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
 * 创建日期：2017/7/17  下午3:39
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class RetrofitResourceService {

    private static final String BASE_URL = "http://192.168.0.92:8087/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Call<ResourceBean> getResource(){
        return retrofit.create(ApiService.class).getResource();
    }

}
