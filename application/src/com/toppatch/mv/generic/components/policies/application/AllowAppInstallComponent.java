package com.toppatch.mv.generic.components.policies.application;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

/**
 * TODO
 */
public class AllowAppInstallComponent extends Component {

	private static final String TAG = "AllowAppComponent";

	public AllowAppInstallComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.APP_ALLOW_INSTALL);
		Log.d(TAG, "Enable: " + enable);

	}
}