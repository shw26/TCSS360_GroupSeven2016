import java.io.Serializable;
import java.util.ArrayList;

public class SubProgramChair implements Serializable {

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
	private ArrayList<Reviewer> mySubList;
	
	public SubProgramChair(String theFirst, String theLast, String theID, 
			ArrayList<Paper> theList) {
}
