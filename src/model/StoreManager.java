package model;

class StoreManager extends Salesperson {
	
	private String department;

	public StoreManager(String name, int salesersonId, String department) {
		super(name, salesersonId);
		this.department = department;
	}
}