package view;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
import model.Paper;
import model.SubProgramChair;
import model.User;

public class SubProgramChairUI {

	private SubProgramChair mySubProgramChair;
	private Conference myConference;
	private Calendar myCalendar;
	
	public SubProgramChairUI() {
		myCalendar = Calendar.getInstance();
	}
	
	/**
	 * Displays the Menu options for the Sub-Program Chair.
	 * @author Jeremy Wolf
	 */
	public void scMenu(Conference theConference, SubProgramChair sC) {
		mySubProgramChair = sC;
		myConference = theConference;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			displayDetails();
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit a Recommendation");
			System.out.println("2) Assign Reviewer to a paper");
			System.out.println("0) Back\n");
		
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
			if(selection == 1) {
				submitRecommendation();
			} else if (selection == 2) {
				assignReviewer();
			}
		}
	}
	
	
	public void assignReviewer() {
		Paper tempPaper = null;
		displayDetails();
		int selection = displayPapers();
		if (selection != 0) {
			tempPaper = mySubProgramChair.getPaperList().get(selection - 1);
			displayDetails();
			System.out.println("Paper: " + tempPaper.getTitle() + "\n");
			selection = displayUsers();
			selection = mySubProgramChair.isAuthor(selection, tempPaper);
			
			if (selection == -1) {
				cantReview();
			} else if (selection == 1) {
				System.out.println("The paper has been assigned to the reviewer.");
			} else if (selection == 2) {
				System.out.println("A Reviewer can't have more then 4 papers");
			}
			System.out.println("___________________________________________________ \n");
		}
	}

	public void submitRecommendation() {
		int selection = 1;
		Scanner scanner = new Scanner(System.in);
		
		displayDetails();
		
		System.out.println("Select a paper to make a recommendation:");
		selection = displayPapers();
		System.out.println("___________________________________________________ \n");
		
		displayDetails();
		
		if (selection != 0) {
			Paper tempPaper = mySubProgramChair.getPaperList().get(selection - 1);
			System.out.println("Paper: " + tempPaper.getTitle());
			System.out.println("\nSelect Recommendation:");
			System.out.println("1) Recommend");
			System.out.println("2) Deny");
			System.out.println("0) Back");
	    	selection = scanner.nextInt();
	    	mySubProgramChair.makeRecommendation(selection, tempPaper);
	    	System.out.println("Recommendation submited");
		}
	}


	public int displayPapers() {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		displayDetails();
		System.out.println("Select a Paper to be Reviewed");
		
		for (Paper printPaper: mySubProgramChair.getPaperList()) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back\n");
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		
		return selection;
	}
	
	/**
	 * Displays the details to be on the top of the screen
	 * @author Jeremy Wolf
	 */
	public void displayDetails() {
		Date today = myCalendar.getTime();
		System.out.println("MSEE System");
		System.out.println("Date: " + today.toString());
		System.out.println("User: " + mySubProgramChair.getID());
		System.out.println("Role: Sub-ProgramChair");
	}
	
	/**
	 * Displays the Users to the console
	 * @author Jeremy Wolf
	 * @return an Int value for the menu selection.
	 */
	public int displayUsers() {
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		for (User tempUser: mySubProgramChair.getList()) {
			System.out.print(optionCounter + ") ");
			System.out.print(tempUser.getFirst() + " " + tempUser.getLast() + "\n");
			optionCounter++;
			}
		
		System.out.println("0) Back"); 
		selection = scanner.nextInt();
		return selection;
	}
	
	public void cantReview() {
		System.out.println("An Author can't review their own paper.");
		System.out.println("___________________________________________________ \n");	
	}
	
	public void canReview() {
		
	}

}
