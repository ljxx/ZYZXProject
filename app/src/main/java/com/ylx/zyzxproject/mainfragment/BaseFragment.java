package com.ylx.zyzxproject.mainfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylx.zyzxproject.MyAppcation;

public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Activity mContext;
    protected MyAppcation app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(inflateView(),null);
        mContext = getActivity();
        app = (MyAppcation) mContext.getApplication();
        initView();
        initListen();
        return mView;
    }

    /**
     * 传递布局
     * @return
     */
    protected abstract int inflateView();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    protected abstract void initListen();
}
