package com.toppatch.mv.generic.components.policies.misc;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;
import com.toppatch.mv.samsung.TopPatchAdmin;

public class CameraStateComponent extends Component {

	private static final String TAG = "CameraStateComponent";

	private Context context;

	public CameraStateComponent(Context context) {
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
		try {
			boolean enable = data.getBoolean(Constants.MISC_CAMERA_STATE_ENABLE);

			DevicePolicyManager policyManager =
					(DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
			policyManager.setCameraDisabled(new ComponentName(context, TopPatchAdmin.class), !enable);

		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
		}
	}
}