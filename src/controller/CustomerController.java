package controller;

import view.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import miscellaneous.*;
import model.*;

public class CustomerController {
	private MainController main;
	private CustomerMenuGUI customerChoicesMenu;
	private AddCustomerGUI addCustomerMenu;
	private EditCustomerGUI editCustomerMenu;
	private ViewCustomerGUI viewCustomerMenu;
	
	private GUIPane mainGUI;

	public CustomerController(MainController main, GUIPane mainGUI) {
		
		this.mainGUI = mainGUI;
		
		this.main = main;

		addCustomerMenu = new AddCustomerGUI();
		
		setCustomerChoicesMenu(new CustomerMenuGUI());
		getCustomerChoicesMenu().addViewCustomerListener(new ViewCustomerListener());
		getCustomerChoicesMenu().addEditCustomerListener(new EditCustomerListener());
		getCustomerChoicesMenu().addAddCustomerListener(new AddCustomerListener());
		getCustomerChoicesMenu().addReturnToMainMenuListener(new ReturnToMainMenuListener());
		
	}

	public CustomerMenuGUI getCustomerChoicesMenu() {
		return customerChoicesMenu;
	}

	public void setCustomerChoicesMenu(CustomerMenuGUI customerChoicesMenu) {
		this.customerChoicesMenu = customerChoicesMenu;
	}

	private class ViewCustomerListener implements ActionListener {
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
			main.setCustomer(customer);

