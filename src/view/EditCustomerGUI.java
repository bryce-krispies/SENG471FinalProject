package view;

import javax.swing.JFrame;

import model.Customer;
import model.Vehicle;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

public class EditCustomerGUI extends JFrame {

	private JTextField emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField, genderField;
	private JTextArea notesField;
	private JButton submitNewInformationButton, addNewVisitButton, returnToCustomerMenuButton;
	private boolean newVisitButtonPressed;

	public EditCustomerGUI(Customer customer, int accessLevel) {
		super("Edit Customer");
		setUndecorated(true);

		if(accessLevel == 1) {
			renderHighAccess(customer);
		} else {
			renderMediumAccess(customer);
		}

		setVisible(true);
	}

	public void renderHighAccess(Customer customer) {

		setSize(1000, 1000);
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

		JLabel genderLabel = new JLabel("Gender");
		genderField = new JTextField(customer.getGender());
		add(genderLabel);
		add(genderField);

		JLabel notesLabel = new JLabel("Notes\n" +customer.getNotes());
		notesField = new JTextArea();
		add(notesLabel);
		add(notesField);

		addNewVisitButton = new JButton("Add New Visit");
		addNewVisitButton.addActionListener(new AddNewVisitListener());
		add(addNewVisitButton);

		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void renderMediumAccess(Customer customer) {

		setSize(750, 750);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		JLabel notesLabel = new JLabel("Notes\n" +customer.getNotes());
		notesField = new JTextArea();
		add(notesLabel);
		add(notesField);

		addNewVisitButton = new JButton("Add New Visit");
		addNewVisitButton.addActionListener(new AddNewVisitListener());
		add(addNewVisitButton);

		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void addSubmitNewInformationListener(ActionListener actionListener) {
		submitNewInformationButton.addActionListener(actionListener);
	}

	public void addReturnToCustomerMenuFromEditListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

	private class AddNewVisitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(newVisitButtonPressed) {
				JOptionPane.showMessageDialog(null, "New Visit Already Recorded", "", JOptionPane.ERROR_MESSAGE);
			} else {
				newVisitButtonPressed = true;
				JOptionPane.showMessageDialog(null, "New Visit Recorded", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

	public String getEmailField() { return emailField.getText().trim(); }
	public String getPhoneNumberField() { return phoneNumberField.getText().trim(); }
	public String getBillingAddressField() { return billingAddressField.getText().trim(); }
	public String getCardNumberField() { return cardNumberField.getText().trim(); }
	public String getCardExpiryDateField() { return cardExpiryDateField.getText().trim(); }
	public String getGenderField() { return genderField.getText().trim(); }
	public String getNotesField() { return notesField.getText().trim(); }
	public boolean getNewVisitButtonPressed() { return newVisitButtonPressed; }
	
}
