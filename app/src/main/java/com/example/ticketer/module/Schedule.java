package com.example.ticketer.module;

import android.content.Context;
import android.widget.Toast;

import com.example.ticketer.network.ApiClient;
import com.example.ticketer.network.ApiInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Schedule {
    ApiInterface apiInterface;


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("repitition")
    @Expose
    private String repitition;
    @SerializedName("tickets")
    @Expose
    private List<String> tickets = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("vehicle_id")
    @Expose
    private String vehicleId;
    @SerializedName("route_id")
    @Expose
    private String routeId;
    @SerializedName("departure_date")
    @Expose
    private String departureDate;
    @SerializedName("departure_time")
    @Expose
    private String departureTime;


    public Schedule() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRepitition() {
        return repitition;
    }

    public void setRepitition(String repitition) {
        this.repitition = repitition;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    public Schedule createnewSchedule(String token, Schedule schedule) {
        Call<Schedule> call = apiInterface.createSchedule(token, schedule);
        try {
            Response<Schedule> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Schedule> searchSchedulebyDate(String token, String date) {
        Call<List<Schedule>> call = apiInterface.searchSchedulebyDate(token, date);
        try {
            Response<List<Schedule>> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Schedule searchScheduleById(String token, String schedule_id) {
        Call<Schedule> call = apiInterface.searchSchedulebyID(token, schedule_id);
        try {
            Response<Schedule> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Vehicle pushScheduleToVehicle(String token, String id, Schedule schedule) {
        Call<Vehicle> call = apiInterface.pushSchedule_toVehicle(token, id, schedule);
        try {
            Response<Vehicle> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void rendermessage(Context context, String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_LONG).show();

    }
}
