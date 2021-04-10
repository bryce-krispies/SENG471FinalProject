package model;

import miscellaneous.SalespersonType;

public class Salesperson {

	//Important: salespersonId should be 10 digits only

	private String salespersonId, name, password;
	private SalespersonType type;

	public Salesperson() {
		salespersonId = null;
		name = null;
		password = null;
		type = null;
	}

	public Salesperson(String salespersonId, String name, String password, SalespersonType type) {
		this.salespersonId = salespersonId;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public boolean isStoreManager() {
		if(type.equals(SalespersonType.STOREMANAGER)) {
			return true;
		}

		return false;
	}

	public boolean isDesignated(Customer customer) {
		if(customer.getDesignatedSalesperson().getId().equals(salespersonId)) {
			return true;
		}

		return false;
	}

	public void setSalesperson(Salesperson salesperson) {
		name = salesperson.name;
		salespersonId = salesperson.salespersonId;
		password = salesperson.password;
		type = salesperson.type;
	}

	public String getName(){ return name; }
	public String getId() { return salespersonId; }
	public String getPassword() { return password; }
	public SalespersonType getType() { return type; }

	@Override
	public String toString() {
		return "Employee ID: " +salespersonId +"\tName: " +name;
	}
}
