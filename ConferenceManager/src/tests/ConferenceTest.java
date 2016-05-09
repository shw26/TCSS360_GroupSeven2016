package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	public void getAuthorTest() {
		
		assertEquals("getAuthor failed!", null, myConference.getAuthor());
	}
	@Test
	public void getAuthorListTest() {
		Author testA = new Author("Wi", "Fi","wifi@everywhere.com", myConference);
		ArrayList<Author> test = new ArrayList<Author>();
		test.add(testA);
		myConference.setAuthorList(test);
		assertEquals("getAuthorList failed!", testA, myConference.getAuthorList().get(0));
	}
	@Test
	public void getPaperListTest() {
		Paper testP = new Paper("wifi@everywhere.com");
		ArrayList<Paper> test = new ArrayList<Paper>();
		test.add(testP);
		myConference.setPaperList(test);
		assertEquals("getPaperList failed!", testP, myConference.getPaperList().get(0));
	}
	@Test
	public void getPCTest() {
		assertEquals("getPC failed!", "jwolf059@uw.edu", myConference.getPC().getID());
	}
	@Test
	public void getReviewerTest() {
		assertEquals("getReviewer failed!", null, myConference.getReviewer());
	}
	@Test
	public void getReviewerListTest() {
		Reviewer testR = new Reviewer("Wi","Fi","wifi@everywhere.com");
		ArrayList<Reviewer> test = new ArrayList<Reviewer>();
		test.add(testR);
		myConference.setReviewerList(test);
		assertEquals("getReviewerList failed!", testR, myConference.getReviewerList().get(0));
	}
	@Test
	public void getSCTest() {
		assertEquals("getSC failed!", null, myConference.getSC());
	}
	@Test
	public void getSCListTest() { 
		SubProgramChair testSC = new SubProgramChair("Wi", "Fi", "wifi@everywhere.com", null, null);
		ArrayList<SubProgramChair> test = new ArrayList<SubProgramChair>();
		test.add(testSC);
		myConference.setSCList(test);
		assertEquals("getSCList failed!", testSC, myConference.getSCList().get(0));
	}
	@Test
	public void getThePCTest() {
		assertEquals("getThePC failed!", first.getID(), myConference.getThePC().getID());
	}
	/* a test for menu require user input. does not check for any result.
	@Test
	public void confMenuTest() {
		myConference.confMenu(first);
		
		//assertEquals(" confMenu failed!", null, myConference);
	}
	*/
	@Test
	public void getNameTest() {
		assertEquals("getName failed!", "Conference A", myConference.getName());
	}
	@Test
	public void addPaperTest() {
		Paper thePaper = new Paper("wifi@everywhere.com");
		myConference.addPaper(thePaper);
		assertEquals("addPaper failed!", "wifi@everywhere.com", myConference.getPaperList().get(0).getAuthor());
	}
	@Test
	public void removePaperTest() {
		Paper thePaper = new Paper("wifi@everywhere.com");
		myConference.addPaper(thePaper);
		myConference.removePaper(thePaper);
		assertEquals("removePaper failed!", true, myConference.getPaperList().isEmpty());
	}
	
	/*
	@Test
	public void Test() {
		assertEquals(" failed! (not null)", null, myConference);
	}
	*/
}
