package view;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditCustomerGUI extends JFrame {

	private JTextField emailField, phoneField, billingAddressField, cardNumberField, cardExpiryDateField;
	private JTextArea notesField;
	private JButton submitNewInformationButton;

	public EditCustomerGUI(int width, int height) {
		super("Login");
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		JLabel emailLabel = new JLabel("Email");
		emailField = new JTextField();
		add(emailLabel);
		add(emailField);
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneField = new JTextField();
		add(phoneLabel);
		add(phoneField);
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
		JLabel notesLabel = new JLabel("Notes");
		notesField = new JTextArea();
		add(notesLabel);
		add(notesField);
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
		return phoneField;
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
		new EditCustomerGUI(500, 500);
	}

	
}
