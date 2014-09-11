package com.toppatch.mv.generic.components.policies.browser;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class HttpProxyComponent extends Component {

	private static final String TAG = "HttpProxyComponent";

	public HttpProxyComponent(Context context) {
		super(context);
		
	}

	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			try {
				String proxy = data.optString(Constants.BROWSER_HTTP_PROXY,null);
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}

}
