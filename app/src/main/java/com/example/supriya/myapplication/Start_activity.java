package com.example.supriya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Start_activity extends AppCompatActivity {
Button track,track_s;
    String to_b_saved, saved;
    EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
        track= (Button) findViewById(R.id.button);
        track_s= (Button) findViewById(R.id.button2);
        editText= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // DataBaseHandler.TABLE_LATNG=to_b_saved;
                Intent intent=new Intent(Start_activity.this,GPSActivity.class);
                intent.putExtra("tbl_name",editText.getText().toString());
                startActivity(intent);
            }
        });
        track_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // DataBaseHandler.TABLE_LATNG=saved;
                Intent intent=new Intent(Start_activity.this,MapsActivity.class);
                intent.putExtra("tbl_name2",editText2.getText().toString());
                startActivity(intent);

            }
        });
    }
}
