package controller;
import model.*;
import view.CustomizeCarGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private String modelSelected;
    private String exteriorColourSelected;
    private String interiorColourSelected;
    private String viewSelected;

    public VehicleCustomizationController(MainController main) {
        this.main = main;
        modelSelected = null;
        exteriorColourSelected = null;
        interiorColourSelected = null;
        viewSelected = null;

        customizeCarMenu = new CustomizeCarGUI();
        //add all other button listeners (like SelectInteriorColour, SelectModel, etc.)

        customizeCarMenu.addSelectCarModelListener(new SelectCarModelListener());
        customizeCarMenu.addSelectExteriorColourListener(new SelectExteriorColourListener());
        customizeCarMenu.addSelectInteriorColourListener(new SelectInteriorColourListener());
        customizeCarMenu.addSelectViewListener(new SelectViewListener());
        customizeCarMenu.addSaveCarModelListener(new SaveCarModelListener());
        customizeCarMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
    }

    public void updateCarView() {
        if(modelSelected != null && exteriorColourSelected != null && interiorColourSelected != null && viewSelected != null) {
            String fileName = "";
            if(modelSelected == "Mustang") {
                modelSelected = modelSelected.toLowerCase();
            }
            if(viewSelected == "Interior") {
                viewSelected = "int";
            }
            if(viewSelected == "dash" || viewSelected == "int") {
                fileName = "resources\\" + modelSelected + "_" + viewSelected.toLowerCase() + "_null_" + interiorColourSelected.toLowerCase() + ".png";
            }
            else {
                fileName = "resources\\" + modelSelected + "_" + viewSelected.toLowerCase() + "_" + exteriorColourSelected.toLowerCase() + "_null.png";
            }
            customizeCarMenu.displayCarView(DatabaseController.getCarImage(fileName));
        }
    }

    private class SelectCarModelListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(customizeCarMenu.getModelSelection() != modelSelected) {
                modelSelected = customizeCarMenu.getModelSelection();
                updateCarView();

                customizeCarMenu.exteriorColoursList.setVisible(true);

                //TODO: fix interior colour selection
                /*if(modelSelected == "MKZ") {
                    customizeCarMenu.interiorColoursList = new JList(new String[]{"Black", "Tan", "Brown"});
                }
                else {
                    customizeCarMenu.interiorColoursList = new JList(new String[]{"Black", "White", "Tan"});
                }*/
                customizeCarMenu.interiorColoursList.setVisible(true);

                customizeCarMenu.viewList.setVisible(true);
            }
        }
    }

    private class SelectExteriorColourListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(customizeCarMenu.getExteriorColourSelection() != exteriorColourSelected) {
                exteriorColourSelected = customizeCarMenu.getExteriorColourSelection();
                updateCarView();
            }
        }
    }

    private class SelectInteriorColourListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(customizeCarMenu.getInteriorColourSelection() != interiorColourSelected) {
                interiorColourSelected = customizeCarMenu.getInteriorColourSelection();
                updateCarView();
            }
        }
    }

    private class SelectViewListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(customizeCarMenu.getViewSelection() != viewSelected) {
                viewSelected = customizeCarMenu.getViewSelection();
                updateCarView();
            }
        }
    }

    private class SaveCarModelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //here check if the vehicle is valid
            main.setVehicle(DatabaseController.getVehicle(modelSelected, exteriorColourSelected, interiorColourSelected));

            //save car model into customer within the database
            String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);

            if(custId == null) {
                return;
            }

            Customer customer = DatabaseController.getCustomer(custId);

            if(customer == null) {
                JOptionPane.showMessageDialog(null, "Customer Not Found", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            main.setCustomer(customer);

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