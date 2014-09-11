package com.toppatch.mv.generic.components.policies.application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class UninstallApplicationComponent extends Component {

	private static final String TAG = "UninstallApplicationComponent";

	private Context context;

	public UninstallApplicationComponent(Context context) {
		super(context);

		this.context = context;
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			String uninstallList = data.optString(Constants.APP_ANDROID_UNINSTALL);
			try {
				JSONArray apps = new JSONArray(uninstallList);
				if(apps!=null){
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
