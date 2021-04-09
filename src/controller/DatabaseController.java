package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import miscellaneous.ExteriorColour;
import miscellaneous.InteriorColour;
import miscellaneous.SalespersonType;
import model.CarModel;
import model.Customer;
import model.Salesperson;
import model.Vehicle;

public class DatabaseController {

    private static ArrayList<Salesperson> salespersonDatabase;
    private static ArrayList<Customer> customerDatabase;
    private static ArrayList<CarModel> carModelDatabase; 

    public static void initializeDatabase() {
        salespersonDatabase = new ArrayList<Salesperson>();
        customerDatabase = new ArrayList<Customer>();
        carModelDatabase = new ArrayList<CarModel>();

        //TODO Add car model pictures to car model and ArrayList<images> in carModel.java (maybe??)
        carModelDatabase.add(new CarModel("Toyota", "Camry", 2018, 20300));
        carModelDatabase.add(new CarModel("Ford", "Mustang", 2020, 40790));

        salespersonDatabase.add(new Salesperson("0", "Bryce Cayanan", "a", SalespersonType.STOREMANAGER)); //demonstrate store manager functionality
        salespersonDatabase.add(new Salesperson("1", "Madison Hill", "a", SalespersonType.EMPLOYEE)); // demonstrate non designated functionality
        salespersonDatabase.add(new Salesperson("2", "Jens Varughese", "a", SalespersonType.EMPLOYEE)); //demonstrate designated functionality

        customerDatabase.add(new Customer("0", 21, "1234123412341234", "Jayden Bischoff", "jb@hotmail.com", 
                                            "+1(123)-456-7890", "177A Bleecker Street, New York, NY", "02/22", 
                                             "", 'F', new ArrayList<LocalDate>(), 
                                             new Vehicle(carModelDatabase.get(0), ExteriorColour.BLACK, InteriorColour.GREEN), 
                                             new ArrayList<Vehicle>(), salespersonDatabase.get(1)));
        customerDatabase.add(new Customer("1", 20, "9867987698769876", "Zachary Lancaster", "zl@hotmail.com", 
                                            "+9(987)-654-3210", "151 Beverly Hills, Los Angeles, CA", "04/26", 
                                            "", 'M', new ArrayList<LocalDate>(), 
                                            new Vehicle(carModelDatabase.get(1), ExteriorColour.BLACK, InteriorColour.GREEN),
                                            new ArrayList<Vehicle>(), salespersonDatabase.get(2)));
    }
    
    public static boolean validateSalesperson(String empId, String password) {
        for(Salesperson s : salespersonDatabase) {
            if(s.getId().equals(empId) && s.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static Salesperson getSalesperson(String empId) {
        for(Salesperson s : salespersonDatabase) {
            if(s.getId().equals(empId)) {
                return s;
            }
        }

        return null;
    }

    public static Customer getCustomer(String custId) {
        for(Customer c : customerDatabase) {
            if(c.getId().equals(custId)) {
                return c;
            }
        }

        return null;
    }

    public static void addCustomer(Customer customer) {
        customerDatabase.add(customer);
    }

    public static void saveCustomer(Customer customer) {
        Customer toRemove = null;

        for(Customer c : customerDatabase) {
            if(c.getId() == customer.getId()) {
                toRemove = c;
            }
        }

        if(customer != null) {
            customerDatabase.remove(toRemove);
            customerDatabase.add(customer);
        }
    }

    public static ArrayList<CarModel> retrieveModels() {
        return carModelDatabase;
    }

    public static String getUniqueId() {
        int id = 0;
        for(int i = 0; i < customerDatabase.size(); ++i){
            if(id == Integer.parseInt(customerDatabase.get(i).getId())) {
                id++;
                i = 0;
            }
        }
        return String.valueOf(id);
    }

}