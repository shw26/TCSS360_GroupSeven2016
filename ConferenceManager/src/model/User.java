package model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * User Class
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */

public class User implements Serializable{
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -7767643624559317435L;
	public Conference theConf;
	List confList = new List();
	public String theFirstName;
	public String theLastName;
	public String myID;
	
	/**
	 * Constructor for the User to store the non-adjustable attributes of these users.
	 * @param firstName
	 * @param lastName
	 * @param id
	 */
	public User(String firstName, String lastName, String id){
		theFirstName = firstName;
		theLastName = lastName;
		myID = id;
	}
	/**
	 * The menu that the user will see to log in.
	 */
	public void userMenu() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * method is called when user chooses a conference.
	 * @return
	 */
	public Conference chooseConf(){
		return theConf;
	}
	/**
	 * This method is called to logout a user from the system.
	 */
	public void logout(){
		
	}
	/**
	 * Getter method for the last name field.
	 * 
	 * @return theLastName
	 */
	public String getLast(){
		return theLastName;
	}
	
	/**
	 * Getter Method for the last name.
	 * 
	 * @return theFirstName
	 */
	public String getFirst(){
		return theFirstName;
	}
	
	/**
	 * 
	 * @return myID
	 */
	public String getID(){
		return myID;
	}
	/**
	 * The user should be displayed similarly in each instance.
	 */
	public String toString(){
		StringBuilder myString = new StringBuilder();
		myString.append(theLastName + ", " + theFirstName + ", " + myID);
		return myString.toString();
	}
	
}