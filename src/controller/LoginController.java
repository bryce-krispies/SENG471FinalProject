package controller;

import view.LoginGUI;
import java.awt.event.*;

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
			//perform login event handler stuff here



			//if good
			//  close loginMenu
			//	new MainMenuGUI(main)

			//if bad
			//   display error message
			System.out.println("Don't Worry. I won't hurt you.");
		}
	}


}
