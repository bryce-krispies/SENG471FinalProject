package controller;
import model.*;
import view.CustomizeCarGUI;

class VehicleCustomizationController {

    private MainController main;
	private CustomizeCarGUI customizeCarMenu;

    public VehicleCustomizationController(MainController main) {
        this.main = main;

        customizeCarMenu = new CustomizeCarGUI(1200, 800);
    }

}