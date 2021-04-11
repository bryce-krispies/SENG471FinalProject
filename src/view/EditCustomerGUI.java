package view;

import model.Customer;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class EditCustomerGUI extends JPanel {

	private JTextField emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField;
	private JComboBox genderFieldComboBox;
	private JTextArea notesField;
	private JButton submitNewInformationButton, addNewVisitButton, returnToCustomerMenuButton;
	private boolean newVisitButtonPressed;
	private Image image;

	public EditCustomerGUI(Customer customer, int accessLevel) {

		try {
			image = ImageIO.read(new File("resources\\Customer_Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		if(accessLevel == 1) {
			renderHighAccess(customer);
		} else {
			renderMediumAccess(customer);
		}

	}

	public void renderHighAccess(Customer customer) {
		
		JLabel personal = new JLabel("Personal Information: ");
		personal.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(personal);
		makePageBreak();
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		emailField = new JTextField();
		emailField.setColumns(10);
		add(emailLabel);
		add(emailField);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		String[] genderChoices = {"M", "F", "-"};
		genderFieldComboBox = new JComboBox<String>(genderChoices);
		genderFieldComboBox.setSelectedIndex(2);
		add(genderLabel);
		add(genderFieldComboBox);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		add(phoneNumberLabel);
		add(phoneNumberField);

		addFiller(40, "                                                                          ");
		
		JLabel billing = new JLabel("Billing Information: ");
		billing.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(billing);
		makePageBreak();
		
		JLabel billingAddressLabel = new JLabel("Billing Address");
		billingAddressLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		billingAddressField = new JTextField();
		billingAddressField.setColumns(10);
		add(billingAddressLabel);
		add(billingAddressField);

		JLabel cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		cardNumberField = new JTextField();
		cardNumberField.setColumns(10);
		add(cardNumberLabel);
		add(cardNumberField);
		
		JLabel cardExpiryDateLabel = new JLabel("Card Expiry Date");
		cardExpiryDateLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		cardExpiryDateField = new JTextField();
		cardExpiryDateField.setColumns(10);
		add(cardExpiryDateLabel);
		add(cardExpiryDateField);

		JLabel records = new JLabel("Records: ");
		records.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(records);
		makePageBreak();
		
		JLabel notesTitle = new JLabel("Notes: ");
		makePageBreak();
		JLabel notesLabel = new JLabel("" + customer.getNotes());
		notesField = new JTextArea();
		notesField.setColumns(30);
		notesField.setRows(4);
		notesField.setLineWrap(true);
		notesField.setPreferredSize(getSize());
		add(notesTitle);
		add(notesLabel);
		add(notesField);
		
		addNewVisitButton = new JButton("Add New Visit");
		addNewVisitButton.addActionListener(new AddNewVisitListener());
		add(addNewVisitButton);

		makePageBreak();
		
		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
	}

	public void renderMediumAccess(Customer customer) {

		JLabel records = new JLabel("Records: ");
		records.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(records);
		makePageBreak();
		
		JLabel notesTitle = new JLabel("Notes: ");
		makePageBreak();
		JLabel notesLabel = new JLabel("" + customer.getNotes());
		notesField = new JTextArea();
		notesField.setColumns(30);
		notesField.setRows(4);
		notesField.setLineWrap(true);
		notesField.setPreferredSize(getSize());
		add(notesTitle);
		add(notesLabel);
		add(notesField);
		
		addNewVisitButton = new JButton("Add New Visit");
		addNewVisitButton.addActionListener(new AddNewVisitListener());
		add(addNewVisitButton);

		makePageBreak();
		
		submitNewInformationButton = new JButton("Submit");
		add(submitNewInformationButton);

		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		add(returnToCustomerMenuButton);
		
		emailField = new JTextField("");
		phoneNumberField = new JTextField("");
		billingAddressField = new JTextField("");
		cardNumberField = new JTextField("");
		cardExpiryDateField = new JTextField("");
		genderFieldComboBox = new JComboBox<String>(new String [] {"M", "F", "-"});
		genderFieldComboBox.setSelectedIndex(2);
		genderFieldComboBox.setSelectedItem("U");
		
	}

	public void addSubmitNewInformationListener(ActionListener actionListener) {
		submitNewInformationButton.addActionListener(actionListener);
	}

	public void addReturnToCustomerMenuFromEditListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}
	
	public void addFiller(int size, String fill) {
		
		JTextArea filler = new JTextArea(fill);
		filler.setSize(new Dimension(46, 5));
		filler.setFont(new Font("Serif", Font.BOLD, size));
		filler.setEnabled(false);
		filler.setOpaque(false);
		this.add(filler);
		
	}
	
	public void makePageBreak() {
		
		addFiller(3, "                                   "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      ");
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0, null);
		
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
	public String getGenderField() { return genderFieldComboBox.getSelectedItem().toString().trim();}
	public String getNotesField() { return notesField.getText().trim(); }
	public boolean getNewVisitButtonPressed() { return newVisitButtonPressed; }
	
}
