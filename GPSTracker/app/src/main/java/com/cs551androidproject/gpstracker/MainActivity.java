package com.cs551androidproject.gpstracker;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileInputStream;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainActivity extends ActionBarActivity {

    String data;
    double lat,lng;
    private String file = "eContactFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TelephonyManager tmanager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();

        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        ImageButton hospital = (ImageButton)findViewById(R.id.hospital_button);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMaps = new Intent(v.getContext(), MapsActivity.class);
                startActivity(openMaps);
            }
        });


        ImageButton garage = (ImageButton)findViewById(R.id.garage_button);
        garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMapsGarage = new Intent(v.getContext(),GarageActivity.class);
                startActivity(openMapsGarage);
            }
        });


        ImageButton button = (ImageButton)findViewById(R.id.track_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj1 = new Intent(v.getContext(), CodeEntry.class);

                startActivity(intentObj1);

            }
        });

        ImageButton button2 = (ImageButton)findViewById(R.id.ambulance_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                callIntent2.setData(Uri.parse("tel:2222222222"));
                startActivity(callIntent2);

            }
        });

        ImageButton button3 = (ImageButton)findViewById(R.id.firestation_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent3 = new Intent(Intent.ACTION_CALL);
                callIntent3.setData(Uri.parse("tel:2222222222"));
                startActivity(callIntent3);
            }
        });

        ImageButton button4 = (ImageButton)findViewById(R.id.police_button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent4 = new Intent(Intent.ACTION_CALL);
                callIntent4.setData(Uri.parse("tel:2222222222"));
                startActivity(callIntent4);
            }
        });

        ImageButton button5 = (ImageButton)findViewById(R.id.sos_register_button);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj2 = new Intent(v.getContext(), sos_register.class);
                startActivity(intentObj2);
            }
        });

        ImageButton sos_button = (ImageButton) findViewById(R.id.sos_button);
        sos_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c;
                String temp="";
                try{
                    FileInputStream fin = openFileInput(file);
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                }
                catch(Exception e){
                }
                String numbers[] = temp.split("----");
                if(numbers[0].trim().equalsIgnoreCase("")){

                }else if(numbers[0].trim().length()>9 && numbers[0].trim().length()<12){
                    sendSMSMessage(numbers[0]);
                }
                else{}

                if(numbers[1].trim().equalsIgnoreCase("")){

                }else if(numbers[1].trim().length()>9 && numbers[1].trim().length()<12){
                    sendSMSMessage(numbers[1]);
                } else{}

                if(numbers[2].trim().equalsIgnoreCase("")){

                }else if(numbers[2].trim().length()>9 && numbers[2].trim().length()<12){
                    sendSMSMessage(numbers[2]);
                }else{}

                Toast.makeText(getBaseContext(),"Message sent to all emergency Contacts",Toast.LENGTH_SHORT).show();

            }
        });
    }

    protected void sendSMSMessage(String phoneNo) {

        SpannableString uri = new SpannableString("http://maps.google.com/maps?q=" +lat+","+lng);
        Linkify.addLinks(uri, Linkify.ALL);
        String message="Hey Please help, I am in emergency. My location is: "+uri;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again."+e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class MyLocationListener implements LocationListener

    {
        @Override
        public void onLocationChanged(Location loc)
        {
                lat=loc.getLatitude();
                lng=loc.getLongitude();
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            makeText(getApplicationContext(), "Gps Disabled", Toast.LENGTH_LONG).show();

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}