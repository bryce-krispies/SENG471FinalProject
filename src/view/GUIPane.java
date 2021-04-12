package view;

import java.awt.*;
import javax.swing.*;

import controller.*;

@SuppressWarnings("serial")
public class GUIPane extends JFrame{
	
	private StartMenuController startMenuController;
	private LoginController loginController;
	private MainController mainController;
	private CustomerController customerController;
	private VehicleCustomizationController vehicleController;
	
	public GUIPane() {
		
		super("CADA Modeling Software");
		
		setStartMenuController(new StartMenuController(this));
		setLoginController(new LoginController(this));
		setMainController(new MainController(this));
		
		customerController = (new CustomerController(mainController, this));
		
		this.add(startMenuController.getStartMenuGUI());

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		setLocation((toolkit.getScreenSize().width-1000)/2, (toolkit.getScreenSize().height-640)/2);
		setUndecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(1000,640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		startMenuController.getMainGUI().paintComponents(getGraphics());
		
	}
	
	

	public StartMenuController getStartMenuController() {
		return startMenuController;
	}



	public void setStartMenuController(StartMenuController startMenuController) {
		this.startMenuController = startMenuController;
	}



	public LoginController getLoginController() {
		return loginController;
	}



	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}



	public MainController getMainController() {
		return mainController;
	}



	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}



	public CustomerController getCustomerController() {
		return customerController;
	}



	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}



	public VehicleCustomizationController getVehicleController() {
		return vehicleController;
	}



	public void setVehicleController(VehicleCustomizationController vehicleController) {
		this.vehicleController = vehicleController;
	}

	
}
