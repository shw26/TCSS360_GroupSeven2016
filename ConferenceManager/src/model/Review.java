package model;

import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * Review Class 
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */
public class Review implements Serializable{

	/**
	 * This is the serialized generated ID.
	 */
	private static final long serialVersionUID = -374717804308411534L;
	/* The name of the paper being reviewed */
	private String theName;
	/* A numerical rating that the reviewer will leave for the author. */
	private int theRateing;
	/* Comments that the reviewer will leave*/
	private String theComment;
	/* the ID of the reviewer for the heading */
	private String theID;
	/* The paper to be reviewed */
	private Paper myPaper;
	/* The Reviewer doing the review */
	private Reviewer myRev;
	
	/**
	 * The constructor for Review class called every time 
	 * a new review is made on a paper.
	 * @param id
	 */
	public Review(String id, Paper thePaper, Reviewer theRev){
		theID = id;
		myPaper = thePaper;
		myRev = theRev;
	}



	/**
	 * This method returns the conference name.
	 * @return theName
	 */
	public String getConfName(){
		return theName;
	}
	
	/**
	 * Subprogram chairs and authors will need to use this to view the comments.
	 * @return theComment
	 */
	public String getComment(){
		return theComment;
	}
	/**
	 * The Program Chair will use this method to view the rateing. 
	 * @return theRateing
	 */
	public int getRateing(){
		return getTheRateing();
	}
	/**
	 * This method will be used when creating a conference.
	 * @param name
	 */
	public void setConfName(String name){
		theName = name;
	}
	/**
	 * The reviewer will need to comment on each paper and will use this method.
	 * @param comment
	 */
	public void setComment(String comment){
		theComment = comment;
	}
	/**
	 * When the reviewer desires to set a rating they will call this method.
	 * @param rateing
	 */
	public void setRateing(int rateing){
		setTheRateing(rateing);
	}
	/**
	 * toString method to display the review in a uniform instance.
	 */
	public String toString(){
		StringBuilder myString = new StringBuilder();
		return myString.toString();
	}
	/**
	 * Submits the review when finished
	 * @author Jeremy Wolf
	 */
	public void submitReview() {
		myPaper.addReview(this);
		myRev.addReview(this);
	}
	
	/**
	 * Getter method for the title of the paper.
	 * @author Jeremy Wolf
	 * @return the title of the paper.
	 */
	public String getPaperName() {
		return myPaper.getTitle();
	}
	/**
	 * Gets the rating
	 * @author Will Almond
	 * @return
	 */
	public int getTheRateing() {
		return theRateing;
	}



	public void setTheRateing(int theRateing) {
		this.theRateing = theRateing;
	}
}
