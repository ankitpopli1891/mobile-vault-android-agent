package com.toppatch.mv.generic.components.policies.bluetooth;

import org.json.JSONObject;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class BluetoothStateComponent extends Component {

	private static final String TAG = "BluetoothStateComponent";

	public BluetoothStateComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.PLUG_BT_STATUS_ENABLE);
		Log.d(TAG, "Enable: " + enable);

		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
		if(adapter == null) {
			Log.d(TAG, "Bluetooth Not Supported");
			return;
		}

		boolean success = false;
		if(enable && !adapter.isEnabled())
			success = adapter.enable();
		else if (!enable && adapter.isEnabled())
			success = adapter.disable();
		else
			success = true;

		Log.d(TAG, "Command Successful: " + success);
	}
}