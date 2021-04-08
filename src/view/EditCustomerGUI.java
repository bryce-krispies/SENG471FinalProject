package view;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditCustomerGUI extends JFrame {

	private JTextField passwordField, emailField, phoneField, billingAddressField, cardNumberField, cardExpiryDateField, notesField;

	public EditCustomerGUI(int width, int height) {
		super("Login");
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		add();
		add();
		add();
		add();
	}

	
}
