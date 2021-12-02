package com.example.ticketer.module;

import com.example.ticketer.network.ApiClient;
import com.example.ticketer.network.ApiInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Ticket {
    ApiInterface apiInterface;
    Ticket responseticket;

    public Ticket() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    @SerializedName("seat_id")
    @Expose
    private List<String> seatId = null;
    @SerializedName("payment")
    @Expose
    private String payment;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("buyer")
    @Expose
    private String buyer;
    @SerializedName("schedule_id")
    @Expose
    private String scheduleId;
    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;

    public List<String> getSeatId() {
        return seatId;
    }

    public void setSeatId(List<String> seatId) {
        this.seatId = seatId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }


    public Ticket createticket(String token, Ticket ticket) {

        Call<Ticket> call = apiInterface.createTicket(token, ticket);
        try {
            Response<Ticket> response = call.execute();

            if (response.code() == 200) {
                responseticket = new Ticket();
                responseticket = response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseticket;


    }


    public User pushTikcetToUser(String token, String userid, Ticket ticket) {
        Call<User> call = apiInterface.pushTicket_toUser(token, userid, ticket);
        try {
            Response<User> response = call.execute();
            if (response.code() == 200) {
                User user = response.body();
                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Schedule pushTicketToSchedule(String token, String id, Ticket ticket) {
        Call<Schedule> call = apiInterface.pushTicket_toSchedule(token, id, ticket);
        try {
            Response<Schedule> response = call.execute();
            if (response.code() == 200) {
                Schedule schedule = response.body();
                return schedule;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Ticket fetchTicektByid(String token, String tid) {

        Call<Ticket> call = apiInterface.fetchTicketById(token, tid);
        try {
            Response<Ticket> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<Ticket>fetchMytickets(String token){
        Call<List<Ticket>> call = apiInterface.fetchMyticket(token);
        try {
            Response<List<Ticket>> response = call.execute();
            if (response.code() == 200) {
                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
