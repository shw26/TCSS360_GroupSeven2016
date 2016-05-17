package view;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

import model.Review;

public class ReviewUI implements Serializable{

	/**
	 * This is the serialized generated ID.
	 */
	private static final long serialVersionUID = 8166951857335269549L;

	/**
	 * Current Review
	 */
	private Review myReview;
	
	
	/**
	 * Constructor for ReviewUI
	 * @param theReview the Review Model
	 */
	public ReviewUI(Review theReview) {
		myReview = theReview;
	}
	
	/**
	 * The menu that will open every time a new review is to be created or edited.
	 */
	public void reviewMenu(){
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
				uploadReview();
			} else if (selection == 2) {
				rate();
			} else if (selection == 3) {
				submitReview();
			}
		}
	}
	private void rate() {
		Scanner scannerRate = new Scanner(System.in);
		int selection = -1;
		System.out.println("Select your numerical rating (1 - 10) for "+ myReview.getPaperName());
		selection = scannerRate.nextInt();
		System.out.println("The Paper was rated at a: " + selection);
		myReview.setRateing(selection);
		System.out.println("___________________________________________________\n");
		
	}

	public void uploadReview() {
		Scanner scanner = new Scanner(System.in);
		String pathOfReview;
		File theReview
		System.out.println("To submit a review, Enter desired path: ");
		System.out.println("(example: C:\\Windows\\System64\\Document\\manuscript)");
		pathOfReview = scanner.nextLine();
		thePaper.setFile(new File(pathOfReview));
		System.out.println("Upload Sucessful");
		System.out.println("___________________________________________________\n");
		scanner.close();
		
	}

	/**
	 * Displays the details that are printed at the top of each screen.
	 * @author Jeremy Wolf
	 */
	public void displayDetails(){
		
		System.out.println("MSEE System");
		System.out.println("Role: Reviewer");	
		System.out.println("Paper: " + myReview.getPaperName());
	}
	
	/**
	 * Submits the review when finished
	 * @author Jeremy Wolf
	 */
	public void submitReview() {
		myPaper.addReview(this);
		myRev.addReview(this);
		System.out.println("Review has been submitted");
		System.out.println("___________________________________________________\n");
	}
}
