package controller;
import model.*;
import view.CustomizeCarGUI;
import java.awt.event.*;

/**
 * Jayden I only provided the constructor and the SaveCarModel action listener so you know how everything ties together,
 * but in terms of the actual customize car functionality, its your call senora
 * 
 * If we're being honest here just look at your state diagram, cause that is how the system works
 * 
 * Additionally, I have no idea how the pictures for the models will work, so talk with Madison bout that one
 * The vehicle class will probably have to be changed for the pics
 * 
 * Also look at the private class ChooseCustomizeCarGUI within MainController.java to see how we get to VehicleCustomizationController
 */
class VehicleCustomizationController {

    private MainController main;
	private CustomizeCarGUI customizeCarMenu;

    public VehicleCustomizationController(MainController main) {
        this.main = main;

        customizeCarMenu = new CustomizeCarGUI();
        //add all other button listeners (like SelectInteriorColour, SelectModel, etc.)
        customizeCarMenu.addSaveCarModelListener(new SaveCarModelListener());
        customizeCarMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
    }

    private class SaveCarModelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //here check if the vehicle is valid

            //save car model into customer within the database
            main.getCustomer().setDesiredVehicle(main.getVehicle());
            DatabaseController.saveCustomer(main.getCustomer());

            // erase/dispose of car menu
            customizeCarMenu.dispose();
			customizeCarMenu = null;

            // go back to main menu 
			new MainController(main.getSalesperson());
        }

    }

    private class ReturnToMainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // erase/dispose of car menu
            customizeCarMenu.dispose();
			customizeCarMenu = null;

            // go back to main menu 
			new MainController(main.getSalesperson());
        }

    }

}