package model;

public class Salesperson {

	private int salespersonId;
	private String name;
	private String password;
	private String type;

	public Salesperson() {
		salespersonId = -1;
		name = null;
		password = null;
		type = null;
	}

	public Salesperson(int salespersonId, String name, String password, String type) {
		this.salespersonId = salespersonId;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public void setSalesperson(Salesperson salesperson) {
		name = salesperson.name;
		salespersonId = salesperson.salespersonId;
		password = salesperson.password;
		type = salesperson.type;
	}

	public String getName(){
		return name;
	}

	public int getId() {
		return salespersonId;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Employee ID: " +salespersonId +"\tName: " +name;
	}
}
