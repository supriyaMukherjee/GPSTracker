package com.example.supriya.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.location.Criteria;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.annotation.TargetApi;
import android.location.Location;
import android.location.LocationListener;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.content.ContextWrapper;
import android.os.Build;


import android.widget.Toast;


public class GPSActivity extends FragmentActivity implements LocationListener {

    private GoogleMap mMap;
    LocationManager locationManager;
    String name_t;
    DataBaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (!isGooglePlayServicesAvailable()) {
            finish();
        }*/
        setContentView(R.layout.activity_gps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
        mMap.setMyLocationEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        db=new DataBaseHandler(this);


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
try
     {
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }

        locationManager.requestLocationUpdates(bestProvider,2000,0,this);
     }
catch (SecurityException ex){
    Toast.makeText(getApplicationContext(),"catch",Toast.LENGTH_LONG).show();
}


        Intent intent=getIntent();
        name_t=intent.getStringExtra("tbl_name");
        Toast.makeText(getApplicationContext(),name_t,Toast.LENGTH_LONG).show();
        db.createTable(name_t);

    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude=location.getLatitude();
        double longitude=location.getLongitude();
        Toast.makeText(getApplicationContext(),latitude+"  "+longitude,Toast.LENGTH_LONG).show();
        LatLng myLocation = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("Marker in My Location"));
        db.addLatlng(new LattLng(latitude, longitude),name_t);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getApplicationContext(),"GPS ENABLED",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getApplicationContext(),"GPS DISABLED",Toast.LENGTH_LONG).show();
    }
   /* private boolean isGooglePlayServicesAvailable(){
        int status=GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(ConnectionResult.SUCCESS==status){
            return true;
        }
        else {
            GooglePlayServicesUtil.getErrorDialog(status,this,0).show();
            return false;
        }
    }*/

}

