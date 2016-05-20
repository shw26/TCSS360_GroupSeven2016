/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import view.PaperUI;

/**
 * Author class. This role can review papers.
 * 
 * @author Jeremy Wolf
 * @version v2 5/11/2016
 */
public class Author implements Serializable{
	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = 4146907723807800178L;

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
	
	/** The conference in which the author is held. */
	private Conference myConference;
	
	/** The User Interface for the paper class. */
	private PaperUI myPaperUI;
	

	
	/**
	 * Constructor for the Author.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 */
	public Author(String theFirst, String theLast, String theID, Conference theConference) {
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = new ArrayList<Paper>();
		myConference = theConference;
		myPaperUI = new PaperUI();
	}
	
	
	/**
	 * Allows an author to removed a paper.
	 * @author Jeremy Wolf
	 */
	public void unsubmit(Paper thePaper) {
		if (!myPaperList.isEmpty()) {
			myPaperList.remove(thePaper);
			myConference.removePaper(thePaper);
		}
	}	
	
	/**
	 * Allows an author to resubmit a paper.
	 * @author Jeremy Wolf
	 */ 
	public void edit(Paper thePaper) {		
		unsubmit(thePaper);
	    Paper temp = new Paper(myID);
	    myPaperUI.paperMenu(temp);
		addPaper(temp);
	}
	
	/**
	 * Adds the paper to be submitted to the list of papers the author has.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be added.
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		myConference.addPaper(thePaper);
}

	/**
	 * Getter method for myID	
	 * @author Jeremy Wolf	
	 * @return myID
	 */
	public String getID() {
		return myID;
	}

	/**
	 * Getter method for myPaperList.
	 * 
	 * @return the authors list of papers
	 */
	public ArrayList<Paper> getPapers() {
		return myPaperList;
	}

	/**
	 * Returns the selected paper from the authors list of papers.
	 * 
	 * @param theInt the number in the list of the paper being selected
	 * @return the author's paper being selected
	 */
	public Paper getAPaper(int theInt) {
		return myPaperList.get(theInt);
	}
}
