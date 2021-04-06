package model;

public class Vehicle {
    private String model;
    private String exteriorColour;
    private String interiorColour;

    public Vehicle(String model, String exteriorColour, String interiorColour) {
        this.model = model;
        this.exteriorColour = exteriorColour;
        this.interiorColour = interiorColour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setExteriorColour(String exteriorColour) {
        this.exteriorColour = exteriorColour;
    }

    public void setInteriorColour(String interiorColour) {
        this.interiorColour = interiorColour;
    }
}