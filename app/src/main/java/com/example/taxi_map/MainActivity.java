package com.example.taxi_map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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
    TextView textView_veri;
    ArrayList<Veri> veriler;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        veriler=new ArrayList<>();

        btn_sorgula=findViewById(R.id.btn_sorgula);
        textView_veri=findViewById(R.id.textView_veri);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Veri veri=d.getValue(Veri.class);
                    veriler.add(veri);
                    textView_veri.setText("Veri Çekme Başarılı");


                }

                if (veriler != null) {
                    first_query();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MainActivity.this, "Hata İle Karşılaşıldı", Toast.LENGTH_SHORT).show();

            }
        });






    }

    private void first_query(){


        textView_veri.setText(String.valueOf(veriler.get(1).getID()));
    }
}