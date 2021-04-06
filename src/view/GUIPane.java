package view;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class GUIPane extends JFrame{

	private MenuPanel mainMenu;
	
	public GUIPane() {
		
		super("CADA Modeling Software");
		
		mainMenu = new MenuPanel();
		this.add(mainMenu);
		
		setSize(900,576);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
		
		mainMenu.paintComponent(getGraphics());
		
	}
	
	private class MenuPanel extends JPanel{
		
		private Image image;
		private JTextField title;
		private JButton employeeLogin;
		private JButton quit;
		
		public MenuPanel() {
			
			try {
				image = ImageIO.read(new File("resources\\background.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			title = new JTextField("Welcome to the CADA Car Customization System");
			title.setHorizontalAlignment(JTextField.CENTER);
			title.setBorder(BorderFactory.createBevelBorder(1, new Color(96,77,70), new Color(196,177,170)));
			title.setDisabledTextColor(new Color(96,77,70));
			title.setSize(46, 1);
			title.setEnabled(false);
			title.setFont(new Font("Serif", Font.BOLD, 35));
			
			this.add(title);
			
			JTextArea filler = new JTextArea("                                   ");
			filler.setSize(new Dimension(46, 5));
			filler.setFont(new Font("Serif", Font.BOLD, 100));
			filler.setEnabled(false);
			filler.setOpaque(false);
			this.add(filler);
			
			employeeLogin = new JButton("Employee Login");
			employeeLogin.setBackground(new Color(213, 183, 147));
			employeeLogin.setFont(new Font("Serif", Font.BOLD, 20));
			this.add(employeeLogin);
			
			JTextArea fillerTwo = new JTextArea("                        "
					+ "                                                  "
					+ "                                                  ");
			fillerTwo.setSize(new Dimension(46, 5));
			fillerTwo.setFont(new Font("Serif", Font.BOLD, 30));
			fillerTwo.setEnabled(false);
			fillerTwo.setOpaque(false);
			this.add(fillerTwo);
			
			quit = new JButton("Quit");
			quit.setBackground(new Color(213, 183, 147));
			quit.setFont(new Font("Serif", Font.BOLD, 20));
			this.add(quit);
			
		}
		
		public void paintComponent(Graphics g) {
			
			g.drawImage(image, 0, 0, null);
			
		}
		
	}
	
}
