package model;

class StoreManager extends Employee {
	
	private String department;

	public StoreManager(String name, int salesersonId, String department) {
		//super(name, salesersonId);
		this.department = department;
	}
}