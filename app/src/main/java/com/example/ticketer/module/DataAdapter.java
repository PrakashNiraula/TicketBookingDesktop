package com.example.ticketer.module;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketer.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ScheduleViewHolder> {

    List<Schedule> scheduleListtodisplay;
    onScheduleListener onScheduleListener;
    Route route;
    String token = null;

    public DataAdapter(List<Schedule> scheduleListtodisplay, onScheduleListener onScheduleListener, String token) {
        this.onScheduleListener = onScheduleListener;
        this.scheduleListtodisplay = scheduleListtodisplay;
        this.token = token;
        route = new Route();
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scheduleview, parent, false);
        return new ScheduleViewHolder(view, onScheduleListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Schedule schedule = scheduleListtodisplay.get(position);

        Route routeofschedule = route.searchRouteByID(token, schedule.getRouteId());

        holder.displaystart.setText(routeofschedule.getStart() + " to " + routeofschedule.getDestination());
        holder.displaydestination.setText(schedule.getDepartureTime());
        holder.displaydate.setText(schedule.getDepartureDate().split("T")[0]);
    }

    @Override
    public int getItemCount() {
        return scheduleListtodisplay.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView displaystart, displaydestination, displaydate;
        onScheduleListener onScheduleListener;
        public ScheduleViewHolder(View itemview, onScheduleListener onScheduleListener) {
            super(itemview);
            displaydate = itemview.findViewById(R.id.displaydate);
            displaystart = itemview.findViewById(R.id.displaystart);
            displaydestination = itemview.findViewById(R.id.displaydestination);
            this.onScheduleListener = onScheduleListener;
            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onScheduleListener.onScheduleCLick(getAdapterPosition());
        }
    }

    public interface onScheduleListener {
        void onScheduleCLick(int position);
    }
}
