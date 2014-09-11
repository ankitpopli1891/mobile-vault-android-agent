package com.toppatch.mv.generic.components.policies.bluetooth;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class BluetoothAddToBlackListComponent extends Component {

	private static final String TAG = "BluetoothAddToBlackListComponent";

	public BluetoothAddToBlackListComponent(Context context) {
		super(context);
	}

	/**{
	 * "list":[
	 * 	{
	 *   "bluetooth_name": "NAME",
	 *   "bluetooth_cod": 1,
	 *   "bluetooth_uuid": "00001101-0000-1000-8000-00805f9b34fb",
	 *   "bluetooth_pairing": true,
	 *   "android": true,
	 *   "iOS": true
	 *  }
	 * ]
	 * }
	 */
	@Override
	public void execute(JSONObject data) {
		if(data!=null){
			JSONArray list = data.optJSONArray(Constants.BLUETOOTH_LIST);
			
			if(list!=null){
			}
		}
	}
}
