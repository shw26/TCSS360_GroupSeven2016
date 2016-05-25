package tests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

import model.Paper;
import model.Review;
import model.Reviewer;

/**
 * Runs tests for the Paper class.
 * 
 * @author Trevor N. Lowe
 * @version 1 : 5/5/16
 */
public class PaperTest {
	
	private Paper testPaper;
	private Paper titledPaper;

	@Before
	public void setup() {
		testPaper = new Paper("Test Author"); // Tests author param Constructor
		titledPaper = new Paper("Test Title", "Test Author"); // Tests Title/Author param Consructor
	}
	
	
	// setRecommendation/getRecommendation Tests
	/** Tests if setRecoomendation sets the recommendation. **/
	@Test
	public void testSetRecommendation_SetRecommendationToTrueAndUseGetter() {
		testPaper.setRecommendation(true);
		assertTrue("setRecommendaion/getRecommendation Failed!", testPaper.getRecommendation());
	}
	
	@Test
	public void testSetRecommendation_SetRecommendationToFalseAndUseGetter() {
		testPaper.setRecommendation(false);
		assertFalse("setRecommendaion/getRecommendation Failed!", testPaper.getRecommendation());
	}
	
	// setReviews/getReviews/addReviews Tests
	@Test
	public void testSetReviewers_CreateNewReviewerAddToNewListAddListToPaperAndUseGetter() {
		List<Review> testReviews  = new LinkedList<Review>();
		Reviewer testReviewer = new Reviewer("first", "last", "id");
		Review testReview = new Review(testPaper, testReviewer);
		testReviews.add(testReview);
		testPaper.setReviews(testReviews);
		assertEquals("setReviewers/getReviews Failed!", testReviews, testPaper.getReviews());
	}
	
	@Test
	public void testSetReviewers_CreateNewListAddListToPaperAddReviwUseGetter() {
		List<Review> testReviews  = new LinkedList<Review>();
		testPaper.setReviews(testReviews);
		Reviewer testReviewer = new Reviewer("first", "last", "id");
		Review testReview = new Review(testPaper, testReviewer);
		testPaper.addReview(testReview);
		
		assertEquals("setReviews/getReviews/addReview Failed!", testReview, testPaper.getReviews().get(0));
	}
	
	// setFinal/getFinal Tests
	@Test
	public void testSetFinal_SetFinalToTrueUseGetter() {
		testPaper.setFinal(true);
		assertTrue("setFinal/getFinal Failed!", testPaper.getFinal());
	}
	
	@Test
	public void testSetFinal_SetFinalToFalseUseGetter() {
		testPaper.setFinal(false);
		assertFalse("setFinal/getFinal Failed!", testPaper.getFinal());
	}
	
	// setFile/getFile Tests
	@Test
	public void testSetFile_CreateNewFileUseGetter() {
		File testFile = new File("Assets/testPaper1.txt");
		testPaper.setFile(testFile);
		assertEquals("setFile/getFile failed!", testFile, testPaper.getFile());
	}
	
	// setTitle/getTitle Tests
	@Test
	public void testSetTitle_CreateNewTitleUseGetter() {
		String testTitle = "Test Title";
		testPaper.setTitle(testTitle);
		assertEquals("setTitle/getTitle failed!", testTitle, testPaper.getTitle());
	}
	
	// getAuthor Tests
	@Test
	public void testGetAuthor_UseGetterOnPreconstructedAuthor() {
		assertEquals("getAuthor Failed!", "Test Author", testPaper.getAuthor());
	}
}
