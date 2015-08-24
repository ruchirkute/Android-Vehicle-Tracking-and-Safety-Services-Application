package com.cs551androidproject.gpstracker.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TableController extends DatabaseHandler {
    boolean createSuccessful;
    public TableController(Context context) {
        super(context);
    }

    public boolean create( ) {

        ContentValues values = new ContentValues();


        SQLiteDatabase db = this.getWritableDatabase();

        values.put("lat", "37.5460507");
        values.put("lng", "-121.979212");
        values.put("title", "Fremont Hospital");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.548542");
        values.put("lng", "-121.973671");
        values.put("title", "Obstetrics & Gynecology");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5497752");
        values.put("lng", "-121.986126");
        values.put("title", "Ace Animal Hospital");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5298113");
        values.put("lng", "-122.1112139");
        values.put("title", "Kaiser Permanente");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.547388");
        values.put("lng", "-121.973442");
        values.put("title", "Psychiatry");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.551531");
        values.put("lng", "-121.9804776");
        values.put("title", "Fremont Urgent Care");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5542341");
        values.put("lng", "-121.9752304");
        values.put("title", "Fremont Surgery Center");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5569211");
        values.put("lng", "-121.9821616");
        values.put("title", "Washington Outpatient Surgery Center");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5570922");
        values.put("lng", "-121.9810939");
        values.put("title", "Washington Hospital");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5815704");
        values.put("lng", "-121.9822913");
        values.put("title", "Quest Diagnostics");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.532554");
        values.put("lng", "-121.9976182");
        values.put("title", "Precision SurgiCenter");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.4771427");
        values.put("lng", "-121.9432734");
        values.put("title", "Universal Hospital Services");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.4771427");
        values.put("lng", "-121.9432734");
        values.put("title", "Walgreens");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.5933328");
        values.put("lng", "-122.0165042");
        values.put("title", "Fremont Acupuncture");
        createSuccessful = db.insert("location", null, values) > 0;

        //-------------------------------------------------------------//

        values.put("lat", "37.434367");
        values.put("lng", "-122.174072");
        values.put("title", "Stanford Hospital");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "39.142825");
        values.put("lng", "-121.618066");
        values.put("title", "Fremont Hospital");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.557260");
        values.put("lng", "-121.979760");
        values.put("title", "Washington Hospital Healthcare");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.4849812");
        values.put("lng", "-121.947746");
        values.put("title", "Arkal Medical Inc");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.5244609");
        values.put("lng", "-121.9607445");
        values.put("title", "Fremont Healthcare Center");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.5184406");
        values.put("lng", "-121.9604693");
        values.put("title", "Surgicenter: Fremont Center: Palo Alto Med Foundation: Sutter Health Affiliate");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.336397");
        values.put("lng", "-121.997638");
        values.put("title", "Kaiser Permanente Santa Clara Medical Center");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.336334");
        values.put("lng", "-121.997459");
        values.put("title", "Kaiser Permanente");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.313762 ");
        values.put("lng", "-121.933259 ");
        values.put("title", "Santa Clara Valley Medical Center");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.251192 ");
        values.put("lng", "-121.946821 ");
        values.put("title", "Good Samaritan Hospital");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.368889 ");
        values.put("lng", "-122.079944 ");
        values.put("title", "El Camino Hospital, Mt View");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.797928");
        values.put("lng", "-122.232063");
        values.put("title", "Alameda County Medical Center");
        createSuccessful = db.insert("location", null, values) > 0;

        values.put("lat", "37.855928");
        values.put("lng", "-122.257303");
        values.put("title", "Alta Bates Summit Medical Center, Berkeley");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.716544");
        values.put("lng", "-122.130243");
        values.put("title", "Kindred Hospital, San Leandro");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.804364");
        values.put("lng", "-122.271114");
        values.put("title", "Kaiser Fnd Hospital, Oakland");
        createSuccessful = db.insert("location", null, values) > 0;


        values.put("lat", "37.697293");
        values.put("lng", "-122.087016");
        values.put("title", "Eden Medical Center");
        createSuccessful = db.insert("location", null, values) > 0;



        db.close();

        return createSuccessful;
    }
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM location";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public List<LocationObject> read() {

        List<LocationObject> recordsList = new ArrayList<LocationObject>();

        String sql = "SELECT * FROM location ORDER BY id DESC";

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
