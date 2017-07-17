package com.ylx.zyzxproject.util;

import android.util.Log;

public class LogUtil {

	
	public static final String TAG="ZhaoOnline";
	public static final boolean DEBUGE = true;
	
	
	public static void i(String msg){
		if(DEBUGE){
			Log.i(TAG, msg);
		}
	}
	
	public static void i(String tag,String msg){
		if(DEBUGE){
			Log.i(tag, msg);
		}
	}
	
	
	public static void v(String msg){
		if(DEBUGE){
			Log.v(TAG, msg);
		}
	}
	
	public static void v(String tag,String msg){
		if(DEBUGE){
			Log.v(tag, msg);
		}
	}
	
	public static void e(String msg){
		if(DEBUGE){
			Log.e(TAG, msg);
		}
	}
	
	public static void e(String tag,String msg){
		if(DEBUGE){
			Log.e(tag, msg);
		}
	}
	
	
}
