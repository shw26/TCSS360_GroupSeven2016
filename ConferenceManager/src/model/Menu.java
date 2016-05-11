package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import view.AuthorUI;

public class Menu implements Serializable{
	
	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = 2219879119428317464L;

	/**
	 * Collection of all System Users.
	 */
	ArrayList<User> myUsers;
	
	/**
	 * Collection of all Conferences.
	 */
	ArrayList<Conference> myConferences;
	
	/**
	 * Current Users
	 */
	User myCurrentUser;
	
	/**
	 * 
	 */
	private AuthorUI myAuthorUI;
	
	public Menu() {
		myUsers = new ArrayList<User>();
		myConferences = new ArrayList<Conference>();
		myAuthorUI = new AuthorUI();
	}
	
	public void welcomeMenu() {
		
		Conference two = myConferences.get(1);
		two.changeDeadline(-2);
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

			if (selection == 1) {
				login();
			} else if (selection == 2) {
				register();
			}
		}
		System.out.println("Thank you for using the MSEE System");
	}
	
	private void login() {
		String ID = "";
		Boolean found = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the MSEE System\n");
		System.out.print("Please enter your Email:  ");

			
		ID = scanner.nextLine();
		
		for (User temp : myUsers) {
			String tempID = temp.getID();
			if(tempID.equals(ID)) {
				//Go into system
				myCurrentUser = temp;
				found = true;
				System.out.println("_________________________________________________");
				selectConference();
			}
		}
		if(!found) {
			System.out.println("Your email did not match anything in our system");
			System.out.println("_________________________________________________");
		}
		
	}
	
	private void register() {
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
		
		User newUser = new User(firstName, lastName, ID);
		myUsers.add(newUser);
		
		System.out.println("\nThank you for Registering!\n");
		System.out.println("_________________________________________________");
		
		myCurrentUser = newUser;
		selectConference();

	}
	
	private void selectConference() {
		int selection = -1;
		
		while (selection != 0) {
			int optionCounter = 1;
			Conference current = null;
			Scanner scanner = new Scanner(System.in);
			System.out.println("User: " + myCurrentUser.getID());
			System.out.println("Select a Conference:");
		
			for (Conference tempConf : myConferences) {
				System.out.print(optionCounter + ") ");
				System.out.println(tempConf.getName());
				optionCounter++;
			}
			System.out.println("0) Log Out");
			selection = scanner.nextInt();
			System.out.println("_________________________________________________");
			if (selection != 0) {
				current = myConferences.get(selection - 1);
				current.confMenu(myCurrentUser);
			}
	
		}
	}
	
	public void createConference(String theName, User thePC, int theNumDayUntilDue) {
		myUsers.add(thePC);
		Conference newConference = new Conference(theName, thePC, myUsers, theNumDayUntilDue);
		myConferences.add(newConference);
		
	}
}
