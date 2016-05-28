package view;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
import model.Review;

public class ReviewUI implements Serializable{

	
	private static final int SUBMIT_REVIEW = 1;
	private static final int RATE_PAPER = 2;
	
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
			
			if(selection == SUBMIT_REVIEW) {
				uploadReview();
			} else if (selection == RATE_PAPER) {
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
		myReview.setFile(pathOfReview);
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
