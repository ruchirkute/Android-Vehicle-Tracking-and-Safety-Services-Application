package com.cs551androidproject.gpstracker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cs551androidproject.gpstracker.Database.LocationObject;
import com.cs551androidproject.gpstracker.Database.TableController;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    double lat=37.5399611,lng=-121.9731584;
    int count=0;
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    List<LocationObject> loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();

        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        int recordCount = new TableController(this).count();
        if (recordCount > 0){
            loc=readRecords();
        }else{
            boolean cretedSuccessfully = new TableController(getApplicationContext()).create();
            loc=readRecords();
        }
    }

    public List<LocationObject> readRecords(){

        List<LocationObject> locations = new TableController(this).read();
        if(locations.size()>0){
            return locations;
        }
        else{
            return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        for (int i = 0; i < loc.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(loc.get(i).getLat(), loc.get(i).getLng())).title(""+loc.get(i).getTitle()));
        }

        LatLng myCoordinates = new LatLng(lat,lng);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(myCoordinates, 13);
        mMap.animateCamera(yourLocation);

        mMap.setMyLocationEnabled(true);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myCoordinates)      // Sets the center of the map to LatLng (refer to previous snippet)
                .zoom(13)                   // Sets the zoom
                .bearing(340)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    public class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc)
        {

            lat=loc.getLatitude();
            lng=loc.getLongitude();
            if(count==0){
                setUpMapIfNeeded();
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

}
