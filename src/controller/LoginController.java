package controller;

import view.LoginGUI;
import java.awt.event.*;

import javax.swing.JOptionPane;

import model.Salesperson;

public class LoginController {
	
	private MainController main;
	private LoginGUI loginMenu;

	public LoginController(MainController main) {
		this.main = main;
		loginMenu = new LoginGUI(750, 400);

		loginMenu.addLoginListener(new LoginListener());
	}

	private class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(loginMenu.getIDField().getText().isBlank() || loginMenu.getPasswordField().getPassword().length < 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int empID = Integer.parseInt(loginMenu.getIDField().getText());
			String password = new String(loginMenu.getPasswordField().getPassword());

			Salesperson salesperson = DatabaseController.searchForSalesperson(empID, password);

			// if (Salesperson == null) {
			// 	JOptionPane.showMessageDialog(null, "Wrong id or password", "Error", JOptionPane.ERROR_MESSAGE);
			// 	return;
			// }

			loginMenu.dispose();
			loginMenu = null;
			main.getMainMenu().showWindow();
		}
	}


}
