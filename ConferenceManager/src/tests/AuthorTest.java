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
	public void addPaperTest() {
		Paper aPaper = new Paper("wifi@everywhere.com");
		myAuthor.addPaper(aPaper);
		assertEquals("addPaper failed!", aPaper, myConference.getPaperList().get(0));
	}
	
	@Test
	public void getIDTest() {
		assertEquals("getID failed!", "wifi@everywhere.com", myAuthor.getID());
	}
	/*
	@Test
	public void Test() {
		assertEquals(" failed!", null, myConference);
	}
	*/
}
