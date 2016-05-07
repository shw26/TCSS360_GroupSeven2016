
public class driver {

	
	
	public static void main(String[] args) {
		Menu system = new Menu();
		User first = new User("Jeremy", "Wolf", "jwolf059@uw.edu");
		User second = new User("Samson", "Gefofy", "Starliker123@yahoo.com");
		User third = new User("Jacob", "Grey", "GreyJ@uw.edu");
		User fourth = new User("Ubal", "Sakses", "ZB4LIFE@yahoo.com");
		
		system.createConference("The Stars are our Future Annual Meeting", first );
		system.createConference("453 Annual Beer Beer Beer Convention", second );
		system.createConference("15th Annual meeting of Robots Will Rule One Day", third);
		
		system.welcomeMenu();

	}

}
