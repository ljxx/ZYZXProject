package com.ylx.zyzxproject.mainfragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ylx.zyzxproject.MyAppcation;
import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.activity.ZxingActivity;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.http.RetrofitService;
import com.ylx.zyzxproject.util.UrlHelper;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    private TextView mRequestBtn,mZxingBtn;
    private RetrofitService rs;

    @Override
    protected int inflateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mRequestBtn = (TextView) mView.findViewById(R.id.request_data);
        mZxingBtn = (TextView) mView.findViewById(R.id.zxing_btn);
        rs = new RetrofitService();
    }

    @Override
    protected void initListen() {
        mRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAppcation appcation = (MyAppcation) getActivity().getApplication();
                UrlHelper urlHelper = new UrlHelper(appcation, UrlHelper.BANNER_URL, "GET");
                Call<List<BannerBean>> bbList = rs.getBanner(urlHelper.getHttpHeaderMap());
                bbList.enqueue(new Callback<List<BannerBean>>() {
                    @Override
                    public void onResponse(Call<List<BannerBean>> call, Response<List<BannerBean>> response) {
                        List<BannerBean> lbb = response.body();
                        Gson gson = new Gson();
                        Toast.makeText(getActivity(), gson.toJson(lbb), Toast.LENGTH_LONG).show();
                        HttpLoggingInterceptor.Logger.DEFAULT.log(gson.toJson(lbb));
                    }

                    @Override
                    public void onFailure(Call<List<BannerBean>> call, Throwable t) {

                    }
                });
            }
        });

        mZxingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZxingActivity.class));
            }
        });
    }

}
