package tests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

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
		testPaper = new Paper("Test Author");
	}
	
	
	// setRecommendation Tests
	/** Tests if setRecoomendation sets the recommendation. **/
	@Test
	public void setRecommendationTest() {
		testPaper.setRecommendation(true);
		assertTrue(testPaper.getRecommendation());
	}
	
	// setReviews Tests
	@Test
	public void setReviewsTest() {
		fail();
	}
	
	// setFinal Tests
	@Test
	public void setFinalTest() {
		fail();
	}
	
	// getAuthor Tests
	@Test
	public void getAuthorTest() {
		fail();
	}
	
	// getReviews Tests
	@Test
	public void getReviewsTest() {
		fail();
	}
	
	// getFinal
	@Test
	public void getFinalTest() {
		fail();
	}
	
	// getTitle
	@Test
	public void getTitleTest() {
		fail();
	}
}
