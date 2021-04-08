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
        salespersonDatabase = new ArrayList<Salesperson>();
        customerDatabase = new ArrayList<Customer>();
        vehicleDatabase = new ArrayList<Vehicle>();

        // if yall have a better idea how to do salesperson type, 
        // go ahead (enums? constants? i have no idea if we're being honest here)
        salespersonDatabase.add(new Salesperson(1, "Bryce Cayanan", "a", "StoreManager"));
        salespersonDatabase.add(new Salesperson(2, "Madison Hill", "a", "Employee"));
        salespersonDatabase.add(new Salesperson(3, "Jens Varughese", "a", "Employee"));
        salespersonDatabase.add(new Salesperson(4, "Jayden Bischoff", "a", "Employee"));
        salespersonDatabase.add(new Salesperson(5, "Zachary Lancaster", "a", "Employee"));

        // if yall have a better idea how to do colours, go ahead (enums? constants? i have no idea if we're being honest here)
        vehicleDatabase.add(new Vehicle("Wienermobile", "BROWN", "PINK"));
    }

    public static Salesperson searchForSalesperson(int empId, String password) {
        for(Salesperson s : salespersonDatabase) {
            if(s.getId() == empId && s.getPassword().equals(password)) {
                return s;
            }
        }

        return null;
    }

    public static Customer searchForCustomer(int custId) {
        return null;
    }

    public static boolean addCustomer(Customer customer) {
        return false;
    }

    public static boolean saveCustomer(Customer customer) {

        Customer toRemove = null;

        for(Customer c : customerDatabase) {
            if(c.getId() == customer.getId()) {
                toRemove = c;
            }
        }

        if(customer != null) {
            customerDatabase.remove(toRemove);
            customerDatabase.add(customer);
            return true;
        }

        return false;
    }

    public static ArrayList<Vehicle> retrieveModels() {
        return vehicleDatabase;
    }

}