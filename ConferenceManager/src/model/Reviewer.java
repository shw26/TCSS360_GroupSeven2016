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
 * Reviewer class. This role can review papers and submit reviews.
 * 
 * @author Jeremy Wolf
 * @version v1 5/1/2016
 */

public class Reviewer implements Serializable{
	
	/** 
	 * Max number of Papers assigned to a Reviewer.
	 */
	public static final int MAX_PAPERS = 4;

	/*
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -6833321289334518369L;

	/*
	 * String representation the first name of the Reviewer.
	 */
	private String myFirstName;
	
	/*
	 * String representation of the Last of the Reviewer.
	 */
	private String myLastName;
	
	/*
	 * String representation of the ID of the Reviewer.
	 */
	private String myID;

	/*
	 * Collection containing a list of all papers assigned to the Sub Program Chair.
	 */
	private ArrayList<Paper> myPaperList;
	
	/*
	 * Collection containing all reviews.
	 */
	private ArrayList<Review> myReviews;
	
	/**
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the Reviewers First Name; not null.
	 * @param theLast String for the Reviewers Last Name; not null.
	 * @param theID String for the Reviewers ID (email); not null.
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
	 * @author Will Almond
	 * @param theSelection is an integer value for the paper selected (from console input). 
	 * @return a Review object for the current paper. 
	 */
	public Review submitReview(int theSelection) {
		Review currentReview = null;
		Paper tPaper = null;
		// Creates the Review object.
		if (theSelection != 0) {
			tPaper = myPaperList.get(theSelection - 1);

			currentReview = new Review(tPaper, this);
		}
		return currentReview;
	}
	
	/**
	 * Getter method for the Reviewers ID
	 * @author Jeremy Wolf
	 * @return a String for the Reviewer's email address.
	 * 
	 */
	public String getID() {
		return myID;
	}
	
	/**
	 * Adds a paper to the Reviewers list, will only add the paper if the Reviewer
	 * Paper Collection is < MAX_PAPERS.
	 * @author Jeremy Wolf
	 * @param thePaper a Paper object to be added to the Reviewers collection of papers. 
	 * @return a boolean true if the paper was successfully added.
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
	 * Getter method for the Paper collection.
	 * @author Jeremy Wolf
	 * @return a collection of Papers that belong to the Reviewer.
	 */
	public ArrayList<Paper> getPaperList() {
		return myPaperList;
		
	}
	
	/**
	 * Adds a review to the Review collection.
	 * @author Will Almond
	 * @param theRev is the review to be added to the list of Reviews
	 * that belong to the Reviewer.
	 */
	public void addReview(Review theRev) {
		myReviews.add(theRev);
	}


	/**
	 * Getter method for the Review list
	 * @author Will Almond
	 * @return myReviews is a list of Reviews that belongs to the Reviewer.
	 */
	public ArrayList<Review> getReviewList() {
		return myReviews;
	}
	
	/**
	 * Getter for a specific item in the review list.
	 * @author Will Almond
	 * @version 05/18/2016
	 * @param index is the index of the Reviews list that will be accessed.
	 * @return theReview is a single review that is retrieved from the Review list.
	 */
	public Review getReview(int index){
		Review theRev = myReviews.get(index);
		return theRev;
	}
}