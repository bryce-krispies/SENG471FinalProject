package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuGUI extends JFrame {
	
	private JButton chooseCustomizeCarGUIButton;
	private JButton chooseCustomerMenuGUIButton;
	
	boolean loggedIn;
	public MainMenuGUI(int width, int height) {
		super("Ticket Registration Application");
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 2));

		chooseCustomizeCarGUIButton = new JButton("Customize Car");
		chooseCustomerMenuGUIButton = new JButton("Edit/View Customer");

		add(chooseCustomizeCarGUIButton);
		add(chooseCustomerMenuGUIButton);
	}

	public void showWindow() {
		setVisible(true);
	}

	public void hideWindow() {
		setVisible(false);
	}
	
	public void addCustomizeCarGUIButtonListener(ActionListener loginListener) {
		chooseCustomizeCarGUIButton.addActionListener(loginListener);
	}

	public void addCustomerMenuGUIButtonListener(ActionListener loginListener) {
		chooseCustomerMenuGUIButton.addActionListener(loginListener);
	}

}
