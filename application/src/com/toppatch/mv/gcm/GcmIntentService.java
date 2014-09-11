package com.toppatch.mv.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.toppatch.mv.generic.Controller;
import com.toppatch.mv.helper.NotificationHelper;

public class GcmIntentService extends IntentService {

	private static final String TAG = "GcmIntentService";

	public GcmIntentService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.e(TAG, "onHandleIntent");
		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

		// The getMessageType() intent parameter must be the intent you received
		// in your BroadcastReceiver.
		String messageType = gcm.getMessageType(intent);
		Log.e(TAG, "Got message from GCM Server");
		if (!extras.isEmpty()) {  
			// has effect of unparcelling Bundle
			if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
				NotificationHelper.sendNotification(getApplicationContext(),"Error","Send error: " + extras.toString(),null);
			} else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {
				NotificationHelper.sendNotification(getApplicationContext(),"Deleted","Deleted messages on server: " +extras.toString(),null);
			} else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
				Controller.execute(getApplicationContext(),extras);
			}
		} else {
			Log.e(TAG, "No exxtras!!!! Da fuk is this GCM message for?");
		}

		// Release the wake lock provided by the WakefulBroadcastReceiver.
		GcmBroadcastReceiver.completeWakefulIntent(intent);
	}
}