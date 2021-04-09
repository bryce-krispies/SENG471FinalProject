package controller;

import view.*;
import model.*;
import java.awt.event.*;

import javax.swing.JOptionPane;


public class MainController {

    private Salesperson salesperson;
    private Vehicle vehicle;
    private Customer customer;

    private MainMenuGUI mainMenu;

	public MainController(Salesperson salesperson) {
		this.salesperson = salesperson;
		vehicle = null;
        customer = null;

		mainMenu = new MainMenuGUI(this);
        mainMenu.addCustomerMenuGUIButtonListener(new ChooseCustomerMenuGUI());
        mainMenu.addCustomizeCarGUIButtonListener(new ChooseCustomizeCarGUI());
		mainMenu.addLogoutButtonListener(new ChooseLogout());
	}

    private class ChooseCustomerMenuGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainController main = mainMenu.getMainController();

			mainMenu.dispose();
			mainMenu = null;

			new CustomerController(main);
		}
	}

    private class ChooseCustomizeCarGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);
			int customerId = Integer.parseInt(custId);

			Customer customer = DatabaseController.searchForCustomer(customerId);
			MainController main = mainMenu.getMainController();

			if(
				(customer.getDesignatedSalesperson().getId() != main.getSalesperson().getId()) &&
				!main.getSalesperson().getType().equals("StoreManager")
			) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			mainMenu.dispose();
			mainMenu = null;

			new VehicleCustomizationController(main);
		}
	}

	private class ChooseLogout implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainMenu.dispose();
			mainMenu = null;

			salesperson = null;
			vehicle = null;
			customer = null;

			DatabaseController.initializeDatabase();
        	new LoginController();
		}
	}

    public MainMenuGUI getMainMenu() {
        return mainMenu;
    }

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Salesperson getSalesperson() {
		return salesperson;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

    public static void main(String [] args) {
		DatabaseController.initializeDatabase();
        new LoginController();
    }
}