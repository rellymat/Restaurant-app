package com.example.bigproject;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dessert extends AppCompatActivity implements  View.OnClickListener {
    FirebaseDatabase database;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desert);
        View v = findViewById(R.id.back);
        v.setOnClickListener(this);
        View v2 = findViewById(R.id.sList);
        v2.setOnClickListener(this);
        ImageView pancake = (ImageView) findViewById(R.id.pancake_pic);
        ImageView muffin = (ImageView) findViewById(R.id.muffin_pic);
        ImageView cheesecake = (ImageView) findViewById(R.id.cake_pic);
        ImageView waffle = (ImageView) findViewById(R.id.waffle_pic);
        database = FirebaseDatabase.getInstance();
        myDialog = new Dialog(this);
        final DatabaseReference myRef = database.getReference("message");
        Button pancake_button = (Button) findViewById(R.id.pancake_button);
        pancake_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Pancake");
                Toast.makeText(Dessert.this, "Pancake added to list !",Toast.LENGTH_LONG).show();
            }
        });
        Button muffin_button = (Button) findViewById(R.id.muffin_button);
        muffin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Muffin");
                Toast.makeText(Dessert.this, "Muffin added to list !",Toast.LENGTH_LONG).show();
            }
        });
        Button waffle_button = (Button) findViewById(R.id.waffle_button);
        waffle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Waffle");
                Toast.makeText(Dessert.this, "Waffle added to list !",Toast.LENGTH_LONG).show();
            }
        });
        Button cheesecake_button = (Button) findViewById(R.id.cake_button);
        cheesecake_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Cheese Cake");
                Toast.makeText(Dessert.this, "Cheese Cake added to list !",Toast.LENGTH_LONG).show();

            }
        });
        pancake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.pancake);
                myDialog.show();
            }
        });
        muffin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.muffin);
                myDialog.show();
            }
        });
        cheesecake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.cheesecake);
                myDialog.show();
            }
        });
        waffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.waffle);
                myDialog.show();
            }
        });
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.back){
            Intent intentMain = new Intent(Dessert.this, MainActivity.class);
            startActivity(intentMain);
        }else if (v.getId()== R.id.sList) {
            Intent intentMain = new Intent(Dessert.this, SList.class);
            startActivity(intentMain);
        }

    }
}
