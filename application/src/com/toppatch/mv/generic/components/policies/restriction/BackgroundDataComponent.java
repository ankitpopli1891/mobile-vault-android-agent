package com.toppatch.mv.generic.components.policies.restriction;

import org.json.JSONObject;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class BackgroundDataComponent extends Component {

	private static final String TAG = "BackgroundDataComponent";

	private Context context; 

	public BackgroundDataComponent(Context context) {
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

		boolean enable = data.optBoolean(Constants.RESTRICTION_BACKGROUND_DATA_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		try {
			/*
			 * @deprecated in API 14
			 * http://developer.android.com/reference/android/provider/Settings.Secure.html#BACKGROUND_DATA
			 * 
			 */
			if(enable)
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.BACKGROUND_DATA, 1);
			else
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.BACKGROUND_DATA, 0);

		} catch (SecurityException e) {
			Log.e(TAG, "Needs System Access", e);
		}
	}
}