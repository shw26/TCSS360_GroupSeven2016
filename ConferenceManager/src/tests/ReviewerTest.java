package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Paper;
import model.Reviewer;

/**
 * Class to test the Reviewer.
 * @author Will Almond
 * @version 05/08/2016
 */
public class ReviewerTest {
	private Reviewer testReviewer;
	private Paper testPaper1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testPaper1 = new Paper("Life and Death");
		testReviewer = new Reviewer("Bob", "Mortimer", "bobmortimer@gmail.com");
		testReviewer.addPaper(testPaper1);
	}
	

	/**
	 * Test method for {@link model.Reviewer#Reviewer(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReviewer() {
		fail("Not yet implemented");
	}


	/**
	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
	 */
	@Test
	public void testSubmitReviewWithZeroAsSubmission(){
		testReviewer.submitReview(0);
		assertEquals("Should return null", testReviewer.getReview(1), null);
	}
	/**
	 * Test method for {@link model.Reviewer#submitReview(java.lang.int)}.
	 */
	@Test
	public void testSubmitReviewWithOneAsSubmission(){
		testReviewer.submitReview(1);
		assertEquals("Should be the Paper 'Life and Death'", 
				testReviewer.getReview(0).getPaperName(), 
				"Life and Death");
	}
	
	/**
	 * Test method for {@link model.Reviewer#getID()}.
	 */
	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Reviewer#addPaper(model.Paper)}.
	 */
	@Test
	public void testAddPaper() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Reviewer#getPaperList()}.
	 */
	@Test
	public void testGetPaperList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Reviewer#addReview(model.Review)}.
	 */
	@Test
	public void testAddReview() {
		fail("Not yet implemented");
	}

}

