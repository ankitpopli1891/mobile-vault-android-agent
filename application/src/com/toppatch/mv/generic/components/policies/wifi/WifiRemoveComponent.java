package com.toppatch.mv.generic.components.policies.wifi;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class WifiRemoveComponent extends Component {

	private static final String TAG = "WifiRemoveComponent";

	private Context context;

	public WifiRemoveComponent(Context context) {
		super(context);
	}

	/**
	 * data is a JSON object having attribute list. 
	 * {
	 * 	"list":[
	 * 			{
	 * 				"ssid": "XYZ"
	 * 			},
	 * 			{
	 * 				"ssid": "PQR"
	 * 			}
	 * 		]
	 * }
	 */
	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		JSONArray wifiList = data.optJSONArray(Constants.WIFI_LIST);
		if(wifiList != null) {
			int length = wifiList.length();
			for(int i = 0; i < length; i++) {
				removeWiFiConfigurationBySSID(((wifiList.optJSONObject(i) != null)?wifiList.optJSONObject(i).optString(Constants.WIFI_SSID):"[[null]]"));
			}
		}
	}

	private boolean removeWiFiConfigurationBySSID(String ssid){
		WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		List<WifiConfiguration> item = wifi.getConfiguredNetworks();

		for(int i = 0; i < item.size(); i++) {
			WifiConfiguration config = item.get(0);
			if(config.SSID.equals(ssid)) {
				int networkId = config.networkId;
				wifi.removeNetwork(networkId);
				wifi.saveConfiguration();
			}
		}
		return true;
	}
}