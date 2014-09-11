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
public class MockLocationComponent extends Component {

	private static final String TAG = "MockLocationComponent";

	private Context context;

	public MockLocationComponent(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.RESTRICTION_MOCK_LOCATION_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		try {
			/*
			 * http://developer.android.com/reference/android/provider/Settings.Secure.html#ALLOW_MOCK_LOCATION
			 */
			if(enable)
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.ALLOW_MOCK_LOCATION, 1);
			else
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.ALLOW_MOCK_LOCATION, 0);

		} catch (SecurityException e) {
			Log.e(TAG, "Needs System Access", e);
		}
	}
}