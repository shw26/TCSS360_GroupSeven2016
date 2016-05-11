package view;

import java.util.Scanner;

import model.Author;
import model.Conference;
import model.ProgramChair;
import model.Reviewer;
import model.SubProgramChair;
import model.User;

public class ConferenceUI {
	
	public AuthorUI myAuthorUI;
	public ProgramChairUI myPCUI;
	public SubProgramChairUI mySCUI;
	public ReviewerUI myReviewerUI;
	public UserUI myUserUI;
	
	public ConferenceUI() {
		myAuthorUI = new AuthorUI();
		myPCUI = new ProgramChairUI();
		mySCUI = new SubProgramChairUI();
		myReviewerUI = new ReviewerUI();
		myUserUI = new UserUI();
	}
	/**
	 * menu for the conference level, User will choose a role here.
	 * @param theUser
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void confMenu(User theUser, Conference theConference){
		
		Scanner scanner = new Scanner(System.in);
		int selection = -1;
		System.out.println("User: " + theUser.getID());
		theConference.checkRoles(theUser);
		
		while(selection != 0) {
		
			System.out.println("Select a Role or submit a paper");
			
			if(theConference.myCurrentPC.getID().equals(theUser.getID())){
				System.out.println("1) Program Chair");
			}
			if(theConference.myCurrentSC != null){
				System.out.println("2) Subprogram Chair");
			}
			if(theConference.myCurrentReviewer != null){
				System.out.println("3) Reviewer");
			}
			if(theConference.myCurrentAuthor != null){
				System.out.println("4) Author");
			} else if (!theConference.isDeadlinePast()){
				//Will only show submit a paper when the Author role is not available. 
				System.out.println("5) Submit Paper");
			}
			System.out.println("0) Back");
			
			selection = scanner.nextInt();
			System.out.println("_________________________________________________\n");
			if(selection == 1){
				ProgramChair pC = theConference.myCurrentPC;
				myPCUI.pcMenu(theConference, pC);
			}
			if(selection == 2){
				SubProgramChair sC = theConference.myCurrentSC;
				mySCUI.scMenu(theConference, sC);
			}
			if(selection == 3){
				Reviewer reviewer = theConference.myCurrentReviewer;
				myReviewerUI.reviewerMenu(theConference, reviewer);
			}
			if(selection == 4){
				Author author = theConference.myCurrentAuthor;
				myAuthorUI.authorMenu(author, theConference);
			}
			if(selection == 5){
				theConference.submitPaper(theUser);
				
			}
			if(selection == 0){
				myUserUI.userMenu(theUser);
			}
		}
	}
}
