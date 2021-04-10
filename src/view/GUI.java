package view;

import controller.DatabaseController;

// just use this class now for testing purposes
class GUI {

    public static void main(String [] args) {

    	DatabaseController.initializeDatabase();
    	GUIPane program = new GUIPane();
    	
    }
    
    
    
}