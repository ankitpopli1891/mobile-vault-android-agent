package com.toppatch.mv.generic.components.policies.access;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

/**
 * TODO
 */
public class AllowScreenShotComponent extends Component {

	private static final String TAG = "AllowScreenShotComponent";

	public AllowScreenShotComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.ACCESS_SCREENSHOT_ENABLE);
		Log.d(TAG, "Enable: " + enable);
	}
}