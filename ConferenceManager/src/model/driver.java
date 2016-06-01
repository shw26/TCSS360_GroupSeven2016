package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import view.MenuUI;

public class driver {	
	
	/**
	 * This is the driver for the Conference Manager program.
	 * 
	 * @param args console arguments, unused
	 */
	public static void main(String[] args) {
		MenuUI newSystem = new MenuUI();
		Menu system = openSave();
		if (system == null) {
			system = new Menu();
			User first = new User("Jeremy", "Wolf", "jwolf059@uw.edu");
			User second = new User("Samson", "Gefofy", "Starliker123@yahoo.com");
			User third = new User("Jacob", "Grey", "GreyJ@uw.edu");

			
			system.createConference("SPIE Astronomical Telescopes + Instrumentation Annual Meeting", first, 10);
			system.createConference("10th Annual Early Childhood Education Convention", second, 0);
			system.createConference("15th Annual meeting of Doctors in Orthopedics", third, 3);
		}
		newSystem.setMenu(system);
		newSystem.welcomeMenu();
		exitSave(system);

	}
	
	/**
	 * This opens a save file containing the serialized data from a previous state.
	 * 
	 * @return A previous saved state of the program
	 */
	public static Menu openSave() {
		Menu m = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("menu.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         m = (Menu) in.readObject();
	         in.close();
	         fileIn.close();
	         return m;
	      } catch (FileNotFoundException e) {
	    	  return m;
	      } catch (IOException e) {
	    	  return m;
			
		} catch (ClassNotFoundException e) {
			return m;
		}
	}
	
	
	
	/**
	 * Creates output file with serialized information for the state of the system.
	 */
	public static void exitSave(Menu theMenu) {
		 try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("menu.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(theMenu);
	         out.close();
	         fileOut.close();
	         System.out.printf("Backup Complete");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

}
