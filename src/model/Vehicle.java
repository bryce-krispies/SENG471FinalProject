package model;

import miscellaneous.ExteriorColour;
import miscellaneous.InteriorColour;

public class Vehicle {

    private CarModel carModel;
    private ExteriorColour exteriorColour;
    private InteriorColour interiorColour;

    public Vehicle(CarModel carModel, ExteriorColour exteriorColour, InteriorColour interiorColour) {
        this.carModel = carModel;
        this.exteriorColour = exteriorColour;
        this.interiorColour = interiorColour;
    }

    public void setCarModel(CarModel carModel) { this.carModel = carModel; }
    public CarModel getCarModel() { return carModel; }

    public void setExteriorColour(ExteriorColour exteriorColour) { this.exteriorColour = exteriorColour; }
    public ExteriorColour getExteriorColour() { return exteriorColour; }

    public void setInteriorColour(InteriorColour interiorColour) { this.interiorColour = interiorColour; }
    public InteriorColour getInteriorColour() {return interiorColour; }

    @Override
	public String toString() {
		return "Car Model: " +carModel.getYear() +" " +carModel.getBrand() +" "  +carModel.getModel() +" "
            +"\n\tExterior Colour: " +exteriorColour +"\n\tInterior Colour: " +interiorColour;
	}
}