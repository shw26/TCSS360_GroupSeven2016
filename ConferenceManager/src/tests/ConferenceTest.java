package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import model.Author;
import model.Conference;
import model.Paper;
import model.Reviewer;
import model.SubProgramChair;
import model.User;
/**
 * junit test for conference.
 * @author Shao-Han Wang
 * @version 5/1/2016
 */
public class ConferenceTest {

	private Conference myConference;
	User first;
	User second;
	User third;
	User fourth;
	
	@Before
	public void setUp(){
		first = new User("Jeremy", "Wolf", "jwolf059@uw.edu");
		second = new User("Samson", "Gefofy", "Starliker123@yahoo.com");
		third = new User("Jacob", "Grey", "GreyJ@uw.edu");
		fourth = new User("Ubal", "Sakses", "ZB4LIFE@yahoo.com");
		ArrayList<User> users = new ArrayList<User>();
		users.add(first);
		users.add(second);
		users.add(third);
		users.add(fourth);
		myConference = new Conference("Conference A", first, users, 5);
	}

	@Test
	public void testGetAuthorNoAuthorsAddedToConference() {
		assertEquals("getAuthor failed!", null, myConference.getAuthor());
	}
	@Test
	public void testGetAuthorListForNewAuthorCreationAndAddition() {
		Author testA = new Author("Wi", "Fi","wifi@everywhere.com", myConference);
		ArrayList<Author> test = new ArrayList<Author>();
		test.add(testA);
		myConference.setAuthorList(test);
		assertEquals("getAuthorList failed!", testA, myConference.getAuthorList().get(0));
	}
	@Test
	public void testGetPaperListForNewPaperCreationAndAddition() {
		Paper testP = new Paper("wifi@everywhere.com");
		ArrayList<Paper> test = new ArrayList<Paper>();
		test.add(testP);
		myConference.setPaperList(test);
		assertEquals("getPaperList failed!", testP, myConference.getPaperList().get(0));
	}
	@Test
	public void testGetPCForPCCreatedInSetup() {
		assertEquals("getPC failed!", "jwolf059@uw.edu", myConference.getPC().getID());
	}
	@Test
	public void testGetReviewerNoReviewerAddedToConference() {
		assertEquals("getReviewer failed!", null, myConference.getReviewer());
	}
	@Test
	public void testGetReviewerListForNewReviewerCreationAndAddition() {
		Reviewer testR = new Reviewer("Wi","Fi","wifi@everywhere.com");
		ArrayList<Reviewer> test = new ArrayList<Reviewer>();
		test.add(testR);
		myConference.setReviewerList(test);
		assertEquals("getReviewerList failed!", testR, myConference.getReviewerList().get(0));
	}
	@Test
	public void testGetSCNoSCAddedToConference() {
		assertEquals("getSC failed!", null, myConference.getSC());
	}
	@Test
	public void testGetSCListForNewSCCreationAndAddition() { 
		SubProgramChair testSC = new SubProgramChair("Wi", "Fi", "wifi@everywhere.com", null, null);
		ArrayList<SubProgramChair> test = new ArrayList<SubProgramChair>();
		test.add(testSC);
		myConference.setSCList(test);
		assertEquals("getSCList failed!", testSC, myConference.getSCList().get(0));
	}
	@Test
	public void testGetThePCForPresetPC() {
		assertEquals("getThePC failed!", first.getID(), myConference.getThePC().getID());
	}
	
	@Test
	public void testGetNameForPresetConferenceName() {
		assertEquals("getName failed!", "Conference A", myConference.getName());
	}
	@Test
	public void testAddPaperForNewPaperCreationAndAddition() {
		Paper thePaper = new Paper("wifi@everywhere.com");
		myConference.addPaper(thePaper);
		assertEquals("addPaper failed!", "wifi@everywhere.com", myConference.getPaperList().get(0).getAuthor());
	}
	@Test
	public void testRemovePaperForNewPaperCreationAdditionAndRemoving() {
		Paper thePaper = new Paper("wifi@everywhere.com");
		myConference.addPaper(thePaper);
		myConference.removePaper(thePaper);
		assertEquals("removePaper failed!", true, myConference.getPaperList().isEmpty());
	}
	
	@Test
	public void testCheckRolesForPCFromPresetPC() {
		myConference.checkRoles(first);
		assertEquals("checkRoles failed!", myConference.getThePC(), myConference.getPC());
	}
	
	@Test
	public void testCheckRolesForNonPC() {
		myConference.checkRoles(second);
		assertEquals("checkRoles failed!", null, myConference.getPC());
	}
	
	@Test
	public void testSetDueDateForPastDeadline() {
		Calendar myCal = Calendar.getInstance();
		myConference.setDueDate(myCal, -1);
		assertTrue("SetDueDate Failure", myConference.isDeadlinePast());
	}
	
	@Test
	public void testSetDueDateForNotPastDeadline() {
		Calendar myCal = Calendar.getInstance();
		myConference.setDueDate(myCal, 2);
		assertFalse("SetDueDate Failure", myConference.isDeadlinePast());
	}
}
