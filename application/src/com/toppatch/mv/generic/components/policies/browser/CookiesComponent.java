package com.toppatch.mv.generic.components.policies.browser;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class CookiesComponent extends Component {

	private static final String TAG = "CookiesComponent";

	public CookiesComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			try {
				boolean enable = data.getBoolean(Constants.BROWSER_COOKIES_ENABLE);
			} catch (JSONException e) {
				//If there is no Constants.ANDROID_BROWSER_ENABLE in the json
				e.printStackTrace();
			}
		}
	}
}
