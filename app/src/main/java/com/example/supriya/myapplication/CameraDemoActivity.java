package com.example.supriya.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class CameraDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int SCROLL_BY_PX=100;
 public static  final CameraPosition BONDI=new CameraPosition.Builder().target(new LatLng(-33.891614, 151.276417)).zoom(15.5f).bearing(300).tilt(50).build();
    public  static final CameraPosition SYDNEY=new CameraPosition.Builder().target(new LatLng(-33.87365, 151.20689)).zoom(15.5f).bearing(0).tilt(25).build();
   private  GoogleMap mMap;
    private CompoundButton mAnimateToggle;
    private CompoundButton mCustomDurationToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
