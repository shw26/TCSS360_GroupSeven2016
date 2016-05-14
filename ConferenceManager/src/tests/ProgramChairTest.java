package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Paper;
import model.ProgramChair;
import model.Reviewer;
import model.SubProgramChair;
import model.User;

public class ProgramChairTest {
	ProgramChair pc;
	ArrayList<Paper> thePList;
	ArrayList<SubProgramChair> theSCs;
	ArrayList<User> theUsers;
	ArrayList<Reviewer> theReviewers;
	@Before
	public void setUp(){
		thePList = new ArrayList<Paper>();
		theSCs = new ArrayList<SubProgramChair>();
		theUsers = new ArrayList<User>();
		theReviewers = new ArrayList<Reviewer>();
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, theUsers, theReviewers);
	}
	
	@Test
	public void testCreateSubProgramChairA() {
		User user = new User("so","me","some");
		theUsers.add(user);
		assertEquals("CreateSubProgramChair A fail", user.getID(), pc.createSubProgramChair(1).getID());
	}
	@Test
	public void testCreateSubProgramChairB() {
		User user = new User("so","me","some");
		theUsers.add(user);
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc);
		assertEquals("CreateSubProgramChair B fail", user.getID(), pc.createSubProgramChair(1).getID());
	}
	@Test
	public void testAssignPaperToSCA() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("pa");
		spc.addPaper(pa);
		spc.addPaper(pa);
		spc.addPaper(pa);
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("AssignPaperToSC A fail", 1, pc.assignPaperToSC(1, spc));
	}
	@Test
	public void testAssignPaperToSCB() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("some");
		spc.addPaper(pa);
		
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("AssignPaperToSC B fail", 2, pc.assignPaperToSC(1, spc));
	}
	@Test
	public void testAssignPaperToSCC() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("pa");
		spc.addPaper(pa);
		spc.addPaper(pa);
		spc.addPaper(pa);
		spc.addPaper(pa);
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("AssignPaperToSC C fail", 3, pc.assignPaperToSC(1, spc));
	}
	

	@Test
	public void testIsPresentA() {
		User user = new User("so","me","some");
		assertEquals("isPresent A failed", false, pc.isPresent(user));
	}
	@Test
	public void testIsPresentB() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent B failed", true, pc.isPresent(user));
	}
	@Test
	public void testIsPresentC() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("el", "se", "else", null, null);
		theSCs.add(spc);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent B failed", false, pc.isPresent(user));
	}
	
	@Test
	public void testMakeFinalT() {
		Paper pa = new Paper("pa");
		pc.makeFinal(pa, 1);
		assertTrue("MakeFinal T failed", pa.getFinal());
	}
	@Test
	public void testMakeFinalF() {
		Paper pa = new Paper("pa");
		pc.makeFinal(pa, 2);
		assertFalse("MakeFinal F failed", pa.getFinal());
	}
}
