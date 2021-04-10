package view;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerMenuGUI extends JFrame{

	private JButton editCustomerButton, viewCustomerButton, addCustomerButton, returnToMainMenuButton;

	public CustomerMenuGUI() {
		super("Login");
		setUndecorated(true);
		setSize(750, 500);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 3));

		editCustomerButton = new JButton("Edit Customer Information");
		viewCustomerButton = new JButton("View Customer Information");
		addCustomerButton = new JButton("Add New Customer");
		returnToMainMenuButton = new JButton("Return To Main Menu");

		add(editCustomerButton);
		add(viewCustomerButton);
		add(addCustomerButton);
		add(returnToMainMenuButton);

		setVisible(true);
	}

	public void addEditCustomerListener(ActionListener actionListener) {
		editCustomerButton.addActionListener(actionListener);
	}

	public void addViewCustomerListener(ActionListener actionListener) {
		viewCustomerButton.addActionListener(actionListener);
	}

	public void addAddCustomerListener(ActionListener actionListener) {
		addCustomerButton.addActionListener(actionListener);
	}

	public void addReturnToMainMenuListener(ActionListener actionListener) {
		returnToMainMenuButton.addActionListener(actionListener);
	}

}
