package com.ylx.zyzxproject.api;

import com.ylx.zyzxproject.bean.AccountBean;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.LoginBean;
import com.ylx.zyzxproject.bean.QueryAccountMarKBean;
import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.bean.SearchBean;
import com.ylx.zyzxproject.bean.SendMessageBean;
import com.ylx.zyzxproject.bean.ValidateRegisterBean;
import com.ylx.zyzxproject.util.UrlHelper;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

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
    @GET("ft1_issue_index.json")
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
     *
     * @GET()中一定要有数据，不能为空 用. 占位
     * http://192.168.0.59:8282/search/?order=price&category=1026&orderBy=asc&specialId=11130&page=1
     * http://192.168.0.59:8282/search/?page=1&perPage=10&stage=2&order=collection,popularity&orderBy=desc,desc&collection=1026
     *
     */
    @GET(".")
    Call<SearchBean> getSearchData(@QueryMap Map<String, String> map);

    /**
     * 获取账户角标数据
     */
    @GET(UrlHelper.QUERYACCOUNTMARK)
    Call<QueryAccountMarKBean> getQueryAccountMarKData(@HeaderMap Map<String, String > mHeaders);

    /**
     * 获取账户信息
     */
    @GET(UrlHelper.ACCOUNT_STATISTICS)
    Call<AccountBean> getAccountData(@HeaderMap Map<String, String> mHeaders);

    /**
     * 用户信息登录
     */
    @FormUrlEncoded
    @POST(".")
    Call<LoginBean> login(@HeaderMap Map<String ,String> mHeaders, @Field("username") String userName, @Field("password") String password);

    /**
     * 发送验证码
     *
     * http://116.236.187.5:13005/user/captcha/18638583601
     */
    @POST(UrlHelper.SEND_CAPTCHA + "{phoneNo}")
    Call<SendMessageBean> sendMessage(@HeaderMap Map<String, String> mHeaders, @Path("phoneNo") String phone);

    /**
     * 验证用户名是否注册
     */
    @FormUrlEncoded
    @POST(UrlHelper.VALIDATE_REGISTER)
    Call<ValidateRegisterBean> validateRegister(@HeaderMap Map<String, String> mHeaders, @Field("nickname") String nickName);

}
