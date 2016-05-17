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
	public String theName;
	/* A numerical rating that the reviewer will leave for the author. */
	public int theRateing;
	/* Comments that the reviewer will leave*/
	public String theComment;
	/* the ID of the reviewer for the heading */
	public String theID;
	/* The paper to be reviewed */
	public Paper myPaper;
	/* The Reviewer doing the review */
	public Reviewer myRev;
	
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
	 * Method to type the review of the paper.
	 */
	private void uploadReview(File theReview){
		String text = null;
		Scanner scannerRev = new Scanner(System.in);
		displayDetails();
		System.out.println("Enter your review for " + myPaper.getTitle());
		text = scannerRev.nextLine();
		setComment(text);
		System.out.println("Review comment updated");
		System.out.println("___________________________________________________\n");

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
		return theRateing;
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
		theRateing = rateing;
	}
	/**
	 * toString method to display the review in a uniform instance.
	 */
	public String toString(){
		StringBuilder myString = new StringBuilder();
		return myString.toString();
	}
	
	
	
	/**
	 * Getter method for the title of the paper.
	 * @author Jeremy Wolf
	 * @return the title of the paper.
	 */
	public String getPaperName() {
		return myPaper.getTitle();
	}
}
