package com.toppatch.mv.generic.components.policies.wifi;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.toppatch.mv.Constants;
import com.toppatch.mv.generic.components.Component;

public class WifiAddComponent extends Component {

	private static final String TAG = "WifiAddComponent";

	private Context context;

	public WifiAddComponent(Context context) {
		super(context);

		this.context = context;
	}

	/**
	 * { "list":[ { "ssid": "", "security": "PSK", "psk": "" }, { "ssid":"",
	 * "security": "WEP", "key": "" }, { "ssid": "", "security": "NONE" } ] }
	 */
	@Override
	public void execute(JSONObject data) {
		if (data == null) {
			Log.d(TAG, "null received");
			return;
		}

		Log.d(TAG, "Executing: " + data.toString());

		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiConfiguration wifiConfiguration = null;

		JSONArray wifiList = data.optJSONArray(Constants.WIFI_LIST);
		if (wifiList != null && wifiList.length() > 0) {
			for (int i = 0; i < wifiList.length(); i++) {
				wifiConfiguration = new WifiConfiguration();
				try {
					JSONObject wifiConfig = wifiList.getJSONObject(i);
					if (wifiConfig != null) {
						String security = wifiConfig.optString(Constants.WIFI_SECURITY);

						wifiConfiguration.SSID = "\"" + wifiConfig.optString(Constants.WIFI_SSID) + "\"";

						if(security.equalsIgnoreCase("PSK")) {
							// WPA
							wifiConfiguration.preSharedKey = "\""+ wifiConfig.optString(Constants.WIFI_KEY) +"\"";
						} else if (security.equalsIgnoreCase("WEP")) {
							// WEP
							wifiConfiguration.wepKeys[0] = "\"" + wifiConfig.optString(Constants.WIFI_KEY) + "\""; 
							wifiConfiguration.wepTxKeyIndex = 0;
							wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
							wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
						} else {
							// Open Network
							wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
						}

						// TODO handle auto_join
						wifiConfiguration.hiddenSSID = wifiConfig.optBoolean(Constants.WIFI_HIDDEN_SSID, false);

						int networkID = wifiManager.addNetwork(wifiConfiguration);
						Log.d(TAG, "Network ID: " + networkID);
					}

					List<WifiConfiguration> config = wifiManager.getConfiguredNetworks();
					Log.d(TAG, "Size: " + config.size());
					for (int j = 0; j < config.size(); j++) {

					}
				} catch (JSONException e) {
					Log.e(TAG, e.getMessage(), e);
				}
			}
		}
	}

}
