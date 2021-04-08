package controller;

import view.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

import model.Customer;

public class CustomerController {
	private MainController main;
	private CustomerMenuGUI customerChoicesMenu;
	private AddCustomerGUI addCustomerMenu;
	private EditCustomerGUI editCustomerMenu;
	private ViewCustomerGUI viewCustomerMenu;

	public CustomerController(MainController main) {
		this.main = main;
		customerChoicesMenu = new CustomerMenuGUI(500, 500);
		customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
		customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
		customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
	}

	private class EditCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);
			int customerId = Integer.parseInt(custId);

			Customer customer = DatabaseController.searchForCustomer(customerId);

			if(customer.getDesignatedSalesperson().getId() != main.getSalesperson().getId()) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			editCustomerMenu = new EditCustomerGUI(500, 500);
			editCustomerMenu.addSubmitNewInformationListener(new SubmitNewInformationListener());
		}
	}


	private class AddCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			editCustomerMenu = new EditCustomerGUI();
		}
	}

	private class ViewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			customerChoicesMenu.dispose();
			customerChoicesMenu = null;
			editCustomerMenu = new EditCustomerGUI();
		}
	}

	private class CustomerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == customerChoicesMenu.getEditButton()) {
				editCustomerMenu = new EditCustomerGUI();
				main.getNotesArea.setText(main.getCustomer().getNotes());
			}
			else if(e.getSource() == editCustomerMenu.getMakeChangesButton()) {
				if(!(editCustomerMenu.getPhoneField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setPhoneNumber(Integer.parseInt(editCustomerMenu.getPhoneField()).getText());
				}
				if(!(editCustomerMenu.getEmailField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setEmail(editCustomerMenu.getEmailField().getText());
				}
				if(!(editCustomerMenu.getBillingAddressField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setBillingAddress(editCustomerMenu.getBillingAddressField().getText());
				}
				if(!(editCustomerMenu.getCardNumberField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setCardNumber(Integer.parseInt(editCustomerMenu.getCardNumberField().getText()));
				}
				if(!(editCustomerMenu.getCardExpiryDateField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setCardExpiryDate(editCustomerMenu.getCardExpiryDateField().getText());
				}
				if(!(editCustomerMenu.getNotesField().getText().equals(""))) {
					main.getCustomer().setNotes(editCustomerMenu.getNotesField().getText());
				}
				if(!(editCustomerMenu.getVehiclesInterestedIn().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().addVehiclesInterestedIn(DatabaseManager.searchForVehicle(
							Integer.parseInt(editCustomerMenu.getVehiclesInterestedIn().getText())));
				}
				if(!(editCustomerMenu.getCurrentVehicle().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
					main.getCustomer().setCurrentVehicle(DatabaseManager.searchForVehicle(
							(Integer.parseInt(editCustomerMenu.getCurrentVehicle().getText()))));
				}
			}
			else if(e.getSource() == customerChoicesMenu.getViewButton()) {
				viewCustomerMenu = new ViewCustomerGUI();
			}
			else if(e.getSource() == viewCustomerMenu.getSearchButton) {
				Customer c = DatabaseController.searchForCustomer(viewCustomerMenu.getIDField(), viewCustomerMenu.getNameField());
				ViewCustomerMenu.display(c);
			}
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
				editCustomerMenu.getNotesField().getText().isBlank()
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {
				main.getCustomer().setCustomer(customerId, age, name, password, email, 
												phoneNumber, billingAddress, cardNumber, 
												cardExpiryDate, notes, gender, visitHistory, 
												currentVehicle, vehiclesInterestedIn, designatedSalesperson);
			}

			// if(!(editCustomerMenu.getCardExpiryDateField().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
			// 	main.getCustomer().setCardExpiryDate(editCustomerMenu.getCardExpiryDateField().getText());
			// }
			// if(!(editCustomerMenu.getNotesField().getText().equals(""))) {
			// 	main.getCustomer().setNotes(editCustomerMenu.getNotesField().getText());
			// }
			// if(!(editCustomerMenu.getVehiclesInterestedIn().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
			// 	main.getCustomer().addVehiclesInterestedIn(DatabaseManager.searchForVehicle(
			// 			Integer.parseInt(editCustomerMenu.getVehiclesInterestedIn().getText())));
			// }
			// if(!(editCustomerMenu.getCurrentVehicle().getText().equals("")) && main.getSalesperson().getType().equals("StoreManager")) {
			// 	main.getCustomer().setCurrentVehicle(DatabaseManager.searchForVehicle(
			// 			(Integer.parseInt(editCustomerMenu.getCurrentVehicle().getText()))));
			// }

			editCustomerMenu.dispose();
			editCustomerMenu = null;

			customerChoicesMenu = new CustomerMenuGUI(500, 500);
			customerChoicesMenu.addEditCustomerListener(new EditCustomerListener());
			customerChoicesMenu.addAddCustomerListener(new AddCustomerListener());
			customerChoicesMenu.addViewCustomerListener(new ViewCustomerListener());
		}

	}
}