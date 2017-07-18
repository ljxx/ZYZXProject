package com.ylx.zyzxproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResponseResultActivity extends AppCompatActivity {

    private static final String RESPONSE_RESULT_DATA = "response_result_data";

    private TextView mResponseResultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_result);
        String mResponseRequestData = getIntent().getStringExtra(RESPONSE_RESULT_DATA);
        mResponseResultTxt = (TextView) findViewById(R.id.reponse_result_data);
        mResponseResultTxt.setText(mResponseRequestData);
    }

    public static void jumpResponseResultActivity(Activity mClazz, String resultData){
        Intent intent = new Intent(mClazz, ResponseResultActivity.class);
        intent.putExtra(RESPONSE_RESULT_DATA, resultData);
        mClazz.startActivity(intent);
    }

}
