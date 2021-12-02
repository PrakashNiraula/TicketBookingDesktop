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

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {

    public List<Ticket> ticketList;
    public LayoutInflater layoutInflater;
    Route route;
    Vehicle vehicle;
    Schedule schedule;
    String token;

    public TicketAdapter(Context context,List<Ticket> ticketList,String token) {
        this.ticketList = ticketList;
        layoutInflater=LayoutInflater.from(context);
        route=new Route();
        vehicle=new Vehicle();
        schedule=new Schedule();
        this.token=token;

    }

    @NonNull
    @Override
    public TicketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.ticketview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position) {
       Ticket ticket=ticketList.get(position);

        Schedule ScheduleInRoute = schedule.searchScheduleById(token, ticket.getScheduleId());
        Route routeofschedule = route.searchRouteByID(token, ScheduleInRoute.getRouteId());
        Vehicle myvehicle=vehicle.searchVehcileByID(token,ScheduleInRoute.getVehicleId());

        holder.ticketroute.setText(routeofschedule.getStart() + " to " + routeofschedule.getDestination());
        holder.ticketbusnumber.setText("Bus no: "+myvehicle.getVehicleNumber());
        holder.ticketseat.setText("Seats: " +ticket.getSeatId());
        holder.ticketdeparture.setText("Leaving on:"+ScheduleInRoute.getDepartureDate().split("T")[0]+" at "+ScheduleInRoute.getDepartureTime());

    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ticketroute,ticketbusnumber,ticketseat,ticketdeparture;
        ImageView buspicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ticketroute = itemView.findViewById(R.id.ticketroute);
            ticketbusnumber = itemView.findViewById(R.id.ticketbus);
            ticketseat = itemView.findViewById(R.id.ticketseat);
            ticketdeparture=itemView.findViewById(R.id.ticketdeparture);
            buspicture=itemView.findViewById(R.id.ticketbusimage);

        }
    }
}
