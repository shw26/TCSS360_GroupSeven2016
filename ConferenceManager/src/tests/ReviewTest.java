package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Paper;
import model.Review;
import model.Reviewer;

/**
 * 
 */

/**
 * Tests the Review Class
 * @author Will Almond
 * @version 05/07/2016
 */
public class ReviewTest {
	Paper paper1;
	Reviewer myRev1;
	Review myReview;
	/**
	 * This method sets up all the tests done in this class.
	 * @author Will Almond
	 * @version 05/18/2016
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		paper1 = new Paper("After Mars Attacks");
		Paper paper2 = new Paper("Our Bodies, Ourselves");
		myRev1 = new Reviewer("Bum", "Dum", "bumdum@gmail.com");
		Reviewer myRev2 = new Reviewer("Dan", "Mann", "danmann@gmail.com");
		myReview = new Review(paper1, myRev1);
	}

//	/**
//	 * Test method for {@link Review#Review(java.lang.String)}.
//	 */
//	@Test
//	public void testReview() {
//		fail("Not yet implemented");
//	}

	/**
	 * Tests the ability of this method to submit a review to the Paper.
	 * @author Will Almond
	 * @version 05/18/2016
	 * Test method for {@link Review#submitReview()}.
	 */
	@Test
	public void testSubmitReviewForPaper() {
		paper1.addReview(myReview);
		assertEquals("the review in Paper and the submitted review should be the same!", 
				myReview, paper1.getReviews().get(0));
	}
	/**
	 * Tests the ability of this method to submit a review to the reviewer.
	 * @author Will Almond
	 * @version 05/18/2016
	 * Test method for {@link Review#submitReview()}.
	 */
	@Test
	public void testSubmitReviewForReviewer() {
		myRev1.addReview(myReview);
		assertEquals("the review in Reviewer and the submitted review should be the same!",
				myReview, myRev1.getReview(0));
	}


}

