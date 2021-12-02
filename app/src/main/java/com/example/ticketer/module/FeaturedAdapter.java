package com.example.ticketer.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketer.R;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {

    List<Vehicle> buslist;
    LayoutInflater layoutInflater;

    public FeaturedAdapter(List<Vehicle> buslist, Context context) {
        this.buslist = buslist;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.ticketview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehicle bus=buslist.get(position);



        holder.ticketroute.setText("Id: "+bus.getId());
        holder.ticketbusnumber.setText("Bus no: "+bus.getVehicleNumber());
        holder.ticketseat.setText("");
        holder.ticketdeparture.setText("");

    }

    @Override
    public int getItemCount() {
        return buslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView ticketroute,ticketbusnumber,ticketseat,ticketdeparture;
        ImageView buspicture,deleteicon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ticketroute = itemView.findViewById(R.id.ticketroute);
            ticketbusnumber = itemView.findViewById(R.id.ticketbus);
            ticketseat = itemView.findViewById(R.id.ticketseat);
            ticketdeparture=itemView.findViewById(R.id.ticketdeparture);
            buspicture=itemView.findViewById(R.id.ticketbusimage);
            deleteicon=itemView.findViewById(R.id.deleteticket);
            deleteicon.setVisibility(View.INVISIBLE);


        }
    }
}
