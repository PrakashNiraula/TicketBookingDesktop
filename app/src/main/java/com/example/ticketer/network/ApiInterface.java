package com.example.ticketer.network;

import com.example.ticketer.module.Message;
import com.example.ticketer.module.Route;
import com.example.ticketer.module.Schedule;
import com.example.ticketer.module.Ticket;
import com.example.ticketer.module.User;
import com.example.ticketer.module.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public abstract interface ApiInterface {


    @POST("users/login")
    public Call<Message> checklogin(@Body User user);

    @POST("users/register")
    public Call<User> createnewuser(@Body User user);

    @GET("route")
    public Call<List<Route>> getallRoutes(@Header("Authorization") String token);

    @POST("route/search/{start}/{destination}")
    public Call<List<Route>> getallRoutesbyNames(@Header("Authorization") String token,@Path("start")String start,@Path("destination") String destination);

    @POST("route")
    public Call<Route> createnewRoute(@Header("Authorization") String token,@Body Route route);

    @POST("vehicle")
    public Call<Vehicle> createnewVehicle(@Header("Authorization") String token,@Body Vehicle vehicle);

    @POST("schedule")
    public Call<Schedule> createSchedule(@Header("Authorization") String token, @Body Schedule schedule);

    @GET("schedule/search/{date}")
    public Call<List<Schedule>> searchSchedulebyDate(@Header("Authorization") String token,@Path("date") String date);

    @GET("vehicles")
    public Call<List<Vehicle>> getvehicles(@Header("Authorization") String token,@Body Vehicle vehicle);

    @GET("schedule/{schedule_id}")
    public Call<Schedule> searchSchedulebyID(@Header("Authorization") String token, @Path("schedule_id") String id);

    @GET("vehicle/{vehicle_id}")
    public Call<Vehicle> searchVehiclebyID(@Header("Authorization") String token, @Path("vehicle_id") String id);

    @GET("route/{route_id}")
    public Call<Route> searchRoutebyID(@Header("Authorization") String token, @Path("route_id") String id);

    @POST("ticket")
    public Call<Ticket> createTicket(@Header("Authorization") String token, @Body Ticket ticket);


    @POST("users/{user_id}/tickets")
    public Call<User> pushTicket_toUser(@Header("Authorization") String token, @Path("user_id") String id, @Body Ticket ticket );

    @POST("schedule/{schedule_id}/tickets")
    public Call<Schedule> pushTicket_toSchedule(@Header("Authorization") String token, @Path("schedule_id") String id, @Body Ticket ticket );


    @POST("users/{user_id}/vehicles")
    public Call<User> pushVehicle_toUser(@Header("Authorization") String token, @Path("user_id") String id, @Body Vehicle vehicle );


    @POST("vehicle/{vehicle_id}/schedule")
    public Call<Vehicle> pushSchedule_toVehicle(@Header("Authorization") String token, @Path("vehicle_id") String id, @Body Schedule schedule );













}

