package controller;

import view.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Customer;
import model.Vehicle;

public class CustomerController {
	private MainController main;
	private CustomerMenuGUI customerChoicesMenu;
	private AddCustomerGUI addCustomerMenu;
	private EditCustomerGUI editCustomerMenu;
	private ViewCustomerGUI viewCustomerMenu;

	public CustomerController(MainController main) {
		this.main = main;
		customerChoicesMenu = new CustomerMenuGUI();
		customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
		customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
		customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
		customerChoicesMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
	}

	private class EditCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);
			int customerId = Integer.parseInt(custId);

			Customer customer = DatabaseController.searchForCustomer(customerId);

			if(customer == null) {
				JOptionPane.showMessageDialog(null, "Customer Not Found", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			main.setCustomer(customer);

			if(
				customer.checkIfSalespersonIsDesignated(main.getSalesperson()) &&
				!main.getSalesperson().isStoreManager()
			) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			editCustomerMenu = new EditCustomerGUI(main.getCustomer());
			editCustomerMenu.addSubmitNewInformationListener(new SubmitNewInformationListener());
			editCustomerMenu.addReturnToCustomerMenuFromEditListener(new ReturnToCustomerMenuFromEditListener());
		}
	}

	private class AddCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!main.getSalesperson().isStoreManager()) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			addCustomerMenu = new AddCustomerGUI();
			addCustomerMenu.addSubmitNewCustomerListener(new SubmitNewCustomerListener());
			addCustomerMenu.addReturnToCustomerMenuButtonFromAddListener(new ReturnToCustomerMenuFromAddListener());
		}
	}

	private class ViewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);
			int customerId = Integer.parseInt(custId);

			Customer customer = DatabaseController.searchForCustomer(customerId);

			if(customer == null) {
				JOptionPane.showMessageDialog(null, "Customer Not Found", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			main.setCustomer(customer);

			boolean validAccessLevel = true;

			if(
				customer.checkIfSalespersonIsDesignated(main.getSalesperson()) &&
				!main.getSalesperson().isStoreManager()
			) {
				validAccessLevel = false;
			}

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			viewCustomerMenu = new ViewCustomerGUI(main.getCustomer(), validAccessLevel);
			viewCustomerMenu.addReturnToCustomerMenuFromViewListener(new ReturnToCustomerMenuFromViewListener());
		}
	}

    private class ReturnToMainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // erase/dispose of car menu
            customerChoicesMenu.dispose();
			customerChoicesMenu = null;

            // go back to main menu 
			new MainController(main.getSalesperson());
        }

    }

	private class SubmitNewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(
				addCustomerMenu.getAgeField().getText().isBlank() ||
				addCustomerMenu.getCardNumberField().getText().isBlank() ||
				addCustomerMenu.getNameField().getText().isBlank() ||
				addCustomerMenu.getEmailField().getText().isBlank() ||
				addCustomerMenu.getPhoneField().getText().isBlank() ||
				addCustomerMenu.getBillingAddressField().getText().isBlank() ||
				addCustomerMenu.getCardExpiryDateField().getText().isBlank() ||
				addCustomerMenu.getGenderField().getText().isBlank() ||
				addCustomerMenu.getCurrentVehicleModelField().getText().isBlank() ||
				addCustomerMenu.getCurrentVehicleExteriorField().getText().isBlank() ||
				addCustomerMenu.getCurrentVehicleInteriorField().getText().isBlank() ||
				addCustomerMenu.getDesignatedSalespersonField().getText().isBlank()
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {
				int id = DatabaseController.getUniqueId();
				Customer customer = new Customer(id, Integer.parseInt(addCustomerMenu.getAgeField().getText()), addCustomerMenu.getCardNumberField().getText(), 
				addCustomerMenu.getNameField().getText(), addCustomerMenu.getEmailField().getText(), addCustomerMenu.getPhoneField().getText(), 
				addCustomerMenu.getBillingAddressField().getText(), addCustomerMenu.getCardExpiryDateField().getText(), "", addCustomerMenu.getGenderField().getText().toCharArray()[0], 
				new ArrayList<LocalDate>(), new Vehicle(addCustomerMenu.getCurrentVehicleModelField().getText(), 
				addCustomerMenu.getCurrentVehicleExteriorField().getText(), 
				addCustomerMenu.getCurrentVehicleInteriorField().getText()), new ArrayList<Vehicle>(), 
				DatabaseController.getSalesperson(Integer.parseInt(addCustomerMenu.getDesignatedSalespersonField().getText())));

				DatabaseController.addCustomer(customer);
			}
			
			editCustomerMenu.dispose();
			editCustomerMenu = null;

			customerChoicesMenu = new CustomerMenuGUI();
			customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
			customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
			customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
		}
	}

	private class SubmitNewInformationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (
				editCustomerMenu.getPhoneField().getText().isBlank() || 
				editCustomerMenu.getEmailField().getText().isBlank() ||
				editCustomerMenu.getBillingAddressField().getText().isBlank() ||
				editCustomerMenu.getCardNumberField().getText().isBlank() ||
				editCustomerMenu.getCardExpiryDateField().getText().isBlank() ||
				editCustomerMenu.getNotesField().getText().isBlank() ||
				editCustomerMenu.getGenderField().getText().isBlank() ||
				editCustomerMenu.getCurrentVehicleModelField().getText().isBlank() ||
				editCustomerMenu.getCurrentVehicleExteriorField().getText().isBlank() ||
				editCustomerMenu.getCurrentVehicleInteriorField().getText().isBlank()
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {

				Customer customer = main.getCustomer();

				customer.setPhoneNumber(editCustomerMenu.getPhoneField().getText());
				customer.setEmail(editCustomerMenu.getEmailField().getText());
				customer.setBillingAddress(editCustomerMenu.getBillingAddressField().getText());
				customer.setCardNumber(editCustomerMenu.getCardNumberField().getText());
				customer.setCardExpiryDate(editCustomerMenu.getCardExpiryDateField().getText());
				customer.setNotes(editCustomerMenu.getNotesField().getText());
				customer.setGender(editCustomerMenu.getGenderField().getText().toCharArray()[0]);
				customer.setCurrentVehicle(new Vehicle(editCustomerMenu.getCurrentVehicleModelField().getText(), 
														editCustomerMenu.getCurrentVehicleExteriorField().getText(), 
														editCustomerMenu.getCurrentVehicleInteriorField().getText()));
				customer.setVehiclesInterestedIn(editCustomerMenu.getVehiclesInterestedIn());

				DatabaseController.saveCustomer(main.getCustomer());
			}
		}

	}

	private class ReturnToCustomerMenuFromAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// erase/dispose of car menu
			addCustomerMenu.dispose();
			addCustomerMenu = null;

			// go back to main menu 
			customerChoicesMenu = new CustomerMenuGUI();
			customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
			customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
			customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
			customerChoicesMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
		}

	}
	
	private class ReturnToCustomerMenuFromEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// erase/dispose of car menu
			editCustomerMenu.dispose();
			editCustomerMenu = null;

			// go back to main menu 
			customerChoicesMenu = new CustomerMenuGUI();
			customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
			customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
			customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
			customerChoicesMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
		}

	}
	
	private class ReturnToCustomerMenuFromViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// erase/dispose of car menu
			viewCustomerMenu.dispose();
			viewCustomerMenu = null;

			// go back to main menu 
			customerChoicesMenu = new CustomerMenuGUI();
			customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
			customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
			customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
			customerChoicesMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
		}

	}
}