package view;

import javax.swing.JFrame;

import model.Customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditCustomerGUI extends JFrame {

	private JTextField emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField, genderField;
	private JTextArea notesField;
	private JButton submitNewInformationButton;

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
		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		setVisible(true);
	}

	public void addSubmitNewInformationListener(ActionListener actionListener) {
		submitNewInformationButton.addActionListener(actionListener);
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

	public static void main(String[] args) {
		new EditCustomerGUI();
	}

	
}