			int accessLevel = 3;
			if(main.getSalesperson().isStoreManager()) {
				accessLevel = 1;
			} else if (main.getSalesperson().isDesignated(customer)) {
				accessLevel = 2;
			} 

			
			viewCustomerMenu = new ViewCustomerGUI(main.getCustomer(), accessLevel);
			viewCustomerMenu.addReturnToCustomerMenuFromViewListener(new ReturnToCustomerMenuFromViewListener());
			
			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			viewCustomerMenu.paintComponents(mainGUI.getGraphics());
			mainGUI.getContentPane().add(viewCustomerMenu);
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}
	}
	private class ReturnToCustomerMenuFromViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}

	}

	private class EditCustomerListener implements ActionListener {
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

			main.setCustomer(customer);

			int accessLevel = 0;
			if(main.getSalesperson().isStoreManager()) {
				accessLevel = 1;
			} else if (main.getSalesperson().isDesignated(customer)) {
				accessLevel = 2;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}

			editCustomerMenu = new EditCustomerGUI(main.getCustomer(), accessLevel, main);
			editCustomerMenu.addSubmitNewInformationListener(new SubmitNewInformationListener());
			editCustomerMenu.addReturnToCustomerMenuFromEditListener(new ReturnToCustomerMenuFromEditListener());
			
			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			editCustomerMenu.paintComponents(mainGUI.getGraphics());
			mainGUI.getContentPane().add(editCustomerMenu);
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}
	}
	private class SubmitNewInformationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (
				editCustomerMenu.getEmailField().isBlank() &&
				editCustomerMenu.getPhoneNumberField().isBlank() && 
				editCustomerMenu.getBillingAddressField().isBlank() &&
				editCustomerMenu.getCardNumberField().isBlank() &&
				editCustomerMenu.getCardExpiryDateField().isBlank() &&
				editCustomerMenu.getGenderField().isBlank() && 
				editCustomerMenu.getGenderField().length() != 1
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {
				Customer customer = main.getCustomer();

				if(!editCustomerMenu.getEmailField().isBlank())
					customer.setEmail(editCustomerMenu.getEmailField());
				
				if(!editCustomerMenu.getPhoneNumberField().isBlank())
					customer.setPhoneNumber(editCustomerMenu.getPhoneNumberField());
				
				if(!editCustomerMenu.getBillingAddressField().isBlank())
					customer.setBillingAddress(editCustomerMenu.getBillingAddressField());
				
				if(!editCustomerMenu.getCardNumberField().isBlank())
				customer.setCardNumber(editCustomerMenu.getCardNumberField());
				
				if(!editCustomerMenu.getCardExpiryDateField().isBlank())
					customer.setCardExpiryDate(editCustomerMenu.getCardExpiryDateField());
				
				if(editCustomerMenu.getGenderField().compareTo("U") != 0)
					customer.setGender(editCustomerMenu.getGenderField().toCharArray()[0]);
				
				if(!editCustomerMenu.getNotesField().isBlank()) {
					customer.setNotes("\n\n" +editCustomerMenu.getNotesField());
				}

				DatabaseController.saveCustomer(main.getCustomer());
			}
			
			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}

	}
	private class ReturnToCustomerMenuFromEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}

	}

	private class AddCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!main.getSalesperson().isStoreManager()) {
				JOptionPane.showMessageDialog(null, "Invalid Access Level", "", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			addCustomerMenu = new AddCustomerGUI();
			addCustomerMenu.getSubmitNewCustomerButton().addActionListener(new SubmitNewCustomerListener());
			addCustomerMenu.getReturnToCustomerMenuButton().addActionListener(new ReturnToCustomerMenuFromAddListener());

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			addCustomerMenu.paintComponents(mainGUI.getGraphics());
			mainGUI.getContentPane().add(addCustomerMenu);
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}
	}
	private class SubmitNewCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(
				addCustomerMenu.getAgeField().isBlank() ||
				addCustomerMenu.getNameField().isBlank() ||
				addCustomerMenu.getEmailField().isBlank() ||
				addCustomerMenu.getPhoneNumberField().isBlank() ||
				addCustomerMenu.getBillingAddressField().isBlank() ||
				addCustomerMenu.getCardNumberField().isBlank() ||
				addCustomerMenu.getCardExpiryDateField().isBlank() ||
				addCustomerMenu.getCurrentVehicleBrandField().isBlank() ||
				addCustomerMenu.getCurrentVehicleModelField().isBlank() ||
				addCustomerMenu.getCurrentVehicleYearField().isBlank() ||
				addCustomerMenu.getCurrentVehiclePriceField().isBlank() ||
				addCustomerMenu.getCurrentVehicleExteriorField().isBlank() ||
				addCustomerMenu.getCurrentVehicleInteriorField().isBlank()
			) {
				JOptionPane.showMessageDialog(null, "Improper format for input(s)", "", JOptionPane.ERROR_MESSAGE);
			} else {

				CarModel carModel = new CarModel(addCustomerMenu.getCurrentVehicleBrandField(), addCustomerMenu.getCurrentVehicleModelField(), 
				Integer.parseInt(addCustomerMenu.getCurrentVehicleYearField()), Double.parseDouble(addCustomerMenu.getCurrentVehiclePriceField()));
				Vehicle vehicle = new Vehicle(carModel, ExteriorColour.BLACK, InteriorColour.BLACK);

				ArrayList<LocalDate> visitHistory = new ArrayList<LocalDate>();
				visitHistory.add(LocalDate.now());

				Salesperson salesperson = DatabaseController.getSalesperson(addCustomerMenu.getDesignatedSalespersonChoice());

				Customer customer = new Customer(DatabaseController.getUniqueId(), Integer.parseInt(addCustomerMenu.getAgeField()), 
				addCustomerMenu.getCardNumberField(), addCustomerMenu.getNameField(), 
				addCustomerMenu.getEmailField(), addCustomerMenu.getPhoneNumberField(), 
				addCustomerMenu.getBillingAddressField(), addCustomerMenu.getCardExpiryDateField(), 
				"", addCustomerMenu.getGenderChoice().toCharArray()[0], 
				visitHistory, 
				vehicle, 
				null, 
				salesperson);

				DatabaseController.addCustomer(customer);
			}
			
			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}
	}
	
	private class ReturnToCustomerMenuFromAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getCustomerController().getCustomerChoicesMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
		}

	}

    private class ReturnToMainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        	mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getMainController().getMainMenu().paintComponents(mainGUI.getGraphics());
			mainGUI.getContentPane().add(mainGUI.getMainController().getMainMenu());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.update(mainGUI.getGraphics());
			
        }
    }


}