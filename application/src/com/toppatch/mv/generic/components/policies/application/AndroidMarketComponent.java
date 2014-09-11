package com.toppatch.mv.generic.components.policies.application;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class AndroidMarketComponent extends Component {

	private static final String TAG = "AndroidMarketComponent";
	public AndroidMarketComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.APP_ANDROID_MARKET_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		try {
			String command = null;
			if(enable)
				command = "enable";
			else
				command = "disable";

			Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "pm", command, "com.android.vending" });
			proc.waitFor();
		} catch (Exception e) {
			Log.e(TAG, "Unable to Disable Youtube", e);
		}
	}
}
