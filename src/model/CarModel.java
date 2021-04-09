package model;

public class CarModel {
	private String brand, model;
	private int year;
	private double listedPrice;

	public CarModel(String brand, String model, int year, double listedPrice) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.listedPrice = listedPrice;
	}

	public String getBrand() { return brand; }
	public String getModel() { return model; }
	public int getYear() { return year; }
	public double getListedPrice() { return listedPrice; }
	
}
