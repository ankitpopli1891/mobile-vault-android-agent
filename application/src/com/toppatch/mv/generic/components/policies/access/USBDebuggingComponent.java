package com.toppatch.mv.generic.components.policies.access;

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
public class USBDebuggingComponent extends Component {

	private static final String TAG = "USBDebuggingComponent";

	private Context context;

	public USBDebuggingComponent(Context context) {
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

		boolean enable = data.optBoolean(Constants.ACCESS_USB_DEBUG_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		try {

			// TODO remove comment when building with API greater than 16
			/*if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.JELLY_BEAN) {
				if(enable)
					Settings.Global.putInt(context.getContentResolver(),Settings.Global.ADB_ENABLED, 1);
				else
					Settings.Global.putInt(context.getContentResolver(),Settings.Global.ADB_ENABLED, 0);
			} else {*/
			/*
			 * @deprecated in API 17
			 * http://developer.android.com/reference/android/provider/Settings.Secure.html#ADB_ENABLED
			 */
			if(enable)
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.ADB_ENABLED, 1);
			else
				Settings.Secure.putInt(context.getContentResolver(),Settings.Secure.ADB_ENABLED, 0);
			/*}*/
		} catch (SecurityException e) {
			Log.e(TAG, "Needs System Access", e);
		}
	}
}