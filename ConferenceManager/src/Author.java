/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

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
	
	/**
	 * Constructor for the Author.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 */
	public Author(String theFirst, String theLast, String theID) {
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = new ArrayList<Paper>();
	}
	
	/**
	 * Displays the Menu options for the Author.
	 * @author Jeremy Wolf
	 */
	public void authorMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			System.out.println("Role: Reviewer \n");
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit");
			System.out.println("2) un-Submit");
			System.out.println("3) resubmit");
			System.out.println("0) Back\n");
			System.out.println("___________________________________________________");
			
			selection = scanner.nextInt();
			
			
			
			if(selection == 1) {
				// FIX THIS SOOOOOOOON+++++++++++++++++++++++
			    Paper temp = new Paper("this is the title");
				submit(temp);
			} else if (selection == 2) {
				// Finish this!!!!
				Paper temp = myPaperList.get(selection - 1);
				unsubmit(temp);
			} else if (selection == 3) {
				Paper temp = myPaperList.get(selection - 1);
				edit(temp);
			}
		}
	}
	/**
	 * Allows an author to submit a paper.
	 * @author Jeremy Wolf
	 * @param thePaper the Paper that is being submitted.
	 */
	public void submit(Paper thePaper) {
	
	}
	
	/**
	 * Allows an author to removed a paper.
	 * @author Jeremy Wolf
	 * @param thePaper the Paper that is being removed.
	 */
	public void unsubmit(Paper thePaper) {
		
	}
	
	/**
	 * Allows an author to resubmit a paper.
	 * @author Jeremy Wolf
	 * @param thePaper the Paper that is being resubmit.
	 */
	public void edit(Paper thePaper) {
		
	}
	
	/**
	 * Adds the paper to be submitted to the list of papers the author has.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be added.
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
}
	
	
	
	
	
}
