package com.toppatch.mv.generic.components.policies.restriction;

import org.json.JSONObject;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

/**
 * 
 * @author ankit
 * Requires android.permission.WRITE_SECURE_SETTINGS
 * 
 */
public class NonMarketAppsComponent extends Component {

	private static final String TAG = "NonMarketAppsComponent";

	private Context context;

	public NonMarketAppsComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.RESTRICTION_NON_MARKET_APPS_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		try {
			/*
			 * @deprecated in API 17
			 * http://developer.android.com/reference/android/provider/Settings.Secure.html#INSTALL_NON_MARKET_APPS
			 * 
			 */
			if(enable)
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.INSTALL_NON_MARKET_APPS, 1);
			else
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.INSTALL_NON_MARKET_APPS, 0);

		} catch (SecurityException e) {
			Log.e(TAG, "Needs System Access", e);
		}
	}
}
