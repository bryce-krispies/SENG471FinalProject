package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class LoginGUI extends JFrame {

	private JPanel leftSide;
	private JPanel rightSide;
	private JButton loginButton;

	private JTextField idField;
	private JPasswordField passwordField;

	public LoginGUI(int width, int height) {
		super("Login");
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 2));

		setupLeftSide(width, height);
		setupRightSide(width, height);

		add(leftSide);
		add(rightSide);

		setVisible(true);
	}

	public void setupLeftSide(int width, int height) {
		leftSide = new JPanel();
		leftSide.setBackground(new Color(134,197,218));
	}

	public void setupRightSide(int width, int height) {
		rightSide = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		rightSide.setBackground(Color.WHITE);

		JLabel idLabel = new JLabel("Employee ID");
		rightSide.add(idLabel);
		idField = new JTextField(40);
		rightSide.add(idField);

		JLabel passwordLabel = new JLabel("Password");
		rightSide.add(passwordLabel);
		passwordField = new JPasswordField(40);
		rightSide.add(passwordField);

		loginButton = new JButton("Login");
		rightSide.add(loginButton);
	}

	public void addLoginListener(ActionListener loginListener) {
		loginButton.addActionListener(loginListener);
	}

	public JTextField getIDField() {
		return idField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}