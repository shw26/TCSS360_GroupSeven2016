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
	 * Sets the recommendation status on a paper.
	 * 
	 * @param theSelection 1 if recommendation made, 2 otherwise
	 * @param thePaper the paper whose status is being updated.
	 */
    public void makeRecommendation(int theSelection, Paper thePaper) {
    	
		if (theSelection == 1) {
			thePaper.setRecommendation(true);
		} else if (theSelection == 2) {
			thePaper.setRecommendation(false);
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
	public int isAuthor(int theSelection, Paper thePaper) {
		int selection = theSelection;
		int buildType = 0;
		String compareID = "";
		String theID = thePaper.getAuthor();
		User userTemp = null;
		compareID = myUsers.get(selection - 1).getID();
		if (!theID.equals(compareID)) {
			userTemp = myUsers.get(selection - 1);
			buildType = createReviewer(userTemp, thePaper);
			selection = buildType;
			
		} else {
			selection = -1;	
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
	public int createReviewer(User theUser, Paper thePaper ) {
		int selection = 0;
		//If the list is empty then a reviewer is added.
		if(myRevList.isEmpty()) {
			Reviewer tempRev = new Reviewer(theUser.getFirst(), theUser.getLast(), theUser.getID());
			myRevList.add(tempRev);
			tempRev.addPaper(thePaper);
			selection = 1;
			
		//If the list is not empty the contents must be check to avoid duplication.	
		} else {
			boolean isPresent = false;
			for (Reviewer rev : myRevList) {
				if (rev.getID().equals(theUser.getID())) {
					// Check to make sure they don't have more then 4 papers.
					if ((rev.getPaperList()).size() <= 3) {
						rev.addPaper(thePaper);
						selection = 1;
					} else {
						selection = 2;
					}
					isPresent = true;
					break;
				}
			}
			//If the User is not already a reviewer a new reviewer is created.
			if (!isPresent) {
				Reviewer tempRev = new Reviewer(theUser.getFirst(), 
						theUser.getLast(), theUser.getID());
				myRevList.add(tempRev);
				tempRev.addPaper(thePaper);
				selection = 1;
			}
		}
		return selection;
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
	
	/**
	 * Getter method for the User list
	 * @return myUsers
	 */
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
}

