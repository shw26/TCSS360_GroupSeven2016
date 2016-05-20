package tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.User;

/**
 * 
 */

/**
 * This class tests the User class.
 * @author Jeremy Wolf
 * @version 05/19/2016
 */
public class UserTest {

	public User testUser1;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testUser1 = new User("Frank", "Smith", "SmithF@gamil.com");
	}
	
	@Test
	public void testGetFirst() {
		assertEquals(testUser1.getFirst(), "Frank");
	}
	
	@Test
	public void testGetLast() {
		assertEquals(testUser1.getLast(), "Smith");
	}
	
	@Test
	public void testGetID() {
		assertEquals(testUser1.getID(), "SmithF@gamil.com");
	}

}