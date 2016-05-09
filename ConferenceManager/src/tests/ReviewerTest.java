package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Reviewer;

/**
 * Class to test the Reviewer.
 * @author Will Almond
 * @version 05/08/2016
 */
public class ReviewerTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Reviewer testReviewer = new Reviewer("Bob", "Mortimer", "bobmortimer@gmail.com");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Reviewer#Reviewer(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReviewer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Reviewer#reviewerMenu()}.
	 */
	@Test
	public void testReviewerMenu() {
		fail("Not yet implemented");
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

