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
	
//<<<<<<< HEAD
//=======
//
//>>>>>>> refs/remotes/origin/master
//	
//<<<<<<< HEAD
//	
//	
//	
//	
//	
//
//=======
//>>>>>>> refs/remotes/origin/master
	/**
	 * Allows the Reviewer to submit a review
	 * @author Jeremy Wolf
	 */
//<<<<<<< HEAD
//	public Review submitReview(Paper paper) {
//			Review currentReview = new Review(myID, paper, this);
//		return currentReview;
//=======
	public void submitReview(int theSelection) {
		
		Paper tPaper = null;
		// Creates the Review object.
		if (theSelection != 0) {
			tPaper = myPaperList.get(theSelection - 1);
			Review currentReview = new Review(myID, tPaper, this);
			currentReview.getReviewUI().reviewMenu();

		}
//>>>>>>> refs/remotes/origin/master
	}
	
	/**
	 * Getter method for the myID field
	 * @author Jeremy Wolf
	 * @return the String myIDs
	 */
	public String getID() {
		return myID;
	}
	
//<<<<<<< HEAD
//
//	
//=======
//>>>>>>> refs/remotes/origin/master
	/**
	 * Adds a paper to be reviewed.
	 * @author Jeremy Wolf
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}
//<<<<<<< HEAD
//=======
//	
//>>>>>>> refs/remotes/origin/master
	/**
	 * Getter method for the Paper list.
	 * @author Jeremy Wolf
	 */
	public ArrayList<Paper> getPaperList() {
		return myPaperList;
		
	}
	/**
	 * Gets a list of reviews.
	 * @author Will Almond
	 * @return myReviews
	 */
	public ArrayList<Review> getReviewList() {
		return myReviews;
		
	}
	
	/**
	 * Adds a review to the Review list.
	 * @param theRev is the review to be added.
	 */
	public void addReview(Review theRev) {
		myReviews.add(theRev);
	}

}
