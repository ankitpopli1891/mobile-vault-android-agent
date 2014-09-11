package com.toppatch.mv.generic.components.policies.restriction;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class AndroidBeamComponent extends Component {

	private static final String TAG = "AndroidBeamComponent";

	public AndroidBeamComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			try {
				boolean enable = data.getBoolean(Constants.RESTRICTION_ANDROID_BEAM_ENABLE);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
