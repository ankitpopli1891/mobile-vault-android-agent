package com.toppatch.mv.generic.components.policies.wifi;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class WifiAutoConnectComponent extends Component {

	private static final String TAG = "WifiAutoConnectComponent";

	public WifiAutoConnectComponent(Context context) {
		super(context);
	}

	/**
	 * {"value":true}
	 * {"value":false}
	 */
	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());
		try {
			boolean enable = data.getBoolean(Constants.WIFI_AUTO_CONNECT_ENABLE);
			Log.d(TAG, Constants.WIFI_AUTO_CONNECT_ENABLE + ": " + enable);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}