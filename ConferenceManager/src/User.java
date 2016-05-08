import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * User Class
 * 
 * @author Will Almond
 * @version 1.1, 05/07/2016
 *
 */

public class User implements Serializable{
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -7767643624559317435L;
	public Conference theConf;
	ArrayList<Conference> confList = new ArrayList<Conference>();
	public String myFirst;
	public String myLast;
	public String myID;
	
	/**
	 * Constructor for the User to store the non-adjustable attributes of these users.
	 * @param firstName
	 * @param lastName
	 * @param id
	 */
	public User(String firstName, String lastName, String id){
		myFirst = firstName;
		myLast = lastName;
		myID = id;
	}
	/**
	 * The menu that the user will see to log in.
	 */
	public void userMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			System.out.println("Welcome! Please sign in. \n");
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Log In");
			System.out.println("2) Register");
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
			if(selection == 1) {
				logIn();
			} else if (selection == 2) {
				register();
			}
		}
		
	}
	private void logIn(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your system ID: \n");
		
		myID = scanner.nextLine();
		
		System.out.println("___________________________________________________ \n");
		
	

	}
	private void register(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your First Name. \n");
		
		myFirst = scanner.nextLine();
		
		System.out.println("Enter your Last Name. \n");
		
		myLast = scanner.nextLine();
		
		System.out.println("Enter your email. \n");
		
		myID = scanner.nextLine();
		
		System.out.println("___________________________________________________ \n");
		
	
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
		System.exit(0);
	}
	
	/**
	 * Getter method for the last name field.
	 * 
	 * @return theLastName
	 */
	public String getLast(){
		return myLast;
	}
	
	/**
	 * Getter Method for the last name.
	 * 
	 * @return theFirstName
	 */
	public String getFirst(){
		return myFirst;
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
		myString.append(myLast + ", " + myFirst + ", " + myID);
		return myString.toString();
	}

	
}