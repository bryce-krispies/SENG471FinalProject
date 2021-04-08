package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCustomerGUI extends JFrame {
	private JTextField ageField, cardNumberField,
		nameField, emailField, phoneNumberField, billingAddressField, cardExpiryDateField,
		genderField, currentVehicleModelField, currentVehicleExteriorField, currentVehicleInteriorField,
		designatedSalespersonField;
	private JButton submitNewCustomerButton;

	public AddCustomerGUI() {
		super("Login");
		setUndecorated(true);
		setSize(500, 500);
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

		JLabel currentVehicleModelLabel = new JLabel("Current Vehicle Model");
		currentVehicleModelField = new JTextField();
		add(currentVehicleModelLabel);
		add(currentVehicleModelField);

		JLabel currentVehicleExteriorLabel = new JLabel("Current Vehicle Exterior");
		currentVehicleExteriorField = new JTextField();
		add(currentVehicleExteriorLabel);
		add(currentVehicleExteriorField);

		JLabel currentVehicleInteriorLabel = new JLabel("Current Vehicle Interior");
		currentVehicleInteriorField = new JTextField();
		add(currentVehicleInteriorLabel);
		add(currentVehicleInteriorField);

		JLabel designatedSalespersonLabel = new JLabel("Designated Salesperson");
		designatedSalespersonField = new JTextField();
		add(designatedSalespersonLabel);
		add(designatedSalespersonField);

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
		genderField = new JTextField();
		add(genderLabel);
		add(genderField);
		submitNewCustomerButton = new JButton("Submit");
		add(submitNewCustomerButton);

		setVisible(true);
	}

	public void addSubmitNewCustomerListener(ActionListener actionListener) {
		submitNewCustomerButton.addActionListener(actionListener);
	}

	public JTextField getAgeField() {
		return ageField;
	}
	public JTextField getCardNumberField() {
		return cardNumberField;
	}
	public JTextField getNameField() {
		return nameField;
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
	public JTextField getCardExpiryDateField() {
		return cardExpiryDateField;
	}
	public JTextField getGenderField() {
		return genderField;
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
	public JTextField getDesignatedSalespersonField() {
		return designatedSalespersonField;
	}

	public static void main(String[] args) {
		new AddCustomerGUI();
	}

}
