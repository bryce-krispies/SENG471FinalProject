package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Customer;
import model.Vehicle;

public class ViewCustomerGUI extends JPanel {

	private JTextArea information;
	private JLabel notesLabel, desiredVehicleLabel;
	private Image image;
	private JList<String> visitHistoryList;
	private JButton returnToCustomerMenuButton;

	public ViewCustomerGUI(Customer customer, int accessLevel) {

		try {
			image = ImageIO.read(new File("resources\\Customer_Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		if(accessLevel == 1) {
			renderHighAccess(customer);
		} else if (accessLevel == 2) {
			renderMediumAccess(customer);
		} else {
			renderLowAccess(customer);
		}

	}

	public void renderHighAccess(Customer customer) {
		//Store manager - everything
		
		String info = "Customer ID: " +customer.getId() + "\nAge: " +customer.getAge()
		+ "\nCard Number: " + customer.getCardNumber() + "\nName: " +customer.getName()
		+ "\nEmail: " + customer.getEmail() + "\nPhone Number: " +customer.getPhoneNumber()
		+ "\nBilling Address: " +customer.getBillingAddress() 
		+ "\nCard Expiry Date: " +customer.getCardExpiryDate()
		+ "\nGender: " +customer.getGender() + "\nCurrent Vehicle: " +customer.getCurrentVehicle() 
		+ "\nDesignated Salesperson: " +customer.getDesignatedSalesperson();
		
		addFiller(30, "                                    ");
		JLabel intro = new JLabel("Customer Information:");
		intro.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(intro);
		addFiller(30, "                                    ");
		
		addFiller(30, "                               ");
		information = new JTextArea(info);
		information.setEnabled(false);
		information.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		information.setDisabledTextColor(Color.BLACK);
		information.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(information);
		addFiller(30, "                               ");
		
		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		
		addFiller(30, "                                                  ");
		JLabel tag =  (new JLabel("Customer Visit History: "));
		tag.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(tag);
		addFiller(30, "                                                  ");
		
		visitHistoryList = new JList<String>(stringHistory);
		visitHistoryList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(visitHistoryList);
		
		makePageBreak();
		
		if(customer.getDesiredVehicle() != null) {
			desiredVehicleLabel = new JLabel("Desired Vehicle: " + customer.getDesiredVehicle());
			desiredVehicleLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(desiredVehicleLabel);
		}
		else {
			desiredVehicleLabel = new JLabel("Desired Vehicle: ");
			desiredVehicleLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(desiredVehicleLabel);
		}
		
		makePageBreak();
		
		if(customer.getNotes() != null) {
			addFiller(30, "                                                 ");
			JLabel notesTitle = new JLabel("Notes: ");
			notesTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesTitle);
			addFiller(30, "                                                 ");
			
			makePageBreak();
			
			notesLabel = new JLabel(customer.getNotes());
			notesLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesLabel);
		}
		
		makePageBreak();
		
		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		returnToCustomerMenuButton.setBackground(new Color(163, 175, 175));
		returnToCustomerMenuButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(returnToCustomerMenuButton);
	}

	public void renderMediumAccess(Customer customer) {
		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		
		addFiller(30, "                                                  ");
		JLabel tag =  (new JLabel("Customer Visit History: "));
		tag.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(tag);
		addFiller(30, "                                                  ");
		
		visitHistoryList = new JList<String>(stringHistory);
		visitHistoryList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(visitHistoryList);
		
		makePageBreak();
		
		if(customer.getDesiredVehicle() != null) {
			desiredVehicleLabel = new JLabel("Desired Vehicle: " + customer.getDesiredVehicle());
			desiredVehicleLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(desiredVehicleLabel);
		}
		else {
			desiredVehicleLabel = new JLabel("Desired Vehicle: ");
			desiredVehicleLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(desiredVehicleLabel);
		}
		
		makePageBreak();
		
		if(customer.getNotes() != null) {
			addFiller(30, "                                                 ");
			JLabel notesTitle = new JLabel("Notes: ");
			notesTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesTitle);
			addFiller(30, "                                                 ");
			
			makePageBreak();
			
			notesLabel = new JLabel(customer.getNotes());
			notesLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesLabel);
		}
		
		makePageBreak();
		
		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		returnToCustomerMenuButton.setBackground(new Color(163, 175, 175));
		returnToCustomerMenuButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(returnToCustomerMenuButton);
	}

	public void renderLowAccess(Customer customer) {
		ArrayList<LocalDate> history = customer.getVisitHistory();
		String[] stringHistory = new String[history.size()];
		for(int i = 0; i < history.size(); ++i) {
			stringHistory[i] = history.get(i).toString();
		}
		
		addFiller(30, "                                                  ");
		JLabel tag =  (new JLabel("Customer Visit History: "));
		tag.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(tag);
		addFiller(30, "                                                  ");
		
		visitHistoryList = new JList<String>(stringHistory);
		visitHistoryList.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		add(visitHistoryList);
		
		makePageBreak();
		
		if(customer.getNotes() != null) {
			addFiller(30, "                                                 ");
			JLabel notesTitle = new JLabel("Notes: ");
			notesTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesTitle);
			addFiller(30, "                                                 ");
			
			makePageBreak();
			
			notesLabel = new JLabel(customer.getNotes());
			notesLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
			add(notesLabel);
		}
		
		makePageBreak();
		
		returnToCustomerMenuButton = new JButton("Return To Customer Menu");
		returnToCustomerMenuButton.setBackground(new Color(163, 175, 175));
		returnToCustomerMenuButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		add(returnToCustomerMenuButton);
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

	public void addReturnToCustomerMenuFromViewListener(ActionListener actionListener) {
		returnToCustomerMenuButton.addActionListener(actionListener);
	}

}
