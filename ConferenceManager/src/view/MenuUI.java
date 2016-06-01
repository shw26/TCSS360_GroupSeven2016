package view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
import model.Menu;
import model.User;

public class MenuUI implements Serializable{
	
	
	private static final int LOGIN = 1;
	private static final int REGISTER = 2;
	
	/*
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -3432974761649507264L;
	
	/*
	 * The Menu Model class.
	 */
	private Menu myMenu;
	
	/*
	 * The Conference UI
	 */
	private ConferenceUI myConferenceUI;
	
	/*
	 * Calendar object to determine date
	 */
	private Calendar myCalendar;
	
	/**
	 * Constructor for the MenuUI.
	 * @param theMenu the Menu Model class.
	 */
	public MenuUI() {
		myMenu = new Menu();
		myConferenceUI = new ConferenceUI();
		myCalendar = Calendar.getInstance();
	}
	/**
	 * UI welcome menu method.
	 */
	public void welcomeMenu() {
	
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			System.out.println("Welcome to the MSEE System\n");
			System.out.println("Please make a selection:");
			System.out.println("1) Login");
			System.out.println("2) Register");
			System.out.println("0) EXIT\n"); 
			
			selection = scanner.nextInt();
			
			System.out.println("_________________________________________________");

			if (selection == LOGIN) {
				login();
			} else if (selection == REGISTER) {
				register();
			}
		}
		System.out.println("Thank you for using the MSEE System");
	}

	/**
	 * UI method for Registering a new user.
	 */
	public void register() {
		String firstName = "";
		String lastName = "";
		String ID = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("MSEE System");
		System.out.println("Registration");
		System.out.print("Enter your first name: ");
		
		firstName = scanner.nextLine();
		System.out.print("\nEnter your last name: ");
		lastName = scanner.nextLine();
		System.out.print("\nEnter your Email: ");
		ID = scanner.nextLine();
		boolean userFound = myMenu.register(firstName, lastName, ID);
		
		if (userFound) {
			System.out.println("\nEmail is already registered with a User.\n");
			System.out.println("_________________________________________________");
			welcomeMenu();
		} else {
			System.out.println("\nThank you for Registering!\n");
			System.out.println("_________________________________________________");
			selectConference();
		}
	}

	/**
	 * UI method for Logging in.
	 */
	public void login() {
		String ID = "";
	
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Welcome to the MSEE System\n");
		System.out.print("Please enter your Email:  ");
	
		
		ID = scanner.nextLine();
		boolean found = myMenu.login(ID);
		if (found) {
			System.out.println("_________________________________________________");
			selectConference();
		} else {
			System.out.println("Your email did not match anything in our system");
			System.out.println("_________________________________________________");
		}
		
	}
	
	/**
	 * UI for selecting a conference
	 */
	public void selectConference() {
		int selection = -1;
		Date due = null;
		
		User tempUser = myMenu.getCurrentUser();
		if (selection != 0) {
			int optionCounter = 1;
			Conference current = null;
			Scanner scanner = new Scanner(System.in);
			System.out.println("MSEE System");
			Date today = myCalendar.getTime();
			System.out.println("Date: " + today.toString());
			System.out.println("User: " + tempUser.getID() + "\n");
			System.out.println("Select a Conference:");
		
			for (Conference tempConf : myMenu.getConferences()) {
				due = tempConf.getDueDate();
				String dueDate = due.toString();
				System.out.print(optionCounter + ") ");
				System.out.println(tempConf.getName() + " ---- Submission Deadline: " + dueDate.substring(0, 11) );
				optionCounter++;
			}
			System.out.println("0) Log Out");
			selection = scanner.nextInt();
			System.out.println("_________________________________________________");
			if (selection != 0) {
				current = myMenu.getConferences().get(selection - 1);
				myConferenceUI.confMenu(tempUser, current);
				
			}
		}
	}
	
	/**
	 * setter for menu.
	 * @param theMenu the main system.
	 */
	public void setMenu(Menu theMenu){
		myMenu = theMenu; 
	}
	
}
