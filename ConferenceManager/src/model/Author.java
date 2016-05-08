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
 * Author class. This role can review papers.
 * 
 * @author Jeremy Wolf
 * @version v1 5/1/2016
 */
public class Author implements Serializable{
	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = 4146907723807800178L;

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
	
	private Conference myConference;
	
	private boolean myIsPastDueDate;
	
	/**
	 * Constructor for the Author.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 */
	public Author(String theFirst, String theLast, String theID, Conference theConference) {
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myIsPastDueDate = false;
		myPaperList = new ArrayList<Paper>();
		myConference = theConference;
	}
	
	/**
	 * Displays the Menu options for the Author.
	 * @author Jeremy Wolf
	 */
	public void authorMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		
		while(selection != 0) {
			printDetails();
			myIsPastDueDate = myConference.isDeadlinePast();
			if (!myIsPastDueDate) {
				System.out.println("Make a Selection: ");
				System.out.println("1) Submit");
				System.out.println("2) Un-Submit");
				System.out.println("3) Resubmit");
				System.out.println("4) View Reviews");
				System.out.println("0) Back\n");
			} else {
				System.out.println("Deadline for submission has passed ");
				System.out.println("Make a Selection: ");
				System.out.println("2) Un-Submit");
				System.out.println("4) View Reviews");
				System.out.println("0) Back\n");
			}
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");

			if(selection == 1 && !myIsPastDueDate) {
			    Paper temp = new Paper(myID);
			    temp.paperMenu();
			    addPaper(temp);
			} else if (selection == 2) {
				unsubmit();
			} else if (selection == 3 && !myIsPastDueDate) {
				edit();
			} else if (selection == 4) {
				displayReviews();
			}
		}
	}
	
	/**
	 * Allows an author to removed a paper.
	 * @author Jeremy Wolf
	 */
	public void unsubmit() {
		
		int selection = displayPapers();
		if (selection != 0) {
			Paper tempPaper = myPaperList.get(selection - 1);
			myPaperList.remove(tempPaper);
			myConference.removePaper(tempPaper);
			System.out.println("Paper has been removed");
			System.out.println("___________________________________________________ \n");
		}
	}
	
	/**
	 * Allows an author to resubmit a paper.
	 * @author Jeremy Wolf
	 */ 
	public void edit() {

		int selection = displayPapers();
		
		if(selection != 0) {
			Paper tempPaper = myPaperList.get(selection - 1);
			myPaperList.remove(selection -1);
			myConference.removePaper(tempPaper);
		    Paper temp = new Paper(myID);
			temp.paperMenu();
			addPaper(temp);
			System.out.println("Paper has been updated");
			System.out.println("___________________________________________________ \n");

		}
	}
	
	/**
	 * Adds the paper to be submitted to the list of papers the author has.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be added.
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		myConference.addPaper(thePaper);
}

	/**
	 * Getter method for myID	
	 * @author Jeremy Wolf	
	 * @return myID
	 */
	public String getID() {
		return myID;
	}
	
	private int displayPapers() {
		
		
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		
		printDetails();
		for (Paper tempPaper: myPaperList) {
			System.out.print(optionCounter + ") ");
			System.out.println(tempPaper.getTitle());	
			optionCounter++;
		}
		System.out.println("0) Back");
		selection = scanner.nextInt();
		return selection;
	}

	private void printDetails() {
		System.out.println("MSEE System");
		System.out.println("User: " + myID);
		System.out.println("Role: Author");
	}
	
	/**
	 * Will display reviews of selected paper if the final 
	 * Recommendation has been made.
	 * @author Jeremy Wolf
	 */
	private void displayReviews() {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		printDetails();
		System.out.println("Selected a paper to view reviews: ");
		System.out.println("If no papers are displayed, they are still awaiting a decsion.");
		for(Paper tempPaper : myPaperList) {
			if (tempPaper.getFinal()) {
				System.out.print(optionCounter + ") ");
				System.out.println(tempPaper.getTitle());
			}
			optionCounter++;
		}
		System.out.println("0) Back");
		
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		
		if(selection != 0) {
			int counter = 1;
			printDetails();
			Paper tempPaper = myPaperList.get(selection - 1);
			System.out.println("Paper: " + tempPaper.getTitle());
			for(Review rev : tempPaper.getReviews()) {
				System.out.println("Review number: " + counter);
				System.out.println("\tThe rating was: " + rev.theRateing);
				System.out.println("\tThe review comment was: ");
				System.out.println("\t" + rev.getComment() + "\n");
				counter++;
			}
			System.out.println("Press 0 to go back");
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
		}
	}
}
