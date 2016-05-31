package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

	/* This is the serialized generated ID.*/
	private static final long serialVersionUID = -374717804308411534L;
	
	/* The name of the paper being reviewed */
	private String theName;
	/* A numerical rating that the reviewer will leave for the author. */
	private int myRateing;
	/* Comments that the reviewer will leave*/
	private String theComment;
	/* the ID of the reviewer for the heading */
	private String theID;
	/* The paper to be reviewed */
	private Paper myPaper;
	/* The Reviewer doing the review */
	private Reviewer myRev;
	/* The Review File */
	private String myFile;
	/* The User Interface for the Review class. */
	private ReviewUI myReviewUI;

	
	/**
	 * The constructor for Review class called every time 
	 * a new review is made on a paper.
	 * @param thePaper is the paper assigned to this Review.
	 * @param theRev is the Reviewer that wrote this Review.
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
	 * @return the Review UI to be used in console display.
	 */
	public ReviewUI getReviewUI() {
		return myReviewUI;
	}
	/**
	 * This method returns the conference name.
	 * @return a String representing the conference name; may be null.
	 */
	public String getConfName(){
		return theName;
	}
	
	/**
	 * Submits the review to the both the papers review list and the Reviewers list of reviews..
	 * @author Jeremy Wolf
	 */
	public void submitReview() {
		myPaper.addReview(this);
		myRev.addReview(this);
	}
	/**
	 * Gets the ID of the reviewer.
	 * @return a unique string value representing the reviewers ID.
	 */
	public String getTheID() {
		return theID;
	}
	/**
	 * Sets the id of the reviewer on this review.
	 * @param a unique string value representing the reviewers ID; can not be null.
	 */
	public void setTheID(String theID) {
		this.theID = theID;
	}
	/**
	 * Moves the submitted file to the System Review folder.
	 * @param a string representing the file path (source file).
	 */
	public boolean setFile(String theFile) {
		
		boolean fileSet = false;
		String newFilePath = ".\\Assets\\Reviews\\" + myPaper.getTitle() + "_" + theID + "Review.txt";
		try {
			Files.copy(Paths.get(theFile), Paths.get(newFilePath), StandardCopyOption.REPLACE_EXISTING);
			fileSet = true;
			myFile = newFilePath;
			
		} catch (IOException E) {
			fileSet = false;
		}
		return fileSet;
	}
		
	
	/**
	 * Getter method for the title of the paper.
	 * 
	 * @author Jeremy Wolf
	 * @return a string value for the title of the paper.
	 */
	public String getPaperName() {
		return myPaper.getTitle();
	}
	/**
	 * Gets the rating of the paper.
	 * @author Will Almond
	 * @return an integer value for a the rating.
	 */
	public int getRating() {
		return myRateing;
	}
	/**
	 * Sets the rating of the paper.
	 * @author Will Almond
	 * @param theRateing the integer value for the rating given to the paper.
	 */
	public void setRating(int theRating) {
		myRateing = theRating;
	}
}
