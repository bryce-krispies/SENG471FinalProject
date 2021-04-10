package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class StartMenuController {

	private GUIPane mainGUI;
	private StartMenuGUI startMenu;
	
	public StartMenuController(GUIPane mainGUI) {
		
		this.mainGUI = mainGUI;
		startMenu = new StartMenuGUI();
		startMenu.getQuit().addActionListener(new QuitListener());
		startMenu.getSalespersonLogin().addActionListener(new ChooseLoginListener());
		
	}
	
	public void setStartMenuGUI(StartMenuGUI startMenu) {
		
		this.startMenu = startMenu;
		
	}
	
	public StartMenuGUI getStartMenuGUI() {
		
		return startMenu;
		
	}
	
	public void setMainGUI(GUIPane mainGUI) {
		
		this.mainGUI = mainGUI;
		
	}
	
	public GUIPane getMainGUI() {
		
		return mainGUI;
		
	}
	
	private class ChooseLoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.getContentPane().removeAll();
			mainGUI.getContentPane().invalidate();
			
			mainGUI.getContentPane().add(mainGUI.getLoginController().getLoginGUI());
			mainGUI.getContentPane().revalidate();
			
			mainGUI.getLoginController().getLoginGUI().paintComponents(mainGUI.getGraphics());
			mainGUI.update(mainGUI.getGraphics());
			
			
			
		}
		
		
		
	}
	
	private class QuitListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {

			mainGUI.dispose();
			
		}
		
		
	}
	
}
