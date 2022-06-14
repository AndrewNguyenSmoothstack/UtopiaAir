package com.company;

import java.sql.SQLException;
import java.util.Scanner;

import static com.company.Admin.aMenu;

public class Main {

    public static void main(String[] args) throws SQLException {
	    System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");
        System.out.println("1) Employee/Agent");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");

        Scanner u = new Scanner(System.in);
        String user = u.nextLine();

        boolean valid=false;

        while(!valid) {
            switch (user) {
                case "1":
                    break;

                case "2":
                    valid=true;
                    aMenu();

                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid user");
            }
        }
    }
}
