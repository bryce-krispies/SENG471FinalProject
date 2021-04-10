package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.DatabaseController;

public class AddCustomerGUI extends JFrame {

	// visitHistory, notes, desired vehicle (null)


	private JTextField ageField,
		nameField, emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField,
		currentVehicleBrandField, currentVehicleModelField, currentVehicleYearField, currentVehiclePriceField,
		currentVehicleExteriorField, currentVehicleInteriorField;
	private JComboBox<String> genderFieldComboBox, designatedSalespersonComboBox;
	private JButton submitNewCustomerButton, returnToCustomerMenuButton;

	public AddCustomerGUI() {
		super("Login");
		setUndecorated(true);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		JLabel ageLabel = new JLabel("Age");
		ageField = new JTextField();
		add(ageLabel);
		add(ageField);

		JLabel nameLabel = new JLabel("Name");
		nameField = new JTextField();
		add(nameLabel);
		add(nameField);

		JLabel emailLabel = new JLabel("Email");
		emailField = new JTextField();
		add(emailLabel);
		add(emailField);

		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberField = new JTextField();
		add(phoneNumberLabel);
		add(phoneNumberField);

		JLabel billingAddressLabel = new JLabel("Billing Address");
		billingAddressField = new JTextField();
		add(billingAddressLabel);
		add(billingAddressField);

		JLabel cardNumberLabel = new JLabel("Card Number");
		cardNumberField = new JTextField();
		add(cardNumberLabel);
		add(cardNumberField);

		JLabel cardExpiryDateLabel = new JLabel("Card Expiry Date");
		cardExpiryDateField = new JTextField();
		add(cardExpiryDateLabel);
		add(cardExpiryDateField);

		JLabel genderLabel = new JLabel("Gender");
		String[] genderChoices = {"M", "F", "-"};
		genderFieldComboBox = new JComboBox<String>(genderChoices);
		genderFieldComboBox.setSelectedIndex(2);
		add(genderLabel);
		add(genderFieldComboBox);

		JLabel currentVehicleBrandLabel = new JLabel("Current Vehicle Brand");
		currentVehicleBrandField = new JTextField();
		add(currentVehicleBrandLabel);
		add(currentVehicleBrandField);

		JLabel currentVehicleModelLabel = new JLabel("Current Vehicle Model");
		currentVehicleModelField = new JTextField();
		add(currentVehicleModelLabel);
		add(currentVehicleModelField);

		JLabel currentVehicleYearLabel = new JLabel("Current Vehicle Year");
		currentVehicleYearField = new JTextField();
		add(currentVehicleYearLabel);
		add(currentVehicleYearField);

		JLabel currentVehiclePriceLabel = new JLabel("Current Vehicle Price");
		currentVehiclePriceField = new JTextField();
		add(currentVehiclePriceLabel);
		add(currentVehiclePriceField);

		JLabel currentVehicleExteriorLabel = new JLabel("Current Vehicle Exterior Colour");
		currentVehicleExteriorField = new JTextField();
		add(currentVehicleExteriorLabel);
		add(currentVehicleExteriorField);

		JLabel currentVehicleInteriorLabel = new JLabel("Current Vehicle Interior Colour");
		currentVehicleInteriorField = new JTextField();
		add(currentVehicleInteriorLabel);
		add(currentVehicleInteriorField);

		JLabel designatedSalespersonLabel = new JLabel("Designated Salesperson");
		designatedSalespersonComboBox = new JComboBox<String>(DatabaseController.getSalespersons());
		designatedSalespersonComboBox.setSelectedIndex(0);
		add(designatedSalespersonLabel);
		add(designatedSalespersonComboBox);

		submitNewCustomerButton = new JButton("Submit");
		add(submitNewCustomerButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);

		setVisible(true);
	}

	public void addSubmitNewCustomerListener(ActionListener actionListener) {
		submitNewCustomerButton.addActionListener(actionListener);
	}

	public void addReturnToCustomerMenuButtonFromAddListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

	public String getAgeField() { return ageField.getText().trim(); }
	public String getNameField() { return nameField.getText().trim(); }
	public String getEmailField() { return emailField.getText().trim(); }
	public String getPhoneNumberField() { return phoneNumberField.getText().trim(); }
	public String getBillingAddressField() { return billingAddressField.getText().trim(); }
	public String getCardExpiryDateField() { return cardExpiryDateField.getText().trim(); }
	public String getCardNumberField() { return cardNumberField.getText().trim(); }
	public String getCurrentVehicleBrandField() { return currentVehicleBrandField.getText().trim(); }
	public String getCurrentVehicleModelField() { return currentVehicleModelField.getText().trim(); }  
	public String getCurrentVehicleYearField() { return currentVehicleYearField.getText().trim(); }
	public String getCurrentVehiclePriceField() { return currentVehiclePriceField.getText().trim(); }
	public String getCurrentVehicleExteriorField() { return currentVehicleExteriorField.getText().trim(); }
	public String getCurrentVehicleInteriorField() { return currentVehicleInteriorField.getText().trim(); }
	public String getGenderChoice() { return genderFieldComboBox.getSelectedItem().toString().trim(); } 
	public String getDesignatedSalespersonChoice() { return designatedSalespersonComboBox.getSelectedItem().toString().trim(); }

}
