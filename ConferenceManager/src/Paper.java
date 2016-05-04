import java.util.LinkedList;
import java.util.List;

/**
 * Holds the data for a paper used in the conference.
 * 
 * @author Trevor N. Lowe
 * @version 1 : 5/1/16
 */
public class Paper {
<<<<<<< HEAD
	// -- Fields --
	
	/** The contact author of the paper. **/
	private String myAuthor;
	
	/** A List of Reviews by Reviewers. **/
	private List<Review> myReviews;
	
	/** True if recommendation has been made. **/
	private boolean myRecommendation;
	
	/** True if final decision has been made. **/
	private boolean myFinal;
	
	
	// -- Constructors --
	
	/**
	 * Creates a new Paper object from an author's name.
	 * 
	 * @param name the contact author for the paper
	 */
	public Paper(String name) {
		this.myAuthor =  name;
		myReviews = new LinkedList<Review>();
		myRecommendation = false;
		myFinal = false;
	}
	
	
	// -- Methods (Mutator) --
	
	public void update() {
		
	}
	
	/**
	 * Sets the recommendation status of a paper.
	 * True if recommendation made.
	 * 
	 * @param newRecommendation recommendation status
	 */
	public void setRecommendation(boolean newRecommendation) {
		this.myRecommendation = newRecommendation;
	}
	
	/**
	 * Sets the Reviews for a paper.
	 * 
	 * @param newReviews the reviews for a paper
	 */
	public void setReviewers(List<Review> newReviews) {
		this.myReviews = newReviews;
	}
	
	/**
	 * Sets the final decision status of a paper.
	 * True if final decision made.
	 * 
	 * @param newFinal
	 */
	public void setFinal(boolean newFinal) {
		this.myFinal = newFinal;
	}
	
	
	// -- Methods (Accessor) --
	
	/**
	 * Returns the contact author of the paper.
	 * 
	 * @return contact author of paper
	 */
	public String getAuthor() {
		return this.myAuthor;
	}
	
	/**
	 * Returns the recommendation status of the paper.
	 * True if recommendation made.
	 * 
	 * @return recommendation status of paper
	 */
	public boolean getRecommendation() {
		return this.myRecommendation;
	}
	
	/**
	 * Returns a list of the reviews on a paper.
	 * 
	 * @return list of reviews on paper
	 */
	public List<Review> getReviews() {
		return this.myReviews;
	}
	
	/**
	 * Returns the final decision status on a paper.
	 * True if final decision made.
	 * 
	 * @return final decision status of paper
	 */
	public boolean getFinal() {
		return this.myFinal;
	}
=======

	public boolean getRecommendation() {
		return true;
	}
	
	public String getTitle() {
		return "This is the book name";
	}
	
	public void setFinal(boolean theD) {
		
	}
	
	public void setRecommendation(boolean theD) {}

	public String getAuthorID() {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> refs/heads/Jeremy
}
