package tiktokers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListMyTikTokManagerTest {
	private MyTikTokManager dir;
	private ArrayListMyTikTokManager topTen;

//	@Before
//	public void setUp()
//	{
//	dir = new ArrayListMyTikTokManager();
//	}
	
	@Before
	public void setUp()
	{
	dir = new ArrayListMyTikTokManager();
	topTen = new ArrayListMyTikTokManager();
	System.out.println(System.getProperty("user.dir"));

	topTen.load("src/Top10TikTokers.txt");
	}
	
	@Test
	public void topTenContainsBurak()
	{
	assertNotNull(topTen.get("@cznburak", "Followers"));
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Before
//	public void setUp() throws Exception {
//		
//	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test public void anEmptyDirectoryHasNoRumpledEater()
	{
		
	
	assertNull(dir.get("@rumpledeater", "Followers"));
	dir.put("@name", "Likes", "2000");
	dir.remove("@name", "Likes");
	
	
	assertNull(dir.get("@name", "Likes"));
	}
	 
	
	  

}
