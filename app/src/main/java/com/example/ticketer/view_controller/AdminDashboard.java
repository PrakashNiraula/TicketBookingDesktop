package com.example.ticketer.view_controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketer.R;
import com.example.ticketer.module.BusAdapter;
import com.example.ticketer.module.Vehicle;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class AdminDashboard extends Fragment {
    RecyclerView recyclerView;
    Vehicle vehicle;



    public AdminDashboard() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_admin_dashboard, container, false);
        recyclerView=view.findViewById(R.id.mybuses);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("com.example.ticketer_preferences", MODE_PRIVATE);
        String token = "Bearer " + sharedPreferences.getString("token", "");

        vehicle=new Vehicle();
        List<Vehicle> myvehicles=vehicle.fetchmYvehicles(token);

        BusAdapter adapter = new BusAdapter( myvehicles,getContext());
        // recyclerview divider or seperator
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

       return view;
    }
}