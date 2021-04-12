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
@SuppressWarnings("serial")
public class CustomizeCarGUI extends JPanel {
	private JButton saveCarModelButton, returnToMainMenuButton;
	public JList<String> modelsList, exteriorColoursList, interiorColoursList, viewList;
	private JLabel carImage;
	private Image image;

	public CustomizeCarGUI() {

			
		addFiller(330, "");
		
		carImage  = new JLabel();
		carImage.setPreferredSize(new Dimension(600, 279));
		add(carImage);
		
		makePageBreak();
		
		try {
			image = ImageIO.read(new File("resources\\Customization_Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		makePageBreak();
		
		JLabel types = new JLabel("Model          Exterior         Interior           View  ");
		types.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		types.setBackground(Color.DARK_GRAY);
		types.setForeground(Color.LIGHT_GRAY);
		add(types);
		
		makePageBreak();
		
		modelsList = new JList<String>(new String[]{"MKZ", "Mustang"});
		modelsList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		modelsList.setPreferredSize(new Dimension(80,113));
		modelsList.setBackground(Color.DARK_GRAY);
		modelsList.setForeground(Color.LIGHT_GRAY);
		add(modelsList);

		
		exteriorColoursList = new JList<String>();
		exteriorColoursList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		exteriorColoursList.setPreferredSize(new Dimension(80,113));
		exteriorColoursList.setBackground(Color.DARK_GRAY);
		exteriorColoursList.setForeground(Color.LIGHT_GRAY);
		add(exteriorColoursList);
		exteriorColoursList.setVisible(true);

		interiorColoursList = new JList<String>();
		interiorColoursList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		interiorColoursList.setPreferredSize(new Dimension(80,113));
		interiorColoursList.setBackground(Color.DARK_GRAY);
		interiorColoursList.setForeground(Color.LIGHT_GRAY);
		add(interiorColoursList);
		interiorColoursList.setVisible(true);

		
		viewList = new JList<String>();
		viewList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		viewList.setPreferredSize(new Dimension(80,113));
		viewList.setBackground(Color.DARK_GRAY);
		viewList.setForeground(Color.LIGHT_GRAY);
		add(viewList);
		viewList.setVisible(true);
		
		makePageBreak();
		
		saveCarModelButton = new JButton("Save Car Model");
		saveCarModelButton.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		saveCarModelButton.setBackground(Color.DARK_GRAY);
		saveCarModelButton.setForeground(Color.LIGHT_GRAY);
		add(saveCarModelButton);
		returnToMainMenuButton = new JButton("Return To Main Menu");
		returnToMainMenuButton.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		returnToMainMenuButton.setBackground(Color.DARK_GRAY);
		returnToMainMenuButton.setForeground(Color.LIGHT_GRAY);
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

	public void displayCarView(File newCarImage) {

		try {
			BufferedImage one = (ImageIO.read(newCarImage));
			Image two = one.getScaledInstance(600, 279, Image.SCALE_SMOOTH);
			carImage.setIcon(new ImageIcon(two));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addFiller(int size, String fill) {
		
		JTextArea filler = new JTextArea(fill);
		filler.setSize(new Dimension(46, 5));
		filler.setFont(new Font("Serif", Font.BOLD, size));
		filler.setEnabled(false);
		filler.setOpaque(false);
		this.add(filler);
		
	}
	
	public void makePageBreak() {
		
		addFiller(3, "                                   "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      "
				+ "                                      ");
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0, null);
		
	}

	public void resetButtonsFull() {

		exteriorColoursList.clearSelection();
		interiorColoursList.clearSelection();
		viewList.clearSelection();
		carImage.setIcon(null);
		
	}
	
	public void resetButtonsPart() {

		interiorColoursList.clearSelection();
		viewList.clearSelection();
		carImage.setIcon(null);
		
	}
	
	public void resetButtonsMin() {

		viewList.clearSelection();
		carImage.setIcon(null);
		
	}

}
