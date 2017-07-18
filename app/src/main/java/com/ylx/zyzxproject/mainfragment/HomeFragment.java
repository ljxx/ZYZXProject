package com.ylx.zyzxproject.mainfragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.ResponseResultActivity;
import com.ylx.zyzxproject.activity.ZxingActivity;
import com.ylx.zyzxproject.bean.BannerBean;
import com.ylx.zyzxproject.bean.SearchBean;
import com.ylx.zyzxproject.http.HttpResource;
import com.ylx.zyzxproject.http.RetrofitService;
import com.ylx.zyzxproject.util.UrlHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    private TextView mRequestBtn,mZxingBtn,mResonseSearchBtn;

    @Override
    protected int inflateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mRequestBtn = (TextView) mView.findViewById(R.id.request_data);
        mZxingBtn = (TextView) mView.findViewById(R.id.zxing_btn);
        mResonseSearchBtn = (TextView) mView.findViewById(R.id.response_search_data);
    }

    @Override
    protected void initListen() {
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

        mZxingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZxingActivity.class));
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
        UrlHelper urlHelper = new UrlHelper(app, UrlHelper.BANNER_URL, "GET");
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
