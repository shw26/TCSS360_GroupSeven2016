package model;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * Review Class 
 * 
 * @author Will Almond
 * @version 1.0, 05/01/2016
 *
 */
public class Review implements Serializable{

	/**
	 * This is the serialized generated ID.
	 */
	private static final long serialVersionUID = -374717804308411534L;
	/* The name of the paper being reviewed */
	public String theName;
	/* A numerical rating that the reviewer will leave for the author. */
	public int theRateing;
	/* Comments that the reviewer will leave*/
	public String theComment;
	/* the ID of the reviewer for the heading */
	public String theID;
	
	/**
	 * The constructor for Review class called every time 
	 * a new review is made on a paper.
	 * @param id
	 */
	public Review(String id){
		theID = id;
	}
	/**
	 * The menu that will open every time a new review is to be created or edited.
	 */
	public void reviewMenu(){
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			System.out.println("Role: Reviewer");
			System.out.println("Paper: "+ theName + "\n");
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Type Review");
			System.out.println("2) Rate Paper");
			System.out.println("0) Back\n");
			System.out.println("___________________________________________________\n");
			
			selection = scanner.nextInt();
			
			if(selection == 1) {
				typeReview();
			} else if (selection == 2) {
				rate();
			}
			else {
				return;
				//return to the previous menu somehow.
			}
		}
	}
	/**
	 * Method to type the review of the paper.
	 */
	private void typeReview(){
		String text = null;
		Scanner scannerRev = new Scanner(System.in);
		
		System.out.println("Enter your review for " + theName);
		text = scannerRev.nextLine();
		setComment(text);
		// return to the previous menu somehow.
	}
	/**
	 * Method to change the rating fo the paper.
	 */
	private void rate(){
		int selection = -1;
		Scanner scannerRate = new Scanner(System.in);
		while(selection != 0) {
			System.out.println("Select your numerical rating for "+ theName);
			selection = scannerRate.nextInt();
			setRateing(selection);
		}
		//return to the previous menu somehow.
	}
	/**
	 * This method returns the conference name.
	 * @return theName
	 */
	public String getConfName(){
		return theName;
	}
	
	/**
	 * Subprogram chairs and authors will need to use this to view the comments.
	 * @return theComment
	 */
	public String getComment(){
		return theComment;
	}
	/**
	 * The Program Chair will use this method to view the rateing. 
	 * @return theRateing
	 */
	public int getRateing(){
		return theRateing;
	}
	/**
	 * This method will be used when creating a conference.
	 * @param name
	 */
	public void setConfName(String name){
		theName = name;
	}
	/**
	 * The reviewer will need to comment on each paper and will use this method.
	 * @param comment
	 */
	public void setComment(String comment){
		theComment = comment;
	}
	/**
	 * When the reviewer desires to set a rating they will call this method.
	 * @param rateing
	 */
	public void setRateing(int rateing){
		theRateing = rateing;
	}
	/**
	 * toString method to display the review in a uniform instance.
	 */
	public String toString(){
		StringBuilder myString = new StringBuilder();
		return myString.toString();
	}
	private void displayDetails(){}
}
