package com.example.safedriver;

import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button startButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startButton = (Button) findViewById(R.id.button1);
		 
		startButton.setOnClickListener(new View.OnClickListener() {
 
			@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
			@SuppressWarnings("deprecation")
			public void onClick(View arg0) {
 
				/**
			     Toast.makeText(getApplicationContext(), 
			    		 Settings.System.getInt(
			    			      getContentResolver(), 
			    			      Settings.Global.AIRPLANE_MODE_ON, 0), Toast.LENGTH_LONG).show();
			    */
				
					AudioManager am;
					am = (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
					
					am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
