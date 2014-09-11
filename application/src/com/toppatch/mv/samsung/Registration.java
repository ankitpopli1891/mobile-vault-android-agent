package com.toppatch.mv.samsung;

import android.app.enterprise.DeviceInventory;
import android.app.enterprise.EnterpriseDeviceManager;
import android.app.enterprise.license.EnterpriseLicenseManager;
import android.content.Context;
import android.util.Log;

import com.toppatch.mv.Memory;

public class Registration {
	private static final String TAG = "com.toppatch.mv.samsung.Registration";

	public static boolean register(Context context) {
		String key = Memory.getLicenceKey();
		EnterpriseLicenseManager mLicenceManager = EnterpriseLicenseManager.getInstance(context);

		if (key == null)
			return false;

		mLicenceManager.activateLicense(key);
		return true;
	}

	public static boolean arePermissionsGranted(Context context) {
		EnterpriseDeviceManager edm = new EnterpriseDeviceManager(context);
		DeviceInventory deviceInventory = edm.getDeviceInventory();
		String deviceName = deviceInventory.getDeviceName();

		if (deviceName != null)
			Log.i(TAG, "Device name is " + deviceName);

		return true;
	}

}