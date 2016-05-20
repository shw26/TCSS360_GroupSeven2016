package view;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Paper;

public class PaperUI implements Serializable {
	
	/**
	 * Serial ID for storage
	 */
	private static final long serialVersionUID = 4108444021508783267L;

	/**
	 * Calendar object to determine date
	 */
	private Calendar myCalendar;
	
	/**
	 * Prints the basic paper menu to the console.
	 * 
	 * @param thePaper the paper being addressed
	 */
	public void paperMenu(Paper thePaper) {
		myCalendar = Calendar.getInstance();
		Scanner scanner = new Scanner(System.in);
		printDetails();
		System.out.println("Enter Title of Paper: ");
		thePaper.setTitle(scanner.nextLine()); 
		uploadFile(thePaper);
		
	}

	/**
	 * Upload the paper UI
	 * @param thePaper thePaper to be uploaded
	 */
	public void uploadFile(Paper thePaper) {
		Scanner scanner = new Scanner(System.in);
		String pathOfPaper;
		System.out.println("\nTo submit a paper, Enter desired path: ");
		System.out.println("(example: C:\\Windows\\System64\\Document\\manuscript)");
		pathOfPaper = scanner.nextLine();
		thePaper.setFile(new File(pathOfPaper));
		System.out.println("Upload Sucessful");
		System.out.println("___________________________________________________\n");
		
	}
	
	/**
	 * Prints the header at the top of the screen
	 */
	public void printDetails(){
		System.out.println("MSEE System");
		Date today = myCalendar.getTime();
		System.out.println("Date: " + today.toString());

	}
}
