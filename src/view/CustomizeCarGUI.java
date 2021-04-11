package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

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
	public JList modelsList, exteriorColoursList, interiorColoursList, viewList;

	public CustomizeCarGUI() {
		super("Customize Car");
		setUndecorated(true);
		setSize(750, 500); //I think this is a good size but change it if ya want
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 2));

		modelsList = new JList(new String[]{"MKZ", "Mustang"});
		add(modelsList);

		exteriorColoursList = new JList(new String[]{"White", "Black", "Blue", "Red", "Grey"});
		add(exteriorColoursList);
		exteriorColoursList.setVisible(false);

		interiorColoursList = new JList(new String[]{"Black", "White", "Tan"});
		add(interiorColoursList);
		interiorColoursList.setVisible(false);

		viewList = new JList(new String[]{"Front", "Back", "Dash", "Interior"});
		add(viewList);
		viewList.setVisible(false);

		saveCarModelButton = new JButton("Save Car Model");
		add(saveCarModelButton);
		returnToMainMenuButton=new JButton("Return To Main Menu");
		add(returnToMainMenuButton);

		setVisible(true);
	}

	public void addSelectCarModelListener(ListSelectionListener listener) {
		modelsList.addListSelectionListener(listener);
	}

	public void addSelectExteriorColourListener(ListSelectionListener listener) {
		exteriorColoursList.addListSelectionListener(listener);
	}

	public void addSelectInteriorColourListener(ListSelectionListener listener) {
		interiorColoursList.addListSelectionListener(listener);
	}

	public void addSelectViewListener(ListSelectionListener listener) {
		viewList.addListSelectionListener(listener);
	}

	public void addSaveCarModelListener(ActionListener actionListener) {
		saveCarModelButton.addActionListener(actionListener);
	}

	public void addReturnToMainMenuListener(ActionListener actionListener) {
		returnToMainMenuButton.addActionListener(actionListener);
	}

	public String getModelSelection() {
		return (String) modelsList.getSelectedValue();
	}

	public String getExteriorColourSelection() {
		return (String) exteriorColoursList.getSelectedValue();
	}

	public String getInteriorColourSelection() {
		return (String) interiorColoursList.getSelectedValue();
	}

	public String getViewSelection() {
		return (String) viewList.getSelectedValue();
	}

	public void displayCarView(File carImage) {
		// Display image on page
	}

}
