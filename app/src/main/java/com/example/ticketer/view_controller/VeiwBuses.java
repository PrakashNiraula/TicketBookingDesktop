package com.example.ticketer.view_controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketer.R;
import com.example.ticketer.module.DataAdapter;
import com.example.ticketer.module.Route;
import com.example.ticketer.module.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VeiwBuses extends AppCompatActivity  implements DataAdapter.onScheduleListener{


    EditText start, destinatin, date;
    ImageButton Search;
    HashMap<String, String> map;
    Bundle bundle;
    String token = "Bearer ";
    Route route;
    Schedule schedule;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Schedule> responseSchedule=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_buses);
        start = findViewById(R.id.starttosearch);
        destinatin = findViewById(R.id.destinationtosearch);
        date = findViewById(R.id.departure_date);
        Search = findViewById(R.id.searchforbuses);
        route = new Route();
        schedule = new Schedule();
        bundle = getIntent().getExtras();
        token += bundle.getString("token");
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map = new HashMap<>();

//                if(!start.getText().toString().equals(" ")){
//                    route.setStart(start.getText().toString());
//                }
//
//                if(!destinatin.getText().toString().equals(" ")){
//                    route.setDestination(destinatin.getText().toString());
//                }
//
//                List<Route> responseRoute= route.searchroutebyName(VeiwBuses.this,token,route);

                if (!date.getText().equals(" ")) {
                    responseSchedule = schedule.searchSchedulebyDate(token, date.getText().toString());
                   // Toast.makeText(VeiwBuses.this, responseSchedule.toString(), Toast.LENGTH_LONG).show();
                    DataAdapter adapter = new DataAdapter( responseSchedule,VeiwBuses.this,token);
                    // recyclerview divider or seperator
                    recyclerView.addItemDecoration(new DividerItemDecoration(VeiwBuses.this, LinearLayoutManager.VERTICAL));

                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(VeiwBuses.this));

                }
            }
        });
    }

    @Override
    public void onScheduleCLick(int position) {
     Schedule schedule=responseSchedule.get(position);

        Intent i=new Intent(this,ViewSeats.class);
       i.putExtra("token",bundle.getString("token"));
       i.putExtra("schedule_id",schedule.getId());
     startActivity(i);
    }
}