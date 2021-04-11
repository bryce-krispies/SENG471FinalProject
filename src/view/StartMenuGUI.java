
package view;

import java.awt.BasicStroke;
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
		private JButton salespersonLogin;
		private JButton quit;
		
		public StartMenuGUI() {
			
			try {
				image = ImageIO.read(new File("resources\\background.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			addFiller(370, "                                            ");
			
			salespersonLogin = new JButton(" Salesperson Login ");
			salespersonLogin.setBackground(new Color(200, 200, 200));
			salespersonLogin.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
			salespersonLogin.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
			this.add(salespersonLogin);
			
			addFiller(30, "                                  "
					+ "                                                     ");

			
			quit = new JButton(" Quit ");
			quit.setBackground(new Color(200, 200, 200));
			quit.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
			quit.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
			this.add(quit);
			
			addFiller(30, "                                      "
					+ "                         "
					+ "                                                ");
			
		}
		
		public void addFiller(int size, String len){
			
			JTextArea filler = new JTextArea(len);
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