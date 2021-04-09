package view;

import javax.swing.JFrame;

import model.Customer;
import model.Vehicle;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class EditCustomerGUI extends JFrame {

	private JTextField emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField, 
						genderField, currentVehicleModelField, currentVehicleExteriorField, currentVehicleInteriorField;
	private JTextArea notesField;
	private JList<Vehicle> vehiclesInterestedInList;
	private ArrayList<Vehicle> vehiclesInterestedIn;
	private JButton submitNewInformationButton, removeVehicleInterestedInButton, returnToCustomerMenuButton;

	public EditCustomerGUI(Customer customer) {
		super("Login");
		setUndecorated(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		JLabel emailLabel = new JLabel("Email");
		emailField = new JTextField(customer.getEmail());
		add(emailLabel);
		add(emailField);

		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberField = new JTextField(customer.getPhoneNumber());
		add(phoneNumberLabel);
		add(phoneNumberField);

		JLabel billingAddressLabel = new JLabel("Billing Address");
		billingAddressField = new JTextField(customer.getBillingAddress());
		add(billingAddressLabel);
		add(billingAddressField);

		JLabel cardNumberLabel = new JLabel("Card Number");
		cardNumberField = new JTextField(customer.getCardNumber());
		add(cardNumberLabel);
		add(cardNumberField);

		JLabel cardExpiryDateLabel = new JLabel("Card Expiry Date");
		cardExpiryDateField = new JTextField(customer.getCardExpiryDate());
		add(cardExpiryDateLabel);
		add(cardExpiryDateField);

		JLabel notesLabel = new JLabel("Notes");
		notesField = new JTextArea(customer.getNotes());
		add(notesLabel);
		add(notesField);

		JLabel genderLabel = new JLabel("Gender");
		genderField = new JTextField(customer.getGender());
		add(genderLabel);
		add(genderField);

		JLabel currentVehicleModelLabel = new JLabel("Current Vehicle Model");
		currentVehicleModelField = new JTextField(customer.getCurrentVehicle().getModel());
		add(currentVehicleModelLabel);
		add(currentVehicleModelField);

		JLabel currentVehicleExteriorLabel = new JLabel("Current Vehicle Exterior");
		currentVehicleExteriorField = new JTextField(customer.getCurrentVehicle().getExteriorColour());
		add(currentVehicleExteriorLabel);
		add(currentVehicleExteriorField);

		JLabel currentVehicleInteriorLabel = new JLabel("Current Vehicle Interior");
		currentVehicleInteriorField = new JTextField(customer.getCurrentVehicle().getInteriorColour());
		add(currentVehicleInteriorLabel);
		add(currentVehicleInteriorField);

		JLabel vehiclesInterestedInLabel = new JLabel("Vehicles Interested In");
		Vehicle[] vehiclesInterestedInArray = new Vehicle[customer.getVehiclesInterestedIn().size()];
		vehiclesInterestedIn = new ArrayList<Vehicle>();
		for(int i = 0; i < customer.getVehiclesInterestedIn().size(); ++i) {
			vehiclesInterestedInArray[i] = customer.getVehiclesInterestedIn().get(i);
			vehiclesInterestedIn.add(customer.getVehiclesInterestedIn().get(i));
		}
		vehiclesInterestedInList = new JList<Vehicle>(vehiclesInterestedInArray);
		add(vehiclesInterestedInLabel);
		add(vehiclesInterestedInList);

		removeVehicleInterestedInButton = new JButton("Remove Selected Vehicle Interested In");
		removeVehicleInterestedInButton.addActionListener(new RemoveVehicleInterestedInListener());
		add(removeVehicleInterestedInButton);

		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);

		setVisible(true);
	}

	public void addSubmitNewInformationListener(ActionListener actionListener) {
		submitNewInformationButton.addActionListener(actionListener);
	}

	public void addReturnToCustomerMenuFromEditListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

	private class RemoveVehicleInterestedInListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			vehiclesInterestedIn.remove(vehiclesInterestedInList.getSelectedValue());
			vehiclesInterestedInList.remove(vehiclesInterestedInList.getSelectedIndex());
		}
		
	}

	public JTextField getGenderField() {
		return genderField;
	}
	public JTextField getEmailField() {
		return emailField;
	}
	public JTextField getPhoneField() {
		return phoneNumberField;
	}
	public JTextField getBillingAddressField() {
		return billingAddressField;
	}
	public JTextField getCardNumberField() {
		return cardNumberField;
	}
	public JTextField getCardExpiryDateField() {
		return cardExpiryDateField;
	}
	public JTextArea getNotesField() {
		return notesField;
	}
	public JTextField getCurrentVehicleModelField() {
		return currentVehicleModelField;
	}
	public JTextField getCurrentVehicleExteriorField() {
		return currentVehicleExteriorField;
	}
	public JTextField getCurrentVehicleInteriorField() {
		return currentVehicleInteriorField;
	}
	public JList<Vehicle> getVehiclesInterestedInList() {
		return vehiclesInterestedInList;
	}
	public ArrayList<Vehicle> getVehiclesInterestedIn() {
		return vehiclesInterestedIn;
	}

	
}
