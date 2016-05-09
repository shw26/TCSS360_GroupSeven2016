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
			System.out.println("3) View Reviews");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			
			if(selection == 1) {
				viewPapers();
			} else if (selection == 2) {
				submitReview();
			} else if (selection == 3) {
				viewReviews();
			} 
		}
	}
	
	
	
	
	
	private void viewReviews() {
		Scanner scanner = new Scanner(System.in);
		if (!myReviews.isEmpty()) {
			for (Review rev : myReviews) {
				System.out.println("Title: " + rev.getPaperName());
				System.out.println("\tThe rating was: " + rev.theRateing);
				System.out.println("\tThe review comment was: ");
				System.out.println("\t" + rev.getComment() + "\n");
			}
			System.out.println("Press 0 to go back");
			int selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
		} else { 
			System.out.println("You have no reviews to view");
			System.out.println("___________________________________________________\n");
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
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	private void viewPapers() {
		int optionCounter = 1;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Currently Assigned Papers: ");
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");
		int selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
	}
	
	/**
	 * Adds a paper to be reviewed.
	 * @author Jeremy Wolf
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}
	
	/**
	 * Prints the details to print at the top of the screen.
	 * @author Jeremy Wolf
	 */
	private void printDetails() {
		System.out.println("MSEE Syystem");
		System.out.println("User: " + myFirstName);
		System.out.println("Role: Reviewer");
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
