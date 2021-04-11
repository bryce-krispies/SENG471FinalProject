package view;

import java.awt.BasicStroke;
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

import controller.*;

public class MainMenuGUI extends JPanel {
	
	private MainController main;
	private JButton chooseCustomizeCarGUIButton, chooseCustomerMenuGUIButton, logoutButton;
	private Image image;
	
	boolean loggedIn;
	public MainMenuGUI(MainController main) {

		this.main = main;

		try {
			image = ImageIO.read(new File("resources\\main_menu.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		chooseCustomizeCarGUIButton = new JButton(" Customize Car ");
		chooseCustomizeCarGUIButton.setBackground(new Color(160, 180, 205));
		chooseCustomizeCarGUIButton.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		chooseCustomizeCarGUIButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
		chooseCustomizeCarGUIButton.setForeground(Color.WHITE);
		
		chooseCustomerMenuGUIButton = new JButton(" Edit/View Customer ");
		chooseCustomerMenuGUIButton.setBackground(new Color(160, 180, 205));
		chooseCustomerMenuGUIButton.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		chooseCustomerMenuGUIButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
		chooseCustomerMenuGUIButton.setForeground(Color.WHITE);
		
		logoutButton = new JButton(" Logout ");
		logoutButton.setBackground(new Color(160, 180, 205));
		logoutButton.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		logoutButton.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
		logoutButton.setForeground(Color.WHITE);
		
		add(chooseCustomizeCarGUIButton);
		addFiller(50, "                                                       ");
		add(chooseCustomerMenuGUIButton);
		addFiller(50, "                                                  ");
		add(logoutButton);
		addFiller(50, "                                                               ");

	}
	
	public void addFiller(int size, String fill) {
		
		JTextArea filler = new JTextArea(fill);
		filler.setSize(new Dimension(46, 5));
		filler.setFont(new Font("Serif", Font.BOLD, size));
		filler.setEnabled(false);
		filler.setOpaque(false);
		this.add(filler);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0, null);
		
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
