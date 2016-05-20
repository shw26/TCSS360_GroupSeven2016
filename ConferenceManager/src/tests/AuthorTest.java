package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import model.Author;
import model.Conference;
import model.Paper;
import model.User;

public class AuthorTest {
	private Conference myConference;
	private Author myAuthor;
	
	@Before
	public void setUp(){
		ArrayList<User> users = new ArrayList<User>();
		User userPC = new User("Wi", "Fi","wifi@everywhere.com");
		myConference = new Conference("Conference A", userPC, users, 5);
		myAuthor = new Author("Wi", "Fi","wifi@everywhere.com", myConference);

	}
	
	@Test 
	public void testUnsubmitEmpty() {
		Paper test1 = new Paper("someAuthor1");
		myAuthor.unsubmit(test1);
		assertTrue("Should be empty", myAuthor.getPapers().isEmpty());
	}
	
	@Test 
	public void testUnsubmitListOnlyHasOnePaper() {
		Paper test1 = new Paper("someAuthor1");
		myAuthor.addPaper(test1);
		assertFalse("Paper list contains papers", myAuthor.getPapers().isEmpty());
		myAuthor.unsubmit(test1);
		assertTrue("Should be empty", myAuthor.getPapers().isEmpty());
	}
	
	@Test 
	public void testUnsubmitListHasMuliPapers() {
		Paper test1 = new Paper("someAuthor1");
		Paper test2 = new Paper("someAuthor2");
		myAuthor.addPaper(test1);
		myAuthor.addPaper(test2);
		assertFalse("Paper List contains papers", myAuthor.getPapers().isEmpty());
		myAuthor.unsubmit(test1);
		assertTrue("Still one in the list", myAuthor.getPapers().size() == 1);
	}
	
	@Test
	public void testEdit() {
		
	}
	
	@Test
	public void testAddPaper() {
		Paper test1 = new Paper("someAuthor1");
		test1.setTitle("Test Paper One");
		myAuthor.addPaper(test1);
		assertFalse("Paper list contains papers", myAuthor.getPapers().isEmpty());
		assertEquals("Titles are the same ", "Test Paper One", myAuthor.getAPaper(0).getTitle() );
	}
	
	@Test
	public void testGetID() {
		assertEquals("ID should be the same ", "wifi@everywhere.com", myAuthor.getID());
	}
	
	@Test
	public void testGetPapers() {
		Paper test1 = new Paper("someAuthor1");
		Paper test2 = new Paper("someAuthor2");
		myAuthor.addPaper(test1);
		myAuthor.addPaper(test2);
		assertEquals("Should be size 2", 2, myAuthor.getPapers().size());
	}
	
	@Test 
	public void testGetAPaper() {
		Paper test1 = new Paper("someAuthor1");
		Paper test2 = new Paper("someAuthor2");
		myAuthor.addPaper(test1);
		myAuthor.addPaper(test2);
		assertEquals("Author should be the same", "someAuthor1", myAuthor.getAPaper(0).getAuthor());
	}
	
	
	
}