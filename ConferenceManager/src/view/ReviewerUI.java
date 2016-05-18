package view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
import model.Paper;
import model.Review;
import model.Reviewer;

public class ReviewerUI implements Serializable{

	/**
	 * Serial Version ID for persistent storage use
	 */
	private static final long serialVersionUID = -2724271279682667805L;
	
	/**
	 * The Reviewer model object
	 */
	private Reviewer myReviewer;
	
	/**
	 * The Current Conference
	 */
	private Conference myConference;
	
	/**
	 * The calendar to determine the date.
	 */
	private Calendar myCalendar;
	
	/**
	 * Displays the Menu options for the Reviewer.
	 * @author Jeremy Wolf
	 */
	public void reviewerMenu(Conference theConference, Reviewer theReviewer) {
		myReviewer = theReviewer;
		myConference = theConference;
		
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			myCalendar = Calendar.getInstance();
			printDetails();
			System.out.println("Make a Selection: ");
			System.out.println("1) View Papers");
			System.out.println("2) Review a Paper");
			System.out.println("3) View Reviews");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			
			if(selection == 1) {
				viewPapers();
			} else if (selection == 2) {
				submitReview();
			} else if (selection == 3) {
				viewReviews();
			} 
		}
	}
	
	public void submitReview() {
		int optionCounter = 1;
		int selection = -1;
	
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Select a Paper to be Reviewed:");
		
		// Displays the papers to the console 
		for (Paper tempPaper : myReviewer.getPaperList()) {
			System.out.print(optionCounter + ") ");
			System.out.print(tempPaper.getTitle()+ "\n");
			optionCounter++;
		}
		
		// User selects paper to be reviewed.
		selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
		myReviewer.submitReview(selection);
	}

	public void viewReviews() {
		Scanner scanner = new Scanner(System.in);
		if (!myReviewer.getReviewList().isEmpty()) {
			for (Review rev : myReviewer.getReviewList()) {
				System.out.println("Title: " + rev.getPaperName());
				System.out.println("\tThe rating was: " + rev.theRateing);
			}
			System.out.println("Press 0 to go back");
			int selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
		} else { 
			System.out.println("You have no reviews to view");
			System.out.println("___________________________________________________\n");
		}
	}
	
	/**
	 * Prints the details to print at the top of the screen.
	 * @author Jeremy Wolf
	 */
	public void printDetails() {
		System.out.println("MSEE Syystem");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());
		System.out.println("User: " + myReviewer.getID());
		System.out.println("Role: Reviewer" + "\n");
	}
	
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	public void viewPapers() {
		int optionCounter = 1;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Currently Assigned Papers: ");
		for (Paper printPaper: myReviewer.getPaperList() ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");
		int selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
	}

}
