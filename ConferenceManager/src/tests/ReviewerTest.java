package tests;

import static org.junit.Assert.*;

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
		testReviewer.addPaper(testPaper1);
		testReviewer.addReview(review1);
	}

//	/**
//	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
//	 */
//	@Test
//	public void testSubmitReviewWithZeroAsSubmission(){
//		testReviewer.submitReview(0);
//		assertEquals("Should return", testReviewer.getReview(0));
//	}
	/**
	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
	 */
	@Test
	public void testSubmitReviewWithOneAsSubmission(){
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
		testReviewer.submitReview(1);
		assertFalse(testReviewer.equals(2));
	}

	/**
	 * Test method for {@link model.Reviewer#addPaper(model.Paper)}.
	 */
	@Test
	public void testAddPaper() {
		testReviewer.addPaper(testPaper2);
		assertEquals("should be 'What is Love?'",testReviewer.getPaperList().get(1).getTitle(),
				testPaper2.getTitle());
	}

	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testAddReview() {
		assertEquals(testReviewer.getReview(0), review1);
	}

}

