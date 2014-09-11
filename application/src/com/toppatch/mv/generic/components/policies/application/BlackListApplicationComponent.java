package com.toppatch.mv.generic.components.policies.application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class BlackListApplicationComponent extends Component{

	private static final String TAG = "BlackListApplicationComponent";

	public BlackListApplicationComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			String blackListString = data.optString(Constants.APP_ANDROID_BLACK_LIST);
			try {
				JSONArray jar = new JSONArray(blackListString);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
