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
}