package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Madison I only provided the saveCarModelButton so you know how everything ties together,
 * but in terms of the actual customize car look and feel, go crazyyyyyyyyyyyyyyyyyyyyy
 * 
 * Additionally, I have no idea how the pictures for the models will work, so talk with Jayden bout that one
 * The vehicle class will probably have to be changed for the pics
 * 
 * Also you determine the overall look, and I'll model the rest of the guis after yours
 * Just make sure they follow what the TAs said about the gui
 */
public class CustomizeCarGUI extends JFrame {
	private JButton saveCarModelButton, returnToMainMenuButton;

	public CustomizeCarGUI() {
		setSize(1200, 800); //I think this is a good size but change it if ya want
	}

	public void addSaveCarModelListener(ActionListener actionListener) {
		saveCarModelButton.addActionListener(actionListener);
	}

	public void addReturnToMainMenuListener(ActionListener actionListener) {
		returnToMainMenuButton.addActionListener(actionListener);
	}

}
