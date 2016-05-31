package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Paper;
import model.Review;
import model.Reviewer;

/**
 * Class to test the Reviewer.
 * @author Will Almond
 * @version 05/08/2016
 */
public class ReviewerTest {
	private Reviewer testReviewer;
	private Paper testPaper1;
	private Paper testPaper2;
	private Review review1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testPaper1 = new Paper("Life and Death");
		testPaper2 = new Paper("What is Love?");
		testReviewer = new Reviewer("Bob", "Mortimer", "bobmortimer@gmail.com");
		review1 = new Review(testPaper1, testReviewer);
		testReviewer.addReview(review1);
	}

	/**
	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
	 */
	@Test
	public void testSubmitReviewWithOneAsSubmission(){
		testReviewer.addPaper(testPaper2);
		testReviewer.submitReview(1);
		assertEquals("Should be the Paper 'Life and Death'", 
				testReviewer.getReview(0).getPaperName(), 
				testPaper1.getTitle());
	}
	/**
	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
	 */
	@Test
	public void testSubmitReviewWithTwoAsSubmission(){
		testReviewer.addPaper(testPaper2);
		testReviewer.submitReview(1);
		assertFalse(testReviewer.equals(2));
	}

	/**
	 * Test method for {@link model.Reviewer#addPaper(model.Paper)}.
	 */
	@Test
	public void testAddPaperwithEmptyList() {
		assertTrue("List should be empty", testReviewer.getPaperList().isEmpty());
		testReviewer.addPaper(testPaper2);
		assertEquals("should be 'What is Love?'",testReviewer.getPaperList().get(0).getTitle(),
				testPaper2.getTitle());
	}
	
	/**
	 * Test method for {@link model.Reviewer#addPaper(model.Paper)}.
	 */
	@Test
	public void testAddPaperwithSinglePaperInList() {
		assertTrue("List should be empty", testReviewer.getPaperList().isEmpty());
		testReviewer.addPaper(testPaper2);
		assertEquals("List should have 1 item", 1, testReviewer.getPaperList().size());
		testReviewer.addPaper(testPaper1);
		assertEquals("Should be 'Life and Death'",testReviewer.getPaperList().get(1).getTitle(),
				testPaper2.getTitle());
	}
	
	/**
	 * Test method for {@link model.Reviewer#addPaper(model.Paper)}.
	 */
	@Test
	public void testAddPaperwithMaxPapers() {
		testReviewer.addPaper(testPaper2);
		testReviewer.addPaper(testPaper1);
		testReviewer.addPaper(new Paper("This One"));
		testReviewer.addPaper(new Paper("This Two"));
		
		//Now at max we can test.
		assertFalse("Should be Fales, Paper was not added because the number of papers was at MAX",
				testReviewer.addPaper(new Paper("This should not work")));
	}

	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testAddReview() {
		assertEquals(testReviewer.getReview(0), review1);
	}
	
	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testgetID() {
		assertEquals("ID should be 'bobmortimer@gmail.com'", "bobmortimer@gmail.com", testReviewer.getID());
		
	}
	
	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testGetPaperList() {
		testReviewer.addPaper(new Paper ("Drod@gmail.com"));
		testReviewer.addPaper(new Paper ("James@gmail.com"));
		
		assertEquals("Paper List should be the same", "Drod@gmail.com", testReviewer.getPaperList().get(0).getAuthor());
		assertEquals("Paper List should be the same", "James@gmail.com", testReviewer.getPaperList().get(1).getAuthor());
	}
	
	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testgetReviewList() {
		testReviewer.addReview(review1);
		ArrayList<Review> theReviews = testReviewer.getReviewList();
		//assertTrue("Reviewed paper should be the same" );
		
	}
	
	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testGetReview() {
		
	}

}

