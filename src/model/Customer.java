package model;

import java.time.LocalDate;

public class Customer {
	
	private int customerId, age, cardNumber;
	private String name, password, email, phoneNumber, billingAddress, cardExpiryDate, notes;
	private char gender;
	private LocalDate[] visitHistory;
	private Vehicle currentVehicle;
	private Vehicle[] vehiclesInterestedIn;
	private Salesperson designatedSalesperson;

	public Customer(int customerId, int age, int cardNumber, String name, String password, String email, String phoneNumber, String billingAddress, String cardExpiryDate, 
						String notes, char gender, LocalDate[] visitHistory, Vehicle currentVehicle, Vehicle[] vehiclesInterestedIn,
						Salesperson designatedSalesperson) {
		this.customerId = customerId;
		this.age = age;
		this.cardNumber = cardNumber;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.billingAddress = billingAddress;
		this.cardExpiryDate = cardExpiryDate;
		this.notes = notes;
		this.gender = gender;
		this.visitHistory = visitHistory;
		this.currentVehicle = currentVehicle;
		this.vehiclesInterestedIn = vehiclesInterestedIn;
		this.designatedSalesperson = designatedSalesperson;
	}

	public void setCustomer(int customerId, int age, int cardNumber, String name, String password, String email, String phoneNumber, String billingAddress, String cardExpiryDate, 
						String notes, char gender, LocalDate[] visitHistory, Vehicle currentVehicle, Vehicle[] vehiclesInterestedIn,
						Salesperson designatedSalesperson) {
		this.customerId = customerId;
		this.age = age;
		this.cardNumber = cardNumber;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.billingAddress = billingAddress;
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

	public int getId() {
		return customerId;
	}

	public int getAge() {
		return age;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public String getNotes() {
		return notes;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate[] getVisitHistory() {
		return visitHistory;
	}

	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}

	public Vehicle[] getVehiclesInterestedIn() {
		return vehiclesInterestedIn;
	}

	public Salesperson getDesignatedSalesperson() {
		return designatedSalesperson;
	}

	@Override
	public String toString() {
    
		//----------------------------PLEASE NOTE THIS SHOULD BE IMPLEMENTED-------------------------------
		return null;
		
	}

}
