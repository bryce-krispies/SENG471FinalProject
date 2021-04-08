package controller;

import view.*;
import model.*;
import java.awt.event.*;

class MainController {
    private Salesperson salesperson;
    private Vehicle vehicle;
    private Customer customer;

    private MainMenuGUI mainMenu;

    public MainController() {
        DatabaseController.initializeDatabase();
        salesperson = null;
        vehicle = null;
        customer = null;

        mainMenu = new MainMenuGUI(750, 400);
        mainMenu.addCustomerMenuGUIButtonListener(new ChooseCustomerMenuGUI());
        mainMenu.addCustomizeCarGUIButtonListener(new ChooseCustomizeCarGUI());
    }

    private class ChooseCustomerMenuGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//if good
			//  mainMenu.hideWindow()
			//	new CustomerMenuGUI(main)

			//if bad
			//   display error message
			System.out.println("Don't Worry. I won't hurt you.");
		}
	}

    private class ChooseCustomizeCarGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//if good
			//  mainMenu.hideWindow()
			//	new CustomizeCarGUI(main)

			//if bad
			//   display error message
			System.out.println("Don't Worry. I won't hurt you.");
		}
	}

    public MainMenuGUI getMainMenu() {
        return mainMenu;
    }


    public static void main(String [] args) {
    	MainController main = new MainController();
        new LoginController(main);
    }
}