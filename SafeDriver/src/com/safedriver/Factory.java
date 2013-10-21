package com.safedriver;

import android.app.Service;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.widget.Toast;

public class Factory {
	
	public static void SpeedTest(float speed, Context context)
	{
		AudioManager audioManager = (AudioManager)context.getSystemService(Service.AUDIO_SERVICE);
		//Toast.makeText(context, "Factory SpeedTest Function", Toast.LENGTH_SHORT).show();
		
		if(speed >= 10)
		{
	        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	        //Toast.makeText(context, "Speed > 10", Toast.LENGTH_SHORT).show();
		}
		else if(speed < 10 && audioManager.getRingerMode() != 1)
		{
			audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			//Toast.makeText(context, "Speed < 10", Toast.LENGTH_SHORT).show();
		}
	}
	
	public static void LocationProvider(Context context)
	{
		LocationManager lManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		//Toast.makeText(context, "Factory LocationProvider Function", Toast.LENGTH_SHORT).show();
		
		//if((lManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)))
		{
			//Toast.makeText(context, "Factory LocationProvider Function Else", Toast.LENGTH_SHORT).show();
			UserLocation.GetUserSpeedGPS(lManager, context);
		}
//		else
//		{
//			Toast.makeText(context, "Factory LocationProvider Function If", Toast.LENGTH_SHORT).show();
//			UserLocation.GetUserSpeedNetwork(lManager, context);
//		}
	}
}
