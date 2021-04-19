package com.example.taxi_map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button btn_sorgula;
    TextView r1c1,r1c2,r2c1,r2c2,r3c1,r3c2,r4c1,r4c2,r5c1,r5c2;
    ExtendedFloatingActionButton fab1;


    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab1=findViewById(R.id.fab1);
        TableLayout table;

        btn_sorgula=findViewById(R.id.btn_sorgu_bir);
        table=findViewById(R.id.table);
        r1c1=findViewById(R.id.r1c1);
        r1c2=findViewById(R.id.r1c2);
        r2c1=findViewById(R.id.r2c1);
        r2c2=findViewById(R.id.r2c2);
        r3c1=findViewById(R.id.r3c1);
        r3c2=findViewById(R.id.r3c2);
        r4c1=findViewById(R.id.r4c1);
        r4c2=findViewById(R.id.r4c2);
        r5c1=findViewById(R.id.r5c1);
        r5c2=findViewById(R.id.r5c2);

        first_query();

        btn_sorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                table.setVisibility(View.VISIBLE);
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);

            }
        });



    }

    private void first_query(){


        ArrayList<Veri> max_trip_distance=new ArrayList<>();

        reference.orderByChild("trip_distance").limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Veri data=d.getValue(Veri.class);
                    max_trip_distance.add(data);

                }
                r1c1.setText(max_trip_distance.get(4).getTpep_dropoff_datetime());
                r1c2.setText(String.valueOf(max_trip_distance.get(4).getTrip_distance()));
                r2c1.setText(max_trip_distance.get(3).getTpep_dropoff_datetime());
                r2c2.setText(String.valueOf(max_trip_distance.get(3).getTrip_distance()));
                r3c1.setText(max_trip_distance.get(2).getTpep_dropoff_datetime());
                r3c2.setText(String.valueOf(max_trip_distance.get(2).getTrip_distance()));
                r4c1.setText(max_trip_distance.get(1).getTpep_dropoff_datetime());
                r4c2.setText(String.valueOf(max_trip_distance.get(1).getTrip_distance()));
                r5c1.setText(max_trip_distance.get(0).getTpep_dropoff_datetime());
                r5c2.setText(String.valueOf(max_trip_distance.get(0).getTrip_distance()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}