package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Paper;
import model.Reviewer;
import model.SubProgramChair;
import model.User;
/**
 * not sure about ln 56 ~ 70. isAuthor tests
 * @author user
 *
 */
public class SubProgramChairTest {
	
	
	ArrayList<User> myUserList;
	ArrayList<Reviewer> myRev;
	SubProgramChair test1;
	SubProgramChair test2;
	Paper thePaper;
	Paper thePaper2;
	User user;
	Reviewer someR;
	
	@Before
	public void setUp() {
		myUserList = new ArrayList<User>();
		myRev = new ArrayList<Reviewer>();
		user = new User("wi", "fi", "wifi@everywhere.com");
		someR = new Reviewer("so", "me", "some@one.com");
		thePaper = new Paper("wifi@everywhere.com");
		thePaper2 = new Paper("Beer Beer Beer");
		
		test1 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu", myUserList, myRev);
		
		ArrayList<Reviewer> myRev2 = new ArrayList<Reviewer>();
		myRev2.add(someR);
		ArrayList<User> UserList = new ArrayList<User>();
		UserList.add(user);
		test2 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu", UserList, myRev2);
	}
	
	
	@Test
	public void testMakeRecommendationOne(){
		test1.makeRecommendation(1, thePaper);
		assertTrue("makeRecommendation choice 1 failed", thePaper.getRecommendation());
	}
	@Test
	public void testMakeRecommendationTwo(){
		test1.makeRecommendation(2, thePaper);
		assertFalse("makeRecommendation choice 2 failed", thePaper.getRecommendation());
	}
	
	//not sure
	@Test
	public void testIsAuthorT(){
		assertEquals(" isAuthor T failed", 0 ,test2.isAuthor(1, thePaper2));
	}
	//not sure
	@Test
	public void testIsAuthorF(){
		
		assertEquals(" isAuthor F failed",-1 ,test2.isAuthor(1, thePaper));
	}
	
	@Test
	public void testCreateReviewerA(){
		assertEquals("CreateReviewer A failed",1 ,test1.createReviewer(user, thePaper));
	}
	@Test
	public void testCreateReviewerB(){
		User someU = new User("so", "me", "some@one.com");
		assertEquals("CreateReviewer B failed",1 ,test2.createReviewer(someU, thePaper));
	}
	@Test
	public void testCreateReviewerC(){
		Paper pa = new Paper("a");
		Paper pb = new Paper("b");
		Paper pc = new Paper("c");
		Paper pd = new Paper("d");
		someR.addPaper(pa);
		someR.addPaper(pb);
		someR.addPaper(pc);
		someR.addPaper(pd);
		User someU = new User("so", "me", "some@one.com");
		assertEquals("CreateReviewer C failed",2 ,test2.createReviewer(someU, thePaper));
	}
	@Test
	public void testCreateReviewerD(){
		assertEquals("CreateReviewer D failed",1 ,test2.createReviewer(user, thePaper));
	}
	
	
	
	@Test
	public void testAddPaper() {
		test1.addPaper(thePaper2);
		ArrayList<Paper> temp = test1.getPaperList();
		
		
		if(thePaper.getTitle().equals(temp.get(0).getTitle())) {
				assertTrue("Paper was added", true);
		} else {
			assertFalse("Paper was not added", false);
		}		
	}

	@Test
	public void testGetFirst() {
		if(test1.getFirst().equals("Jeremy")) {
			assertTrue("First names match", true);
		} else {
			assertFalse("First name did not match", false);
		}
	}

	@Test
	public void testGetLast() {
		if(test1.getLast().equals("Wolf")) {
			assertTrue("Last names match", true);
		} else {
			assertFalse("Last name did not match", false);
		}
	}
	@Test
	public void testGetID() {
		assertEquals("getID failed", "Jwolf059@uw.edu", test1.getID());
	}
	@Test
	public void testGetList() {
		assertEquals("getList (user list) failed", myUserList, test1.getList());
	}
}
