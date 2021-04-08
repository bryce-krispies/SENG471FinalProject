package model;

import java.time.LocalDate;

public class Customer {
	
	private int customerId, age;
	private String name, password, email, phoneNumber, billingAddress, cardNumber, cardExpiryDate, notes;
	private char gender;
	private LocalDate[] visitHistory;
	private Vehicle currentVehicle;
	private Vehicle[] vehiclesInterestedIn;
	private Employee designatedSalesperson;

	public Customer(int customerId, int age, String name, String password, String email, String phoneNumber, String billingAddress, String cardNumber, 
						String cardExpiryDate, String notes, char gender, LocalDate[] visitHistory, Vehicle currentVehicle, Vehicle[] vehiclesInterestedIn,
						Employee designatedSalesperson) {
		this.customerId = customerId;
		this.age = age;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.billingAddress = billingAddress;
		this.cardNumber = cardNumber;
		this.cardExpiryDate = cardExpiryDate;
		this.notes = notes;
		this.gender = gender;
		this.visitHistory = visitHistory;
		this.currentVehicle = currentVehicle;
		this.vehiclesInterestedIn = vehiclesInterestedIn;
		this.designatedSalesperson = designatedSalesperson;
	}

	public void setCustomer(Customer customer) {
		customerId = customer.customerId;
		age = customer.age;
		name = customer.name;
		password = customer.password;
		email = customer.email;
		phoneNumber = customer.phoneNumber;
		billingAddress = customer.billingAddress;
		cardNumber = customer.cardNumber;
		cardExpiryDate = customer.cardExpiryDate;
		notes = customer.notes;
		gender = customer.gender;
		visitHistory = customer.visitHistory;
		currentVehicle = customer.currentVehicle;
		vehiclesInterestedIn = customer.vehiclesInterestedIn;
		designatedSalesperson = customer.designatedSalesperson;
	}

	@Override
	public String toString() {
    
		//----------------------------PLEASE NOTE THIS SHOULD BE IMPLEMENTED-------------------------------
		return null;
		
	}

}
