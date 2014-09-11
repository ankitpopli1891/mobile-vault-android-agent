package com.toppatch.mv.generic.components.policies.restriction;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class CellularDataComponent extends Component {

	private static final String TAG = "CellularDataComponent";

	public CellularDataComponent(Context context) {
		super(context);
	}

	@Override
	public void execute(JSONObject data) {
		if(data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		boolean enable = data.optBoolean(Constants.RESTRICTION_CELLULAR_DATA_ENABLE);
		Log.d(TAG, "Enabled: " + enable);
	}
}