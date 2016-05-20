package model;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

import view.ReviewUI;

/**
 * 
 * Review Class 
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */
public class Review implements Serializable{

	/** This is the serialized generated ID.*/
	private static final long serialVersionUID = -374717804308411534L;
	
	/** The name of the paper being reviewed */
	private String theName;
	/** A numerical rating that the reviewer will leave for the author. */
	private int theRateing;
	/** Comments that the reviewer will leave*/
	private String theComment;
	/** the ID of the reviewer for the heading */
	private String theID;
	/** The paper to be reviewed */
	private Paper myPaper;
	/** The Reviewer doing the review */
	private Reviewer myRev;
	/** The Review File */
	private File myFile;
	/** The User Interface for the Review class. */
	private ReviewUI myReviewUI;

	
	/**
	 * The constructor for Review class called every time 
	 * a new review is made on a paper.
	 * @param
	 */
	public Review(Paper thePaper, Reviewer theRev){// removed String id to prevent errors 05/18/2016.
		theID = theRev.getID();
		myPaper = thePaper;
		myRev = theRev;
		myFile = null;
		myReviewUI = new ReviewUI(this);
	}
	/**
	 * Getter method for the ReviewUI
	 */
	public ReviewUI getReviewUI() {
		return myReviewUI;
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
	 * The Program Chair will use this method to view the rating. 
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
//	/**
//	 * toString method to display the review in a uniform instance.
//	 */
//	public String toString(){
//		StringBuilder myString = new StringBuilder();
//		return myString.toString();
//	}
	/**
	 * Submits the review when finished.
	 * @author Jeremy Wolf
	 */
	public void submitReview() {
		myPaper.addReview(this);
		myRev.addReview(this);

	}
	/**
	 * Gets the ID of the reviewer.
	 * @return theID
	 */
	public String getTheID() {
		return theID;
	}
	/**
	 * Sets the id of the reviewer on this review.
	 * @param theID
	 */
	public void setTheID(String theID) {
		this.theID = theID;
	}
	/**
	 * Sets the file for the review
	 * @param theFile the review file.
	 */
	public void setFile(File theFile) {
		this.myFile = theFile;
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
	 * Gets the rating of the paper.
	 * @author Will Almond
	 * @return
	 */
	public int getTheRateing() {
		return theRateing;
	}
	/**
	 * Sets the rating of the paper.
	 * @author Will Almond
	 * @param theRateing
	 */
	public void setTheRateing(int theRateing) {
		this.theRateing = theRateing;
	}
}
