package com.ylx.zyzxproject.api;

import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.util.UrlHelper;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/12  上午10:51
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface ApiService {

    @GET("ft1_issue_index.json")
    Call<ResourceBean> getResource();


    /*@Headers({
            "Authorization:ZHAO m0daKz4Kz3twmeMABwf:WhdMY0IrHjmZ6rRYfMduKlDC2qY=",
            "X-Zhao-DeviceId:af73c2c3d6d8ced9",
            "X-Zhao-AppId:fKhnk3UwbjhLP5NuFNQm5W",
            "X-Zhao-UserId:8039936",
            "Content-Type:application/json",
            "X-Zhao-OSInfo:{\"os\":\"android\",\"osv\":\"6.0\",\"deviceToken\":\"18071adc033d0fffe57\",\"appVer\":\"4.0\",\"make\":\"Android\",\"model\":\"Samsung Galaxy S6 - 6.0.0 - API 23 - 1440x2560\"}",
            "charset:utf-8"
    })*/
    @GET(UrlHelper.BANNER_URL+"?indexPage=0")
    Call<List<BannerBean>> getBannerData(@HeaderMap Map<String, String> mHeaders);
}
