package com.toppatch.mv.generic.components.policies.misc;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class MicrophoneStateComponent extends Component {

	private static final String TAG = "MicrophoneStateComponent";

	public MicrophoneStateComponent(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			try {
				// Muting Microphone: http://developer.android.com/reference/android/media/AudioManager.html#setMicrophoneMute(boolean)
				boolean enable = data.getBoolean(Constants.MISC_MICROPHONE_ENABLE);
				Log.d(TAG, "Microphone enable: " + enable);
			} catch (JSONException e) {
				Log.e(TAG, e.getMessage(), e);
			}
		}
	}
}
