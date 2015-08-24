package com.cs551androidproject.gpstransmitter;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainActivity extends Activity {

    double lat,lng;
    int count=0;
    String deviceID,codeName;

    Button reg;
    TextView serialText,latitudeText,longitudeText;
    EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serialText = (TextView)findViewById(R.id.serialCode);
        latitudeText = (TextView)findViewById(R.id.latitudeTxt);
        longitudeText = (TextView)findViewById(R.id.longitudeTxt);
        code = (EditText) findViewById(R.id.editText);

        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();

        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        serialText.setText(tm.getDeviceId());
        deviceID = tm.getDeviceId();

        reg = (Button)findViewById(R.id.button);
        reg.setEnabled(false);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SigninActivity().execute(String.valueOf(lat), String.valueOf(lng), deviceID, code.getText().toString());
                TelephonyManager tmTest = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                Toast.makeText(getApplicationContext(), tmTest.getDeviceId() + " Updated with location", Toast.LENGTH_LONG).show();
                reg.setEnabled(false);
            }
        });
    }

    public class MyLocationListener implements LocationListener

    {
        @Override
        public void onLocationChanged(Location loc)
        {

            if(count==0){
                lat=loc.getLatitude();
                lng=loc.getLongitude();
                latitudeText.setText(String.valueOf(lat));
                longitudeText.setText(String.valueOf(lng));
                if(code.getText().toString().equals("") || code.getText().toString().equals(" ")) {
                    Toast.makeText(getApplicationContext(),"Please enter Code to enable register button",Toast.LENGTH_SHORT);
                }
                else
                {
                    ++count;
                    reg.setEnabled(true);
                }
            }


            if((lat-loc.getLatitude() > 0.0005)||(lat-loc.getLatitude() < -0.0005)) {
                lat=loc.getLatitude();
                lng=loc.getLongitude();
                latitudeText.setText(String.valueOf(lat));
                longitudeText.setText(String.valueOf(lng));
                new SigninActivity().execute(String.valueOf(lat),String.valueOf(lng), deviceID,code.getText().toString());
                String Text = "Your current location is: "+"Latitude = " + loc.getLatitude() +"Longitude = " + loc.getLongitude();
                makeText(getApplicationContext(), Text, LENGTH_SHORT).show();
            }

        }

        @Override
        public void onProviderDisabled(String provider)
        {
            makeText(getApplicationContext(), "Gps Disabled", LENGTH_SHORT).show();
        }

        @Override
        public void onProviderEnabled(String provider)
        {
            makeText(getApplicationContext(), "Gps Enabled", LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
