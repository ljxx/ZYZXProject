package com.ylx.zyzxproject.mainfragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.http.RetrofitService;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    private TextView mRequestBtn;
    private RetrofitService rs;

    @Override
    protected int inflateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mRequestBtn = (TextView) mView.findViewById(R.id.request_data);
        rs = new RetrofitService();
    }

    @Override
    protected void initListen() {
        mRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<BannerBean>> bbList = rs.getBanner();
                bbList.enqueue(new Callback<List<BannerBean>>() {
                    @Override
                    public void onResponse(Call<List<BannerBean>> call, Response<List<BannerBean>> response) {
                        List<BannerBean> lbb = response.body();
                        Gson gson = new Gson();
                        HttpLoggingInterceptor.Logger.DEFAULT.log(gson.toJson(lbb));
                    }

                    @Override
                    public void onFailure(Call<List<BannerBean>> call, Throwable t) {

                    }
                });
            }
        });
    }

}
