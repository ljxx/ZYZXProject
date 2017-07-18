package com.ylx.zyzxproject.api;

import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.bean.SearchBean;
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

    /**
     * 获取Resource文件数据
     * @return
     */
    @GET("resource_dev.json")
    Call<ResourceBean> getResource();

    /**
     * 获取Banner图数据
     * @param mHeaders
     * @return
     */
    @GET(UrlHelper.BANNER_URL+"?indexPage=0")
    Call<List<BannerBean>> getBannerData(@HeaderMap Map<String, String> mHeaders);

    /**
     * 获取搜索接口数据
     */
    @GET()
    Call<SearchBean> getSearchData();
}
