package com.example.bigproject;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database;
    TextView tv ;
    LinearLayout linearLayout;
    ArrayList<String> arrayList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.maindish);
        v.setOnClickListener(this);

        View v2 = findViewById(R.id.starters);
        v2.setOnClickListener(this);

        View v3 = findViewById(R.id.dessert);
        v3.setOnClickListener(this);

        View v4 = findViewById(R.id.sList);
        v4.setOnClickListener(this);
    }
        @Override
        public void onClick(View arg0){
            if(arg0.getId() == R.id.maindish){
                Intent intentMain = new Intent(MainActivity.this, Launch.class);
                startActivity(intentMain);
            } else if (arg0.getId()== R.id.starters){
                Intent intentMain = new Intent(MainActivity.this, Breakfast.class);
                startActivity(intentMain);
            } else if (arg0.getId()== R.id.dessert) {
                Intent intentMain = new Intent(MainActivity.this, Dessert.class);
                startActivity(intentMain);
            } else if (arg0.getId()== R.id.sList) {
                Intent intentMain = new Intent(MainActivity.this, SList.class);
                startActivity(intentMain);
            }

        }

}









