/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

package model;

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
	 * Collection containing all reviews.
	 */
	private ArrayList<Review> myReviews;
	
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
		myReviews = new ArrayList<Review>();
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
		System.out.println("___________________________________________________\n");
		
		// Creates the Review object.
		if (selection != 0) {
			tPaper = myPaperList.get(selection - 1);
			Review currentReview = new Review(myID, tPaper, this);
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
	 * Adds a paper to be reviewed.
	 * @author Jeremy Wolf
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}
	/**
	 * Getter method for the Paper list.
	 * @author Jeremy Wolf
	 */
	public ArrayList<Paper> getPaperList() {
		return myPaperList;
		
	}
	
	public void addReview(Review theRev) {
		myReviews.add(theRev);
	}
}
