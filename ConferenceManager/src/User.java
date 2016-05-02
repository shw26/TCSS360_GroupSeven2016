import java.awt.List;
import java.util.ArrayList;

/**
 * 
 * User Class
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */
public class User {
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
	 * The user should be displayed similarly in each instance.
	 */
	public String toString(){
		StringBuilder myString = new StringBuilder();
		myString.append(theLastName + ", " + theFirstName + ", " + myID);
		return myString.toString();
	}
	
}
