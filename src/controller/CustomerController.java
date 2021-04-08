package controller;

import view.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class CustomerController {
	private MainController main;
	private CustomerMenuGUI customerChoicesMenu;
	private AddCustomerGUI addCustomerMenu;
	private EditCustomerGUI editCustomerMenu;
	private ViewCustomerGUI viewCustomerMenu;

	public CustomerController(MainController main) {
		this.main = main;
		customerChoicesMenu = new CustomerMenuGUI();
	}
	
	private class CustomerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == customerChoicesMenu.getEditButton()) {
				editCustomerMenu = new EditCustomerGUI();
				main.getNotesArea.setText(main.getCustomer().getNotes());
			}
			else if(e.getSource() == editCustomerMenu.getMakeChangesButton()) {
				if(!(editCustomerMenu.getPhoneNumberField().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().setPhoneNumber(Integer.parseInt(editCustomerMenu.getPhoneNumberField()).getText());
				}
				if(!(editCustomerMenu.getEmailField().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().setEmail(editCustomerMenu.getEmailField().getText());
				}
				if(!(editCustomerMenu.getBillingAddressField().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().setBillingAddress(editCustomerMenu.getBillingAddressField().getText());
				}
				if(!(editCustomerMenu.getCardNumberField().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().setCardNumber(Integer.parseInt(editCustomerMenu.getCardNumberField().getText()));
				}
				if(!(editCustomerMenu.getCardExpiryDateField().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().setCardExpiryDate(editCustomerMenu.getCardExpiryDateField().getText());
				}
				if(!(editCustomerMenu.getNotesArea().getText().equals(""))) {
					main.getCustomer().setNotes(editCustomerMenu.getNotesArea().getText());
				}
				if(!(editCustomerMenu.getVehiclesInterestedIn().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
					main.getCustomer().addVehiclesInterestedIn(DatabaseManager.searchForVehicle(
							Integer.parseInt(editCustomerMenu.getVehiclesInterestedIn().getText())));
				}
				if(!(editCustomerMenu.getCurrentVehicle().getText().equals("")) && main.getEmployee().getType().equals("StoreManager")) {
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
}