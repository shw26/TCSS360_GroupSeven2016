package view;

//<<<<<<< HEAD
//import java.util.Scanner;
//
//import model.Paper;
//import model.Review;
//
///**
// * UI class for the Review and all related menus.
// * @author Will Almond
// *
// */
//public class ReviewUI {
//	/** Create an instance of Review**/
//	public Review myReview;
//	/** Create an instance of Review**/
//	public Paper myPaper;
//	
//	/**
//	 * The menu that will open every time a new review is to be created or edited.
//	 */
//	public void reviewMenu(Review theReview){
//		myReview = theReview;
//		int selection = -1;
//		Scanner scanner = new Scanner(System.in);
//		
//		while(selection != 0) {
//			displayDetails();
//		
//			System.out.println("Make a Selection: ");
//			System.out.println("1) Type Review");
//			System.out.println("2) Rate Paper");
//			System.out.println("3) Submit Review");
//			System.out.println("0) Back\n");
//			
//			
//			selection = scanner.nextInt();
//			System.out.println("___________________________________________________\n");
//			
//			if(selection == 1) {
//				typeReview();
//			} else if (selection == 2) {
//				rate();
//			} else if (selection == 3) {
//				submitReview();
//			}
//		}
//	}
//	/**
//	 * Method to change the rating for the paper.
//	 */
//	private void rate(){
//		int selection = -1;
//		displayDetails();
//		Scanner scannerRate = new Scanner(System.in);
//	
//		System.out.println("Select your numerical rating (1 - 10) for "+ myPaper.getTitle());
//		selection = scannerRate.nextInt();
//		System.out.println("The Paper was rated at a: " + selection);
//
//		myReview.setRateing(selection);
//		System.out.println("___________________________________________________\n");
//	}
//	/**
//	 * Method to type the review of the paper.
//	 */
//	private void typeReview(){
//		String text = null;
//		Scanner scannerRev = new Scanner(System.in);
//		displayDetails();
//		System.out.println("Enter your review for " + myPaper.getTitle());
//		text = scannerRev.nextLine();
//		myReview.setComment(text);
//		System.out.println("Review comment updated");
//		System.out.println("___________________________________________________\n");
//
//	}
//	/**
//	 * Displays the details that are printed at the top of each screen.
//	 * @author Jeremy Wolf
//	 */
//	private void displayDetails(){
//		
//		System.out.println("MSEE System");
//		System.out.println("Role: Reviewer");	
//		System.out.println("Paper: " + myPaper.getTitle());
//	}
//	
//	/**
//	 * Submits the review when finished
//	 * @author Jeremy Wolf
//	 */
//	private void submitReview() {
//		myReview.submitReview();
//		System.out.println("Review has been submitted");
//		System.out.println("___________________________________________________\n");
//=======
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
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
	 * Calendar object to determine date
	 */
	private Calendar myCalendar;
	
	
	/**
	 * Constructor for ReviewUI
	 * @param theReview the Review Model
	 */
	public ReviewUI(Review theReview) {
		myReview = theReview;
		myCalendar = Calendar.getInstance();
	}
	
	/**
	 * The menu that will open every time a new review is to be created or edited.
	 */
	public void reviewMenu(){
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			myCalendar = Calendar.getInstance();
			displayDetails();
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit a Review File");
			System.out.println("2) Rate Paper");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			
			if(selection == 1) {
				uploadReview();
			} else if (selection == 2) {
				rate();
			}
		}
		
	}
	public void rate() {
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
		System.out.println("To submit a review, Enter desired path: ");
		System.out.println("(example: C:\\Windows\\System64\\Document\\manuscript)");
		pathOfReview = scanner.nextLine();
		myReview.setFile(new File(pathOfReview));
		System.out.println("Upload Sucessful");
		System.out.println("___________________________________________________\n");
	
		
	}

	/**
	 * Displays the details that are printed at the top of each screen.
	 * @author Jeremy Wolf
	 */
	public void displayDetails(){
		
		System.out.println("MSEE System");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());
		System.out.println("Role: Reviewer");	
		System.out.println("Paper: " + myReview.getPaperName() + "\n");
//>>>>>>> refs/heads/Will2
	}
}
