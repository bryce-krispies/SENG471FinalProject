package controller;

import view.*;
import model.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class MainController {

    private Salesperson salesperson;
    private Vehicle vehicle;
    private Customer customer;
	private GUIPane mainGUI;
    
    private MainMenuGUI mainMenu;

	public MainController(GUIPane mainGUI) {
		
		this.mainGUI = mainGUI;
		
		salesperson = null;
		vehicle = null;
        customer = null;

		setMainMenu(new MainMenuGUI(this));
        getMainMenu().addCustomerMenuGUIButtonListener(new ChooseCustomerMenuGUI());
        getMainMenu().addCustomizeCarGUIButtonListener(new ChooseCustomizeCarGUI());
		getMainMenu().addLogoutButtonListener(new ChooseLogout());
	}
	

    private class ChooseCustomerMenuGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());

		}
	}

    private class ChooseCustomizeCarGUI implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String custId = JOptionPane.showInputDialog(null, "Enter Customer ID", "Select Customer", JOptionPane.INFORMATION_MESSAGE);

			if(custId == null) {
				return;
			}

			Customer customer = DatabaseController.getCustomer(custId);

			if(customer == null) {
				JOptionPane.showMessageDialog(null, "Customer Not Found", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			MainController main = getMainMenu().getMainController();

			if(
				(customer.getDesignatedSalesperson().getId() != main.getSalesperson().getId()) &&
				!main.getSalesperson().isStoreManager()
			) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			//mainMenu.dispose();
			//mainMenu = null;

			new VehicleCustomizationController(main);
		}
	}

	private class ChooseLogout implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getStartMenuController().getStartMenuGUI());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.getStartMenuController().getMainGUI().paintComponents(mainGUI.getGraphics());
			mainGUI.update(mainGUI.getGraphics());

			salesperson = null;
			vehicle = null;
			customer = null;

		}
	}

	public Customer getCustomer() { return customer; }
	public void setCustomer(Customer customer) { this.customer = customer; }
	public Salesperson getSalesperson() { return salesperson; }
	public void setSalesperson(Salesperson salesperson) { this.salesperson = salesperson; }
	public Vehicle getVehicle() { return vehicle; }
	public void setVehicle(Vehicle v) { this.vehicle = v; }

	public MainMenuGUI getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenuGUI mainMenu) {
		this.mainMenu = mainMenu;
	}
}