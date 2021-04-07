package controller;

import java.util.ArrayList;

import model.Customer;
import model.Employee;
import model.Vehicle;

public class DatabaseController {

    private static ArrayList<Employee> employeeDatabase;
    private static ArrayList<Customer> customerDatabase;
    private static ArrayList<Vehicle> vehicleDatabase; 

    public static void initializeDatabase() {
        //initialize database here
    }

    public static Employee searchForEmployee(int empID, String password) {
        //return null if employee not found
        //else return employee
        return null;
    }

    public static boolean addCustomer(Customer customer) {
        return false;
    }

}