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
public class SubProgramChair implements Serializable {

	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -7924787836896189243L;

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
	 * Collection containing a list of all Reviewer under the Program Chair.
	 */
	private ArrayList<Reviewer> myRevList;
	
	/**
	 * Collection containing a list of all users.
	 */
	private ArrayList<User> myUsers;
	

	
	
	/**
	 * Constructor for the Sub-Program Chair.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 * @param theList a collection of Users.
	 */
	public SubProgramChair(String theFirst, String theLast, String theID, 
			ArrayList<User> theList, ArrayList<Reviewer> theReviewers) {
	
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myUsers = theList;
		myPaperList = new ArrayList<Paper>();
		myRevList = theReviewers;	
	}
	
	/**
	 * Displays the Menu options for the Sub-Program Chair.
	 * @author Jeremy Wolf
	 */
	public void scMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			displayDetails();
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit a Recommendation");
			System.out.println("2) Assign Reviewer to a paper");
			System.out.println("0) Back\n");
		
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
			if(selection == 1) {
				submitRecommendation();
			} else if (selection == 2) {
				assignReviewer();
			}
		}
	}
	
	/**
	 * Allows the Sub-program chair to submit a recommendation on
	 * a paper.
	 * @author Jeremy Wolf
	 */
	private void submitRecommendation() {
		int optionCounter = 1;
		int selection = -1;
		Paper tempPaper = null;
		Scanner scanner = new Scanner(System.in);
		displayDetails();
		System.out.println("Select a paper to make a recommendation:");
		
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		displayDetails();
		tempPaper = myPaperList.get(selection - 1);
		System.out.println("Paper: " + tempPaper.getTitle());
		
		if (selection != 0) {
			tempPaper = myPaperList.get(selection - 1);
			
			// Displays Options
			System.out.println("Select Recommendation:");
			System.out.println("1) Recommend");
			System.out.println("2) Deny");
			System.out.println("0) Back");
		
			//Recommendation selection is made.
			selection = scanner.nextInt();
			if (selection == 1) {
				tempPaper.setRecommendation(true);
			} else if (selection == 2) {
				tempPaper.setRecommendation(false);
			}
			System.out.println("___________________________________________________ \n");
		}
	}
	
	private int displayPapers() {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		displayDetails();
		System.out.println("Select a Paper to be Reviewed");
		
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back\n");
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		
		return selection;
	}
	
	
	/**
	 * Allows the Sub-Program Chair to assign Reviewer to papers
	 * they are coordinating the review on. 
	 * @author Jeremy Wolf
	 */
	private void assignReviewer() {
		int selection = -1;
		Paper tempPaper = null;
		String authorID = "";
		selection = displayPapers();

		// Gets the paper the user selected.
		if (selection != 0) {
			tempPaper = myPaperList.get(selection - 1);
			authorID = tempPaper.getAuthor();
		}
		//Displays the users for review.
		while(selection != 0) {
			displayDetails();
			System.out.println("Paper: " + tempPaper.getTitle() + "\n");
			selection = isAuthor(authorID, tempPaper);
		}
	}
	
	/**
	 * Checks to see if the User is the author of the paper. This enforces 
	 * the bussiness rule that a Author cant review a paper they have written.
	 * @author Jeremy Wolf
	 * @param theID the ID of the Author of the paper
	 * @param thePaper the Paper to be assigned to a reviewer
	 * @return the menu option selected.
	 */
	public int isAuthor(String theID, Paper thePaper) {
		int selection = 1;
		boolean isSame = true;
		String compareID = "";
		User userTemp = null;
		selection = displayUsers();

		// Creates a Reviewer object and places into the Reviewer list.
		if (selection != 0) {
			compareID = myUsers.get(selection - 1).getID();
			if (!theID.equals(compareID)) {
				userTemp = myUsers.get(selection - 1);
				createReviewer(userTemp, thePaper);
			} else {
				System.out.println("An Author can't review their own paper.");
				System.out.println("___________________________________________________ \n");	
			} 
		}
		return selection;
	}
	
	/**
	 * If the user is not already a reviewer they a reviewer object is created.
	 * If the user is a reviewer then they will have thePaper added to their review
	 * list.
	 * @author Jeremy Wolf
	 * @param theUser theUser that is going to be a Reviewer.
	 * @param thePaper the paper to be reviewed by the Reviewer.
	 */
	private void createReviewer(User theUser, Paper thePaper ) {
		
		//If the list is empty then a reviewer is added.
		if(myRevList.isEmpty()) {
			System.out.println(theUser.getFirst() + " " + theUser.getLast() + " has been assigned as the reviewer on the paper.");
			Reviewer tempRev = new Reviewer(theUser.getFirst(), theUser.getLast(), theUser.getID());
			myRevList.add(tempRev);
			tempRev.addPaper(thePaper);
			
		//If the list is not empty the contents must be check to avoid duplication.	
		} else {
			boolean isPresent = false;
			for (Reviewer rev : myRevList) {
				if (rev.getID().equals(theUser.getID())) {
					// Check to make sure they don't have more then 4 papers.
					if ((rev.getPaperList()).size() <= 3) {
						rev.addPaper(thePaper);
						System.out.println("The paper has been assigned to " + theUser.getFirst() + " " + theUser.getLast());
					} else {
						System.out.println("A Reviewer can't have more then 4 papers");
					}
					isPresent = true;
					break;
				}
			}
			//If the User is not already a reviewer a new reviewer is created.
			if (!isPresent) {
				System.out.println(theUser.getFirst() + " " + 
						theUser.getLast() + " has been assigned as the reviewer on the paper.");
				Reviewer tempRev = new Reviewer(theUser.getFirst(), 
						theUser.getLast(), theUser.getID());
				myRevList.add(tempRev);
				tempRev.addPaper(thePaper);
				System.out.println("___________________________________________________ \n");
			}
		}
	}

	/**
	 * Adds the Paper to the Sub-Program Chairs list.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be assigned to reviewers.
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}

	/**
	 * Getter method for my First name field.
	 * @author Jeremy Wolf
	 * @return string for First Name.
	 */
	public String getFirst() {
		return myFirstName;
	}

	/**
	 * Getter method for my Last name field.
	 * @author Jeremy Wolf
	 * @return string for Last Name.
	 */
	public ArrayList<Paper> getPaperList() {
		return myPaperList;
	}

	/**
	 * Getter method for my Last name field.
	 * @author Jeremy Wolf
	 * @return string for Last Name.
	 */
	public String getLast() {
		return myLastName;
	}
	
	public ArrayList<User> getList() {
		return myUsers;
	}
	
	/**
	 * Getter method for the myID field
	 * @author Jeremy Wolf
	 * @return the String myID
	 */
	public String getID() {
		return myID;
	}
	
	/**
	 * Displays the details to be on the top of the screen
	 * @author Jeremy Wolf
	 */
	private void displayDetails() {
		System.out.println("MSEE System");
		System.out.println("User: " + myID);
		System.out.println("Role: Sub-ProgramChair");
	}
	
	/**
	 * Displays the Users to the console
	 * @author Jeremy Wolf
	 * @return an Int value for the menu selection.
	 */
	private int displayUsers() {
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		for (User tempUser: myUsers) {
			System.out.print(optionCounter + ") ");
			System.out.print(tempUser.getFirst() + " " + tempUser.getLast() + "\n");
			optionCounter++;
			}
		
		System.out.println("0) Back"); 
		selection = scanner.nextInt();
		return selection;
	}
}

