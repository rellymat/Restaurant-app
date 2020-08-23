package com.example.bigproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SList extends AppCompatActivity implements  View.OnClickListener{
    FirebaseDatabase database;
    ArrayList<String> arrayList;
    TextView tv ;
    TextView tvsum;
    HashMap<String, Integer> dishes;
    int i;
    LinearLayout linearLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slist_layout);
        database = FirebaseDatabase.getInstance();
        arrayList = new ArrayList<>();
         i=0;

        linearLayout = (LinearLayout)findViewById(R.id.list_layout2);
        Button mainmenu = (Button)findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(SList.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final DatabaseReference myRef = database.getInstance().getReference().child("message");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                     String val = snapshot.getValue(String.class);
                     arrayList.add(val);
                     System.out.println(val);
                }
                loadLayout(arrayList);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeAllViews();
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ent: dataSnapshot.getChildren()){
                            ent.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public  void loadLayout(ArrayList<String> arrayList){
        int sum = 0;
        dishes = new HashMap<>();
        for(String val : arrayList){
            if(dishes.containsKey(val)) {
                dishes.put(val, dishes.get(val) + 1 );
            } else{
                dishes.put(val, 1);
            }
            switch (val){
                case "Garlic Bread":
                sum += 5;

                break;
                case "Fries":
                    sum += 7;
                    break;
                case "Nachos":
                    sum += 12;
                    break;
                case "Soup":
                    sum += 10;
                    break;
                case "Hamburger":
                    sum += 15;
                    break;
                case "Steak":
                    sum += 20;
                    break;
                case "Pizza":
                    sum += 10;
                    break;
                case "Salmon":
                    sum += 25;
                    break;
                case "Pancake":
                    sum += 8;
                    break;
                case "Waffle":
                    sum += 11;
                    break;
                case "Cheese Cake":
                    sum += 6;
                    break;
                case "Muffin":
                    sum += 3;
                    break;
            }
        }
        for(HashMap.Entry ent: dishes.entrySet()){
            tv = new TextView(this);
            tv.setText(ent.getValue()+ " X " + ent.getKey() );
            tv.setId(i++);
            tv.setTextSize(20);
            tv.setOnClickListener(this);
            linearLayout.addView(tv);
        }
        tvsum = new TextView(this);
        tvsum.setText("Total: " + (Integer.toString(sum)) + "$");
        dishes.put("total", sum);
        tvsum.setTextSize(25);
        linearLayout.addView(tvsum);
    }

    @Override
    public void onClick(View v) {
        tv = findViewById(v.getId());
        int num;
        String str = "";
        str = tv.getText().toString();
        if((tv.getText().charAt(0)) == '1'){
            tv.setText("");

        }else{
            num = Character.getNumericValue(str.charAt(0))-1;
            tv.setText(Integer.toString(num) + str.substring(1,str.length()));
        }




    }
}
