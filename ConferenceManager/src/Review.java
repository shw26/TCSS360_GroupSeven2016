/**
 * 
 * @author Will Almond
 *
 */
public class Review {

	public String theName;
	public int theRateing;
	public String theComment;
	
	public String getConfName(){
		return theName;
		
	}
	public String getComment(){
		return theComment;
	}
	
	public int getRating(){
		return theRateing;
	}
	public void setConfName(String name){
		theName = name;
	}
	public void setComment(String comment){
		theComment = comment;
	}
	public void setRating(int rateing){
		theRateing = rateing;
	}
}
