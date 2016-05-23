package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuthorTest.class, ConferenceTest.class, MenuTest.class, PaperTest.class, ProgramChairTest.class,
		ReviewerTest.class, ReviewTest.class, SubProgramChairTest.class, UserTest.class })

public class AllTests {

}
