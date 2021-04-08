package model;

public class Employee {

	private int id;
	private String name;
	private String password;
	private String type;

	public Employee() {
		id = -1;
		name = null;
		password = null;
		type = null;
	}

	public Employee(int id, String name, String password, String type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public void setEmployee(Employee employee) {
		name = employee.name;
		id = employee.id;
		password = employee.password;
		type = employee.type;
	}

	public String getName(){
		return name;
	}

	public int getID() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}
}
