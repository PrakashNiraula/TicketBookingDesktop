package com.example.ticketer.module;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.ticketer.network.ApiClient;
import com.example.ticketer.network.ApiInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Vehicle {

    ApiInterface apiInterface;

    @SerializedName("schedule")
    @Expose
    private List<String> schedule = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("vehicle_number")
    @Expose
    private String vehicleNumber;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("ratings")
    @Expose
    private List<Rating> ratings = null;

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    Vehicle singleresponse;

    public Vehicle() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }


    public Vehicle createVehicle( String token, Vehicle vehicle) {

        Call<Vehicle> call = apiInterface.createnewVehicle(token, vehicle);
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


    public Vehicle searchVehcileByID(String token, String Vehicle_id) {
        Call<Vehicle> call = apiInterface.searchVehiclebyID(token, Vehicle_id);
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



    public User pushVehicleToUser(String token,String user_id,Vehicle vehicle){
        Call<User> call=apiInterface.pushVehicle_toUser(token,user_id,vehicle);
        try {
            Response<User> response=call.execute();
            if(response.code()==200){
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void rendermessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }

}
