package model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * User is the object that represents each registered user. It contains
 * a First and Last name and a ID (Unique String). This object is used
 * to verify if a user is already registered. 
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */

public class User implements Serializable{
	
	/* Generated Serial ID. */
	private static final long serialVersionUID = -7767643624559317435L;
	
	/* The conference which the user is currently using. **/
	private Conference theConf;
	/* The first name of the user. */
	private String theFirstName;
	/* The last name of the user. */
	private String theLastName;
	/* The ID of the user. */
	private String myID;
	
	/**
	 * Constructor for the User to store the non-adjustable attributes of these users.
	 * @param firstName first name of user; not null.
	 * @param lastName last name of user; not null.
	 * @param id the ID of user; not null.
	 */
	public User(String firstName, String lastName, String id){
		theFirstName = firstName;
		theLastName = lastName;
		myID = id;
	}
	/**
	 * method is called when user chooses a conference.
	 * @return The conference user is currently viewing.
	 */
	public Conference chooseConf(){
		return theConf;
	}

	/**
	 * Getter method for the last name field.
	 * 
	 * @return a String representing the Last name of user
	 */
	public String getLast(){
		return theLastName;
	}
	
	/**
	 * Getter Method for the last name.
	 * 
	 * @return a String representing the First name of user
	 */
	public String getFirst(){
		return theFirstName;
	}
	
	/**
	 * Returns the ID of the User.
	 * 
	 * @return a String representing the user's ID
	 */
	public String getID(){
		return myID;
	}	
}