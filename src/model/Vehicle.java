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
    public String getModel() {
        return model;
    }

    public void setExteriorColour(String exteriorColour) {
        this.exteriorColour = exteriorColour;
    }
    public String getExteriorColour() {
        return exteriorColour;
    }

    public void setInteriorColour(String interiorColour) {
        this.interiorColour = interiorColour;
    }
    public String getInteriorColour() {
        return interiorColour;
    }

    @Override
	public String toString() {
    
		return "Model: " +model +"\n\tExterior Colour: " +exteriorColour +"\n\tInterior Colour: " +interiorColour;
		
	}
}