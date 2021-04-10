package controller;

import view.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import miscellaneous.ExteriorColour;
import miscellaneous.InteriorColour;
import model.CarModel;
import model.Customer;
import model.Salesperson;
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
		customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
		customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
		customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
		customerChoicesMenu.addReturnToMainMenuListener(new ReturnToMainMenuListener());
	}

	private class ViewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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

			int accessLevel = 3;
			if(main.getSalesperson().isStoreManager()) {
				accessLevel = 1;
			} else if (main.getSalesperson().isDesignated(customer)) {
				accessLevel = 2;
			} 

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			viewCustomerMenu = new ViewCustomerGUI(main.getCustomer(), accessLevel);
			viewCustomerMenu.addReturnToCustomerMenuFromViewListener(new ReturnToCustomerMenuFromViewListener());
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

	private class EditCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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

			int accessLevel = 0;
			if(main.getSalesperson().isStoreManager()) {
				accessLevel = 1;
			} else if (main.getSalesperson().isDesignated(customer)) {
				accessLevel = 2;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			editCustomerMenu = new EditCustomerGUI(main.getCustomer(), accessLevel);
			editCustomerMenu.addSubmitNewInformationListener(new SubmitNewInformationListener());
			editCustomerMenu.addReturnToCustomerMenuFromEditListener(new ReturnToCustomerMenuFromEditListener());
		}
	}
	private class SubmitNewInformationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (
				editCustomerMenu.getEmailField().isBlank() ||
				editCustomerMenu.getPhoneNumberField().isBlank() || 
				editCustomerMenu.getBillingAddressField().isBlank() ||
				editCustomerMenu.getCardNumberField().isBlank() ||
				editCustomerMenu.getCardExpiryDateField().isBlank() ||
				editCustomerMenu.getGenderField().isBlank() || 
				editCustomerMenu.getGenderField().length() != 1
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {
				Customer customer = main.getCustomer();

				customer.setEmail(editCustomerMenu.getEmailField());
				customer.setPhoneNumber(editCustomerMenu.getPhoneNumberField());
				customer.setBillingAddress(editCustomerMenu.getBillingAddressField());
				customer.setCardNumber(editCustomerMenu.getCardNumberField());
				customer.setCardExpiryDate(editCustomerMenu.getCardExpiryDateField());
				customer.setGender(editCustomerMenu.getGenderField().toCharArray()[0]);
				if(!editCustomerMenu.getNotesField().isBlank()) {
					customer.setNotes("\n\n" +editCustomerMenu.getNotesField());
				}

				DatabaseController.saveCustomer(main.getCustomer());
			}
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
	private class SubmitNewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(
				addCustomerMenu.getAgeField().isBlank() ||
				addCustomerMenu.getNameField().isBlank() ||
				addCustomerMenu.getEmailField().isBlank() ||
				addCustomerMenu.getPhoneNumberField().isBlank() ||
				addCustomerMenu.getBillingAddressField().isBlank() ||
				addCustomerMenu.getCardNumberField().isBlank() ||
				addCustomerMenu.getCardExpiryDateField().isBlank() ||
				addCustomerMenu.getCurrentVehicleBrandField().isBlank() ||
				addCustomerMenu.getCurrentVehicleModelField().isBlank() ||
				addCustomerMenu.getCurrentVehicleYearField().isBlank() ||
				addCustomerMenu.getCurrentVehiclePriceField().isBlank() ||
				addCustomerMenu.getCurrentVehicleExteriorField().isBlank() ||
				addCustomerMenu.getCurrentVehicleInteriorField().isBlank()
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {

				CarModel carModel = new CarModel(addCustomerMenu.getCurrentVehicleBrandField(), addCustomerMenu.getCurrentVehicleModelField(), 
				Integer.parseInt(addCustomerMenu.getCurrentVehicleYearField()), Double.parseDouble(addCustomerMenu.getCurrentVehiclePriceField()));
				Vehicle vehicle = new Vehicle(carModel, ExteriorColour.BLACK, InteriorColour.BLACK);

				ArrayList<LocalDate> visitHistory = new ArrayList<LocalDate>();
				visitHistory.add(LocalDate.now());

				Salesperson salesperson = DatabaseController.getSalesperson(addCustomerMenu.getDesignatedSalespersonChoice());

				Customer customer = new Customer(DatabaseController.getUniqueId(), Integer.parseInt(addCustomerMenu.getAgeField()), 
				addCustomerMenu.getCardNumberField(), addCustomerMenu.getNameField(), 
				addCustomerMenu.getEmailField(), addCustomerMenu.getPhoneNumberField(), 
				addCustomerMenu.getBillingAddressField(), addCustomerMenu.getCardExpiryDateField(), 
				"", addCustomerMenu.getGenderChoice().toCharArray()[0], 
				visitHistory, 
				vehicle, 
				null, 
				salesperson);

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


}