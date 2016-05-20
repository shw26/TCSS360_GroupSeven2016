package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import model.Conference;
import model.Menu;
import model.User;

public class MenuTest {
	
	Menu testMenu;
	User testUser;
 
	@Before
	public void setUp() {
		testMenu = new Menu();
		testUser = new User("Jim", "White", "WhiteJ@uw.edu");
		User testUser2 = new User("Sam", "Lo", "LoSam@uw.edu");
		testMenu.addUser(testUser2);
		testMenu.addUser(testUser);
		testMenu.createConference("This is the name", testUser2, 5);
	}
	
	@Test
	public void testloginRegisteredUser() {
		assertTrue(testMenu.login("WhiteJ@uw.edu"));
		
	}
	
	@Test
	public void testloginNotRegistered() {
		assertFalse(testMenu.login("Jredd@uw.edu"));
	}
	
	public void testRegisterNewUser() {
		testMenu.register("New", "User", "UserNew@uw.edu");
		assertTrue(testMenu.login("UserNew@uw.edu"));
	}
	
	@Test
	public void testRegisterRegisteredUser() {
		assertEquals(true, testMenu.register("Jim", "White", "WhiteJ@uw.edu"));
	}
	
	/**
	 * Test method for the Factory method createConference.
	 */
	@Test
	public void testCreateConference() {
		User testUser3 = new User("Tester", "Three", "testThree@uw.edu");
		testMenu.createConference("this one", testUser3, 5);
		Conference test = testMenu.getConferences().get(1);
		assertEquals("Conference name matches", "this one", test.getName());
		
	}
	
	@Test
	public void testgetCurrentUser() {
		testMenu.login("WhiteJ@uw.edu");
		assertEquals(testUser, testMenu.getCurrentUser());
	}
	
	@Test
	public void testgetConferences() {
		Conference test = testMenu.getConferences().get(0);
		assertEquals("Conference name matches", "This is the name", test.getName());
		
	}
	
}
