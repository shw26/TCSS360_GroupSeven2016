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
 * test for subprogram chair.
 * @author shao-han wang (kevin)
 * @version 5/22/2016
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
		thePaper2 = new Paper("some@one.com");
		
		test1 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu", myUserList, myRev);
		
		ArrayList<Reviewer> rev2 = new ArrayList<Reviewer>();
		rev2.add(someR);
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		User someU= new User("so", "me", "some@one.com");
		userList.add(someU);
		test2 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu",userList, rev2);
	}
	
	/**
	 * Recommended.
	 */
	@Test
	public void testMakeRecommendation_Recommended(){
		test1.makeRecommendation(1, thePaper);
		assertTrue("makeRecommendation Recommended failed", thePaper.getRecommendation());
	}
	/**
	 * not recommended.
	 */
	@Test
	public void testMakeRecommendation_notRecommended(){
		test1.makeRecommendation(2, thePaper);
		assertFalse("makeRecommendation choice 2 failed", thePaper.getRecommendation());
	}
	
	/**
	 * the chosen user is not the author of the paper.
	 */
	@Test
	public void testIsAuthor_notAuthor(){
		assertEquals(" isAuthor notAuthor failed", false ,test2.isAuthor(1, thePaper2));
	}
	/**
	 * the chosen user is the author of the paper.
	 */
	@Test
	public void testIsAuthor_isAuthor(){
		
		assertEquals(" isAuthor isAuthor failed", true ,test2.isAuthor(1, thePaper));
	}
	
	
	/**
	 * empty reviewer list.
	 */
	@Test
	public void testCreateReviewer_noReviewer(){
		myUserList.add(user);
		Reviewer expected = new Reviewer("wi", "fi", "wifi@everywhere.com");
		assertEquals("CreateReviewer empty failed", expected.getID(), test1.createReviewer(1, thePaper).getID());
	}
	/**
	 * the user is a reviewer. no paper.
	 */
	@Test
	public void testCreateReviewer_isReviewer(){
		User someU = new User("so", "me", "some@one.com");
		myUserList.add(someU);
		assertEquals("CreateReviewer isReviewer failed","some@one.com" ,test2.createReviewer(2, thePaper).getID());
	}
	/**
	 * the reviewer has max(4) papers.
	 */
	@Test
	public void testCreateReviewer_exceedMaxPaper(){
		Paper pa = new Paper("a");
		Paper pb = new Paper("b");
		Paper pc = new Paper("c");
		Paper pd = new Paper("d");
		someR.addPaper(pa);
		someR.addPaper(pb);
		someR.addPaper(pc);
		someR.addPaper(pd);
		User someU = new User("so", "me", "some@one.com");
		
		assertEquals("CreateReviewer exceedMaxPaper failed",someU.getID() ,test2.createReviewer(2, thePaper).getID());
	}
	/**
	 * new reviewer, user list is not empty.
	 */
	@Test
	public void testCreateReviewer_notEmptyList(){
		assertEquals("CreateReviewer notEmptyList failed","wifi@everywhere.com" ,test2.createReviewer(1, thePaper).getID());
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
