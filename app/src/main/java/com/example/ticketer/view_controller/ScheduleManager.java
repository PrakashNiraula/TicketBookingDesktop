package com.example.ticketer.view_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ticketer.R;
import com.example.ticketer.module.Schedule;
import com.example.ticketer.module.Vehicle;

public class ScheduleManager extends AppCompatActivity {

    EditText departureDate,departureTime;
    RadioGroup radioGroup;
    RadioButton once;
    Button saveschedule;
    com.example.ticketer.module.Schedule moduleSchedule;
    Bundle bundle;
    RadioButton radioButton;
    String token="Bearer ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        departureDate=findViewById(R.id.departuredate);
        departureTime=findViewById(R.id.departuretime);
        radioGroup=findViewById(R.id.radiogroup);
        saveschedule=findViewById(R.id.saveschedule);
        once=findViewById(R.id.once);
        once.setChecked(true);
        moduleSchedule=new com.example.ticketer.module.Schedule();
        bundle =getIntent().getExtras();
        token+=bundle.get("token").toString();

        saveschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicle_id=bundle.get("vehicle_id").toString();
                String route_id=bundle.get("route_id").toString();

                if(departureDate.getText().toString().equals("")){
                    rendermessage("Departure date cannot be empty");
                    //rendermessage(bundle.toString());
                    return;

                }
                if(departureTime.getText().toString().equals("")){
                    rendermessage("Departure time cannot be empty");
                    return;

                }
                moduleSchedule.setVehicleId(vehicle_id);
                moduleSchedule.setRouteId(route_id);
                moduleSchedule.setDepartureDate(departureDate.getText().toString());
                moduleSchedule.setDepartureTime(departureTime.getText().toString());
                moduleSchedule.setStatus("LeavingOnTime");
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                moduleSchedule.setRepitition(radioButton.getText().toString());
                Schedule responseSchedule=moduleSchedule.createnewSchedule(token,moduleSchedule);
                Vehicle vehicle=moduleSchedule.pushScheduleToVehicle(token,vehicle_id,responseSchedule);
                if(vehicle!=null){
                    rendermessage("Successfully created. Users now can buy ticket for it");
                }
            }
        });
    }


    public  void rendermessage(String message){
        Toast.makeText(ScheduleManager.this,message,Toast.LENGTH_LONG).show();

    }
}