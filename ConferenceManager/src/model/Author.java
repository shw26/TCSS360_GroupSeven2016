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

	

	
	/**
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name; not null
	 * @param theLast String for the Last Name; not null
	 * @param theID String for the ID; not null
	 * @param theConference Conference where Author is held; not null
	 */
	public Author(String theFirst, String theLast, String theID, Conference theConference) {
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = new ArrayList<Paper>();
		myConference = theConference;
	}
	
	
	/**
	 * Removes (thePaper) from the Author's Paper collection and the Conference (thePaper) was submitted to.
	 * @author Jeremy Wolf
	 * @param thePaper A Paper Object; not null
	 */
	public void unsubmit(Paper thePaper) {
		if (!myPaperList.isEmpty()) {
			myPaperList.remove(thePaper);
			myConference.removePaper(thePaper);
			
			assert myPaperList.contains(thePaper);
		}
	}	
	
	/**
	 * Allows an author to edit the title of a paper.
	 * @author Jeremy Wolf
	 * @param thePaper the paper object that will have the title changed; not null
	 * @param theTitle a string for the new title; not null 
	 */ 
	public void edit(Paper thePaper, String theTitle) {		
		thePaper.setTitle(theTitle);
		
		assert thePaper.getTitle().equals(theTitle);
	}
	
	/**
	 * Adds the paper to be submitted to the list of papers the author has and the conference.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be added; not null
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		myConference.addPaper(thePaper);
		
		assert myPaperList.contains(thePaper);
		assert myConference.getPaperList().contains(thePaper);
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
	 * @param theInt the number in the list of the paper being selected; greater than or equal to 0, less than size of the paper collection
	 * @return the author's paper being selected by (theInt) index in the collection
	 */
	public Paper getAPaper(int theInt) {
		return myPaperList.get(theInt);
	}
}
