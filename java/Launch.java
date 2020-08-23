package com.example.bigproject;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Launch extends AppCompatActivity implements  View.OnClickListener {
    FirebaseDatabase database;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maindish);
        ImageView hamburger = (ImageView) findViewById(R.id.hamburger_pic);
        ImageView steak = (ImageView) findViewById(R.id.steak_pic);
        ImageView pizza = (ImageView) findViewById(R.id.pizza_pic);
        ImageView salmon = (ImageView) findViewById(R.id.salmon_pic);
        database = FirebaseDatabase.getInstance();
        myDialog = new Dialog(this);
        final DatabaseReference myRef = database.getReference("message");
        View v = findViewById(R.id.back);
        v.setOnClickListener(this);
        View v2 = findViewById(R.id.sList);
        v2.setOnClickListener(this);
        Button hamburger_button = (Button) findViewById(R.id.hamburger_button);
        hamburger_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Hamburger");
                Toast.makeText(Launch.this, "Hamburger added to list !",Toast.LENGTH_LONG).show();

            }
        });
        Button steak_button = (Button) findViewById(R.id.steak_button);
        steak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Steak");
                Toast.makeText(Launch.this, "Steak added to list !",Toast.LENGTH_LONG).show();

            }
        });
        Button pizza_button = (Button) findViewById(R.id.pizza_button);
        pizza_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Pizza");
                Toast.makeText(Launch.this, "Pizza added to list !",Toast.LENGTH_LONG).show();

            }
        });
        Button salmon_button = (Button) findViewById(R.id.salmon_button);
        salmon_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Salmon");
                Toast.makeText(Launch.this, "Salmon added to list !",Toast.LENGTH_LONG).show();

            }
        });
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.hamburger);
                myDialog.show();
            }
        });
        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.steak);
                myDialog.show();
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.pizza);
                myDialog.show();
            }
        });
        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.salmon);
                myDialog.show();
            }
        });
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.back){
            Intent intentMain = new Intent(Launch.this, MainActivity.class);
            startActivity(intentMain);
        }else if (v.getId()== R.id.sList) {
            Intent intentMain = new Intent(Launch.this, SList.class);
            startActivity(intentMain);
        }

    }

}
