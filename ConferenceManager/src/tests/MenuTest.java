package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import model.Menu;
import model.User;

public class MenuTest {
	
	Menu testMenu;
 
	@Before
	public void setUp() {
		testMenu = new Menu();
		User testUser = new User("Jim", "White", "WhiteJ@uw.edu");
		User testUser2 = new User("Sam", "Lo", "LoSam@uw.edu");
		testMenu.addUser(testUser2);
		testMenu.addUser(testUser);
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
		
	}
	
	/**
	 * Test method for the Factory method createConference.
	 */
	@Test
	public void testCreateConference() {
		
	}
	
	@Test
	public void testgetCurrentUser() {
		
	}
	
	@Test
	public void testgetConferences() {
		
	}
	
}
