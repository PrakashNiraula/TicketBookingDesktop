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

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    List<Vehicle> buslist;
    LayoutInflater layoutInflater;

    public BusAdapter(List<Vehicle> buslist, Context context) {
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

        String URL="http://localhost:3000/"+bus.getImage();
        URL = URL.replace("\\", "/");

//        downloadfile(URL,holder.buspicture);
     holder.ticketseat.setText("Seats: ");
//        holder.ticketdeparture.setText("Leaving on:"+ScheduleInRoute.getDepartureDate().split("T")[0]+" at "+ScheduleInRoute.getDepartureTime());


    }

    @Override
    public int getItemCount() {
        return buslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ticketroute,ticketbusnumber,ticketseat,ticketdeparture;
        ImageView buspicture;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ticketroute = itemView.findViewById(R.id.ticketroute);
            ticketbusnumber = itemView.findViewById(R.id.ticketbus);
            ticketseat = itemView.findViewById(R.id.ticketseat);
            ticketdeparture=itemView.findViewById(R.id.ticketdeparture);
            buspicture=itemView.findViewById(R.id.ticketbusimage);
            ticketseat.setVisibility(View.INVISIBLE);
            ticketdeparture.setVisibility(View.INVISIBLE);
        }
    }




//    public  void downloadfile(String fileurl, ImageView img) {
//        Bitmap bmImg = null;
//        URL myfileurl = null;
//        try {
//            myfileurl = new URL(fileurl);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            HttpURLConnection conn = (HttpURLConnection) myfileurl.openConnection();
//            conn.setDoInput(true);
//            conn.connect();
//            int length = conn.getContentLength();
//            if (length > 0) {
//                int[] bitmapData = new int[length];
//                byte[] bitmapData2 = new byte[length];
//                InputStream is = conn.getInputStream();
//                bmImg = BitmapFactory.decodeStream(is);
//                img.setImageBitmap(bmImg);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
