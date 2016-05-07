package tests;
import org.junit.*;

import model.Paper;

/**
 * Runs tests for the Paper class.
 * 
 * @author Trevor N. Lowe
 * @version 1 : 5/5/16
 */
public class PaperTest {
	
	private Paper testPaper;

	@Before
	public void setup() {
		// Constructor Tests
		testPaper = new Paper("Testing123");
	}
	
	// paperMenu Tests
	@Test
	public void paperMenuTest() {
		testPaper.paperMenu();
	}
	
	// uploadFile Tests
	@Test
	public void uploadFileTest() {
		
	}
	
	// setRecommendation Tests
	@Test
	public void setRecommendationTest() {
		
	}
	
	// setReviews Tests
	@Test
	public void setReviewsTest() {
		
	}
	
	// setFinal Tests
	@Test
	public void setFinalTest() {
		
	}
	
	// getAuthor Tests
	@Test
	public void getAuthorTest() {
		
	}
	
	// getReviews Tests
	@Test
	public void getReviewsTest() {
		
	}
	
	// getFinal
	@Test
	public void getFinalTest() {
		
	}
	
	// getTitle
	@Test
	public void getTitleTest() {
		
	}
}
