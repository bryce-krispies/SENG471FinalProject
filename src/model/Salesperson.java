package model;

public class Salesperson {

	private int id;
	private String name;
	private String password;
	private String type;

	public Salesperson() {
		id = -1;
		name = null;
		password = null;
		type = null;
	}

	public Salesperson(int id, String name, String password, String type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public void setSalesperson(Salesperson salesperson) {
		name = salesperson.name;
		id = salesperson.id;
		password = salesperson.password;
		type = salesperson.type;
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
