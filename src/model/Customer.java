package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
	
	private int customerId, age;
	private String name, email, phoneNumber, billingAddress, cardNumber, cardExpiryDate, notes;
	private char gender;
	private ArrayList<LocalDate> visitHistory;
	private Vehicle currentVehicle;
	private ArrayList<Vehicle> vehiclesInterestedIn;
	private Salesperson designatedSalesperson;


	public Customer(int customerId, int age, String cardNumber, String name, String email, String phoneNumber, String billingAddress, String cardExpiryDate, 
						String notes, char gender, ArrayList<LocalDate> visitHistory, Vehicle currentVehicle, ArrayList<Vehicle> vehiclesInterestedIn,
						Salesperson designatedSalesperson) {
		this.customerId = customerId;
		this.age = age;
		this.cardNumber = cardNumber;
		this.name = name;
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

	public boolean checkIfSalespersonIsDesignated(Salesperson salesperson) {
		if(designatedSalesperson.getId() == salesperson.getId()) {
			return true;
		}

		return false;
	}


	public void setCustomer(int customerId, int age, String cardNumber, String name, String email, String phoneNumber, String billingAddress, String cardExpiryDate, 
						String notes, char gender, ArrayList<LocalDate> visitHistory, Vehicle currentVehicle, ArrayList<Vehicle> vehiclesInterestedIn,
						Salesperson designatedSalesperson) {
		this.customerId = customerId;
		this.age = age;
		this.cardNumber = cardNumber;
		this.name = name;
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
	public void setId(int customerId) {
		this.customerId = customerId;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	public ArrayList<LocalDate> getVisitHistory() {
		return visitHistory;
	}
	public void addVisitToVisitHistory(LocalDate visit) {
		visitHistory.add(visit);
	}

	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}
	public void setCurrentVehicle(Vehicle currentVehicle) {
		this.currentVehicle = currentVehicle;
	}

	public ArrayList<Vehicle> getVehiclesInterestedIn() {
		return vehiclesInterestedIn;
	}
	public void addNewVehicleInterestedIn(Vehicle newVehicleInterestedIn) {
		vehiclesInterestedIn.add(newVehicleInterestedIn);
	}

	public Salesperson getDesignatedSalesperson() {
		return designatedSalesperson;
	}
	public void setDesignatedSalesperson(Salesperson designatedSalesperson) {
		this.designatedSalesperson = designatedSalesperson;
	}

	@Override
	public String toString() {
    
		//----------------------------PLEASE NOTE THIS SHOULD BE IMPLEMENTED-------------------------------
		return null;
		
	}

}
