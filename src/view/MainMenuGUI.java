package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;

public class MainMenuGUI extends JFrame {
	
	private MainController main;
	private JButton chooseCustomizeCarGUIButton, chooseCustomerMenuGUIButton, logoutButton;
	
	boolean loggedIn;
	public MainMenuGUI(MainController main) {
		super("Ticket Registration Application");
		setUndecorated(true);
		setSize(750, 400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 3));

		this.main = main;

		chooseCustomizeCarGUIButton = new JButton("Customize Car");
		chooseCustomerMenuGUIButton = new JButton("Edit/View Customer");
		logoutButton = new JButton("Logout");

		add(chooseCustomizeCarGUIButton);
		add(chooseCustomerMenuGUIButton);
		add(logoutButton);

		setVisible(true);
	}
	
	public void addCustomizeCarGUIButtonListener(ActionListener actionListener) {
		chooseCustomizeCarGUIButton.addActionListener(actionListener);
	}

	public void addCustomerMenuGUIButtonListener(ActionListener actionListener) {
		chooseCustomerMenuGUIButton.addActionListener(actionListener);
	}

	public void addLogoutButtonListener(ActionListener actionListener) {
		logoutButton.addActionListener(actionListener);
	}

	public MainController getMainController() {
		return main;
	}

}
