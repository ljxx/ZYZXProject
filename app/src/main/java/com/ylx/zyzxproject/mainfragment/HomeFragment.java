package com.ylx.zyzxproject.mainfragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ylx.zyzxproject.MyAppcation;
import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.ResponseResultActivity;
import com.ylx.zyzxproject.activity.TimeActivity;
import com.ylx.zyzxproject.activity.ZxingActivity;
import com.ylx.zyzxproject.bean.AccountBean;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.LoginBean;
import com.ylx.zyzxproject.bean.LoginPostParame;
import com.ylx.zyzxproject.bean.QueryAccountMarKBean;
import com.ylx.zyzxproject.bean.SearchBean;
import com.ylx.zyzxproject.bean.SendMessageBean;
import com.ylx.zyzxproject.http.HttpResource;
import com.ylx.zyzxproject.http.RetrofitService;
import com.ylx.zyzxproject.util.UrlHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    private TextView mGetServerTimeBtn, mRequestLoginBtn, mRequestBtn,mZxingBtn,mResonseSearchBtn, mResponseAccountBtn, mResponseNumBtn, mSendMessageBtn, mValidateBtn, mOutLogin;
    private EditText mNickNameEt;

    @Override
    protected int inflateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mGetServerTimeBtn = (TextView) mView.findViewById(R.id.m_get_server_time_btn);
        mRequestLoginBtn = (TextView) mView.findViewById(R.id.request_login);
        mRequestBtn = (TextView) mView.findViewById(R.id.request_data);
        mZxingBtn = (TextView) mView.findViewById(R.id.zxing_btn);
        mResonseSearchBtn = (TextView) mView.findViewById(R.id.response_search_data);
        mResponseAccountBtn = (TextView) mView.findViewById(R.id.response_account_data);
        mResponseNumBtn = (TextView) mView.findViewById(R.id.response_num_data);
        mSendMessageBtn = (TextView) mView.findViewById(R.id.send_message);
        mNickNameEt = (EditText) mView.findViewById(R.id.nickname_et);
        mValidateBtn = (TextView) mView.findViewById(R.id.validate_btn);
        mOutLogin = (TextView) mView.findViewById(R.id.out_login);
    }

    @Override
    protected void initListen() {

        /**
         * 获取服务器时间
         */
        mGetServerTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeActivity.JumpTimeActivity(getActivity());
            }
        });

        /**
         * 登录
         */
        mRequestLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = "8039936";
                String password = "123456";
                login(userId, password);
            }
        });

        /**
         * 退出登录
         */
        mOutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outLogin();
            }
        });

        /**
         * 获取Banner图数据
         */
        mRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBannerData();
            }
        });

        /**
         * 获取搜索列表数据
         */
        mResonseSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSearchData();
            }
        });

        /**
         * 账户角标数据
         */
        mResponseNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAccountNumData();
            }
        });

        /**
         * 获取账户信息数据
         */
        mResponseAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAccountData();
            }
        });

        /**
         * 发送验证码
         */
        mSendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageData();
            }
        });

        /**
         * 验证码用户名是否被注册
         */
        mValidateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vallidateNickName();
            }
        });

        mZxingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZxingActivity.class));
            }
        });
    }

    /**
     * 退出登录
     */
    private void outLogin() {
        String mKey = "mAuth";
        String baseUrl = HttpResource.getResource(mKey);
        baseUrl = baseUrl.replace("/auth","");
        final RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper ul = new UrlHelper(app, mKey, "", "DELETE");
        Call<ResponseBody> outCall = rs.outLogin(ul.getHttpHeaderMap(), MyAppcation.appId);
        outCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    MyAppcation.appId = app.APP_ID;
                    MyAppcation.appKey = app.APP_KEY;
                    MyAppcation.userId = "";
                    HttpLoggingInterceptor.Logger.DEFAULT.log(MyAppcation.appId + "===" + MyAppcation.appKey + "==="+MyAppcation.userId);
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(), "退出登录成功");
                } else {
                    try {
                        Toast.makeText(getActivity(), "退出登录失败：" + response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "退出登录失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 验证用户名是否被注册
     */
    private void vallidateNickName() {
        String mNickName = mNickNameEt.getText().toString().trim();
        if(TextUtils.isEmpty(mNickName)){
            return;
        }
        JSONObject mJson = new JSONObject();
        try {
            mJson.put("nickname", mNickName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpLoggingInterceptor.Logger.DEFAULT.log("===nickName====="+ mNickName);
        String mKey = "mRegister";
        String baseUrl = HttpResource.getResource(mKey);
        RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper uh = new UrlHelper(app, mKey, UrlHelper.VALIDATE_REGISTER, "POST");
        Call<ResponseBody> vrb = rs.validateRegister(uh.getHttpHeaderMap(), mJson.toString());
        vrb.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(), "验证用户通过，允许注册");
                } else {
                    try {
                        Toast.makeText(getActivity(), "验证有异常：" + response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "用户名验证失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 发送验证码
     */
    private void sendMessageData() {
        String phone = "1234567890";
        String mKey = "mUser";
        String baseUrl = HttpResource.getResource(mKey);
        final RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper uh = new UrlHelper(app, mKey, UrlHelper.SEND_CAPTCHA + phone, "POST");
        Call<SendMessageBean> sb = rs.sendMessageBeanCall(uh.getHttpHeaderMap(), phone);
        sb.enqueue(new Callback<SendMessageBean>() {
            @Override
            public void onResponse(Call<SendMessageBean> call, Response<SendMessageBean> response) {
                if(response.isSuccessful()){
                    SendMessageBean sb = response.body();
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(), "发送验证码成功：" + new Gson().toJson(sb));
                } else {
                    try {
                        Toast.makeText(getActivity(), response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<SendMessageBean> call, Throwable t) {
                Toast.makeText(getActivity(), "验证码发送失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 登录
     * @param userId
     * @param password
     */
    private void login(String userId, String password) {
        String mKey = "mAuth";
        String baseUrl = HttpResource.getResource(mKey);
        baseUrl = baseUrl.replace("/auth", "");
        HttpLoggingInterceptor.Logger.DEFAULT.log("===/auth===="+baseUrl);
        RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper uh = new UrlHelper(app, mKey, "", "POST");
        LoginPostParame lpp = new LoginPostParame();
        lpp.setUsername(userId);
        lpp.setPassword(password);
        Call<LoginBean> lb = rs.login(uh.getHttpHeaderMap(), lpp);
        lb.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                try {
                    int code = response.code();
                    if(response.isSuccessful()){
                        LoginBean lb = response.body();
                        if(lb != null){
                            MyAppcation.appId = lb.getId();
                            MyAppcation.appKey = lb.getKey();
                            MyAppcation.userId = lb.getUser_id();
                            ResponseResultActivity.jumpResponseResultActivity(getActivity(), "登录成功信息：" + new Gson().toJson(lb));
                        }
                    } else {
                        String mErrorData = response.errorBody().string();
                        Toast.makeText(getActivity(), "登录失败：" + mErrorData, Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Toast.makeText(getActivity(), "登录失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 获取用户账户信息
     */
    private void getAccountData(){
        String mKey = "user";
        String baseUrl = HttpResource.getResource(mKey);
        RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper uh = new UrlHelper(app, mKey, UrlHelper.ACCOUNT_STATISTICS, "GET");
        Call<AccountBean> ab = rs.getAccount(uh.getHttpHeaderMap());
        ab.enqueue(new Callback<AccountBean>() {
            @Override
            public void onResponse(Call<AccountBean> call, Response<AccountBean> response) {
                AccountBean ab = response.body();
                if(ab != null){
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(),"获得用户账户信息数据：" + new Gson().toJson(ab));
                }
            }

            @Override
            public void onFailure(Call<AccountBean> call, Throwable t) {
                Toast.makeText(getActivity(), "请求失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 获取用户账户角标数据
     */
    private void getAccountNumData() {
        String mKey = "user";
        String baseUrl = HttpResource.getResource(mKey);
        RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper uh = new UrlHelper(app, mKey, UrlHelper.QUERYACCOUNTMARK, "GET");
        Call<QueryAccountMarKBean> sb = rs.getQueryAccountMark(uh.getHttpHeaderMap());
        sb.enqueue(new Callback<QueryAccountMarKBean>() {
            @Override
            public void onResponse(Call<QueryAccountMarKBean> call, Response<QueryAccountMarKBean> response) {
                QueryAccountMarKBean qm = response.body();
                if(qm != null){
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(),"获得账户角标数据：" + new Gson().toJson(qm));
                }
            }

            @Override
            public void onFailure(Call<QueryAccountMarKBean> call, Throwable t) {
                Toast.makeText(getActivity(), "请求失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * 获取搜索列表数据
     */
    private void getSearchData() {
        String baseUrl = HttpResource.getResource("search");
        RetrofitService rs = new RetrofitService(baseUrl);
        String page = "1";
        String perPage = "10";
        String stage = "2";
        String collection = "1026";
        String order = "collection,popularity";
        String orderBy = "desc,desc";

        Map<String, String> map = new HashMap<String, String>();
        map.put("page", page);
        map.put("perPage", perPage);
        map.put("stage", stage);
        map.put("order", order);
        map.put("orderBy", orderBy);
        map.put("collection", collection);
        Call<SearchBean> searchCall = rs.getSearch(map);
        searchCall.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                SearchBean sb = response.body();
                if(sb != null){
                    ResponseResultActivity.jumpResponseResultActivity(getActivity(),"搜索结果的数据：" + new Gson().toJson(sb));
                }
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {
                Toast.makeText(getActivity(), "请求失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 获取banner图数据
     */
    private void getBannerData(){
        String baseUrl = HttpResource.getResource("root");
        RetrofitService rs = new RetrofitService(baseUrl);
        UrlHelper urlHelper = new UrlHelper(app,"root", UrlHelper.BANNER_URL, "GET");
        Call<List<BannerBean>> bbList = rs.getBanner(urlHelper.getHttpHeaderMap());
        bbList.enqueue(new Callback<List<BannerBean>>() {
            @Override
            public void onResponse(Call<List<BannerBean>> call, Response<List<BannerBean>> response) {
                List<BannerBean> lbb = response.body();
                Gson gson = new Gson();
                String mResponseData = "获取Banner图数据：" + gson.toJson(lbb);
                ResponseResultActivity.jumpResponseResultActivity(getActivity(),mResponseData);
            }

            @Override
            public void onFailure(Call<List<BannerBean>> call, Throwable t) {
                Toast.makeText(getActivity(), "请求失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
