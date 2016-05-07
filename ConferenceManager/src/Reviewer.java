/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reviewer class. This role can review papers.
 * 
 * @author Jeremy Wolf
 * @version v1 5/1/2016
 */

public class Reviewer implements Serializable{

	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -6833321289334518369L;

	/**
	 * String representation the first name of the Sub Program Chair.
	 */
	private String myFirstName;
	
	/**
	 * String representation of the Last of the Sub Program Chair.
	 */
	private String myLastName;
	
	/**
	 * String representation of the ID of the Sub Program Chair.
	 */
	private String myID;
	
	/**
	 * Collection containing a list of all papers assigned to the Sub Program Chair.
	 */
	private ArrayList<Paper> myPaperList;
	
	/**
	 * Constructor for the Reviewer.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 */
	public Reviewer(String theFirst, String theLast, String theID) {
		
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = new ArrayList<Paper>();
	}
	
	/**
	 * Displays the Menu options for the Reviewer.
	 * @author Jeremy Wolf
	 */
	public void reviewerMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			printDetails();
			System.out.println("Make a Selection: ");
			System.out.println("1) View Papers");
			System.out.println("2) Review a Paper");
			System.out.println("0) Back\n");
			System.out.println("___________________________________________________\n");
			
			selection = scanner.nextInt();
			
			if(selection == 1) {
				viewPapers();
			} else if (selection == 2) {
				submitReview();
			} 
		}
	}
	
	/**
	 * Allows the Reviewer to submit a review
	 * @author Jeremy Wolf
	 */
	private void submitReview() {
		int optionCounter = 1;
		int selection = -1;
		Paper tPaper = null;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Select a Paper to be Reviewed:");
		
		// Displays the papers to the console 
		for (Paper tempPaper : myPaperList) {
			System.out.print(optionCounter + ") ");
			System.out.print(tempPaper.getTitle()+ "\n");
			optionCounter++;
		}
		
		// User selects paper to be reviewed.
		selection = scanner.nextInt();
		
		// Creates the Review object.
		if (selection != 0) {
			tPaper = myPaperList.get(selection - 1);
			Review currentReview = new Review(myID);
			currentReview.reviewMenu();

		}
	}
	
	/**
	 * Getter method for the myID field
	 * @author Jeremy Wolf
	 * @return the String myIDs
	 */
	public String getID() {
		return myID;
	}
	
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	private void viewPapers() {
		int optionCounter = 1;
		printDetails();
		System.out.println("Currently Assigned Papers: ");
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");
	}
	
	/**
	 * Adds a paper to be reviewed.
	 * @author Jeremy Wolf
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}
	private void printDetails() {
		System.out.println("MSEE Syystem");
		System.out.println("User: " + myFirstName);
		System.out.println("Role: Reviewer");
	}
}
