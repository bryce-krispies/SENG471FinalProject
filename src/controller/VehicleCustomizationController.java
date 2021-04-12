package controller;
import model.*;
import view.CustomizeCarGUI;
import view.GUIPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class VehicleCustomizationController {

    private MainController main;
    private GUIPane mainGUI;
	private CustomizeCarGUI customizeCarMenu;
    private String modelSelected;
    private String exteriorColourSelected;
    private String interiorColourSelected;
    private String viewSelected;
    private String picLocation;

    public VehicleCustomizationController(MainController main, GUIPane mainGUI) {
    	
    	this.mainGUI = mainGUI;
    	
        this.main = main;
        modelSelected = null;
        exteriorColourSelected = null;
        interiorColourSelected = null;
        viewSelected = null;

        setCustomizeCarMenu(new CustomizeCarGUI());
        //add all other button listeners (like SelectInteriorColour, SelectModel, etc.)

        getCustomizeCarMenu().addSelectCarModelListener(new SelectCarModelListener());
        getCustomizeCarMenu().addSelectExteriorColourListener(new SelectExteriorColourListener());
        getCustomizeCarMenu().addSelectInteriorColourListener(new SelectInteriorColourListener());
        getCustomizeCarMenu().addSelectViewListener(new SelectViewListener());
        getCustomizeCarMenu().addSaveCarModelListener(new SaveCarModelListener());
        getCustomizeCarMenu().addReturnToMainMenuListener(new ReturnToMainMenuListener());
    }

    public void updateCarView() {
        
            getCustomizeCarMenu().displayCarView(DatabaseController.getCarImage(picLocation));
            
    }

    public CustomizeCarGUI getCustomizeCarMenu() {
		return customizeCarMenu;
	}

	public void setCustomizeCarMenu(CustomizeCarGUI customizeCarMenu) {
		this.customizeCarMenu = customizeCarMenu;
	}

	private class SelectCarModelListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
        	
        	modelSelected = getCustomizeCarMenu().getModelSelection();
        	
        	customizeCarMenu.resetButtonsFull();
        	
        	customizeCarMenu.exteriorColoursList.setListData(new String[]{"White", "Black", "Blue", "Red", "Grey"});
    		
        	if(modelSelected.compareTo("MKZ") == 0)
        		customizeCarMenu.interiorColoursList.setListData(new String[]{"Black", "Beige", "Brown"});
        	else
        		customizeCarMenu.interiorColoursList.setListData(new String[]{"Black", "White", "Tan"});
        	
        }
    }

    private class SelectExteriorColourListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
        	
            if(getCustomizeCarMenu().getModelSelection() != null && 
            		getCustomizeCarMenu().getInteriorColourSelection() != null) {

            	customizeCarMenu.resetButtonsPart();
            	
            	exteriorColourSelected = getCustomizeCarMenu().getExteriorColourSelection();
            	interiorColourSelected = getCustomizeCarMenu().getInteriorColourSelection();
            	
            	getCustomizeCarMenu().viewList.setListData(new String[]{"Front", "Back", "Dash", "Interior"});
                
            }
        }
    }

    private class SelectInteriorColourListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
        	
        	if(getCustomizeCarMenu().getModelSelection() != null && 
        			getCustomizeCarMenu().getExteriorColourSelection() != null) {

        		customizeCarMenu.resetButtonsMin();
        		
        		exteriorColourSelected = getCustomizeCarMenu().getExteriorColourSelection();
            	interiorColourSelected = getCustomizeCarMenu().getInteriorColourSelection();
        		
            	getCustomizeCarMenu().viewList.setListData(new String[]{"Front", "Back", "Dash", "Interior"});
                
            }
        }
    }

    private class SelectViewListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
        	
        	if(getCustomizeCarMenu().getModelSelection() != null &&
        			getCustomizeCarMenu().getExteriorColourSelection() != null &&
        			getCustomizeCarMenu().getInteriorColourSelection() != null &&
        			getCustomizeCarMenu().getViewSelection() != null) {
        		viewSelected = getCustomizeCarMenu().getViewSelection();

        		picLocation = "resources\\" + modelSelected + 
        				"\\" + interiorColourSelected + "\\" + 
        			exteriorColourSelected +
        			"\\" + viewSelected.toLowerCase() + ".png";
        		
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

            mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			
			mainGUI.getContentPane().add(mainGUI.getVehicleController().getCustomizeCarMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());

            
        }

    }

    private class ReturnToMainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        	mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getMainController().getMainMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
        }

    }

}