package com.example.ticketer.module;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.Toast;
import android.content.SharedPreferences;
import com.example.ticketer.network.ApiClient;
import com.example.ticketer.network.ApiInterface;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import retrofit2.Call;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User extends Observable {

    ApiInterface apiInterface;

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("vehicles")
    @Expose
    private List<Object> vehicles = null;
    @SerializedName("tickets")
    @Expose
    private List<Object> tickets = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Object> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Object> getTickets() {
        return tickets;
    }

    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public User(String username, String password) {
        this.username = username;
        this.password = password;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }



    public void makelogin(Context context, User user) throws IOException {
        Call<Message> call = apiInterface.checklogin(user);
            Response<Message> response=call.execute();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
            if(response.code()==500) {
                editor.putString("token","").commit();
            }else{
                editor.putString("token",response.body().getToken().split(" ")[1]).commit();
            }

            return;
    }


    public String[] registeruser(Context context, User user) {

        Call<User> call = apiInterface.createnewuser(user);
        try {
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User reply = response.body();
                    if (response.code() == 200) {
                        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();

                }
            });
        } catch (Throwable t) {
            throw t;
        }
        return null;
    }
}

