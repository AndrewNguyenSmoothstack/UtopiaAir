package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    public static void aMenu() throws SQLException {
        System.out.println("1)\tAdd/Update/Delete/Read Flights\n" +
                "2)\tAdd/Update/Delete/Read Seats\n" +
                "3)\tAdd/Update/Delete/Read Tickets and Passengers\n" +
                "4)\tAdd/Update/Delete/Read Airports\n" +
                "5)\tAdd/Update/Delete/Read Travelers\n" +
                "6)\tAdd/Update/Delete/Read Employees\n" +
                "7)\tOver-ride Trip Cancellation for a ticket.\n");

        Scanner u = new Scanner(System.in);
        String action = u.nextLine();

        boolean valid=false;

        while(!valid) {
            switch (action) {
                case "1":

                    System.out.println("Select flight to update/delete or add");
                    List<Flights> fs= getFlights("tbl_flight");

                    int x=fs.size()+1;
                    for(int i = 0; i<x;i++){
                        if(i<fs.size()) {
                            System.out.print(i+") "+"Flight Number:");
                            if(fs.get(i).getFlightNumber()==null) {System.out.println("null"+"\t Depart: "+fs.get(i).getDepartTime()+"\t Arrives:"+fs.get(i).getArrivalTime()+"\t Seats Available:"+ fs.get(i).getSeatsAvailable()+"\t Price:"+fs.get(i).getPrice());
                            }
                            else System.out.println(fs.get(i).getFlightNumber()+"\t Depart: "+fs.get(i).getDepartTime()+"\t Arrives:"+fs.get(i).getArrivalTime()+"\t Seats Available:"+ fs.get(i).getSeatsAvailable()+"\t Price:"+fs.get(i).getPrice());
                        }
                        else  System.out.println(i+") Add Flight");
                    }
                    Scanner d = new Scanner(System.in);
                    int act = d.nextInt();
                    if(act==x-1){
                        addFlight();
                    }
                    else{
                        updateFlight(fs.get(act).getFlightId());
                    }
                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                default:

            }
        }
    }

    public static List<Flights> getFlights(String table) {
        List<Flights> flights = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select flightId, departTime, seatsAvailable, price, arrivalTime, flightNumber from "+table+";");
            while (rset.next()) {
                Flights s = new Flights(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6));
                flights.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }

    public static void updateFlight(String f) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select flightId, departTime, seatsAvailable, price, arrivalTime, flightNumber from tbl_flight where flightId = "+f);
            //System.out.println("1)"+rset.getString(1)+ " 2)"+rset.getString(2)+" 3)"+rset.getString(3)+" 4)"+rset.getString(4)+" 5)"+rset.getString(5)+" 6)"+rset.getString(6)+" 7)"+rset.getString(7)+" 8)Delete Flight");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner u = new Scanner(System.in);
        String action = u.nextLine();

        boolean valid=false;

        while(!valid) {
            switch (action) {
                case "1":
                    System.out.println("Update Flight ID");
                    Scanner d = new Scanner(System.in);
                    String act = d.nextLine();

                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    Statement stmt = c.createStatement();
                    ResultSet rset = stmt.executeQuery("update tbl_flight set flightID = '"+act+"' where flightID = '"+f+"';");

                    break;
                case "2":

                    System.out.println("Update Departure");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set departTime = '"+act+"' where flightID = '"+f+"';");

                    break;
                case "3":
                    System.out.println("Update Available Seats");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set seatsAvailable = '"+act+"' where flightID = '"+f+"';");
                    break;
                case "4":
                    System.out.println("Update Price");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set price = '"+act+"' where flightID = '"+f+"';");
                    break;
                case "5":
                    System.out.println("Update Arrival");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set arrivalTime = '"+act+"' where flightID = '"+f+"';");
                    break;
                case "6":
                    System.out.println("Update Flight Number");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set flightNumber = '"+act+"' where flightID = '"+f+"';");
                    break;
                case "7":
                    System.out.println("Deleting Flight");
                    d = new Scanner(System.in);
                    act = d.nextLine();

                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("update tbl_flight set flightNumber = '"+act+"' where flightID = '"+f+"';");
                    break;
                case "8":
                    System.out.println("Deleting Flight");
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
                    stmt = c.createStatement();
                    rset = stmt.executeQuery("Delete from tbl_flight where flightID = '"+f+"';");
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    public static void addFlight() throws SQLException {
        System.out.println("Adding Flight");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "nguyen");
        Statement stmt = c.createStatement();

        String dT,sA,p,aT,fN;
        Scanner x=new Scanner(System.in);

        System.out.print("Depart time(YYYY-MM-DD hh: mm: ss):");
        dT=x.nextLine();

        System.out.print("Seats Available:");
        sA=x.nextLine();

        System.out.print("Price:");
        p=x.nextLine();

        System.out.print("Arrival time(YYYY-MM-DD hh: mm: ss):");
        aT=x.nextLine();

        System.out.print("Flight Number:");
        fN=x.nextLine();

        stmt.execute("insert into tbl_flight (departTime, seatsAvailable, price, arrivalTime, flightNumber) values ('"+dT+"', '"+sA+"', '"+p+"','"+aT+"',(select flightNumber from tbl_flight_details where flightNumber = "+fN+"));");
        /*
        insert into tbl_flight (departTime, seatsAvailable, price, arrivalTime, flightNumber) values('2016-12-21 00:00:00','20','30','2016-12-22 00:00:00',(select flightNumber from tbl_flight_details where flightNumber = 6));
         */
    }

}
