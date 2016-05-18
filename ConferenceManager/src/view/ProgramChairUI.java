package view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Conference;
import model.Paper;
import model.ProgramChair;
import model.SubProgramChair;
import model.User;

public class ProgramChairUI implements Serializable{

	/**
	 * Serial ID for storage
	 */
	private static final long serialVersionUID = 2942664104684682820L;

	/**
	 * The current Program Chair
	 */
	private ProgramChair myCurrentPC;
	
	/**
	 * Calendar object to determine date
	 */
	private Calendar myCalendar;
	
	/**
	 * Conference object
	 */
	private Conference myConference;
	
	public void pcMenu() {
		myCurrentPC = null;
		myConference = null;
		myCalendar = Calendar.getInstance();
	}
	
	/**
	 * Displays the Menu options for the Program Chair.
	 * @author Jeremy Wolf
	 */
	public void pcMenu(Conference theConference, ProgramChair thePC) {
		myCurrentPC = thePC;
		myConference = theConference;
		myCalendar = Calendar.getInstance();
		
		
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			printDetails();
			System.out.println("Make a Selection: ");
			System.out.println("1) View Papers");
			System.out.println("2) Designate Sub-Program Chair(s)");
			System.out.println("3) View Sub-Program Chair(s) assigned papers");
			System.out.println("4) Make final decision");
			System.out.println("0) Back\n");
			
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________\n");
			if(selection == 1) {
				viewPapers();
			} else if (selection == 2) {
				designateSC();
			} else if (selection == 3) {
				viewSCPapers();
			} else if (selection == 4) {
				
				makeFinal();
			}
		}
	}
	
	public void designateSC() {
		Scanner scanner = new Scanner(System.in);
		SubProgramChair tempSC = null;
		printDetails();
		System.out.println("Current Registered Users:\n");
		displayUsers();
		System.out.println("0) Back");
		System.out.println("Select a User: (1 - " + myCurrentPC.getUsers().size() + ")");
		
		int selection = scanner.nextInt();
		if (selection != 0) {
			tempSC = myCurrentPC.createSubProgramChair(selection);
			System.out.println("___________________________________________________\n");
			printDetails();
			System.out.println("Select a Paper to be Assigned to the SubProgram Chair: ");
			selection = viewPapersWithOptions();
		} else {
			System.out.println("___________________________________________________\n");
		}
		if (selection != 0) {
			int status = myCurrentPC.assignPaperToSC(selection, tempSC);
			
			if (status == 1) {
				System.out.println("Paper has been assigned");
				System.out.println("_________________________________________________\n");
			} else if (status == 2) {
				System.out.println("SubProgram Chair is the Author, can not assign paper");
				System.out.println("_________________________________________________\n");
			} else if (status == 3) {
				System.out.println("SubProgram Chair can have no more the 4 papers");
				System.out.println("_________________________________________________\n");
			}
		}
	}
	
	public void makeFinal() {
		printDetails();
		System.out.println("Select a Paper:");
		viewPapersWithOptions();
		
	}
	
	/**
	 * Method displays title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	public void viewPapers() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Currently Assigned Papers:");
		for (Paper printPaper: myCurrentPC.getPapers()) {
			System.out.print( "\t" + printPaper.getTitle()+ "\n");
		}
		System.out.println("Press 0 to go back");
		selection = scanner.nextInt();
		System.out.println("___________________________________________________\n");
	}
	
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 * @return 
	 */
	public int viewPapersWithOptions() {
		int optionCounter = 1;
		Scanner scanner = new Scanner(System.in);
		for (Paper printPaper: myCurrentPC.getPapers() ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back");
		return scanner.nextInt();
	}
	
	/**
	 * Method displays an option number and the title of each paper to be
	 * displayed to the console.
	 * @author Jeremy Wolf
	 */
	public void viewPapersReadyForFinal() {
		int optionCounter = 1;
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		boolean none = true;
		for (Paper tempPaper : myCurrentPC.getPapers()) {
			if (tempPaper.getRecommendation() == true) {
				none = false;
				System.out.print(optionCounter + ") ");
				System.out.print(tempPaper.getTitle() + "\n");
			}
			optionCounter++;
		}
		if (none) {
			System.out.println("No papers are ready for final decsion.");
			System.out.println("_________________________________________________\n");
		} else {
			selection = scanner.nextInt();
			Paper paperTemp = myCurrentPC.getPapers().get(selection - 1);
			System.out.println("_________________________________________________\n");
			finalDecsionMenu(paperTemp);
		}
	}
	
	public void finalDecsionMenu(Paper thePaper) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Paper: " + thePaper.getTitle());
		// Displays Options
		System.out.println("Select Final Decision:\n");
		System.out.println("1) Accept");
		System.out.println("2) Deny");
		System.out.println("0) Back");
		
		int selection = scanner.nextInt();
		System.out.println("_________________________________________________\n");
		myCurrentPC.makeFinal(thePaper, selection);
	}
	
	/**
	 * Prints the header at the top of the screen
	 */
	public void printDetails(){
		System.out.println("MSEE System");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());
		System.out.println("User: " + myCurrentPC.getID());
		System.out.println("Conference: " + myConference.getName());
		System.out.println("Role: Program Chair \n");	
	}

	/**
	 * Private helper method that displays all registered users to the console.
	 * @author Jeremy Wolf
	 */
	public void displayUsers() {
		int optionCounter = 1;
		for (User u: myCurrentPC.getUsers()) {
			System.out.print(optionCounter + ") ");
			System.out.print(u.getFirst() + " " + u.getLast() + "\n");
			optionCounter++;
		}
	}
	
	/**
	 * Displays the papers assigned to each Sub program Chair.
	 * @author Jeremy Wolf
	 */
	public void viewSCPapers() {
		Scanner scanner = new Scanner(System.in);
		printDetails();
		for (SubProgramChair temp: myCurrentPC.getSCs()) {
			System.out.println(temp.getFirst() + " " + temp.getLast() + ":");
			for (Paper tempPaper : temp.getPaperList()){
				System.out.println("\t" + tempPaper.getTitle());
			}
		}
		System.out.println("Press 0 to go back");
		int selection = scanner.nextInt();
		
		System.out.println("_________________________________________________\n");
	}

}
