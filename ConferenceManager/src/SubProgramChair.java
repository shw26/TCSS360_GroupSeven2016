/*
 * Group Seven Project
 * TCSS360 - Spring 2016
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Program Chair class.
 * 
 * @author Jeremy Wolf
 * @version v1 4/30/2016
 */
public class SubProgramChair implements Serializable {

	/**
	 * Serial Version ID for persistent storage use.
	 */
	private static final long serialVersionUID = -7924787836896189243L;

	/**
	 * String representation the first name of the Sub Program Chair.
	 */
	private String myFirstName;
	
	/**
	 * String representation of the Last of the Sub Program Chair.
	 */
	private String myLastName;
	
	/**
	 * String representation of the ID of the Sub Program Chair.
	 */
	private String myID;
	
	/**
	 * Collection containing a list of all papers assigned to the Sub Program Chair.
	 */
	private ArrayList<Paper> myPaperList;
	
	/**
	 * Collection containing a list of all Reviewer under the Program Chair.
	 */
	private ArrayList<Reviewer> myRevList;
	
	/**
	 * Collection containing a list of all Reviewer under the Program Chair.
	 */
	private ArrayList<User> myUsers;
	
	
	/**
	 * Constructor for the Sub-Program Chair.
	 * 
	 * @author Jeremy Wolf
	 * @param theFirst string for the First Name.
	 * @param theLast String for the Last Name.
	 * @param theID String for the ID
	 * @param theList a collection of Users.
	 */
	public SubProgramChair(String theFirst, String theLast, String theID, 
			ArrayList<User> theList) {
	
		myFirstName = theFirst;
		myLastName = theLast;
		myID = theID;
		myUsers = theList;
		myPaperList = new ArrayList<Paper>();
		myRevList = new ArrayList<Reviewer>();	
	}
	
	/**
	 * Displays the Menu options for the Sub-Program Chair.
	 * @author Jeremy Wolf
	 */
	public void scMenu() {
		int selection = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(selection != 0) {
			displayDetails();
		
			System.out.println("Make a Selection: ");
			System.out.println("1) Submit a Recommendation");
			System.out.println("2) Assign Reviewer to a paper");
			System.out.println("0) Back\n");
		
			
			selection = scanner.nextInt();
			System.out.println("___________________________________________________ \n");
			if(selection == 1) {
				submitRecommendation();
			} else if (selection == 2) {
				assignReviewer();
			}
		}
	}
	
	/**
	 * Allows the Sub-program chair to submit a recommendation on
	 * a paper.
	 * @author Jeremy Wolf
	 */
	private void submitRecommendation() {
		int optionCounter = 1;
		int selection = -1;
		Paper tempPaper = null;
		Scanner scanner = new Scanner(System.in);
		displayDetails();
		System.out.println("Select a paper to make a recommendation:");
		
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		displayDetails();
		System.out.println("Paper: " + tempPaper.getTitle());
		
		if (selection != 0) {
			tempPaper = myPaperList.get(selection - 1);
			
			// Displays Options
			System.out.println("Select Recommendation:");
			System.out.println("1) Recommend");
			System.out.println("2) Deny");
			System.out.println("0) Back");
		
			//Recommendation selection is made.
			selection = scanner.nextInt();
			if (selection == 1) {
				tempPaper.setRecommendation(true);
			} else if (selection == 2) {
				tempPaper.setRecommendation(false);
			}
			System.out.println("___________________________________________________ \n");
		}
	}
	
	/**
	 * Allows the Sub-Program Chair to assign Reviewer to papers
	 * they are coordinating the review on. 
	 * @author Jeremy Wolf
	 */
	private void assignReviewer() {
		int optionCounter = 1;
		int selection = -1;
		Paper tempPaper = null;
		User userTemp = null;
		String authorID = "";
		
		Scanner scanner = new Scanner(System.in);
		displayDetails();
		System.out.println("Select a Paper to be Reviewed");
		
		for (Paper printPaper: myPaperList ) {
			System.out.print(optionCounter + ") ");
			System.out.print(printPaper.getTitle()+ "\n");
			optionCounter++;
		}
		System.out.println("0) Back\n");
		selection = scanner.nextInt();
		System.out.println("___________________________________________________ \n");
		displayDetails();
		System.out.println("Paper: " + tempPaper.getTitle());
		
		if (selection != 0) {
			tempPaper = myPaperList.get(selection - 1);
			authorID = tempPaper.getAuthor();
			
			
			while(selection != 0) {
				optionCounter = 1;
				for (User tempUser: myUsers) {
					System.out.print(optionCounter + ") ");
					System.out.print(tempUser.getFirst() + " " + tempUser.getLast() + "\n");
					optionCounter++;
					}
				}
				System.out.println("0) Back"); 
				
				selection = scanner.nextInt();
				userTemp = myUsers.get(selection - 1);
				
				// Creates a Reviewer object and places into the Reviewer list.
				if (selection != 0) {
					//If the list is empty then a reviewer is added.
					if(myRevList.isEmpty()) {
						System.out.println(userTemp.getFirst() + " " + 
											userTemp.getLast() + " has been assigned as a reviewer "
													+ "and the paper has been assigned");
						Reviewer tempRev = new Reviewer(userTemp.getFirst(), 
							           userTemp.getLast(), userTemp.getID());
						myRevList.add(tempRev);
					//If the list is not empty the contents must be check to avoid duplication.	
					} else {
						boolean isPresent = false;
						for (Reviewer rev : myRevList) {
							if (rev.getID().equals(userTemp.getID())) {
								rev.addPaper(tempPaper);
								System.out.println("The paper has been assigned to " +
													userTemp.getFirst() + " " + 
													userTemp.getLast());
								isPresent = true;
								break;
							}
						}
						//If the User is not already a reviewer a new reviewer is created.
						if (!isPresent) {
							System.out.println(userTemp.getFirst() + " " + 
									userTemp.getLast() + " has been assigned as a reviewer and teh paper "
											+ "has been assigned");
							Reviewer tempRev = new Reviewer(userTemp.getFirst(), 
							           userTemp.getLast(), userTemp.getID());
							myRevList.add(tempRev);
						}
					}
				} 
				System.out.println("___________________________________________________ \n");
		}
	}
	


	/**
	 * Adds the Paper to the Sub-Program Chairs list.
	 * @author Jeremy Wolf
	 * @param thePaper the paper to be assigned to reviewers.
	 */
	public void addPaper(Paper thePaper) {
		myPaperList.add(thePaper);
		
	}

	/**
	 * Getter method for my First name field.
	 * @author Jeremy Wolf
	 * @return string for First Name.
	 */
	public String getFirst() {
		return myFirstName;
	}

	/**
	 * Getter method for my Last name field.
	 * @author Jeremy Wolf
	 * @return string for Last Name.
	 */
	public ArrayList<Paper> getPaperList() {
		return myPaperList;
	}

	/**
	 * Getter method for my Last name field.
	 * @author Jeremy Wolf
	 * @return string for Last Name.
	 */
	public String getLast() {
		return myLastName;
	}
	
	public ArrayList<User> getList() {
		return myUsers;
	}
	
	/**
	 * Getter method for the myID field
	 * @author Jeremy Wolf
	 * @return the String myID
	 */
	public String getID() {
		return myID;
	}
	
	private void displayDetails() {
		System.out.println("MSEE Syystem");
		System.out.println("User: " + myFirstName);
		System.out.println("Role: Sub-ProgramChair");
	}
}

