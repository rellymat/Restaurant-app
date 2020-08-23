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


public class Breakfast  extends AppCompatActivity implements  View.OnClickListener {
    Dialog myDialog;
    FirebaseDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starters_layout);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");
        ImageView garlic = (ImageView) findViewById(R.id.starters1);
        ImageView soup = (ImageView) findViewById(R.id.starters2);
        ImageView nachos = (ImageView) findViewById(R.id.starters4);
        ImageView fries = (ImageView) findViewById(R.id.starters3);
        myDialog = new Dialog(this);
        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.garlic);
                myDialog.show();
            }
        });
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.soup);
                myDialog.show();
            }
        });
        fries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.fries);
                myDialog.show();
            }
        });
        nachos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.nachos);
                myDialog.show();
            }
        });
        View v = findViewById(R.id.back);
        v.setOnClickListener(this);
        View v2 = findViewById(R.id.sList);
        v2.setOnClickListener(this);
        Button garlic_button = (Button) findViewById(R.id.garlic_button);
        garlic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Garlic Bread");
                Toast.makeText(Breakfast.this, "Garlic Bread added to list !",Toast.LENGTH_LONG).show();
            }
        });
        Button fries_button = (Button) findViewById(R.id.fries_button);
        fries_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Fries");
                Toast.makeText(Breakfast.this, "Fries added to list !",Toast.LENGTH_LONG).show();
            }
        });
        Button soup_button = (Button) findViewById(R.id.soup_button);
        soup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Soup");
                Toast.makeText(Breakfast.this, "Soup added to list !",Toast.LENGTH_LONG).show();

            }
        });
        Button nachos_button = (Button) findViewById(R.id.nachos_button);
        nachos_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.push().setValue("Nachos");
                Toast.makeText(Breakfast.this, "Nachos added to list !",Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.back){
            Intent intentMain = new Intent(Breakfast.this, MainActivity.class);
            startActivity(intentMain);
        }else if (v.getId()== R.id.sList) {
            Intent intentMain = new Intent(Breakfast.this, SList.class);
            startActivity(intentMain);
        }
    }

}

