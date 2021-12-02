package com.example.ticketer.view_controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ticketer.R;
import com.example.ticketer.module.Route;
import com.example.ticketer.module.Schedule;
import com.example.ticketer.module.Ticket;
import com.example.ticketer.module.User;
import com.example.ticketer.module.Vehicle;
import com.example.ticketer.module.decoder;
import com.example.ticketer.module.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewSeats extends AppCompatActivity implements View.OnClickListener {

    CardView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;
    List<String> selectedseats=new ArrayList<>();
    TextView routedisplay,departure_date,status,bus_number,departure_time;
    Bundle bundle;
    Schedule selected_schedule;
    Ticket ticket;
    String token="Bearer ";
    Button bookticket;
   int filledcolor=5234913,emptycolor=14700372,selectedcolor=14536345;
    int temp;
    Vehicle vehicleof_Schedule;
    Route routeof_vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_seats);
        bundle=getIntent().getExtras();
        routedisplay=findViewById(R.id.routedisplay);
        departure_date=findViewById(R.id.departuredatedisplay);
        status=findViewById(R.id.statusdisplay);
        bus_number=findViewById(R.id.busnumberdisplay);
        departure_time=findViewById(R.id.departuretimedisplay);
        bookticket=findViewById(R.id.btnbook);

        selected_schedule=new Schedule();
        if(bundle!=null)
        {token+=bundle.get("token");}
        vehicleof_Schedule=new Vehicle();
        routeof_vehicle=new Route();

        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        a13 = findViewById(R.id.a13);
        a14 = findViewById(R.id.a14);
        a15 = findViewById(R.id.a15);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b13 = findViewById(R.id.b13);
        b14 = findViewById(R.id.b14);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);
        a6.setOnClickListener(this);
        a7.setOnClickListener(this);
        a8.setOnClickListener(this);
        a9.setOnClickListener(this);
        a10.setOnClickListener(this);
        a11.setOnClickListener(this);
        a12.setOnClickListener(this);
        a13.setOnClickListener(this);
        a14.setOnClickListener(this);
        a15.setOnClickListener(this);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        bookticket.setOnClickListener(this);

        if(bundle!=null)

      {  loaddata();}


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.a1:
               temp= a1.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a1.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a1");
                }
                if (temp == -selectedcolor) {
                    a1.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a1")) {
                        selectedseats.remove("a1");
                    }
                }
                break;
            case R.id.a2:

                temp= a2.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a2.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a2");
                }
                if (temp == -selectedcolor) {
                    a2.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a2")) {
                        selectedseats.remove("a2");
                    }
                }
                break;
            case R.id.a3:
                temp= a3.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a3.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a3");
                }
                if (temp == -selectedcolor) {
                    a3.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a3")) {
                        selectedseats.remove("a3");
                    }
                }
                break;
            case R.id.a4:
                temp= a4.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a4.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a4");
                }
                if (temp == -selectedcolor) {
                    a4.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a4")) {
                        selectedseats.remove("a4");
                    }
                }
                break;
            case R.id.a5:
                temp= a5.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a5.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a5");
                }
                if (temp == -selectedcolor) {
                    a5.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a5")) {
                        selectedseats.remove("a5");
                    }
                }

                break;
            case R.id.a6:
                temp= a6.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a6.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a6");
                }
                if (temp == -selectedcolor) {
                    a6.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a6")) {
                        selectedseats.remove("a6");
                    }
                }
                break;
            case R.id.a7:
                temp= a7.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a7.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a7");
                }
                if (temp == -selectedcolor) {
                    a7.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a7")) {
                        selectedseats.remove("a7");
                    }
                }
                break;
            case R.id.a8:
                temp= a8.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a8.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a8");
                }
                if (temp == -selectedcolor) {
                    a8.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a8")) {
                        selectedseats.remove("a8");
                    }
                }
                break;
            case R.id.a9:
                temp= a9.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a9.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a9");
                }
                if (temp == -selectedcolor) {
                    a9.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a9")) {
                        selectedseats.remove("a9");
                    }
                }

                break;
            case R.id.a10:
                temp= a10.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a10.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a10");
                }
                if (temp == -selectedcolor) {
                    a10.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a10")) {
                        selectedseats.remove("a10");
                    }
                }
                break;
            case R.id.a11:
                temp= a11.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a11.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a11");
                }
                if (temp == -selectedcolor) {
                    a11.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a11")) {
                        selectedseats.remove("a11");
                    }
                }

                break;
            case R.id.a12:
                temp= a12.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a12.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a12");
                }
                if (temp == -selectedcolor) {
                    a12.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a12")) {
                        selectedseats.remove("a12");
                    }
                }

                break;

            case R.id.a13:
                temp= a13.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a13.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a13");
                }
                if (temp == -selectedcolor) {
                    a13.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a13")) {
                        selectedseats.remove("a13");
                    }
                }

                break;
            case R.id.a14:
                temp= a14.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a14.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a14");
                }
                if (temp == -selectedcolor) {
                    a14.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a14")) {
                        selectedseats.remove("a14");
                    }
                }
                break;
            case R.id.a15:
                temp= a15.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    a15.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("a15");
                }
                if (temp == -selectedcolor) {
                    a15.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("a15")) {
                        selectedseats.remove("a15");
                    }
                }

                break;



            case R.id.b1:
                temp= b1.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b1.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b1");
                }
                if (temp == -selectedcolor) {
                    b1.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b1")) {
                        selectedseats.remove("b1");
                    }
                }
                break;
            case R.id.b2:

                temp= b2.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b2.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b2");
                }
                if (temp == -selectedcolor) {
                    b2.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b2")) {
                        selectedseats.remove("b2");
                    }
                }
                break;
            case R.id.b3:
                temp= b3.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b3.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b3");
                }
                if (temp == -selectedcolor) {
                    b3.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b3")) {
                        selectedseats.remove("b3");
                    }
                }
                break;
            case R.id.b4:
                temp= b4.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b4.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b4");
                }
                if (temp == -selectedcolor) {
                    b4.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b4")) {
                        selectedseats.remove("b4");
                    }
                }
                break;
            case R.id.b5:
                temp= b5.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b5.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b5");
                }
                if (temp == -selectedcolor) {
                    b5.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b5")) {
                        selectedseats.remove("b5");
                    }
                }

                break;
            case R.id.b6:
                temp= b6.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b6.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b6");
                }
                if (temp == -selectedcolor) {
                    b6.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b6")) {
                        selectedseats.remove("b6");
                    }
                }
                break;
            case R.id.b7:
                temp= b7.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b7.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b7");
                }
                if (temp == -selectedcolor) {
                    b7.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b7")) {
                        selectedseats.remove("b7");
                    }
                }
                break;
            case R.id.b8:
                temp= b8.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b8.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b8");
                }
                if (temp == -selectedcolor) {
                    b8.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b8")) {
                        selectedseats.remove("b8");
                    }
                }
                break;
            case R.id.b9:
                temp= b9.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b9.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b9");
                }
                if (temp == -selectedcolor) {
                    b9.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b9")) {
                        selectedseats.remove("b9");
                    }
                }

                break;
            case R.id.b10:
                temp= b10.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b10.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b10");
                }
                if (temp == -selectedcolor) {
                    b10.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b10")) {
                        selectedseats.remove("b10");
                    }
                }
                break;
            case R.id.b11:
                temp= b11.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b11.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b11");
                }
                if (temp == -selectedcolor) {
                    b11.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b11")) {
                        selectedseats.remove("b11");
                    }
                }

                break;
            case R.id.b12:
                temp= b12.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b12.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b12");
                }
                if (temp == -selectedcolor) {
                    b12.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b12")) {
                        selectedseats.remove("b12");
                    }
                }

                break;

            case R.id.b13:
                temp= b13.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b13.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b13");
                }
                if (temp == -selectedcolor) {
                    b13.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b13")) {
                        selectedseats.remove("b13");
                    }
                }

                break;
            case R.id.b14:
                temp= b14.getCardBackgroundColor().getDefaultColor();
  
                if (temp == -filledcolor) {
                    return;
                }
                if (temp == -emptycolor) {
                    b14.setCardBackgroundColor(-selectedcolor);
                    selectedseats.add("b14");
                }
                if (temp == -selectedcolor) {
                    b14.setCardBackgroundColor(-emptycolor);
                    if (selectedseats.contains("b14")) {
                        selectedseats.remove("b14");
                    }
                }
                break;

            case R.id.btnbook:
                if(selectedseats.size()==0){
                    Toast.makeText(this,"Seat not selected",Toast.LENGTH_LONG).show();
                    return;
                }
                createticket();
                break;
        }


    }

    public void loaddata(){

        String schedule_id=bundle.get("schedule_id").toString();
         selected_schedule=selected_schedule.searchScheduleById(token,schedule_id);
         vehicleof_Schedule=vehicleof_Schedule.searchVehcileByID(token,selected_schedule.getVehicleId());
         routeof_vehicle=routeof_vehicle.searchRouteByID(token,selected_schedule.getRouteId());
        routedisplay.setText(routeof_vehicle.getStart()+ " to " +routeof_vehicle.getDestination());
       departure_date.setText(selected_schedule.getDepartureDate().split("T")[0]);
        status.setText(selected_schedule.getStatus());
        bus_number.setText(vehicleof_Schedule.getVehicleNumber());
        departure_time.setText(selected_schedule.getDepartureTime());

    }

    public void createticket(){
        Map<String, String> map;
        ticket=new Ticket();
        String decoded= null;
        try {
            decoded = decoder.decoded(token);
            map= mapper.stringmapper(decoded);
            ticket.setScheduleId(selected_schedule.getId());
            ticket.setBuyer(map.get("id"));
            ticket.setSeatId(selectedseats);
            ticket.setPayment("Pending");
            ticket.setMethod("COD");
            Ticket responseticket=ticket.createticket(token,ticket);
            User user=ticket.pushTikcetToUser(token,map.get("id"),responseticket);
            Schedule schedule=ticket.pushTicketToSchedule(token,selected_schedule.getId(),responseticket);
           Toast.makeText(this,"Ticket booked successfully. Go to my tickets to view tickets",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}