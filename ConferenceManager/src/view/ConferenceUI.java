package view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Author;
import model.Conference;
import model.ProgramChair;
import model.Reviewer;
import model.SubProgramChair;
import model.User;

public class ConferenceUI implements Serializable{
	
	
	private static final int PROGRAMCHAIR = 1;
	
	private static final int SUBPROGRAMCHAIR = 2;
	
	private static final int REVIEWER = 3;
	
	private static final int AUTHOR = 4;
	
	/**
	 * Serial ID for Storage
	 */
	private static final long serialVersionUID = -625244184685421177L;
	
	/**
	 * AuthorUI Object
	 */
	public AuthorUI myAuthorUI;
	/**
	 * Program Chair UI Object
	 */
	public ProgramChairUI myPCUI;
	/**
	 * SubProgram Chair UI object
	 */
	public SubProgramChairUI mySCUI;
	
	/**
	 * Reviewer UI object
	 */
	public ReviewerUI myReviewerUI;
	
	/**
	 * Calendar Object
	 */
	private Calendar myCalendar;

	/** Instantiates a new Conference User Interface object. **/
	public ConferenceUI() {
		myAuthorUI = new AuthorUI();
		myPCUI = new ProgramChairUI();
		mySCUI = new SubProgramChairUI();
		myReviewerUI = new ReviewerUI();
		myCalendar = Calendar.getInstance();
	}
	/**
	 * menu for the conference level, User will choose a role here.
	 * @param theUser
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void confMenu(User theUser, Conference theConference){
		
		
		int selection = -1;
		printDetails(theUser);
		theConference.checkRoles(theUser);
		
		while(selection != 0) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Select a Role or submit a paper");
			
			if(theConference.getPC() != null){
				System.out.println("1) Program Chair");
			}
			if(theConference.getSC() != null){
				System.out.println("2) Subprogram Chair");
			}
			if(theConference.getReviewer() != null){
				System.out.println("3) Reviewer");
			}
			if(theConference.getAuthor() != null){
				System.out.println("4) Author");
			} 
			
			System.out.println("0) Back");
			
			selection = scanner.nextInt();
			
			System.out.println("_________________________________________________\n");
			if(selection == PROGRAMCHAIR){
				ProgramChair pC = theConference.getPC();
				myPCUI.pcMenu(theConference, pC);
			}
			if(selection == SUBPROGRAMCHAIR){
				SubProgramChair sC = theConference.getSC();
				mySCUI.scMenu(theConference, sC);
			}
			if(selection == REVIEWER){
				Reviewer reviewer = theConference.getReviewer();
				myReviewerUI.reviewerMenu(theConference, reviewer);
			}
			if(selection == AUTHOR){
				Author author = theConference.getAuthor();
				myAuthorUI.authorMenu(author, theConference);
			}

		}
	}
	
	/**
	 * Prints the details regarding a user.
	 * 
	 * @param theUser the user whose details are to be printed
	 */
	public void printDetails(User theUser) {
		System.out.println("MSEE System");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());
		System.out.println("User: " + theUser.getID() + "\n");
	}
}
