package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.DatabaseController;

public class AddCustomerGUI extends JPanel {

	// visitHistory, notes, desired vehicle (null)

	private Image image;

	private JTextField ageField,
		nameField, emailField, phoneNumberField, billingAddressField, cardNumberField, cardExpiryDateField,
		currentVehicleBrandField, currentVehicleModelField, currentVehicleYearField, currentVehiclePriceField,
		currentVehicleExteriorField, currentVehicleInteriorField;
	private JComboBox<String> genderFieldComboBox, designatedSalespersonComboBox;
	private JButton submitNewCustomerButton, returnToCustomerMenuButton;

	public AddCustomerGUI() {

		try {
			image = ImageIO.read(new File("resources\\Customer_Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		JLabel personal = new JLabel("Personal Information: ");
		personal.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(personal);
		makePageBreak();
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		ageField = new JTextField();
		ageField.setColumns(10);
		add(ageLabel);
		add(ageField);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		nameField = new JTextField();
		nameField.setColumns(10);
		add(nameLabel);
		add(nameField);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		String[] genderChoices = {"M", "F", "-"};
		genderFieldComboBox = new JComboBox<String>(genderChoices);
		genderFieldComboBox.setSelectedIndex(2);
		add(genderLabel);
		add(genderFieldComboBox);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		emailField = new JTextField();
		emailField.setColumns(10);
		add(emailLabel);
		add(emailField);
		
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
		
		addFiller(40, "                                                                          ");
		
		JLabel vehicle = new JLabel("Current Vehicle Information: ");
		vehicle.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(vehicle);
		makePageBreak();
		
		JLabel currentVehicleBrandLabel = new JLabel("Current Vehicle Brand");
		currentVehicleBrandLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehicleBrandField = new JTextField();
		currentVehicleBrandField.setColumns(10);
		add(currentVehicleBrandLabel);
		add(currentVehicleBrandField);
		
		JLabel currentVehicleModelLabel = new JLabel("Current Vehicle Model");
		currentVehicleModelLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehicleModelField = new JTextField();
		currentVehicleModelField.setColumns(10);
		add(currentVehicleModelLabel);
		add(currentVehicleModelField);
		
		JLabel currentVehicleYearLabel = new JLabel("Current Vehicle Year");
		currentVehicleYearLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehicleYearField = new JTextField();
		currentVehicleYearField.setColumns(10);
		add(currentVehicleYearLabel);
		add(currentVehicleYearField);
		
		makePageBreak();
		
		JLabel currentVehiclePriceLabel = new JLabel("Current Vehicle Price");
		currentVehiclePriceLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehiclePriceField = new JTextField();
		currentVehiclePriceField.setColumns(10);
		add(currentVehiclePriceLabel);
		add(currentVehiclePriceField);
		
		JLabel currentVehicleExteriorLabel = new JLabel("Current Vehicle Exterior Colour");
		currentVehicleExteriorLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehicleExteriorField = new JTextField();
		currentVehicleExteriorField.setColumns(10);
		add(currentVehicleExteriorLabel);
		add(currentVehicleExteriorField);
		
		JLabel currentVehicleInteriorLabel = new JLabel("Current Vehicle Interior Colour");
		currentVehicleInteriorLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		currentVehicleInteriorField = new JTextField();
		currentVehicleInteriorField.setColumns(10);
		add(currentVehicleInteriorLabel);
		add(currentVehicleInteriorField);
		
		addFiller(40, "                                                                          ");
		
		JLabel person = new JLabel("Designated Salesperson: ");
		person.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		add(person);
		makePageBreak();
		
		JLabel designatedSalespersonLabel = new JLabel("Employee ID");
		designatedSalespersonLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		designatedSalespersonComboBox = new JComboBox<String>(DatabaseController.getSalespersons());
		designatedSalespersonComboBox.setSelectedIndex(0);
		add(designatedSalespersonLabel);
		add(designatedSalespersonComboBox);
		
		addFiller(40, "                                           "
				+ "                                                   ");
		
		setSubmitNewCustomerButton(new JButton("Submit"));
		getSubmitNewCustomerButton().setBackground(new Color(163, 175, 175));
		getSubmitNewCustomerButton().setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(getSubmitNewCustomerButton());

		setReturnToCustomerMenuButton(new JButton("Return To Customer Menu"));
		getReturnToCustomerMenuButton().setBackground(new Color(163, 175, 175));
		getReturnToCustomerMenuButton().setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(getReturnToCustomerMenuButton());
		

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

	public void addSubmitNewCustomerListener(ActionListener actionListener) {
		getSubmitNewCustomerButton().addActionListener(actionListener);
	}

	public void addReturnToCustomerMenuButtonFromAddListener(ActionListener actionListener) {
		getReturnToCustomerMenuButton().addActionListener(actionListener);
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

	public JButton getSubmitNewCustomerButton() {
		return submitNewCustomerButton;
	}

	public void setSubmitNewCustomerButton(JButton submitNewCustomerButton) {
		this.submitNewCustomerButton = submitNewCustomerButton;
	}

	public JButton getReturnToCustomerMenuButton() {
		return returnToCustomerMenuButton;
	}

	public void setReturnToCustomerMenuButton(JButton returnToCustomerMenuButton) {
		this.returnToCustomerMenuButton = returnToCustomerMenuButton;
	}

}
