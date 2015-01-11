package com.example.minam.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.EditText;

public class MinaUtil {
	
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
	/**判断用户是否存入昵称
	 * @return
	 */
	public static String hasName(Activity activity){
		SharedPreferences edit = activity.getPreferences(Context.MODE_PRIVATE);
		String name  = edit.getString("name","");
		return name;
	}
	

}
