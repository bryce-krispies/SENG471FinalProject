package controller;

import view.GUIPane;
import view.LoginGUI;
import java.awt.event.*;

import javax.swing.JOptionPane;

import model.Salesperson;

public class LoginController {
	
	private LoginGUI loginMenu;
	private GUIPane mainGUI;

	public LoginController(GUIPane mainGUI) {
		
		this.mainGUI = mainGUI;
		loginMenu = new LoginGUI();
		loginMenu.addLoginListener(new LoginListener());
		loginMenu.addCancelListener(new CancelListener());
	}
	
	public LoginGUI getLoginGUI() {
		
		return loginMenu;
		
	}
	
	public void setLoginGUI(LoginGUI loginMenu) {
		
		this.loginMenu = loginMenu;
		
	}

	private class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(loginMenu.getIDField().getText().isBlank() || loginMenu.getPasswordField().getPassword().length < 1) {
				JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String empId = loginMenu.getIDField().getText();
			String password = new String(loginMenu.getPasswordField().getPassword());

			Salesperson salesperson = null;
			if(DatabaseController.validateSalesperson(empId, password)) {
				salesperson = DatabaseController.getSalesperson(empId);
			}

			if (salesperson == null) {
				JOptionPane.showMessageDialog(null, "Wrong id or password", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			loginMenu.clearFields();

			mainGUI.getMainController().setSalesperson(salesperson);
			
			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getMainController().getMainMenu().paintComponents(mainGUI.getGraphics());
			mainGUI.getContentPane().add(mainGUI.getMainController().getMainMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}
	}

	private class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getStartMenuController().getStartMenuGUI());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
			loginMenu.clearFields();
			
		}
		
		
		
	}

}
