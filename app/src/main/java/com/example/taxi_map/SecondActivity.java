package com.example.taxi_map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

public class SecondActivity extends AppCompatActivity {

    private Date oneWayTripDate;
    private Date date_s;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference();
    ArrayList<Veri> want_dates=new ArrayList<>();

    Button btn_sorgula;
    Button date_picker1;
    Button date_picker2;
    Button fab2;
    Button btn_sorgu_iki_yenile;
    int start_day,last_day,start_month,last_month;

    TextView r1c1,r1c2,r1c3,r2c1,r2c2,r2c3,r3c1,r3c2,r3c3,r4c1,r4c2,r4c3,r5c1,r5c2,r5c3;



    DatePickerDialog datePickerDialog;


    Tarih sDate=new Tarih();
    Tarih lDate=new Tarih();

    TableLayout table;
    TableRow row1,row2,row3,row4,row5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        date_picker1=findViewById(R.id.date_picker1);
        date_picker2=findViewById(R.id.date_picker2);
        btn_sorgula=findViewById(R.id.btn_sorgula_iki);
        btn_sorgu_iki_yenile=findViewById(R.id.btn_sorgula_iki_tekrar);
        table=findViewById(R.id.table2);
        r1c1=findViewById(R.id.r1c1_2);
        r1c2=findViewById(R.id.r1c2_2);
        r1c3=findViewById(R.id.r1c3_2);
        r2c1=findViewById(R.id.r2c1_2);
        r2c2=findViewById(R.id.r2c2_2);
        r2c3=findViewById(R.id.r2c3_2);
        r3c1=findViewById(R.id.r3c1_2);
        r3c2=findViewById(R.id.r3c2_2);
        r3c3=findViewById(R.id.r3c3_2);
        r4c1=findViewById(R.id.r4c1_2);
        r4c2=findViewById(R.id.r4c2_2);
        r4c3=findViewById(R.id.r4c3_2);
        r5c1=findViewById(R.id.r5c1_2);
        r5c2=findViewById(R.id.r5c2_2);
        r5c3=findViewById(R.id.r5c3_2);
        row1=findViewById(R.id.tRow1);
        row2=findViewById(R.id.tRow2);
        row3=findViewById(R.id.tRow3);
        row4=findViewById(R.id.tRow4);
        row5=findViewById(R.id.tRow5);



        date_picker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tarih_sec(date_picker1,sDate);

            }
        });
        date_picker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarih_sec(date_picker2,lDate);
            }
        });



        btn_sorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                table.setVisibility(View.VISIBLE);
                second_query(sDate,lDate);
                btn_sorgu_iki_yenile.setVisibility(View.VISIBLE);
                btn_sorgula.setVisibility(View.GONE);

            }
        });

        btn_sorgu_iki_yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });







    }

    private void second_query(Tarih sDay,Tarih lDay){




        ArrayList<Veri> dates=new ArrayList<>();

        reference.orderByChild("trip_distance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Veri data=d.getValue(Veri.class);
                    dates.add(data);


                }


                if(dates.size()>1){
                    for (Veri veri:dates){
                        boolean bool=select_day(veri.getTpep_pickup_datetime(),12,sDay.gun,lDay.gun);
                        if (bool){
                            want_dates.add(veri);
                        }
                    }

                    Log.e("Size",":"+want_dates.size());
                    Collections.sort(want_dates, new DistanceComparator());
                    Log.e("0"+want_dates.get(0).getTrip_distance(),"0"+want_dates.get(0).getTrip_distance());
                    Log.e("1"+want_dates.get(1).getTrip_distance(),"0"+want_dates.get(1).getTrip_distance());
                    Log.e("2"+want_dates.get(2).getTrip_distance(),"0"+want_dates.get(2).getTrip_distance());
                    int want_dates_size=want_dates.size();


                    if (want_dates_size>=1){

                        row1.setVisibility(View.VISIBLE);
                        r1c1.setText(want_dates.get(0).getTpep_pickup_datetime());
                        r1c2.setText(String.valueOf(want_dates.get(0).getTrip_distance()));
                        r1c3.setText(String.valueOf(want_dates.get(0).getID()));
                        if(want_dates_size >=2){
                            row2.setVisibility(View.VISIBLE);
                            r2c1.setText(want_dates.get(1).getTpep_pickup_datetime());
                            r2c2.setText(String.valueOf(want_dates.get(1).getTrip_distance()));
                            r2c3.setText(String.valueOf(want_dates.get(1).getID()));

                            if(want_dates_size>=3){
                                row3.setVisibility(View.VISIBLE);
                                r3c1.setText(want_dates.get(2).getTpep_pickup_datetime());
                                r3c2.setText(String.valueOf(want_dates.get(2).getTrip_distance()));
                                r3c3.setText(String.valueOf(want_dates.get(2).getID()));
                                if(want_dates_size>=4){
                                    row4.setVisibility(View.VISIBLE);
                                    r4c1.setText(want_dates.get(3).getTpep_pickup_datetime());
                                    r4c2.setText(String.valueOf(want_dates.get(3).getTrip_distance()));
                                    r4c3.setText(String.valueOf(want_dates.get(3).getID()));
                                    if(want_dates_size>=5){
                                        row5.setVisibility(View.VISIBLE);
                                        r5c1.setText(want_dates.get(4).getTpep_pickup_datetime());
                                        r5c2.setText(String.valueOf(want_dates.get(4).getTrip_distance()));
                                        r5c3.setText(String.valueOf(want_dates.get(4).getID()));
                                    }
                                }
                            }
                        }



                    }else
                        Toast.makeText(SecondActivity.this, "Secilen Tarihlerde Veri Bulunamadi", Toast.LENGTH_SHORT).show();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    private boolean select_day(String date,int w_month,int w_day1,int w_day2){
        boolean bool=false;

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
        try {
            oneWayTripDate = input.parse(date);  // parse input
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(oneWayTripDate);

        int day=cal.get(Calendar.DAY_OF_MONTH);
        int mont=cal.get(Calendar.MONTH)+1;
        Log.e("Ay:"+mont,"Gun"+day);

        if (w_month==mont){
            if(day>=w_day1 && day<=w_day2){
                bool= true;
            }
        }

        return bool;
    }


    class DistanceComparator implements Comparator<Veri> {

        // Function to compare
        public int compare(Veri v1, Veri v2)
        {
            if (v1.getTrip_distance() == v2.getTrip_distance())
                return 0;
            else if (v1.getTrip_distance() > v2.getTrip_distance())
                return 1;
            else
                return -1;
        }
    }


    public void tarih_sec(Button btn,Tarih c){

        int d;
        int m;
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,2020);
        calendar.set(Calendar.MONTH,Calendar.DECEMBER);

        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);


        datePickerDialog=new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                btn.setText(dayOfMonth+"-"+(month+1)+"-"+year);


                c.gun=dayOfMonth;
                c.ay=month;

            }
        },year,month,day);


        datePickerDialog.show();


    }



}