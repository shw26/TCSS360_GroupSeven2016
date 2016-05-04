import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SubProgramChairTest {
	ArrayList<User> myUserList = new ArrayList<User>();
	User testUser = new User("Frank", "Small", "SmallTank@uw.edu");
	User testUser1 = new User("James", "Franco", "jFrank@aswesome.net");
	SubProgramChair test1 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu", myUserList);
	Paper thePaper = new Paper("Freddy is crazy");
	Paper thePaper2 = new Paper("Beer Beer Beer");

	@Test
	public void testscMenu() {
		myUserList.add(testUser);
		myUserList.add(testUser1); 
		SubProgramChair test1 = new SubProgramChair("Jeremy", "Wolf", "Jwolf059@uw.edu", myUserList);
		test1.addPaper(thePaper);
		test1.scMenu();
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
}
