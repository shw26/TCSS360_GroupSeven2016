package model;

/* 
 * Group Seven Project
 * TCSS360 - Spring 2016
 */
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import view.AuthorUI;
import view.PaperUI;

/**
 * Conference class.
 * 
 * @author Shao-Han Wang 
 * @version 5/1/2016
 */
public class Conference implements Serializable{

	private static final long serialVersionUID = -6224113936102614936L;
	
	/*
	 * the name of the conference.
	 */
	private String myName;
	
	/*
	 * the program chair of the conference.
	 */
	private ProgramChair myProgramChair;
	/*
	 * the list of subprogram chairs of the conference.
	 */
	private ArrayList<SubProgramChair> mySubprogramChairs;
	/*
	 * the list of reviewers of the conference.
	 */
	private ArrayList<Reviewer> myReviewers;
	/*
	 * the list of authors of the conference.
	 */
	private ArrayList<Author> myAuthors;
	/*
	 * the list of papers of the conference.
	 */
	private ArrayList<Paper> myPapers;
	
	/*
	 * if the user is a PC, then this will hold the info.
	 */
	private ProgramChair myCurrentPC;
	/*
	 * if the user is a SC, then this will hold the info.
	 */
	private SubProgramChair myCurrentSC;
	/*
	 * if the user is a Reviewer, then this will hold the info.
	 */
	private Reviewer myCurrentReviewer;
	/*
	 * if the user is a Author, then this will hold the info.
	 */
	private Author myCurrentAuthor;
	/*
	 * @author Will Almond
	 * Calendar object for each conference.
	 */
	private Calendar calendar;
	/*
	 * @author Will Almond
	 * Date object for each conference.
	 */
	private Date dueDate;
	/*
	 * @author Will Almond
	 * the number of days until papers are due.
	 */
	private int myDays;
	
	/* The User Interface for a paper object. */
	private PaperUI myPaperUI;
	

	
		
	/**
	 * Menu will call this constructor. 
	 * 
	 * @author Jeremy Wolf, Made changes to the constructor.
	 * 
	 * @param theName is the Title of the Conference.
	 * @param theProgramChair the Program Chair
	 * @param theUsers the list of Users
	 */
	public Conference(String theName, User thePC, ArrayList<User> theUsers, int theNumDayUntilDue){
		
		myName = theName;
		mySubprogramChairs = new ArrayList<SubProgramChair>();
		myPapers = new ArrayList<Paper>();
		myReviewers = new ArrayList<Reviewer>(); 
		myAuthors = new ArrayList<Author>();
		myProgramChair = new ProgramChair(thePC.getFirst(), thePC.getLast(), thePC.getID(), myPapers, mySubprogramChairs, theUsers, myReviewers);
		
		myCurrentPC = null;
		myCurrentSC = null;
		myCurrentReviewer= null;
		myCurrentAuthor = null;
		myDays = theNumDayUntilDue; 
		//Trying this calendar and setting the dueDates to 2 weeks later.
		calendar = Calendar.getInstance();
		setDueDate(calendar, myDays);
		myPaperUI = new PaperUI();
		
	}
	
