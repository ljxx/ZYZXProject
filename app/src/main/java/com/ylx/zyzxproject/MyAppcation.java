package com.ylx.zyzxproject;

import android.app.Application;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/17  下午3:13
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class MyAppcation extends Application {

    public static MyAppcation singleInstance;
    public static final String RESOURCE_URL = "http://192.168.16.105:8080";

    public String userId = "8039936";
    public final String APP_ID = "fKhnk3UwbjhLP5NuFNQm5W";
    public final String APP_KEY = "9dbe75e0-d10a-55a5-b232-ecd60a9f60be";

    @Override
    public void onCreate() {
        super.onCreate();
        singleInstance = this;
    }

    public static synchronized MyAppcation getInstance() {
        return singleInstance;
    }

}
