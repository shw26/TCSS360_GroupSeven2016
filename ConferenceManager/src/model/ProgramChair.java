/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Program Chair class.
 * 
 * @author Jeremy Wolf
 * @version v1 4/30/2016
 */
public class ProgramChair implements Serializable {
	
	
	/*
	 * Max number of Papers assigned to a SubProgramChair
	 */
	public static final int MAX_PAPERS = 4;
	/*
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -5029928592171799831L;

	/*
	 * String representation the first name of the Program Chair.
	 */
	private String myFirstName;
	
	/*
	 * String representation of the Last of the Program Chair.
	 */
	private String myLastName;
	
	/*
	 * String representation of the ID of the Program Chair.
	 */
	private String myID;
	
	/*
	 * Collection containing a list of all papers under the Program Chair.
	 */
	private ArrayList<Paper> myPaperList;
	
	/*
	 * Collection containing a list of all SubProgramChairs under the Program Chair.
	 */
	private ArrayList<SubProgramChair> mySubList;
	
	/*
	 * Collection containing a list of all registered users.
	 */
	private ArrayList<User> myUserList;
	
	/*
	 * Collection containing a list of all Reviewers. 
	 */
	private ArrayList<Reviewer> myReviewers;
	
	/**
	 * Constructor for the Program Chair Class.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 * @param theList Collection of Papers
	 */
	public ProgramChair(String theFirst, String theLast, String theID, 
			ArrayList<Paper> theList, ArrayList<SubProgramChair> theSCs, 
			ArrayList<User> theUsers, ArrayList<Reviewer> theReviewers) {
		
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myPaperList = theList; // No deep copy since we want this to be connected by reference. 
		myUserList = theUsers; // No deep copy since we want this to be connected by reference. 
		mySubList = theSCs;
		myReviewers = theReviewers;
		
	}
	
	
	/**
	 * Allows the Program Chair to select SubProgram Chairs.
	 * The clients have to know the position of a user in a list of user.
	 * theSelection is the index of a user plus 1.
	 * @author Jeremy Wolf
	 * @param theSelection the position of a user in a list of user.
	 * @return 
	 */
	public SubProgramChair createSubProgramChair(int theSelection) {		
		User selectedUser = null;
		SubProgramChair createdSC = null;
		
		if(theSelection != 0) {
			selectedUser = myUserList.get(theSelection - 1);
			if (!isPresent(selectedUser)) {
			// Creates a new subprogram Chair
				createdSC = new SubProgramChair(selectedUser.getFirst(), selectedUser.getLast(),
										 selectedUser.getID(), myUserList, myReviewers);
				mySubList.add(createdSC);
			} else {
				for(SubProgramChair itrSC : mySubList) {
					if (selectedUser.getID().equals(itrSC.getID())) {
						createdSC = itrSC;
						break;
					}
				}
			}
		}
		return createdSC;
	}
	
	/**
	 * This will be called from a UI and assigns a paper to a subprogram chair.
	 * This will not check if the subprogram chair(theSC) is a author of the paper.
	 * The client have to know the position of the desire paper in the list of paper.
	 * theSelection is the index of a paper plus 1.
	 * The range of theSelection: 1 ~ size of the paper list.
	 * @param theSelection The selected paper from the list of papers for the subprogram chair(theSC)
	 * @param theSC the subprogram chair being given a paper
	 * @return boolean value, True if paper was assigned. 
	 */
	public boolean assignPaperToSC(int theSelection, SubProgramChair theSC) {
		boolean status = false;	
		Paper tPaper = myPaperList.get(theSelection - 1);
		if (theSC.getPaperList().size() < MAX_PAPERS && !tPaper.getAssigned()) {
			theSC.addPaper(tPaper);
			tPaper.setAssigned();
			status = true;
		}
		return status;
	}

	/**
	 * Check the Papers Author ID against the SubProgram Chairs ID. Ensures
	 * that the a SubProgram Chair can not assign reviewers to the paper.
	 * @param theSelection a integer value >= 0 and less than Paper List collection size.
	 * @param theSC the SubProgram Chair that the paper is to be assigned too.
	 * @return a boolean value, True if the SubProgam Chair is the Author of the Paper.
	 */
	public boolean isAuthor(int theSelection, SubProgramChair theSC) {
		boolean isTheAuthor = false;
		Paper tPaper = myPaperList.get(theSelection - 1);
		
		if (theSC.getID().equals(tPaper.getAuthor())) {
			isTheAuthor = true;
		}
		return isTheAuthor;
	}
	
	/**
	 * Checks to see if a User ID is already a SubProgramChair.
	 * @author Jeremy Wolf
	 * @param theUser the user we want to check, theUser has to be a registered user.
	 * @return isPresent true if the user(theUser) is a present subprogram chair, false if not.
	 */
	public boolean isPresent(User theUser) {
		boolean isPresent = false; 
		if (mySubList.isEmpty()) {
			isPresent =  false;
		} else {
			for(SubProgramChair tempSC : mySubList) {
				if (theUser.getID().equals(tempSC.getID())) {
					isPresent = true;
				}
			}
		}
		return isPresent;
	}
	
	/**
	 * Allows the Program Chair to make the final decision on a paper.
	 * @author Jeremy Wolf
	 * @param thePaper the paper we want to make accept/reject decision on.
	 * @param theSelection 1 for yes, the paper(thePaper) is accepted, 2 for rejected.
	 */
	public void makeFinal(Paper thePaper, int theSelection) {
		if (theSelection == 1) {
			thePaper.setFinal(true);
		} else if (theSelection == 2) {
			thePaper.setFinal(false);
		}
	}
	
	
	/**
	 * Getter method for the myID field.
	 * @author Jeremy Wolf
	 * @return myID the ID of this program chair.
	 */
	public String getID() {
		return myID;
	}
	
	/**
	 * Getter method for the list of Papers.
	 * @return myPaperList a list contains all submitted paper under this program chair.
	 */
	public ArrayList<Paper> getPapers() {
		return myPaperList;
	}


	/**
	 * Getter method for the User list
	 * @return myUserList a list contains all registered users.
	 */
	public ArrayList<User> getUsers() {
		return myUserList;
	}

	/**
	 * Getter method for the SubProgram Chair list
	 * @return mySubList the list contains all subprogram chairs under this program chair.
	 */
	public ArrayList<SubProgramChair> getSCs() {
		return mySubList;
	}
}
