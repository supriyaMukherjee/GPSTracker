package com.example.supriya.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
        mMap.setMyLocationEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        GPSActivity gpsActivity=new GPSActivity();
        Intent intent=getIntent();
       name=intent.getStringExtra("tbl_name2");
        DataBaseHandler db=new DataBaseHandler(this);

        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        try{
        List<LattLng> lattLngList = db.getallLatlng(name);
        for (LattLng ln : lattLngList) {
            LatLng pos = new LatLng(ln.getlat(), ln.getlng());
            mMap.addMarker(new MarkerOptions().position(pos).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));

        }


        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(),"no such saved location",Toast.LENGTH_LONG).show();
        }


    }
}