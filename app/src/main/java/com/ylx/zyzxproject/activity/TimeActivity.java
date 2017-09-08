package com.ylx.zyzxproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.ylx.zyzxproject.R;
import com.ylx.zyzxproject.http.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeActivity extends AppCompatActivity {

    private static long org_tablet_tm; //保存终端的时间
    private static long org_server_tm; //保存服务器的时间
    private static String server_timezone = "0"; //服务器时间所在的时区

    private TextView mTimeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        mTimeTxt = (TextView) findViewById(R.id.m_time_txt);

        initData();
    }

    /**
     * 永远以server为准
     * 获取当前设备时间再加上org_server_tm-org_tablet_tm的差值。
     */
    public static Date now(){
        Date date = new Date();
        date.setTime(date.getTime() + org_server_tm);
        return date;
    }

    public static Date nowNow(Date mDate){
        mDate.setTime(mDate.getTime() + org_server_tm);
        return mDate;
    }

    /**
     * 先从tm中减去当前时区跟格林威治之间的时间差，再加上服务器所在时区跟格林威治时间差，即可算出到服务器时间
     * 把当地的时间转为服务器当时的时间，一般递交数据前先把Date一类数据转换
     */
    public static Date dateTimeConvertToServer(Date tm){
        Date mDate = new Date();
        Log.i("===","=参数mDate=="+mDate + "==tm="+tm);
        Log.i("===","=时区=="+TimeZone.getDefault().getID());
        if(tm == null) return null;
        tm = new Date(tm.getTime() - getDiffTimeZoneRawOffsetStd(TimeZone.getDefault().getID())); //转成格林威治时间
        Date date = new Date(tm.getTime() + getDiffTimeZoneRawOffsetStd(server_timezone));
        return date;
    }

    /**
     * 用于计算指定时区跟格林威治时区的时间差（毫秒）：
     * 计算出指定时区跟格林威治时间差
     */
    public static int getDiffTimeZoneRawOffsetStd(String timeZoneId){
        //return TimeZone.getTimeZone(timeZoneId).getRawOffset();
        TimeZone tz = TimeZone.getTimeZone(timeZoneId);
        return tz.getOffset(GregorianCalendar.getInstance(tz).getTimeInMillis());
    }

    /**
     * 获取服务器时间
     */
    private void initData(){
        String baseUrl = "https://appservices.zhaoonline.com/pub/";
        RetrofitService rs = new RetrofitService(baseUrl);
        Call<ResponseBody> timeCall = rs.getServerTime();
        timeCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        String timeData = response.body().string();

                        JSONObject json = null;
                        json = new JSONObject(timeData);
                        String webTime = json.optString("time");
                        org_server_tm = timeSubLocalNow(webTime);

                        long serverTime = 0;
                        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            serverTime = simple.parse(getTimeStr(webTime)).getTime();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Log.i("===serverTime=="+serverTime, "==now=="+now().getTime());

                        mTimeTxt.setText(timeData + "====now====" + now() + "====dateTimeConvertToServer====" + dateTimeConvertToServer(nowNow(new Date())));
                        Log.i("===","=结果观察=="+ timeData + "====now====" + now() + "====dateTimeConvertToServer====" + dateTimeConvertToServer(new Date()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    /**
     * 获取服务器时间与手机本地时间的差值的毫秒数
     * @param webTime
     * @return
     */
    public static long timeSubLocalNow(String webTime) {
        webTime=getTimeStr(webTime);
        long temp = 0;
        long first = 0;
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            first = simple.parse(webTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long nowtime = System.currentTimeMillis();
        temp = (first - nowtime);
        return temp;
    }

    /**
     * 清除后台返回的时间格式
     *
     * @param time
     * @return
     */
    public static String getTimeStr(String time) {
        if (!isNullStr(time))
            return time.replace("T", " ").replace("Z", "");
        return "";

    }

    /**
     * 判断是不空字符串包括“null”
     *
     * @param str
     * @return
     */
    public static boolean isNullStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        } else if ("null".equals(str.trim().toLowerCase())) {
            return true;
        } else if (str == null){
            return true;
        }
        return false;
    }

    /**
     * 跳转Activity
     * @param context
     */
    public static void JumpTimeActivity(Context context){
        Intent intent = new Intent(context, TimeActivity.class);
        context.startActivity(intent);
    }
}
