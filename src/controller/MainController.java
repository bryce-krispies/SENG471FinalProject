package controller;

import view.*;
import model.*;

class MainController {
    private Employee employee;
    private Vehicle vehicle;
    private Customer customer;

    public MainController() {
        // mainMenu = new MainMenuGUI(1200, 800);
        DatabaseController.initializeDatabase();
        employee = null;
        vehicle = null;
        customer = null;
    }

    public static void main(String [] args) {
    	MainController main = new MainController();
        new LoginController(main);
    }
}