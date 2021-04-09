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
					notesLabel, genderLabel, currentVehicleLabel, designatedSalespersonLabel;
	private JList<String> visitHistoryList, vehiclesInterestedInList;
	private JButton returnToCustomerMenuButton;

	public ViewCustomerGUI(Customer customer, boolean validAccessLevel) {
		//TODO Find out which customer information cannot be seen by non-designated salesperson

		super("Login");
		setUndecorated(true);
		setSize(500, 500);
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

		ArrayList<Vehicle> carsInterestedIn = customer.getVehiclesInterestedIn();
		String[] stringCarsInterestedIn = new String[carsInterestedIn.size()];
		for(int i = 0; i < carsInterestedIn.size(); ++i) {
			stringCarsInterestedIn[i] = carsInterestedIn.get(i).toString();
		}
		vehiclesInterestedInList = new JList<String>(stringCarsInterestedIn);
		add(vehiclesInterestedInList);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);

		setVisible(true);
	}

	public void addReturnToCustomerMenuFromViewListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

}
