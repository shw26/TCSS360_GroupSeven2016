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
	 * Max number of Papers assigned to a Reviewer
	 */
	public static final int MAX_PAPERS = 4;
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
	 * the business rule that a Author can't review a paper they have written.
	 * @author Jeremy Wolf
	 * @param theSelection an integer value for the index position of the User in the User collection that is
	 * 					   being compared to the Author of the paper
	 * @param thePaper the Paper to be assigned to a reviewer
	 * @return a boolean true if the selected user is the author of the paper.
	 */
	public boolean isAuthor(int theSelection, Paper thePaper) {
		boolean isTheAuthor = false;
		String compareID = "";
		String theID = thePaper.getAuthor();
		
		compareID = myUsers.get(theSelection - 1).getID();
		if (theID.equals(compareID)) {
			isTheAuthor = true;	
		} 
		
		return isTheAuthor;
	}
	
	/**
	 * If the user is not already a reviewer then a reviewer object is created.
	 * 
	 * @author Jeremy Wolf
	 * @param theUser theUser that is going to be a Reviewer.
	 * @return if a Reviewer Object is found with the same ID then it is returned, otherwise a
	 * 			new Reviewer is created.
	 */
	public Reviewer createReviewer(int theSelection) {
		Reviewer tempReviewer = null;
		User userTemp = myUsers.get(theSelection - 1);
		boolean isPresent = false;
		for (Reviewer rev : myRevList) {
			if (rev.getID().equals(userTemp.getID())) {
				isPresent = true;
				tempReviewer = rev;
				break;
			}
		}
		//If the User is not already a reviewer a new reviewer is created.
		if (!isPresent) {
			tempReviewer = new Reviewer(userTemp.getFirst(), 
					userTemp.getLast(), userTemp.getID());
			myRevList.add(tempReviewer);
		}
	
		return tempReviewer;
	}

	/**
	 * Adds the Paper to the Sub-Program Chairs list.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be assigned to reviewers.
	 * @return a boolean value indicating if the paper was successfully added/ 
	 */
	public boolean addPaper(Paper thePaper) {
		boolean paperAdded = false;
		
		if (myPaperList.size() < MAX_PAPERS) {
			myPaperList.add(thePaper);
			paperAdded = true;
		}
		return paperAdded;
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
	
	/**
	 * Getter method for the collection of Reviewers. 
	 * @author Jeremy Wolf
	 * @return the Collection of Reviewers for the SubProgram Chair.
	 */
	public ArrayList<Reviewer> getReviewers() {
		return myRevList;
	}
}

