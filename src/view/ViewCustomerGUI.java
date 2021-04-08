package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ViewCustomerGUI extends JFrame {
	
	private JLabel passwordLabel, emailLabel, phoneLabel, billingAddressLabel, cardNumberLabel, cardExpiryDateLabel, notesLabel;

	public ViewCustomerGUI(int width, int height, Customer customer) {
		super("Login");
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1));

		add(passwordLabel);
		add(emailLabel);
		add(phoneLabel);
		add(billingAddressLabel);
		add(cardNumberLabel);
		add(cardExpiryDateLabel);
		add(notesLabel);
	}



	public static void main(String [] args) {
    	new ViewCustomerGUI(500, 500);
    }

}
