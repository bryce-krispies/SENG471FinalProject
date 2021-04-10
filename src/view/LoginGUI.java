package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class LoginGUI extends JPanel {
	
	private Image image;
	
	GUIPane mainGUI;
	
	private JButton loginButton;
	private JButton cancelButton;
	private JTextField idField;
	private JPasswordField passwordField;
	private JTextArea title;

	public LoginGUI() {
		
		try {
			image = ImageIO.read(new File("resources\\login_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		setup();

	}

	public void setup() {
		
		title = new JTextArea("Login");
		title.setDisabledTextColor(new Color(135,197,218));
		title.setFont(new Font("Serif", Font.BOLD, 80));
		title.setEnabled(false);
		this.add(title);
		
		addFiller(100, "             ");
		addFiller(100, "                                             ");
		addFiller(50, "  ");
		
		JLabel idLabel = new JLabel("Salesperson ID");
		this.add(idLabel);
		idField = new JTextField(40);
		this.add(idField);

		addFiller(50, "                                ");
		addFiller(50, "     ");
		
		JLabel passwordLabel = new JLabel("Password");
		this.add(passwordLabel);
		passwordField = new JPasswordField(40);
		this.add(passwordField);
		
		addFiller(100, "                 ");
		addFiller(100, "      ");
		
		cancelButton = new JButton("Cancel");
		this.add(cancelButton);
		
		loginButton = new JButton("Login");
		this.add(loginButton);
		
		addFiller(100, "                   ");
	}
	
	public void addFiller(int size, String fill) {
		
		JTextArea filler = new JTextArea(fill);
		filler.setSize(new Dimension(46, 5));
		filler.setFont(new Font("Serif", Font.BOLD, size));
		filler.setEnabled(false);
		filler.setOpaque(false);
		this.add(filler);
		
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
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0, null);
		
	}

	public void addCancelListener(ActionListener cancelListener) {

		cancelButton.addActionListener(cancelListener);
		
	}
}