	/**
	 * Check if the user is one of the roles.
	 * @param theUser 
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void checkRoles(User theUser){
		
		myCurrentSC = null;
		myCurrentReviewer= null;
		myCurrentPC = null;
		myCurrentAuthor = null;
		
		if(theUser.getID() == myProgramChair.getID()){
			myCurrentPC = myProgramChair;
		} 
		
		for(int i = 0; i < mySubprogramChairs.size(); i++){
			if(mySubprogramChairs.get(i).getID() == theUser.getID()){
				myCurrentSC = mySubprogramChairs.get(i);
			}
		}
		
		for(int i = 0; i < mySubprogramChairs.size(); i++){
			if(mySubprogramChairs.get(i).getID() == theUser.getID()){
				myCurrentSC = mySubprogramChairs.get(i);
				break;
			}
		}
		
		for(int i = 0; i < myReviewers.size(); i++){
			if(myReviewers.get(i).getID() == theUser.getID()){
				myCurrentReviewer = myReviewers.get(i);
				break;
			}
		}
		boolean isFound = false;
		for(int i = 0; i < myAuthors.size(); i++){
			if(myAuthors.get(i).getID() == theUser.getID()){
				myCurrentAuthor = myAuthors.get(i);
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			Author newAuthor = new Author(theUser.getFirst(), theUser.getLast(), theUser.getID(), this);
			myAuthors.add(newAuthor);
			myCurrentAuthor = newAuthor;
		}
		
	}
	
	/**
	 * getter for current Program Chair. return null if user is not a program chair.
	 * @return myCurrentPC
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ProgramChair getPC(){
		return myCurrentPC;
	}
	/**
	 * getter for current Subprogram Chair. return null if user is not a subprogram chair.
	 * @return myCurrentSC
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public SubProgramChair getSC(){
		return myCurrentSC;
	}
	/**
	 * getter for current Reviewer. return null if user is not a reviewer.
	 * @return myCurrentReviewer
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public Reviewer getReviewer(){
		return myCurrentReviewer;
	}
	/**
	 * getter for current Author. return null if user is not a author.
	 * @return myCurrentAuthor
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public Author getAuthor(){
		return myCurrentAuthor;
	}
	
	/**
	 * setter for Program Chair of the conference.
	 * for testing purpose.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void setThePC(ProgramChair thePC){
		myProgramChair = thePC;
	}
	/**
	 * setter for subprogram Chair list.
	 * for testing purpose.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void setSCList(ArrayList<SubProgramChair> theSCList){
		mySubprogramChairs = theSCList;
	}
	/**
	 * setter for Reviewer list.
	 * for testing purpose.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void setReviewerList(ArrayList<Reviewer> theRList){
		myReviewers = theRList;
	}
	/**
	 * setter for Author list.
	 * for testing purpose.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void setAuthorList(ArrayList<Author> theAList){
		myAuthors = theAList;
	}
	/**
	 * setter for Paper list.
	 * for testing purpose.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void setPaperList(ArrayList<Paper> thePList){
		myPapers = thePList;
	}
	
	/**
	 * getter for Program Chair of the conference.
	 * @return myProgramChair
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ProgramChair getThePC(){
		return myProgramChair;
	}
	/**
	 * getter for Subprogram Chair list.
	 * @return mySubprogramChairs
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ArrayList<SubProgramChair> getSCList(){
		return mySubprogramChairs;	
	}
	/**
	 * getter for Reviewer List.
	 * @return myReviewers
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ArrayList<Reviewer> getReviewerList(){
		return myReviewers;
	}
	/**
	 * getter for Author List.
	 * @return myAuthors
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ArrayList<Author> getAuthorList(){
		return myAuthors;
	}
	/**
	 * Getter for paper List.
	 * @return a collection of papers that have been submitted to this conference.
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ArrayList<Paper> getPaperList(){
		return myPapers;
	}
	
	/**
	 * Getter method for the Name of the conference.
	 * @return the conference name.
	 *
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * Add Papers to the Conference List.
	 * @param thePaper the paper to be added.
	 */
	public void addPaper(Paper thePaper) {
		myPapers.add(thePaper);
	}
	
	/**
	 * Remove a paper from the conference.
	 * @param thePaper to be removed
	 */
	public void removePaper(Paper thePaper) {
		myPapers.remove(thePaper);
	}
	/**
	 * Method to control the calendar for the Conference.
	 * @author Will Almond, Trevor Lowe
	 * 
	 */
	public void setDueDate(Calendar myCalendar, int days){
		Calendar theDueDate = myCalendar;
		theDueDate.add(Calendar.DAY_OF_MONTH, days);
		dueDate = theDueDate.getTime();
	}

	/**
	 * Returns true if deadline past
	 * 
	 * @return True if deadline past
	 */
	public boolean isDeadlinePast() {
		Date today = Calendar.getInstance().getTime();
		int value = today.compareTo(dueDate);
		return	value > 0;
	}
	
	/**
	 * Getter method for the due date.
	 * @return a Date object for the due date.
	 */
	public Date getDueDate() {
		return dueDate;	
	}
}
