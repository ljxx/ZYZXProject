package com.ylx.zyzxproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ylx.zyzxproject.bean.ResourceBean;
import com.ylx.zyzxproject.http.HttpResource;
import com.ylx.zyzxproject.http.RetrofitResourceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private Button btn_jump;
    private RetrofitResourceService mRetrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRetrofitService = new RetrofitResourceService();
        setContentView(R.layout.activity_splash);
        btn_jump = (Button) findViewById(R.id.btn_jump);

        initData();
        initListener();
    }

    private void initData() {

        Call<ResourceBean> resourceBeanCall = mRetrofitService.getResource();
        resourceBeanCall.enqueue(new Callback<ResourceBean>() {
            @Override
            public void onResponse(Call<ResourceBean> call, Response<ResourceBean> response) {
                ResourceBean rb = response.body();
                if(rb != null){
                    HttpResource.fastGetResourceFromMap(rb);
                }
            }

            @Override
            public void onFailure(Call<ResourceBean> call, Throwable t) {

            }
        });

    }

    private void initListener() {
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }
}
