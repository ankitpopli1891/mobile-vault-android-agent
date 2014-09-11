package com.toppatch.mv.generic.components.policies.wifi;

import org.json.JSONObject;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class WifiStateComponent extends Component{

	private static final String TAG = "WifiStateComponent";

	private Context context;

	public WifiStateComponent(Context context) {
		super(context);

		this.context = context;
	}

	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.WIFI_STATE_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifiManager.setWifiEnabled(enable);

	}
}
