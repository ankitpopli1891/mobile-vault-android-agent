

package com.toppatch.mv.generic.components.policies.vpn;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class VPNAddComponent extends Component {

	private static final String TAG = "VPNAddComponent";

	public VPNAddComponent(Context context) {
		super(context);
	}

	/**
	 * {
	 * 	"list":[
	 * 			{
	 * 				"vpn_name":""
	 * 				...
	 * 				...
	 * 				...
	 * 			}
	 * 		]
	 * }
	 */
	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			Log.d(TAG, "Executing "+data.toString());
			JSONArray vpnList = data.optJSONArray(Constants.VPN_LIST);
		}
	}

}
