package com.cs551androidproject.gpstracker.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class GarageController extends DatabaseHandler {
    boolean createSuccessful;
    public GarageController(Context context) {
        super(context);
    }

    public boolean create( ) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();


        values.put("lat", "37.359828");
        values.put("lng", "-121.981435");
        values.put("title", "MB German Car Service");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.432372");
        values.put("lng", "-121.899353");
        values.put("title", "Milpitas Garage LLC");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.721513");
        values.put("lng", "-122.479739");
        values.put("title", "South Bay Honda");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "36.778261");
        values.put("lng", "-119.417932");
        values.put("title", "Enriques Auto Upholstery");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "52.114618");
        values.put("lng", "-106.289369");
        values.put("title", "Pit Row");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "36.778261");
        values.put("lng", "-119.417932");
        values.put("title", "Exact Motorsports,");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "48.576572");
        values.put("lng", "-89.416524");
        values.put("title", "Bay City Automotive");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.514844");
        values.put("lng", "-121.913176");
        values.put("title", "KT Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.432372");
        values.put("lng", "-121.899353");
        values.put("title", "Alvins Auto Center");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "38.705310");
        values.put("lng", "-121.170111");
        values.put("title", "68 Auto Detail");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "34.845818");
        values.put("lng", "-116.456098");
        values.put("title", "Garage Door Guys");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.353966");
        values.put("lng", "-121.952999");
        values.put("title", "Oller Bros Automotive Service");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.398604");
        values.put("lng", "-121.964375");
        values.put("title", " DICE Motorsports");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.359828");
        values.put("lng", "-121.981435");
        values.put("title", "Keystone Auto Service");
        createSuccessful = db.insert("garage", null, values) > 0;






        values.put("lat", "37.561844");
        values.put("lng", "-122.012354");
        values.put("title", "Fremont Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.579023");
        values.put("lng", "-121.977555");
        values.put("title", "Mission Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.568287");
        values.put("lng", "-121.970913");
        values.put("title", "West Coast Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.558700");
        values.put("lng", "-122.008465");
        values.put("title", "Dhillon Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.533815");
        values.put("lng", "-121.957808");
        values.put("title", "Bob's Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;



        values.put("lat", "37.594319");
        values.put("lng", "-122.019326");
        values.put("title", "T & L's Elite Automotive Brakes & Transmissions");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.596068");
        values.put("lng", "-122.033860");
        values.put("title", "Union City Auto Body");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.602556");
        values.put("lng", "-122.032456");
        values.put("title", "Bay Star Auto Care");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.610808");
        values.put("lng", "-122.068845");
        values.put("title", "Pep Boys Auto Parts & Service");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.583907");
        values.put("lng", "-122.008711");
        values.put("title", "Autowise Car Care");
        createSuccessful = db.insert("garage", null, values) > 0;



        values.put("lat", "37.336858");
        values.put("lng", "-121.876192");
        values.put("title", "Naglee Park Garage");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.339324");
        values.put("lng", "-121.880713");
        values.put("title", "North Parking Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.371691");
        values.put("lng", "-121.922763");
        values.put("title", "Ace Parking");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.279777");
        values.put("lng", "-121.851689");
        values.put("title", "Heritage Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.338208");
        values.put("lng", "-121.886329");
        values.put("title", "Halcyon Overhead Garage");
        createSuccessful = db.insert("garage", null, values) > 0;



        values.put("lat", "37.548270");
        values.put("lng", "-121.988572");
        values.put("title", "MILPITAS GARAGE");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.459599");
        values.put("lng", "-121.910555");
        values.put("title", "RCO Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.432334");
        values.put("lng", "-121.899574");
        values.put("title", "Garage Door Guys");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.429385");
        values.put("lng", "-121.883904");
        values.put("title", "Professional Garage");
        createSuccessful = db.insert("garage", null, values) > 0;



        values.put("lat", "37.432334");
        values.put("lng", "-121.899574");
        values.put("title", "Handyman Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.394345");
        values.put("lng", "-122.077748");
        values.put("title", "Depot Garage");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.428434");
        values.put("lng", "-122.072382");
        values.put("title", "Garage One Subaru Workshop");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.411827");
        values.put("lng", "-122.092049");
        values.put("title", "Garage Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.396386");
        values.put("lng", "-122.086683");
        values.put("title", "Accurate Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.386052");
        values.put("lng", "-122.083851");
        values.put("title", "Handyman Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.445797");
        values.put("lng", "-122.157575");
        values.put("title", "Webster/Cowper Garage");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.420924");
        values.put("lng", "-122.135894");
        values.put("title", "eCar Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.441883");
        values.put("lng", "-122.143019");
        values.put("title", "Handyman Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.445614");
        values.put("lng", "-122.161539");
        values.put("title", "KEEN Garage");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.441883");
        values.put("lng", "-122.143019");
        values.put("title", "Active Garage Repair");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.382583");
        values.put("lng", "-122.044426");
        values.put("title", "Georges Fuel & Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;

        values.put("lat", "37.406118");
        values.put("lng", "-121.995243");
        values.put("title", "Overhead Door Company");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.379924");
        values.put("lng", "-122.033385");
        values.put("title", "Hank Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.381739");
        values.put("lng", "-122.042096");
        values.put("title", "Le's Auto Repair");
        createSuccessful = db.insert("garage", null, values) > 0;


        values.put("lat", "37.375796");
        values.put("lng", "-122.028869");
        values.put("title", "First Auto Service");
        createSuccessful = db.insert("garage", null, values) > 0;


        db.close();

        return createSuccessful;
    }
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM garage";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public List<LocationObject> read() {

        List<LocationObject> recordsList = new ArrayList<LocationObject>();

        String sql = "SELECT * FROM garage ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                double lat=cursor.getDouble(cursor.getColumnIndex("lat"));
                double lng=cursor.getDouble(cursor.getColumnIndex("lng"));
                String title = cursor.getString(cursor.getColumnIndex("title"));


                LocationObject locationObject = new LocationObject();
                locationObject.setLat(lat);
                locationObject.setLng(lng);
                locationObject.setTitle(title);

                recordsList.add(locationObject);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return recordsList;
    }

}
