package view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Author;
import model.Conference;
import model.Paper;
import model.Review;

public class AuthorUI implements Serializable{

	
	private static final int SUBMIT = 1;
	private static final int UNSUBMIT = 2;
	private static final int RESUBMIT = 3;
	private static final int VIEW_REVIEWS = 4;
	private static final int EDIT = 5;
	
	/**
	 * Serial ID for storage
	 */
	private static final long serialVersionUID = -9055603173113374284L;
	
	/**
	 * Calendar object to determine date
	 */
	private Calendar myCalendar;
	
	/**
	 * Paper UI Object
	 */
	private PaperUI myPaperUI;
	
	/**
	 * the Current Conference object.
	 */
	private Conference myConference;
	
	/**
	 * Displays the Menu options for the Author.
	 * @author Jeremy Wolf
	 */
	public void authorMenu(Author theAuthor, Conference theConference) {
		myCalendar = Calendar.getInstance();
		myPaperUI = new PaperUI();
		int selection = -1;
		Author currentAuthor = theAuthor;
		myConference = theConference;
		boolean isPastDueDate = false;
		Scanner scanner = new Scanner(System.in);
		
		
		while(selection != 0) {
			printDetails(theAuthor);
			isPastDueDate = theConference.isDeadlinePast();
			if (!isPastDueDate) {
				System.out.println("Make a Selection: ");
				System.out.println("1) Submit");
				System.out.println("2) Un-Submit");
				System.out.println("3) Resubmit");
				System.out.println("4) View Reviews");
				System.out.println("5) Edit");
				System.out.println("0) Back\n");
			} else {
				System.out.println("Deadline for submission has passed ");
				System.out.println("Make a Selection: ");
				System.out.println("2) Un-Submit");
				System.out.println("4) View Reviews");
				System.out.println("0) Back\n");
			}
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			

			if(selection == SUBMIT && !isPastDueDate) {
			    Paper temp = new Paper(currentAuthor.getID());
			    myPaperUI.paperMenu(temp);
			    currentAuthor.addPaper(temp);
			} else if (selection == UNSUBMIT) {
				unsubmit(currentAuthor);
			} else if (selection == RESUBMIT && !isPastDueDate) {
				resubmit(currentAuthor);
			} else if (selection == VIEW_REVIEWS) {
				displayReviews(currentAuthor);
			} else if (selection == EDIT) {
				edit(currentAuthor);
			}
		}
	}
	public void resubmit(Author theAuthor) {
		int selection = -1;
		printDetails(theAuthor);
		System.out.println("Select a paper to resubmit: \n");
		selection = displayPapers(theAuthor);
		if (selection != 0) {
			Paper reSubmitPaper = theAuthor.getAPaper(selection - 1);
			myPaperUI.paperMenu(reSubmitPaper);
			System.out.println("Your paper has been resubmitted");
			System.out.println("___________________________________________________\n");
		} else {
			System.out.println("___________________________________________________\n");
		}
		
		
	}
	/**
	 * Displays the menu for the unsubmission of a paper.
	 * 
	 * @param theAuthor The author who wants to unsubmit a paper
	 */
	public void unsubmit(Author theAuthor) {
		printDetails(theAuthor);
		int selection = displayPapers(theAuthor);
		if (selection != 0) {
			Paper tempPaper = theAuthor.getAPaper(selection - 1);
			theAuthor.unsubmit(tempPaper);
			isRemoved();
		} 
	}
	
	/**
	 * Menu allowing an author to edit a paper of their choosing.
	 * 
	 * @param theAuthor the author who wants to edit a paper
	 */
	public void edit(Author theAuthor) {
		String title = "";
		Scanner scanner = new Scanner(System.in);
		printDetails(theAuthor);
		int selection = displayPapers(theAuthor);
		if (selection != 0) {
			Paper tempPaper = theAuthor.getAPaper(selection - 1);
			System.out.println("Paper: " + tempPaper.getTitle());
			System.out.println("Enter the new Title: ");
			title = scanner.nextLine();
			theAuthor.edit(tempPaper, title);
			isUpdated();
		}		
	}
	
	/**
	 * Displays a list of authors papers.
	 * 
	 * @param theAuthor the author whose papers are to be displayed 
	 * @return the number corresponding to an author's paper, or 0 for the user to go back
	 */
	public int displayPapers(Author theAuthor) {
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		
		for (Paper tempPaper: theAuthor.getPapers()) {
			System.out.print(optionCounter + ") ");
			System.out.println(tempPaper.getTitle());	
			optionCounter++;
		}
		System.out.println("0) Back");
		selection = scanner.nextInt();
		return selection;
	}
	
	/**
	 * Displays all papers of an author that have been reviewed.
	 * 
	 * @param theAuthor the author who has a list of papers
	 * @return the number corresponding to an author's paper, or 0 for the user to go back
	 */
	public int displayPapersThatAreReviewed(Author theAuthor) {
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		
		for (Paper tempPaper: theAuthor.getPapers()) {
			if (tempPaper.getFinal()) {
				System.out.print(optionCounter + ") ");
				System.out.println(tempPaper.getTitle());	
				optionCounter++;
			}
		}
		System.out.println("0) Back");
		selection = scanner.nextInt();
		return selection;
	}
	
	
	/**
	 * Will display reviews of selected paper if the final 
	 * Recommendation has been made.
	 * @author Jeremy Wolf
	 */
	public void displayReviews(Author theAuthor) {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		printDetails(theAuthor);
		System.out.println("If no papers are displayed, they are still awaiting a decsion. \n");
		System.out.println("Selected a paper to view reviews: ");
		selection = displayPapersThatAreReviewed(theAuthor);
		System.out.println("___________________________________________________ \n");
		
		if(selection != 0) {
			int counter = 1;
			printDetails(theAuthor);
			Paper tempPaper = theAuthor.getPapers().get(selection - 1);
			System.out.println("Paper: " + tempPaper.getTitle());
			for(Review rev : tempPaper.getReviews()) {
				System.out.println("Review number: " + counter);
				System.out.println("\tThe rating was: " + rev.getRating());
				counter++;
			}
			System.out.println("Press 0 to go back");
			selection = scanner.nextInt();
			
		} 
		System.out.println("___________________________________________________ \n");
	}

	/**
	 * Prints details regarding the author to the console.
	 * 
	 * @param theAuthor the currently selected author
	 */
	public void printDetails(Author theAuthor) {
		String dueDate = myConference.getDueDate().toString();
		System.out.println("MSEE System");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());
		System.out.println("User: " + theAuthor.getID());
		System.out.println("Conference: " + myConference.getName());
		System.out.println("Submission Deadline: " + dueDate.substring(0, 11));
		System.out.println("Role: Author " + "\n");
	}
	
	/** Prints to console that a paper has been removed. */
	public void isRemoved() {
		System.out.println("Paper has been removed");
		System.out.println("___________________________________________________ \n");
	}
	
	/** Prints to console that a paper has been updates. */
	public void isUpdated() {
		System.out.println("Paper has been updated");
		System.out.println("___________________________________________________ \n");
	}
}
