package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Conference;
import model.Paper;
import model.Review;
import model.Reviewer;

public class ReviewerUI {
	private Conference myConference;
	private Reviewer myReviewer;
	private ArrayList<Paper> myPaperList;
	private ArrayList<Review> myReviews;
	private ReviewUI reviewUI;
	public void reviewerMenu(Conference theConference, Reviewer reviewer) {
		myConference = theConference;
		myReviewer = reviewer;
		myPaperList = reviewer.getPaperList();
		myReviews = reviewer.getReviewList();
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
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
	public void viewReviews() {
		Scanner scanner = new Scanner(System.in);
		if (!myReviews.isEmpty()) {
			for (Review rev : myReviews) {
				System.out.println("Title: " + rev.getPaperName());
				System.out.println("\tThe rating was: " + rev.getTheRateing());
				System.out.println("\tThe review comment was: ");
				System.out.println("\t" + rev.getComment() + "\n");
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
	 * Allows the Reviewer to submit a review
	 * @author Jeremy Wolf
	 */
	private void submitReview() {
		int optionCounter = 1;
		int selection = -1;
		Paper tPaper = null;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Select a Paper to be Reviewed:");
		
		// Displays the papers to the console 
		for (Paper tempPaper : myPaperList) {
			System.out.print(optionCounter + ") ");
			System.out.print(tempPaper.getTitle()+ "\n");
			optionCounter++;
		}
		
		// User selects paper to be reviewed.
		selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
		
		// Creates the Review object.
		if (selection != 0) {
			tPaper = myPaperList.get(selection - 1);
			Review currentReview = myReviewer.submitReview(tPaper);
			reviewUI.reviewMenu(currentReview);

		}
	}
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	private void viewPapers() {
		int optionCounter = 1;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Currently Assigned Papers: ");
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");
		int selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
	}
	/**
	 * Prints the details to print at the top of the screen.
	 * @author Jeremy Wolf
	 */
	private void printDetails() {
		System.out.println("MSEE Syystem");
		System.out.println("User: " + myReviewer.getID());
		System.out.println("Role: Reviewer");
	}

}
