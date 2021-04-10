
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartMenuGUI extends JPanel{
		
		private Image image;
		private JTextField title;
		private JButton salespersonLogin;
		private JButton quit;
		
		public StartMenuGUI() {
			
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
			
			JTextArea filler = new JTextArea("                                ");
			filler.setSize(new Dimension(46, 5));
			filler.setFont(new Font("Serif", Font.BOLD, 100));
			filler.setEnabled(false);
			filler.setOpaque(false);
			this.add(filler);
			
			setSalespersonLogin(new JButton("Salesperson Login"));
			getSalespersonLogin().setBackground(new Color(213, 183, 147));
			getSalespersonLogin().setFont(new Font("Serif", Font.BOLD, 20));
			this.add(getSalespersonLogin());
			
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
		
		@Override
		public void paintComponent(Graphics g) {
			
			g.drawImage(image, 0, 0, null);
			
		}
		
		public JButton getQuit() {
			
			return quit;
			
		}

		public JButton getSalespersonLogin() {
			return salespersonLogin;
		}

		public void setSalespersonLogin(JButton salespersonLogin) {
			this.salespersonLogin = salespersonLogin;
		}
		
	}