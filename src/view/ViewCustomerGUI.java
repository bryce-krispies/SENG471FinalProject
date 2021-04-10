package view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import model.Customer;
import model.Vehicle;

public class ViewCustomerGUI extends JFrame {

	private JLabel customerIdLabel, ageLabel, cardNumberLabel, nameLabel, 
					emailLabel, phoneNumberLabel, billingAddressLabel, cardExpiryDateLabel, 
					notesLabel, genderLabel, currentVehicleLabel, desiredVehicleLabel, 
					designatedSalespersonLabel;
	private JList<String> visitHistoryList;
	private JButton returnToCustomerMenuButton;

	public ViewCustomerGUI(Customer customer, int accessLevel) {
		super("View Customer");
		setUndecorated(true);

		if(accessLevel == 1) {
			renderHighAccess(customer);
		} else if (accessLevel == 2) {
			renderMediumAccess(customer);
		} else {
			renderLowAccess(customer);
		}

		setVisible(true);
	}

	public void renderHighAccess(Customer customer) {
		//Store manager - everything
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));
		
		customerIdLabel = new JLabel("Customer ID: " +customer.getId());
		add(customerIdLabel);
		ageLabel = new JLabel("Age: " +customer.getAge());
		add(ageLabel);
		cardNumberLabel = new JLabel("Card Number: " +customer.getCardNumber());
		add(cardNumberLabel);
		nameLabel = new JLabel("Name: " +customer.getName());
		add(nameLabel);
		emailLabel = new JLabel("Email: " +customer.getEmail());
		add(emailLabel);
		phoneNumberLabel = new JLabel("Phone Number: " +customer.getPhoneNumber());
		add(phoneNumberLabel);
		billingAddressLabel = new JLabel("Billing Address: " +customer.getBillingAddress());
		add(billingAddressLabel);
		cardExpiryDateLabel = new JLabel("Card Expiry Date: " +customer.getCardExpiryDate());
		add(cardExpiryDateLabel);
		notesLabel = new JLabel("Notes: " +customer.getNotes());
		add(notesLabel);
		genderLabel = new JLabel("Gender: " +customer.getGender());
		add(genderLabel);
		currentVehicleLabel = new JLabel("Current Vehicle: " +customer.getCurrentVehicle());
		add(currentVehicleLabel);
		designatedSalespersonLabel = new JLabel("Designated Salesperson: " +customer.getDesignatedSalesperson());
		add(designatedSalespersonLabel);

		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		visitHistoryList = new JList<String>(stringHistory);
		add(visitHistoryList);

		desiredVehicleLabel = new JLabel("Notes: " +customer.getDesiredVehicle());
		add(desiredVehicleLabel);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void renderMediumAccess(Customer customer) {
		//design. salesperson - desired vehicle, price, notes, visit history

		setSize(750, 750);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		desiredVehicleLabel = new JLabel("Notes: " +customer.getDesiredVehicle());
		add(desiredVehicleLabel);

		notesLabel = new JLabel("Notes: " +customer.getNotes());
		add(notesLabel);

		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		visitHistoryList = new JList<String>(stringHistory);
		add(visitHistoryList);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void renderLowAccess(Customer customer) {
		//non-designated - customer notes, visit history

		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		notesLabel = new JLabel("Notes: " +customer.getNotes());
		add(notesLabel);

		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		visitHistoryList = new JList<String>(stringHistory);
		add(visitHistoryList);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void addReturnToCustomerMenuFromViewListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

}
