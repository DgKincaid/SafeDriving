package com.example.safedriver;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class UserLocation {

	public static void GetUserSpeedNetwork(LocationManager lManager, final Context context)
	{
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
	
	public static void GetUserSpeedGPS(LocationManager lManager, final Context context)
	{
		Toast.makeText(context, "UserLocation GPS Function", Toast.LENGTH_SHORT).show();
		LocationListener lListener = new LocationListener()
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
		
		lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
	}
}
