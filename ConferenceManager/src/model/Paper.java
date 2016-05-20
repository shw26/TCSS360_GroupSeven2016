package model;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Holds the data for a paper used in the conference.
 * 
 * @author Trevor N. Lowe
 * @version 1 : 5/1/16
 */
public class Paper implements Serializable {
	
	/** Serial Version ID.*/
	private static final long serialVersionUID = -1356721982552780326L;
	

	// -- Fields --
	
	/** The contact author of the paper. **/
	private String myAuthor;
	
	/** A List of Reviews by Reviewers. **/
	private List<Review> myReviews;
	
	/** True if recommendation has been made. **/
	private boolean myRecommendation;
	
	/** True if final decision has been made. **/
	private boolean myFinal;
	
	/** The Title of the Paper **/
	private String myTitle;
	
	/** The Paper file **/
	private File myFile;
	
	
	// -- Constructors --
	
	/**
	 * Creates a new Paper object from an author's name.
	 * 
	 * @param name the contact author for the paper
	 */
	public Paper(String name) {
		
		myTitle = "";
		myFile = null;
		myAuthor =  name;
		myReviews = new LinkedList<Review>();
		myRecommendation = false;
		myFinal = false;
	}
	
	
	// -- Methods (Mutator) --
	
	/**
	 * Sets the recommendation status of a paper.
	 * True if recommendation made.
	 * 
	 * @param newRecommendation recommendation status
	 */
	public void setRecommendation(boolean newRecommendation) {
		this.myRecommendation = newRecommendation;
	}
	
	/**
	 * Sets the Reviews for a paper.
	 * 
	 * @param newReviews the reviews for a paper
	 */
	public void setReviewers(List<Review> newReviews) {
		this.myReviews = newReviews;
	}
	
	/**
	 * Sets the final decision status of a paper.
	 * True if final decision made.
	 * 
	 * @param newFinal
	 */
	public void setFinal(boolean newFinal) {
		this.myFinal = newFinal;
	}
	
	/**
	 * Sets the file for a paper.
	 * 
	 * @param newFile file for the paper
	 */
	public void setFile(File newFile) {
		this.myFile = newFile;
	}
	
	/**
	 * Sets the title for a paper
	 * 
	 * @param newTitle title of paper
	 */
	public void setTitle(String newTitle) {
		this.myTitle = newTitle;
	}
	
	/**
	 * Add Review to paper.
	 * 
	 * @param The review being added
	 */
	public void addReview(Review theRev) {
		myReviews.add(theRev);
	}
	
	
	// -- Methods (Accessor) --
	
	/**
	 * Returns the contact author of the paper.
	 * 
	 * @return contact author of paper
	 */
	public String getAuthor() {
		return this.myAuthor;
	}
	
	
	/**
	 * Returns the recommendation status of the paper.
	 * True if recommendation made.
	 * 
	 * @return recommendation status of paper
	 */
	public boolean getRecommendation() {
		return this.myRecommendation;
	}
	
	/**
	 * Returns a list of the reviews on a paper.
	 * 
	 * @return list of reviews on paper
	 */
	public List<Review> getReviews() {
		return this.myReviews;
	}
	
	/**
	 * Returns the final decision status on a paper.
	 * True if final decision made.
	 * 
	 * @return final decision status of paper
	 */
	public boolean getFinal() {
		return this.myFinal;
	}

	/**
	 * Returns the Title of the paper.
	 * 
	 * @return Title of the paper
	 */
	public String getTitle() {
		return myTitle;
	}
	
	/**
	 * Returns the File path.
	 * @author Jeremy Wolf
	 */
	public File getFile() {
		return myFile;
	}
}
