package com.toppatch.mv.generic.components.policies.roaming;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class RoamingPushComponent  extends Component{

	private static final String TAG = "RoamingPushComponent";

	public RoamingPushComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.ROAMING_PUSH_ENABLE);
		Log.d(TAG, "Enable: " + enable);	
	}
}
