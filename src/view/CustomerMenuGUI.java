package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CustomerMenuGUI extends JPanel{

	private JButton editCustomerButton, viewCustomerButton, addCustomerButton, returnToMainMenuButton;

	public CustomerMenuGUI() {

		setLayout(new GridLayout(2,4));
		
		editCustomerButton = new JButton("Edit Customer Information");
		editCustomerButton.setBackground(new Color(163, 175, 175));
		editCustomerButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		editCustomerButton.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		editCustomerButton.setForeground(Color.BLACK);
		
		viewCustomerButton = new JButton("View Customer Information");
		viewCustomerButton.setBackground(new Color(160, 180, 205));
		viewCustomerButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		viewCustomerButton.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		viewCustomerButton.setForeground(Color.BLACK);
		
		addCustomerButton = new JButton("Add New Customer");
		addCustomerButton.setBackground(new Color(163, 175, 175));
		addCustomerButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		addCustomerButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		addCustomerButton.setForeground(Color.BLACK);
		
		returnToMainMenuButton = new JButton("Return To Main Menu");
		returnToMainMenuButton.setBackground(new Color(160, 180, 205));
		returnToMainMenuButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		returnToMainMenuButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		returnToMainMenuButton.setForeground(Color.BLACK);
		
		try {
			JLabel edit = new JLabel(new ImageIcon(ImageIO.read(new File("resources\\Edit_Icon.png"))));
			edit.setMaximumSize(new Dimension(250, 160));
			JLabel view = new JLabel(new ImageIcon(ImageIO.read(new File("resources\\View_Icon.png"))));
			view.setMaximumSize(new Dimension(250, 160));
			JLabel add = new JLabel(new ImageIcon(ImageIO.read(new File("resources\\Add_Icon.png"))));
			add.setMaximumSize(new Dimension(250, 160));
			JLabel main = new JLabel(new ImageIcon(ImageIO.read(new File("resources\\Menu_Icon.png"))));
			main.setMaximumSize(new Dimension(250, 160));
			
			add(view);
			add(viewCustomerButton);
			add(edit);
			add(editCustomerButton);
			add(add);
			add(addCustomerButton);
			add(main);
			add(returnToMainMenuButton);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

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
