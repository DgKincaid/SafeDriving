package com.example.safedriver;

import java.sql.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

public class UserLocation {

	public static void GetUserSpeedNetwork(LocationManager lManager, final Context context)
	{
		Toast.makeText(context, "UserLocation GPS Function", Toast.LENGTH_SHORT).show();
		LocationListener lListener = new LocationListener()
		{
			public void onLocationChanged(android.location.Location location)
			{
				location.getLatitude();
				//Toast.makeText(context, "Current Speed:" + location.getSpeed(), Toast.LENGTH_SHORT).show();
				Toast.makeText(context, "Current Speed:" + location.getSpeed(), Toast.LENGTH_SHORT).show();
				
				Factory.SpeedTest(location.getSpeed(), context);
			}
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
			}
		};
		
		lManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, lListener);
	}
	
	public static void GetUserSpeedGPS(final LocationManager lManager, final Context context)
	{
		Toast.makeText(context, "UserLocation GPS Function", Toast.LENGTH_SHORT).show();
		final LocationListener lListener = new LocationListener()
		{
			public void onLocationChanged(android.location.Location location)
			{
				location.getLatitude();
				Toast.makeText(context, "Current Speed:" + location.getSpeed(), Toast.LENGTH_SHORT).show();
				
				Factory.SpeedTest(location.getSpeed(), context);
			}
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
			}
		};
		
		//BroadcastReceiver receiver = new BroadcastReceiver() 
		{
            //@Override public void onReceive( Context context, Intent _ )
            {
            	lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
            	//Toast.makeText(context, "Current Speed: broadcast reciever", Toast.LENGTH_SHORT).show();
                //context.unregisterReceiver( this ); // this == BroadcastReceiver, not Activity
            }
        }
		
        /*context.registerReceiver( receiver, new IntentFilter("com.blah.blah.somemessage") );

        PendingIntent pintent = PendingIntent.getBroadcast(context, 0, new Intent("com.blah.blah.somemessage"), 0 );
        AlarmManager manager = (AlarmManager)(context.getSystemService( Context.ALARM_SERVICE ));

        manager.set( AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 1000*60, pintent );*/
	}
}
