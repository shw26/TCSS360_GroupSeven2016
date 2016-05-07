import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**
 * junit test for conference.
 * @author Shao-Han Wang
 * @version 5/1/2016
 */
public class ConferenceTest {

	/*private Conference myConference;
	
	@Before
	public void setUp(){
		myConference = new Conference(null, null, null, null, null);
	}

	@Test
	public void getAuthorTest() {
		assertEquals("getAuthor failed! (not null)", null, myConference.getAuthor());
	}
	@Test
	public void getAuthorListTest() {
		Author testA = new Author();
		ArrayList<Author> test = new ArrayList<Author>();
		test.add(testA);
		myConference.setAuthorList(test);
		assertEquals("getAuthorList failed! (not null)", testA, myConference.getAuthorList().get(0));
	}
	@Test
	public void getPaperListTest() {
		Paper testP = new Paper(null);
		ArrayList<Paper> test = new ArrayList<Paper>();
		test.add(testP);
		myConference.setPaperList(test);
		assertEquals("getPaperList failed! (not null)", testP, myConference.getPaperList().get(0));
	}
	@Test
	public void getPCTest() {
		assertEquals("getPC failed! (not null)", null, myConference.getPC());
	}
	@Test
	public void getReviewerTest() {
		assertEquals("getReviewer failed! (not null)", null, myConference.getReviewer());
	}
	@Test
	public void getReviewerListTest() {
		Reviewer testR = new Reviewer();
		ArrayList<Reviewer> test = new ArrayList<Reviewer>();
		test.add(testR);
		myConference.setReviewerList(test);
		assertEquals("getReviewerList failed! (not null)", testR, myConference.getReviewerList().get(0));
	}
	@Test
	public void getSCTest() {
		assertEquals("getSC failed! (not null)", null, myConference.getSC());
	}
	@Test
	public void getSCListTest() {
		SubprogramChair testSC = new SubprogramChair();
		ArrayList<SubprogramChair> test = new ArrayList<SubprogramChair>();
		test.add(testSC);
		myConference.setSCList(test);
		assertEquals("getSCList failed! (not null)", testSC, myConference.getSCList().get(0));
	}
	@Test
	public void getThePCTest() {
		ProgramChair testPC = new ProgramChair();
		myConference.setThePC(testPC);
		assertEquals("getThePC failed! (not null)", testPC, myConference.getThePC());
	}
	/*
	@Test
	public void Test() {
		assertEquals(" failed! (not null)", null, myConference);
	}
	*/
}
