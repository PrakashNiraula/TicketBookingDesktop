package com.example.ticketer.module;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ticketer.R;
import com.example.ticketer.network.ApiClient;
import com.example.ticketer.network.ApiInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Route {

    ApiInterface apiInterface;
    List<Route> routedata;
    public List<String> routeidlist = new ArrayList<>();
    Route responseRoute;


    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("destination")
    @Expose
    private String destination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public Route() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        routedata = new ArrayList<>();

    }

    public List<Route> getallroutes( String tokenforuse) {
        Call<List<Route>> call = apiInterface.getallRoutes(tokenforuse);

        try {
            Response<List<Route>> response=call.execute();
            if(response.code()==200){
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createroute(String tokenforuse, Route route) {
        Call<Route> call = apiInterface.createnewRoute(tokenforuse, route);
        try {
            Response<Route> response = call.execute();
            if (response.code() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Route> searchroutebyName(Context context, String token, Route route) {
        Call<List<Route>> call = apiInterface.getallRoutesbyNames(token, route.getStart().toString(), route.getDestination().toString());
        try {
            Response<List<Route>> response = call.execute();
            routedata = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routedata;
    }

    public Route searchRouteByID(String token, String Route_id) {
        Call<Route> call = apiInterface.searchRoutebyID(token, Route_id);
        try {
            Response<Route> response = call.execute();
            if (response.code() == 200) {
                responseRoute = new Route();
                responseRoute = response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseRoute;
    }

    public void makemessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }


}
