package view;

import java.util.Scanner;

import model.Author;
import model.Conference;
import model.Paper;
import model.Review;

public class AuthorUI {

	
	/**
	 * Displays the Menu options for the Author.
	 * @author Jeremy Wolf
	 */
	public void authorMenu(Author theAuthor, Conference theConference) {
		int selection = -1;
		Author currentAuthor = theAuthor;
		Conference currentConference = theConference;
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

			if(selection == 1 && !isPastDueDate) {
			    Paper temp = new Paper(currentAuthor.getID());
			    temp.paperMenu();
			    currentAuthor.addPaper(temp);
			} else if (selection == 2) {
				unsubmit(currentAuthor);
			} else if (selection == 3 && !isPastDueDate) {
				edit(currentAuthor);
			} else if (selection == 4) {
				displayReviews(currentAuthor);
			}
		}
	}
	
	
	public void unsubmit(Author theAuthor) {
		printDetails(theAuthor);
		int selection = displayPapers(theAuthor);
		if (selection != 0) {
			Paper tempPaper = theAuthor.getAPaper(selection - 1);
			theAuthor.unsubmit(tempPaper);
			isRemoved();
		} 
	}
	
	public void edit(Author theAuthor) {
		printDetails(theAuthor);
		int selection = displayPapers(theAuthor);
		if (selection != 0) {
			Paper tempPaper = theAuthor.getAPaper(selection - 1);
			theAuthor.edit(tempPaper);
			isUpdated();
		}		
	}
	
	public int displayPapers(Author theAuthor) {
		Scanner scanner = new Scanner(System.in);
		int optionCounter = 1;
		int selection = -1;
		
		printDetails(theAuthor);
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
	 * Will display reviews of selected paper if the final 
	 * Recommendation has been made.
	 * @author Jeremy Wolf
	 */
	private void displayReviews(Author theAuthor) {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		printDetails(theAuthor);
		System.out.println("Selected a paper to view reviews: ");
		System.out.println("If no papers are displayed, they are still awaiting a decsion.");
		selection = displayPapers(theAuthor);
		System.out.println("___________________________________________________ \n");
		
		if(selection != 0) {
			int counter = 1;
			printDetails(theAuthor);
			Paper tempPaper = theAuthor.getPapers().get(selection - 1);
			System.out.println("Paper: " + tempPaper.getTitle());
			for(Review rev : tempPaper.getReviews()) {
				System.out.println("Review number: " + counter);
				System.out.println("\tThe rating was: " + rev.getTheRateing());
				System.out.println("\tThe review comment was: ");
				System.out.println("\t" + rev.getComment() + "\n");
				counter++;
			}
			System.out.println("Press 0 to go back");
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
		}
	}

	public void printDetails(Author theAuthor) {
		System.out.println("MSEE System");
		System.out.println("User: " + theAuthor.getID());
		System.out.println("Role: Author");
	}
	
	public void isRemoved() {
		System.out.println("Paper has been removed");
		System.out.println("___________________________________________________ \n");
	}
	
	public void isUpdated() {
		System.out.println("Paper has been updated");
		System.out.println("___________________________________________________ \n");
	}
}
