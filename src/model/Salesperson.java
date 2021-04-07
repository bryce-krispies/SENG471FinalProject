package model;

public class Salesperson extends Employee{
	
	
	protected String name;
	protected int salespersonId;

	public Salesperson (String name, int salesersonId) {
		this.name = name;
		this.salespersonId = salesersonId;
	}

	// not sure how to implement this one. u can change the return type to ur desire
	public void getInformation() {
    
	}

	@Override
	public String toString() {
    
		//----------------------------PLEASE NOTE THIS SHOULD BE IMPLEMENTED-------------------------------
		return null;
		
	}

}