package controller;

import java.util.ArrayList;

import model.Customer;
import model.Salesperson;
import model.Vehicle;

public class DatabaseController {

    private static ArrayList<Salesperson> salespersonDatabase;
    private static ArrayList<Customer> customerDatabase;
    private static ArrayList<Vehicle> vehicleDatabase; 

    public static void initializeDatabase() {
        //initialize database here
    }

    public static Salesperson searchForSalesperson(int empID, String password) {
        //return null if Salesperson not found
        //else return Salesperson
        return null;
    }

    public static boolean addCustomer(Customer customer) {
        return false;
    }

}