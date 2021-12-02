package com.example.ticketer.view_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticketer.R;
import com.example.ticketer.module.Route;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Routes extends AppCompatActivity {

    Route route;
    public String token = "Bearer ";
    ListView listView;
    LinearLayout addarea;
    FloatingActionButton addlayout;
    Button createroute;
    EditText start, destination;
    List<String> routeidlist;
    List<Route> routedata;
    TextView routename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        listView = findViewById(R.id.listarea);
        addarea = findViewById(R.id.addarea);
        start = findViewById(R.id.start);
        destination = findViewById(R.id.destination);
        createroute = findViewById(R.id.createroute);
        addlayout = findViewById(R.id.addroute);
        routename=findViewById(R.id.routename);
        bundle = getIntent().getExtras();
        route = new Route();
        token += bundle.getString("token");
        routeidlist = new ArrayList<>();
        loaddata();


        addlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = addarea.getVisibility();
                if (visibility == 1 || visibility == 0) {
                    addarea.setVisibility(View.GONE);
                } else {
                    addarea.setVisibility(View.VISIBLE);
                }

            }
        });

        createroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";

                if (start.getText().toString().equals("")) {
                    rendererror("Invalid start place");
                    return;

                } else if (destination.getText().toString().equals("")) {

                    rendererror("Invalid destination place");
                    return;
                }
                route.setStart(start.getText().toString());
                route.setDestination(destination.getText().toString());
                boolean result = route.createroute(token, route);
                if (result == true) {
                    rendererror("Route Created successfully");
                }
               loaddata();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Route selectedRoute = routedata.get(position);
                String selectedid=selectedRoute.getId();
                Intent intent = new Intent(Routes.this, BusDetails.class);
                intent.putExtra("token", bundle.getString("token"));
                intent.putExtra("route", selectedid);
                startActivity(intent);
            }
        });


    }

    public void loaddata() {

       routedata = route.getallroutes(token);
        List<String> displayformat = new ArrayList<>();
        if (routedata != null) {
            for (Route r : routedata) {
                displayformat.add(r.getStart() + " to " + r.getDestination());

            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,
               R.layout.listitem, R.id.routename,displayformat);
        listView.setAdapter(arrayAdapter);


    }


    public void rendererror(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}