package com.example.supriya.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supriya on 02-08-2016.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="LOCATIONS.db";
    public static final String KEY_ID="ID";
    public static final String KEY_LAT="LATITUDES";
    public static final String KEY_LNG="LONGITUDES";

    public DataBaseHandler(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    void addLatlng(LattLng latlng,String tbl_name){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_LAT,latlng.getlat());
        values.put(KEY_LNG,latlng.getlng());
        db.insert(tbl_name, null, values);
        //db.setTransactionSuccessful();
        db.close();

    }


    public List<LattLng> getallLatlng(String name){
        List<LattLng> latlnglist=new ArrayList<LattLng>();
        String select_query="SELECT * FROM "+ name;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(select_query,null);
        if(cursor.moveToFirst()){
            do{
                LattLng lattLng=new LattLng();
                lattLng.setId(Integer.parseInt(cursor.getString(0)));
                lattLng.setlat(Double.parseDouble(cursor.getString(1)));
                lattLng.setlng(Double.parseDouble(cursor.getString(2)));
                latlnglist.add(lattLng);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return latlnglist;


    }
    public void createTable(String TABLE_LATNG)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String create_table="CREATE TABLE " + TABLE_LATNG + "(" + KEY_ID + " Integer Primary Key AutoIncrement," + KEY_LAT + " DOUBLE," + KEY_LNG + " DOUBLE" + ");";
        db.execSQL(create_table);
        db.close();
    }
}
