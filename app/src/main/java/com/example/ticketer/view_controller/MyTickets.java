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
import com.example.ticketer.module.Ticket;
import com.example.ticketer.module.TicketAdapter;
import com.example.ticketer.module.decoder;
import com.example.ticketer.module.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MyTickets extends Fragment  {
    RecyclerView recyclerView;


    public MyTickets() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_tickets, container,
                false);
        recyclerView=view.findViewById(R.id.ticketsView);
        Map<String, String> map = null;
        List<Ticket> mytickets = new ArrayList<>();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("com.example.ticketer_preferences", MODE_PRIVATE);
        String token = "Bearer " + sharedPreferences.getString("token", "");

        String decoded = null;
        try {
            decoded = decoder.decoded(token);
            map = mapper.stringmapper(decoded);
//            User user = new User("Dummy", "Dummy");
            Ticket ticket = new Ticket();
//            user = user.getuserDetails(token, map.get("id"));
            List<Ticket> tickets = ticket.fetchMytickets(token);
            TicketAdapter adapter = new TicketAdapter( getContext(),tickets,token);
            // recyclerview divider or seperator
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }



}