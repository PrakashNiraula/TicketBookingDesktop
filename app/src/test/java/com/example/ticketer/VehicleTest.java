package com.example.ticketer;

import com.example.ticketer.module.Message;
import com.example.ticketer.module.User;
import com.example.ticketer.module.Vehicle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class VehicleTest {

    @Test

    public void createVehicle() {
        System.setProperty("http.proxyHost", "127.0.2.2");
        System.setProperty("http.proxyPort", "3000");
        Boolean status = false;
        User user = new User("user123", "user123");
        try {
            Message message = user.makelogin(user);
            if (message == null) status = false;
            else status = true;
            Assert.assertEquals(true, status);
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType("Bus");
            vehicle.setVehicleNumber("Bus-AAA-43");
            vehicle.setOwner("5f4a773b789b0213203ad04a");
            Vehicle response = vehicle.createVehicle(message.getToken(), vehicle);
            if (response != null) {
                status = true;
            }
            boolean deleteresponse = vehicle.deleteVehicle(message.getToken(), response.getId());
            Assert.assertEquals(true, status);
            Assert.assertEquals(true, deleteresponse);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void SearchVehiclebyId() {
        System.setProperty("http.proxyHost", "127.0.2.2");
        System.setProperty("http.proxyPort", "3000");
        Boolean status = false;
        User user = new User("user123", "user123");
        try {
            Message message = user.makelogin(user);
            if (message == null) status = false;
            else status = true;
            Assert.assertEquals(true, status);
            status = false;
            Vehicle vehicle = new Vehicle();
            Vehicle responseVehicle = vehicle.searchVehcileByID(message.getToken(), "5f4fec9feee42e493099cde3");
            if (responseVehicle != null) status = true;
            Assert.assertEquals(true, status);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
