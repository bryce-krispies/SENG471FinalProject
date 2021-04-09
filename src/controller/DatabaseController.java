package controller;

import java.time.LocalDate;
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
        //TODO Change salesperson IDs to 12 length
        salespersonDatabase.add(new Salesperson(1, "Bryce Cayanan", "a", "StoreManager")); //demonstrate store manager functionality
        salespersonDatabase.add(new Salesperson(2, "Madison Hill", "a", "Employee")); // demonstrate non designated functionality
        salespersonDatabase.add(new Salesperson(3, "Jens Varughese", "a", "Employee")); //demonstrate designated functionality

        customerDatabase.add(new Customer(0, 21, "1234123412341234", "Jayden Bischoff", "jb@hotmail.com", 
                                            "+1(123)-456-7890", "177A Bleecker Street, New York, NY", "02/22", 
                                             "", 'F', new ArrayList<LocalDate>(), new Vehicle("Hummer", "BLACK", "YELLOW"), 
                                             new ArrayList<Vehicle>(), salespersonDatabase.get(1)));
        customerDatabase.add(new Customer(1, 20, "9867987698769876", "Zachary Lancaster", "zl@hotmail.com", 
                                            "+9(987)-654-3210", "151 Beverly Hills, Los Angeles, CA", "04/26", 
                                            "", 'M', new ArrayList<LocalDate>(), new Vehicle("Beetle", "PURPLE", "BLUE"), 
                                            new ArrayList<Vehicle>(), salespersonDatabase.get(2)));

        // if yall have a better idea how to do colours, go ahead (enums? constants? i have no idea if we're being honest here)
        vehicleDatabase.add(new Vehicle("Wienermobile", "BROWN", "PINK"));
        vehicleDatabase.add(new Vehicle("Delorean", "SILVER", "BLACK"));
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