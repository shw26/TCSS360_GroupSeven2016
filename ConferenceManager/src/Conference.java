/* 
 * Group Seven Project
 * TCSS360 - Spring 2016
 */
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Conference class.
 * 
 * @author Shao-Han Wang 
 * @version 5/1/2016
 */
public class Conference implements Serializable{
	
	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -6224113936102614936L;
	
	/**
	 * the program chair of the conference.
	 */
	public ProgramChair myProgramChair;
	/**
	 * the list of subprogram chairs of the conference.
	 */
	public ArrayList<SubprogramChair> mySubprogramChairs;
	/**
	 * the list of reviewers of the conference.
	 */
	public ArrayList<Reviewer> myReviewers;
	/**
	 * the list of authors of the conference.
	 */
	public ArrayList<Author> myAuthors;
	/**
	 * the list of papers of the conference.
	 */
	public ArrayList<Paper> myPapers;
	
	/**
	 * if the user is a PC, then this will hold the info.
	 */
	public ProgramChair myCurrentPC;
	/**
	 * if the user is a SC, then this will hold the info.
	 */
	public SubprogramChair myCurrentSC;
	/**
	 * if the user is a Reviewer, then this will hold the info.
	 */
	public Reviewer myCurrentReviewer;
	/**
	 * if the user is a Author, then this will hold the info.
	 */
	public Author myCurrentAuthor;
	
	/**
	 * might not be using this constructor.
	 * @param theUser
	 */
	public Conference(User theUser) {
		mySubprogramChairs = new ArrayList<SubprogramChair>();
		myPapers = new ArrayList<Paper>();
		myReviewers = new ArrayList<Reviewer>();
		myAuthors = new ArrayList<Author>();
		
		myCurrentPC = null;
		myCurrentSC = null;
		myCurrentReviewer= null;
		myCurrentAuthor = null;
		checkRoles(theUser);
		
		confMenu(theUser);
	}
	
	/**
	 * Menu will call this constructor.
	 * 
	 * @param theProgramChair the Program Chair
	 * @param theSubprogramChairs the list of Subprogram Chairs
	 * @param theReviewers the list of Reviewers
	 * @param theAuthors  the list of Authors
	 * @param thePapers  the list of Papers
	 */
	public Conference(ProgramChair theProgramChair, ArrayList<SubprogramChair> theSubprogramChairs,
			ArrayList<Reviewer> theReviewers, ArrayList<Author> theAuthors,
			ArrayList<Paper> thePapers){
		
		myProgramChair = theProgramChair;
		mySubprogramChairs = theSubprogramChairs;
		myPapers = thePapers;
		myReviewers = theReviewers;
		myAuthors = theAuthors;
		
		myCurrentPC = null;
		myCurrentSC = null;
		myCurrentReviewer= null;
	}
	
	/**
	 * Check if the user is one of the roles.
	 * @param theUser 
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	private void checkRoles(User theUser){
		
		if(theUser.getID() == ProgramChair.getID()){
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
		
		for(int i = 0; i < myAuthors.size(); i++){
			if(myAuthors.get(i).getID() == theUser.getID()){
				myCurrentAuthor = myAuthors.get(i);
				break;
			}
		}
	}
	
	/**
	 * menu for the conference level, User will choose a role here.
	 * @param theUser
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public void confMenu(User theUser){
		Scanner scanner = new Scanner(System.in);
		int selection = -1;
		
		checkRoles(theUser);
		
		while(selection < 0 || selection >5)
		
		System.out.println("Select a Role or submit a paper");
		
		if(myCurrentPC != null){
			System.out.println("1) Program Chair");
		}
		if(myCurrentSC != null){
			System.out.println("2) Subprogram Chair");
		}
		if(myCurrentReviewer!= null){
			System.out.println("3) Reviewer");
		}
		if(myCurrentAuthor!= null){
			System.out.println("4) Author");
		}
		System.out.println("5) Submit Paper");
		System.out.println("0) Back");
		
		selection = scanner.nextInt();
		
		if(selection == 1){
			myCurrentPC.pcMenu();
		}
		if(selection == 2){
			myCurrentSC.scMenu();
		}
		if(selection == 3){
			myCurrentReviewer.reviewerMenu();
		}
		if(selection == 4){
			myCurrentAuthor.AuthorMenu();
		}
		if(selection == 5){
			submitPaper();
		}
		if(selection == 0){
			theUser.userMenu();
		}
		
	}
	
	/**
	 * load file and make a new Paper and add it to the list.
	 * (may need to change the constructor of paper)
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	private void submitPaper(){
		Scanner scanner = new Scanner(System.in);
		String pathOfPaper;
		System.out.println("To submit a paper, Enter desired path: ");
		System.out.println("(example: C:\\Windows\\System64\\Document\\manuscript)");
		pathOfPaper = scanner.nextLine();
		File file = new File(pathOfPaper);
		
		Paper newPaper = new Paper("new paper");
		//Paper newPaper = new Paper(file);
		myPapers.add(newPaper);
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
	public SubprogramChair getSC(){
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
	public void setSCList(ArrayList<SubprogramChair> theSCList){
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
	public ArrayList<SubprogramChair> getSCList(){
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
	 * getter for paper List.
	 * @return myPapers
	 * @author Shao-Han Wang 
	 * @version 5/1/2016
	 */
	public ArrayList<Paper> getPaperList(){
		return myPapers;
	}
	
}





