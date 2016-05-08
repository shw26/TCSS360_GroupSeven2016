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
 * Program Chair class.
 * 
 * @author Jeremy Wolf
 * @version v1 4/30/2016
 */
public class ProgramChair implements Serializable {
	
	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -5029928592171799831L;

	/**
	 * String representation the first name of the Program Chair.
	 */
	private String myFirstName;
	
	/**
	 * String representation of the Last of the Program Chair.
	 */
	private String myLastName;
	
	/**
	 * String representation of the ID of the Program Chair.
	 */
	private String myID;
	
	/**
	 * Collection containing a list of all papers under the Program Chair.
	 */
	private ArrayList<Paper> myPaperList;
	
	/**
	 * Collection containing a list of all SubProgramChairs under the Program Chair.
	 */
	private ArrayList<SubProgramChair> mySubList;
	
	/**
	 * Collection containing a list of all registered users.
	 */
	private ArrayList<User> myUserList;
	
	/**
	 * Collection containing a list of all Reviewers. 
	 */
	private ArrayList<Reviewer> myReviewers;
	
	/**
	 * Constructor for the Program Chair Class.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 * @param theList Collection of Papers
	 */
	public ProgramChair(String theFirst, String theLast, String theID, 
			ArrayList<Paper> theList, ArrayList<SubProgramChair> theSCs, 
			ArrayList<User> theUsers, ArrayList<Reviewer> theReviewers) {
		
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = theList; // No deep copy since we want this to be connected by reference. 
		myUserList = theUsers; // No deep copy since we want this to be connected by reference. 
		mySubList = theSCs;
		myReviewers = theReviewers;
		
	}
	/**
	 * Displays the Menu options for the Program Chair.
	 * @author Jeremy Wolf
	 */
	public void pcMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			System.out.println("User: " + myID);
			System.out.println("Role: Program Chair");
			System.out.println("Make a Selection: ");
			System.out.println("1) View Papers");
			System.out.println("2) Designate Sub-Program Chair(s)");
			System.out.println("3) View Sub-Program Chair(s) assigned papers");
			System.out.println("4) Make final decision");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			if(selection == 1) {
				viewPapers();
			} else if (selection == 2) {
				designateSC();
			} else if (selection == 3) {
				viewSCPapers();
			} else if (selection == 4) {
				
				makeFinal();
			}
		}
	}
	
	/**
	 * Method displays title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	private void viewPapers() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Currently Assigned Papers:");
		for (Paper printPaper: myPaperList ) {
			System.out.print( "\t" + printPaper.getTitle()+ "\n");
		}
		System.out.println("Press 0 to go back");
		selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
	}
	
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	private void viewPapersWithOptions() {
		int optionCounter = 1;
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");

	}
	
	/**
	 * Allows the Program Chair to select SubProgram Chairs
	 * @author Jeremy Wolf
	 */
	private void designateSC() {

		int selection = -1;
		SubProgramChair tempSC = null;
		User tempUser =null;
		
		Scanner scanner = new Scanner(System.in);
		
		while (selection != 0) {
			printDetails();
			System.out.println("Current Registered Users:\n");
			displayUsers();
			System.out.println("0) Back");
			System.out.println("Select a User: (1 - " + myUserList.size() + ")");
			
			selection = scanner.nextInt();
		
			if(selection != 0) {
				tempUser = myUserList.get(selection - 1);
				if (!isPresent(tempUser)) {
				// Creates a new subprogram Chair
					tempSC = new SubProgramChair(tempUser.getFirst(), tempUser.getLast(),
											 tempUser.getID(), myUserList, myReviewers);
					mySubList.add(tempSC);
				} else {
					for(SubProgramChair temp : mySubList) {
						if (tempUser.getID().equals(temp.getID())) {
							tempSC = temp;
							break;
						}
					}
				}
			
				
				while (selection != 0 && tempSC.getPaperList().size() <= 4) {
					printDetails();
				
					System.out.println("Select a Paper to be Assigned to " + tempUser.getFirst() 
									+ " " + tempUser.getLast() + ":");
					
					// Will display the paper to be assigned.
					viewPapersWithOptions(); 
					selection = scanner.nextInt();
					if (selection != 0) {
						Paper tPaper = myPaperList.get(selection - 1);
							if (!tempSC.getID().equals(tPaper.getAuthor())) {
								tempSC.addPaper(myPaperList.get(selection - 1));
								System.out.println("Paper has been assigned");
								System.out.println("_________________________________________________\n");
					} else {
						System.out.println("SubProgram Chair is the Author, can not assign paper");
						System.out.println("_________________________________________________\n");
					}
				}
				
				}
				if (tempSC.getPaperList().size() >= 4 ) {
					System.out.println("SubProgram Chair can have no more the 4 papers");
					System.out.println("_________________________________________________\n");
				}
			}
			
		}
	}
	
	/**
	 * Checks to see if the User ID matches a Current SC.
	 * @param theUser being checked
	 * @return true if present, false if not.
	 */
	private boolean isPresent(User theUser) {
		boolean isPresent = false; 
		if (mySubList.isEmpty()) {
			isPresent =  false;
		} else {
			for(SubProgramChair tempSC : mySubList) {
				if (theUser.getID().equals(tempSC.getID())) {
					isPresent = true;
				}
			}
		}
		return isPresent;
	}
	
	/**
	 * Allows the Program Chair to make the final decision on a paper.
	 * @author Jeremy Wolf
	 */
	private void makeFinal() {
		int optionCounter = 1;
		int offsetCounter = 0;
		int selection = -1;
		Paper paperTemp = null;
		
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Select a Paper:");
		//Displays papers that have been given a true recommendation.
		boolean none = true;
		for (Paper tempPaper : myPaperList) {
			if (tempPaper.getRecommendation() == true) {
				none = false;
				System.out.print(optionCounter + ") ");
				System.out.print(tempPaper.getTitle() + "\n");
			}
			optionCounter++;
		}
		if (none) {
			System.out.println("No papers are ready for final decsion.");
			System.out.println("_________________________________________________\n");

		} else {
			//Scans for input for paper selection.
			selection = scanner.nextInt();
			paperTemp = myPaperList.get(selection - 1);
		
			System.out.println("_________________________________________________\n");
			printDetails();
			System.out.println("Paper: " + paperTemp.getTitle());
			// Displays Options
			System.out.println("Select Final Decision:\n");
			System.out.println("1) Accept");
			System.out.println("2) Deny");
			System.out.println("0) Back");
	
			//Final Decision selection is made.
			selection = scanner.nextInt();
			System.out.println("_________________________________________________\n");
			if (selection == 1) {
				paperTemp.setFinal(true);
			} else if (selection == 2) {
				paperTemp.setFinal(false);
			}
		}
	}
	
	/**
	 * Displays the papers assigned to each Sub program Chair.
	 * @author Jeremy Wolf
	 */
	private void viewSCPapers() {
		Scanner scanner = new Scanner(System.in);
		printDetails();
		for (SubProgramChair temp: mySubList) {
			System.out.println(temp.getFirst() + " " + temp.getLast() + ":");
			for (Paper tempPaper : temp.getPaperList()){
				System.out.println("\t" + tempPaper.getTitle());
			}
		}
		System.out.println("Press 0 to go back");
		int selection = scanner.nextInt();
		
		System.out.println("_________________________________________________\n");
	}
	
	/**
	 * Private helper method that displays all registered users to the console.
	 * @author Jeremy Wolf
	 */
	private void displayUsers() {
		int optionCounter = 1;
		for (User u: myUserList) {
			System.out.print(optionCounter + ") ");
			System.out.print(u.getFirst() + " " + u.getLast() + "\n");
			optionCounter++;
		}
	}
	
	/**
	 * Getter method for the myID field
	 * @author Jeremy Wolf
	 * @return the String myID
	 */
	public String getID() {
		return myID;
	}
	
	private void printDetails(){
		System.out.println("User: " + myID);
		System.out.println("Role: Program Chair");	
	}
	}
