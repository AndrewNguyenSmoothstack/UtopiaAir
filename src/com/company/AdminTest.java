package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.company.Admin.getFlights;
import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @org.junit.jupiter.api.Test
    void aMenu() {
    }

    @org.junit.jupiter.api.Test
    void testGetFlights() {
        Connection conn = null;
        List<Flights>testGet = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
            Statement stmt = conn.createStatement();
            stmt.execute("create table testme (flightId varchar(255), departTime varchar(255), seatsAvailable varchar(255), price varchar(255), arrivalTime varchar(255), flightNumber varchar(255));");
            stmt.executeUpdate("insert into testme( flightId, departTime, seatsAvailable, price, arrivalTime, flightNumber) values (2,2016-12-21,20,20,2016-12-22,2);");

            testGet=getFlights("testme");

            assertEquals(2,Integer.parseInt(testGet.get(0).getFlightId()));
            assertEquals(20,Integer.parseInt(testGet.get(0).getPrice()));
            assertEquals(2, Integer.parseInt(testGet.get(0).getFlightNumber()));

            stmt.executeUpdate("Drop table testme");
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @org.junit.jupiter.api.Test
    void updateFlight() {
    }

    @org.junit.jupiter.api.Test
    void addFlight() {
    }
}