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
/**
 * TEST FOR PC
 * @author SHAO-HAN WANG (kevin)
 * @version 5/22/2016
 */
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
	
	/**
	 * theSelection is 0.
	 */
	@Test
	public void testCreateSubProgramChair_0() {
		assertEquals("CreateSubProgramChair 0 fail", null, pc.createSubProgramChair(0));
	}
	
	/**
	 * a user is not an SC.
	 */
	@Test
	public void testCreateSubProgramChair_notSC() {
		User user = new User("so","me","some");
		theUsers.add(user);
		assertEquals("CreateSubProgramChair notSC fail", user.getID(), pc.createSubProgramChair(1).getID());
	}
	/**
	 * a user is an SC, and one item in SC list.
	 */
	@Test
	public void testCreateSubProgramChair_isSC_oneItem() {
		User user = new User("so","me","some");
		theUsers.add(user);
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc);
		assertEquals("CreateSubProgramChair isSC_oneItem fail", user.getID(), pc.createSubProgramChair(1).getID());
	}
	
	/**
	 * a user is an SC, and multiple item in SC list.
	 */
	@Test
	public void testCreateSubProgramChair_isSC_multiItem() {
		User user = new User("so","me","some");
		theUsers.add(user);
		SubProgramChair spc1 = new SubProgramChair("1", "1", "1", null, null);
		theSCs.add(spc1);
		SubProgramChair spc2 = new SubProgramChair("2", "2", "2", null, null);
		theSCs.add(spc2);
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc);
		assertEquals("CreateSubProgramChair isSC_multiItem fail", user.getID(), pc.createSubProgramChair(1).getID());
	}
	
	/**
	 * paper has been assigned to the selected SC, success.
	 */
	@Test
	public void testAssignPaperToSC_paperHasBeenAssigned() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("pa");
		spc.addPaper(pa);
		Paper pb = new Paper("pb");
		spc.addPaper(pb);
		Paper pd = new Paper("pd");
		spc.addPaper(pd);
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("AssignPaperToSC paperHasBeenAssigned fail", true, pc.assignPaperToSC(1, spc));
	}
	
	/**
	 * sc already have 4 papers.
	 */
	@Test
	public void testAssignPaperToSC_exceedMax() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("pa");
		spc.addPaper(pa);
		Paper pb = new Paper("pb");
		spc.addPaper(pb);
		Paper pd = new Paper("pd");
		spc.addPaper(pd);
		Paper pe = new Paper("pe");
		spc.addPaper(pe);
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("AssignPaperToSC exceedMax fail", false, pc.assignPaperToSC(1, spc));
	}
	
	/**
	 * the selected SC is the Author of the paper.
	 */
	@Test
	public void testIsAuthor_SCIsTheAuthor() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("some");
		spc.addPaper(pa);
		
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("testIsAuthor SCIsTheAuthor fail", true, pc.isAuthor(1, spc));
	}
	
	/**
	 * the selected SC is not the Author of the paper.
	 */
	@Test
	public void testIsAuthor_SCIsNotTheAuthor() {
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		Paper pa = new Paper("wifi");
		spc.addPaper(pa);
		
		theSCs.add(spc);
		thePList.add(pa);
		
		assertEquals("testIsAuthor SCIsNotTheAuthor fail", false, pc.isAuthor(1, spc));
	}
	
	
	
	/**
	 * When the List is empty.
	 */
	@Test
	public void testIsPresent_TheUserIsNotSubChair_WhenListIsEmpty() {
		User user = new User("so","me","some");
		assertEquals("isPresent TheUserIsNotSubChair_WhenListIsEmpty failed", false, pc.isPresent(user));
	}
	/**
	 * When the list has one item
	 * The User is a subprogram chair.
	 */
	@Test
	public void testIsPresent_TheUserIsSubChair_OneItem() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent TheUserIsSubChair_OneItem failed", true, pc.isPresent(user));
	}
	/**
	 * When the list has one item
	 * The User is NOT a subprogram chair.
	 */
	@Test
	public void testIsPresent_TheUserIsNotSubChair_OneItem() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("el", "se", "else", null, null);
		theSCs.add(spc);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent TheUserIsNotSubChair_OneItem failed", false, pc.isPresent(user));
	}
	/**
	 * When the list has multiple item
	 * The User is a subprogram chair.
	 */
	@Test
	public void testIsPresent_TheUserIsSubChair_MutiItem() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("el", "se", "else", null, null);
		theSCs.add(spc);
		SubProgramChair spc2 = new SubProgramChair("2", "2", "2", null, null);
		theSCs.add(spc2);
		SubProgramChair spc3 = new SubProgramChair("so", "me", "some", null, null);
		theSCs.add(spc3);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent TheUserIsSubChair_MutiItem failed", true, pc.isPresent(user));
	}
	/**
	 * When the list has multiple item
	 * The User is not subprogram chair.
	 */
	@Test
	public void testIsPresent_TheUserIsNotSubChair_MutiItem() {
		User user = new User("so","me","some");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		SubProgramChair spc = new SubProgramChair("el", "se", "else", null, null);
		theSCs.add(spc);
		SubProgramChair spc2 = new SubProgramChair("2", "2", "2", null, null);
		theSCs.add(spc2);
		SubProgramChair spc3 = new SubProgramChair("3", "3", "3", null, null);
		theSCs.add(spc3);
		pc = new ProgramChair("wi", "fi", "wifi@everywhere.com", thePList, theSCs, userList, theReviewers);
		assertEquals("isPresent TheUserIsNotSubChair_MutiItem failed", false, pc.isPresent(user));
	}
	
	/**
	 * the paper is accepted.
	 */
	@Test
	public void testMakeFinal_ThePaperIsTheDecision() {
		Paper pa = new Paper("pa");
		pc.makeFinal(pa, 1);
		assertTrue("MakeFinal T failed", pa.getFinal());
	}
	/**
	 * the paper is not accepted.
	 */
	@Test
	public void testMakeFinal_ThePaperIsNotTheDecision() {
		Paper pa = new Paper("pa");
		pc.makeFinal(pa, 2);
		assertFalse("MakeFinal F failed", pa.getFinal());
	}
}
