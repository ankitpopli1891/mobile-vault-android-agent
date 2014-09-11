package com.toppatch.mv.generic.components.policies.bluetooth;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class BluetoothPowerStateComponent extends Component {

	private static final String TAG = "BluetoothPowerStateComponent";

	public BluetoothPowerStateComponent(Context context) {
		super(context);
	}

	/**
	 * This module is being used for changing bluetooth discoverability.
	 * No workaround till now for this. 
	 * Might be possible using WRITE_SECURE_SETTINGS
	 */
	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());
		boolean discoverable = data.optBoolean(Constants.PLUG_BT_STATUS_POWER);
		Log.d(TAG, "Discoverable: " + discoverable);
	}
}