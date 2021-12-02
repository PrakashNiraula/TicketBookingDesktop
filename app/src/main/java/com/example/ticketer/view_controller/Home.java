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
import com.example.ticketer.module.FeaturedAdapter;
import com.example.ticketer.module.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Home extends Fragment {

    RecyclerView recyclerView;

    Vehicle vehicle;
    public Home() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.featuredVehicles);

        vehicle=new Vehicle();
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("com.example.ticketer_preferences",MODE_PRIVATE);
        String token="Bearer "+sharedPreferences.getString("token","");


        List<Vehicle> featured=vehicle.fetchFeatured(token);

        List<Vehicle> top = new ArrayList<>();
        for(int i=0;i<5;i++){
            top.add(featured.get(i));


        }

        FeaturedAdapter adapter = new FeaturedAdapter( top,getContext());
        // recyclerview divider or seperator
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Toast.makeText(getContext(),token,Toast.LENGTH_LONG).show();



return view;
    }
}