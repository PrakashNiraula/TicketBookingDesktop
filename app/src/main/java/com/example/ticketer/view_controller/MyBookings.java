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
import com.example.ticketer.module.MyBookingsAdapter;
import com.example.ticketer.module.Ticket;
import com.example.ticketer.module.Vehicle;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class MyBookings extends Fragment {
   Vehicle vehicle;
   RecyclerView recyclerView;



    public MyBookings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vehicle=new Vehicle();
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_my_bookings, container, false);
       recyclerView=view.findViewById(R.id.bookingsView);


        SharedPreferences sharedPreferences=getContext().getSharedPreferences("com.example.ticketer_preferences",MODE_PRIVATE);
        String token="Bearer "+sharedPreferences.getString("token","");


        List<Ticket> mybookings=vehicle.fetchMyBookings(token);

        MyBookingsAdapter adapter = new MyBookingsAdapter( mybookings,getContext());
        // recyclerview divider or seperator
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));






        return view;
    }
}