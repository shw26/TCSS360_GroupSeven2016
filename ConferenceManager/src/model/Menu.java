package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import view.AuthorUI;
import view.ConferenceUI;
import view.MenuUI;

public class Menu implements Serializable{
	
	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = 2219879119428317464L;

	/**
	 * Collection of all System Users.
	 */
	private ArrayList<User> myUsers;
	
	/**
	 * Collection of all Conferences.
	 */
	private ArrayList<Conference> myConferences;
	
	/**
	 * Current Users
	 */
	private User myCurrentUser;
	
	/**
	 * The MenuUI to start the program.
	 */
	//private MenuUI myMenuUI;
	
	/**
	 * Menu object constructor.
	 */
	public Menu() {
		myUsers = new ArrayList<User>();
		myConferences = new ArrayList<Conference>();
		//myMenuUI = new MenuUI(this);
		myCurrentUser = null;
	}
	
	/**
	 * Logs the returning user in to the system.
	 * @param theID the email of the User
	 * @return boolean for if they are registered.
	 */
	public boolean login(String theID) {
		Boolean found = false;
		for (User temp : myUsers) {
			String tempID = temp.getID();
			if(tempID.equals(theID)) {
				//Go into system
				myCurrentUser = temp;
				found = true;
			}
		}
		return found;	
	}
	
	/**
	 * Registers a new user.
	 * @param theFirst the first name
	 * @param theLast the last name
	 * @param theID the email address
	 */
	public boolean register(String theFirst, String theLast, String theID) {
		
		Boolean found = false;
		for (User temp : myUsers) {
			String tempID = temp.getID();
			if(tempID.equals(theID)) {
				
				found = true;
			}
		}
		if (!found) {		
			User newUser = new User(theFirst, theLast, theID);
			myUsers.add(newUser);		
			myCurrentUser = newUser;
		}
		return found;

	}
	
	
	/**
	 * Creates a new Conference.
	 * @param theName a String for the name  of the conference
	 * @param thePC the User to be the Program Chair
	 * @param theNumDayUntilDue the Number of days until the due date.
	 */
	public void createConference(String theName, User thePC, int theNumDayUntilDue) {
		myUsers.add(thePC);
		Conference newConference = new Conference(theName, thePC, myUsers, theNumDayUntilDue);
		myConferences.add(newConference);
		
	}
	
	/**
	 * Getter method for the Current User.
	 * @return myCurrentUser
	 */
	public User getCurrentUser() {
		return myCurrentUser;
	}
	
	/**
	 * Getter method for the conference list.
	 * @return myConferences
	 */
	public ArrayList<Conference> getConferences() {
		return myConferences;
	}
	
	/**
	 * Getter method for the menu ui.
	 * @return myMenuUI
	 */
	//public MenuUI getMenuUI() {
	//	return myMenuUI;
	//}
	
	/**
	 * This adds a user to the list of system users.
	 * 
	 * @param theUser the user being added to the list of system users
	 */
	public void addUser(User theUser) {
		myUsers.add(theUser);
	}
}
