package view;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerMenuGUI extends JFrame{

	private JButton editCustomerButton, viewCustomerButton, addCustomerButton;

	public CustomerMenuGUI() {
		super("Login");
		setUndecorated(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 3));

		editCustomerButton = new JButton("Edit Customer Information");
		viewCustomerButton = new JButton("View Customer Information");
		addCustomerButton = new JButton("Add New Customer");

		add(editCustomerButton);
		add(viewCustomerButton);

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

	public static void main(String[] args) {
		new CustomerMenuGUI();
	}

}
