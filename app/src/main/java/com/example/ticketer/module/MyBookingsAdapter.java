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

public class MyBookingsAdapter extends RecyclerView.Adapter<MyBookingsAdapter.ViewHolder> {
    List<Ticket> bookings;
    LayoutInflater layoutInflater;

    public MyBookingsAdapter(List<Ticket> bookings, Context context) {
        this.bookings = bookings;
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
        Ticket aticket=bookings.get(position);
        if(aticket!=null){

            holder.ticketroute.setText("Id: "+aticket.getId());
            holder.ticketbusnumber.setText("Seat: "+aticket.getSeatId());
            holder.ticketseat.setText("");
            holder.ticketdeparture.setText("");
        }



    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {


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
            buspicture.setVisibility(View.INVISIBLE);

        }
    }
}
