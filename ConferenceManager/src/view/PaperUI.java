package view;

import java.io.File;
import java.util.Scanner;

import model.Paper;

public class PaperUI {
	
	public static void paperMenu(Paper thePaper) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Title of Paper: ");
		thePaper.setTitle(scanner.nextLine()); 
		uploadFile(thePaper);
		
	}

	public static void uploadFile(Paper thePaper) {
		Scanner scanner = new Scanner(System.in);
		String pathOfPaper;
		System.out.println("To submit a paper, Enter desired path: ");
		System.out.println("(example: C:\\Windows\\System64\\Document\\manuscript)");
		pathOfPaper = scanner.nextLine();
		thePaper.setFile(new File(pathOfPaper));
		System.out.println("Upload Sucessful");
		System.out.println("___________________________________________________\n");
		
	}
}
