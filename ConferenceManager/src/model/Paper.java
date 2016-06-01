package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	
	// -- Constants --
	
	/* Serial Version ID. */
	private static final long serialVersionUID = -1356721982552780326L;
	

	// -- Fields --
	
	/* The contact author of the paper. */
	private String myAuthor;
	
	/* A List of Reviews by Reviewers. */
	private List<Review> myReviews;
	
	/* True if recommendation has been made. */
	private boolean myRecommendation;
	
	/* True if final decision has been made. */
	private boolean myFinal;
	
	/* The Title of the Paper. */
	private String myTitle;
	
	/* The Path for the Paper file. */
	private String myFile;
	
	/* Boolean value for if the paper has already been assigned to a SubProgram Chair*/
	private Boolean myAssigned; 
	
	// -- Constructors --
	
	/**
	 * @param name - the contact author for the paper; not null
	 */
	public Paper(String name) {	
		myTitle = "";
		myFile = null;
		myAuthor =  name;
		myReviews = new LinkedList<Review>();
		myRecommendation = false;
		myFinal = false;
		myAssigned = false;
	}
	
	/**
	 * TEST ONLY
	 * Creates a new paper object with a title and authors ID
	 * @param theTitle - the string for the papers title; not null
	 * @param theAuthor - the String for the Authors ID; not null
	 * @author Jeremy Wolf
	 */
	public Paper(String theTitle, String theAuthor) {
		myTitle = theTitle;
		myFile = null;
		myAuthor =  theAuthor;
		myReviews = new LinkedList<Review>();
		myRecommendation = false;
		myFinal = false;
	}
	
	
	// -- Methods (Mutator) --
	
	/**
	 * Sets the recommendation status of a paper.
	 * True if recommendation made.
	 * @param newRecommendation - recommendation status
	 */
	public void setRecommendation(boolean newRecommendation) {
		this.myRecommendation = newRecommendation;
	}
	
	/**
	 * Sets the Reviews for a paper.
	 * @param newReviews - the reviews for a paper; not null
	 */
	public void setReviews(List<Review> newReviews) {
		this.myReviews = newReviews;
	}
	
	/**
	 * Sets the final decision status of a paper.
	 * True if final decision made.
	 * @param newFinal - the new final decision status for a paper
	 */
	public void setFinal(boolean newFinal) {
		this.myFinal = newFinal;
	}
	
	/**
	 * Sets the file for a paper.
	 * @param newFile - file for the paper; not null
	 */
	public boolean setFile(String theFile) {
		boolean fileSet = false;
		String newFilePath = ".\\Assets\\" + myTitle + ".txt";
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
	 * Sets the title for a paper
	 * @param newTitle - title of paper; not null
	 */
	public void setTitle(String newTitle) {
		this.myTitle = newTitle;
	}
	
	/**
	 * Add Review to paper.
	 * @param theRev - The review being added; not null
	 */
	public void addReview(Review theRev) {
		myReviews.add(theRev);
	}
	
	
	// -- Methods (Accessor) --
	
	/**
	 * Returns the contact author of the paper.
	 * @return contact author of paper
	 */
	public String getAuthor() {
		return this.myAuthor;
	}
	
	
	/**
	 * Returns the recommendation status of the paper.
	 * True if recommendation made.
	 * @return recommendation status of paper
	 */
	public boolean getRecommendation() {
		return this.myRecommendation;
	}
	
	/**
	 * Returns a list of the reviews on a paper.
	 * @return list of reviews on paper
	 */
	public List<Review> getReviews() {
		return this.myReviews;
	}
	
	/**
	 * Returns the final decision status on a paper.
	 * True if final decision made.
	 * @return final decision status of paper
	 */
	public boolean getFinal() {
		return this.myFinal;
	}

	/**
	 * Returns the Title of the paper.
	 * @return Title of the paper
	 */
	public String getTitle() {
		return myTitle;
	}
	
	/**
	 * Returns the File path.
	 * @return File path of paper
	 * @author Jeremy Wolf
	 */
	public String getFile() {
		return myFile;
	}
	
	/**
	 * Sets the myAssigned field to true if the paper has been assigned to a subprogram chair 
	 * already.
	 */
	public void setAssigned() {
		myAssigned = true;
	}
	
	/**
	 * Gets the myAssigned field to evaluate if the paper has been assigned to a subprogram chair 
	 * already.
	 */
	public boolean getAssigned() {
		return myAssigned;
	}
}
