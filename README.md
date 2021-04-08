So here's the system.

We run the system at the main function within MainController. Here is the order to events that happen

1. We initialize the database
2. Login Controller created
	a. Login controller creates a LoginGUI
	b. We stay at this login gui until we have a valid login
3. Successful login, create a MainController instance (this instance keeps track of our "state" of the system, as it holds
member variables of the model layer), and erase/dispose of the login gui
	a. Main controller creates the MainMenuGUI (gives us three choices)
		1. Logout -> we erase/dispose the main menu GUI, the main controller instance, and then we go back to 1.
		2. Choose to customize car -> create vehicle customization controller with the main controller instance, erase/dispose the main menu GUI
		3. Choose to edit/view car -> create customer controller with main controller instance, erase/dispose the main menu gui