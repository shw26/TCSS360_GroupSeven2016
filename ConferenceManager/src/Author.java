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
	
	private Conference myConference;
	
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
		
<<<<<<< HEAD
		while(selection != 0) {
			System.out.println("Role: Author \n");
=======
>>>>>>> refs/heads/master
		
		while(selection != 0) {
			printDetails();
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit");
			System.out.println("2) un-Submit");
			System.out.println("3) resubmit");
			System.out.println("0) Back\n");
			
			selection = scanner.nextInt();
<<<<<<< HEAD
			
=======
			System.out.println("___________________________________________________\n");

>>>>>>> refs/heads/master
			if(selection == 1) {
			    Paper temp = new Paper(myID);
<<<<<<< HEAD
=======
			    temp.paperMenu();
			    addPaper(temp);
>>>>>>> refs/heads/master
			} else if (selection == 2) {
				unsubmit();
			} else if (selection == 3) {
				edit();
			}
		}
	}
	
	/**
	 * Allows an author to removed a paper.
	 * @author Jeremy Wolf
	 */
	public void unsubmit() {
<<<<<<< HEAD
		Paper tempPaper = myPaperList.get(displayPapers());
		myPaperList.remove(tempPaper);
=======
		
		int selection = displayPapers();
		if (selection != 0) {
			Paper tempPaper = myPaperList.get(selection - 1);
			myPaperList.remove(tempPaper);
			myConference.removePaper(tempPaper);
			System.out.println("Paper has been removed");
			System.out.println("___________________________________________________ \n");
		}
>>>>>>> refs/heads/master
	}
	
	/**
	 * Allows an author to resubmit a paper.
	 * @author Jeremy Wolf
	 */ 
	public void edit() {
<<<<<<< HEAD
		Paper tempPaper = myPaperList.get(displayPapers());
		tempPaper.edit();
=======

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
>>>>>>> refs/heads/master
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
		
<<<<<<< HEAD
		System.out.println("Role: Author \n");
		for (Paper tempPaper: myPaperList) {
			System.out.print(optionCounter + ") ");
			System.out.println(tempPaper.getTitle());	
		}
		System.out.println("0) Back");
		return selection = scanner.nextInt();
	}

=======
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
		System.out.println("MSEE Syystem");
		System.out.println("User: " + myID);
		System.out.println("Role: Author");
	}
>>>>>>> refs/heads/master
	
	
	
	
	
}
