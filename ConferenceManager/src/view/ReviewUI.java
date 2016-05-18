package view;

import java.util.Scanner;

import model.Paper;
import model.Review;

/**
 * UI class for the Review and all related menus.
 * @author Will Almond
 *
 */
public class ReviewUI {
	/** Create an instance of Review**/
	public Review myReview;
	/** Create an instance of Review**/
	public Paper myPaper;
	
	/**
	 * The menu that will open every time a new review is to be created or edited.
	 */
	public void reviewMenu(Review theReview){
		myReview = theReview;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			displayDetails();
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Type Review");
			System.out.println("2) Rate Paper");
			System.out.println("3) Submit Review");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			
			if(selection == 1) {
				typeReview();
			} else if (selection == 2) {
				rate();
			} else if (selection == 3) {
				submitReview();
			}
		}
	}
	/**
	 * Method to change the rating for the paper.
	 */
	private void rate(){
		int selection = -1;
		displayDetails();
		Scanner scannerRate = new Scanner(System.in);
	
		System.out.println("Select your numerical rating (1 - 10) for "+ myPaper.getTitle());
		selection = scannerRate.nextInt();
		System.out.println("The Paper was rated at a: " + selection);

		myReview.setRateing(selection);
		System.out.println("___________________________________________________\n");
	}
	/**
	 * Method to type the review of the paper.
	 */
	private void typeReview(){
		String text = null;
		Scanner scannerRev = new Scanner(System.in);
		displayDetails();
		System.out.println("Enter your review for " + myPaper.getTitle());
		text = scannerRev.nextLine();
		myReview.setComment(text);
		System.out.println("Review comment updated");
		System.out.println("___________________________________________________\n");

	}
	/**
	 * Displays the details that are printed at the top of each screen.
	 * @author Jeremy Wolf
	 */
	private void displayDetails(){
		
		System.out.println("MSEE System");
		System.out.println("Role: Reviewer");	
		System.out.println("Paper: " + myPaper.getTitle());
	}
	
	/**
	 * Submits the review when finished
	 * @author Jeremy Wolf
	 */
	private void submitReview() {
		myReview.submitReview();
		System.out.println("Review has been submitted");
		System.out.println("___________________________________________________\n");
	}
}
