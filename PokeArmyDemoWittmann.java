/**
 * @author Adam Wittmann <br>
 * 
 * Prog10Wittmann <br>
 * 
 * Purpose: This class handles user inputs, manipulates the linked list of Pokemon, and calls other classes to make calculations based on the data.
 * 
 * Input: User inputs a file name, name of pokemon, multiplier of pokemon, power of pokemon, along with the menu selections.
 * 
 * Output: Each pokemon in the linked list of nodes, a pokemon associated with a specific user specified name, the total power of the army, the bonus power of the army, whether the list is empty,
 * and whether the list is full.
 * 
 * Certification of authenticity: <br>
 * I certify that this lab is entirely my own work.
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * PokeArmyDemoWittmann handles all user input and calls needed methods from KeyedListWittmann.
 */
public class PokeArmyDemoWittmann {
	/**
	 * Scanner for user inputs.
	 */
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * Main function where user interacts with program.
	 * @param args, param for main.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokemonWittmann pokeGuy = new PokemonWittmann();//creates an instance of an object from the pokemonWittmann constructor
		PokemonWittmann pokeDude = null;//declares another instance of pokemonWittmann but does not construct it
		KeyedListWittmann myList = new KeyedListWittmann();//declares and constructs the linked list from the linked list class KeyedListWittmann
		String name = null;//declares a String named "name"
		int multiplier = 0;//declares multiplier int
		double power = 0;//declares power
		char choice = 0;//declares char choice
		boolean added = false;//declares boolean added used in the add method
		boolean removed = false;//declares boolean removed used in the remove method
		String forsaken = null;//declares String forsaken used in the remove method
		String find = null;
		double totalPower = 0;
		double bonusPower = 0;
		String fileName = null;
		int pokesInFile = 0;
		int i = 0;
		System.out.println("Hello, welcome to Pokemon Storage.");
		
		System.out.println("--Import Pokemon--");
		System.out.println("Enter a filename: ");
		fileName = keyboard.next();
		File inputFile = new File(fileName);
		//try to input file
		try
		{
			Scanner input = new Scanner(inputFile);
			pokesInFile = input.nextInt();
			for(i = 0; i < pokesInFile; i++) {
				name = input.next();
				multiplier = input.nextInt();
				power = input.nextDouble();
				pokeGuy = new PokemonWittmann(name, multiplier, power);
				added =  myList.add(pokeGuy);
			}//for i
			if(added)System.out.println("Pokemon Added to Storage");
			input.close();
		}//try
		catch(FileNotFoundException ex)
	    {
		      System.out.println("Failed to find file: " + inputFile.getAbsolutePath()); 
		    }//catch
		    catch(InputMismatchException ex)
		    {
		    	System.out.println("Type mismatch for the number I just tried to read.");
		        System.out.println(ex.getMessage());
		    }//catch
		    catch(NumberFormatException ex)
		    {
		      System.out.println("Failed to convert String text into an integer value.");
		      System.out.println(ex.getMessage());
		    }//catch
		    catch(NullPointerException ex)
		    {
		      System.out.println("Null pointer exception.");
		      System.out.println(ex.getMessage());
		    }//catch
		    catch(Exception ex)
		    {
		      // Like an "else" catch(Exception should come last as the catchall.
		    	System.out.println("Something went wrong");
		      ex.printStackTrace();
		    }//catch
		
		do
		{
		
		System.out.println("1. Add a Pokemon to the army\r\n"
				+ "2. Delete a Pokemon from the army\r\n"
				+ "3. Print each Pokemon in the army\r\n"
				+ "4. Search for a user-specified Pokemon in the army\r\n"
				+ "5. Get the total power of the Pokemon army\r\n"
				+ "6. Get the bonus power of the Pokemon army\r\n"
				+ "7. Determine whether the army is empty\r\n"
				+ "8. Determine whether the army is full\r\n"
				+ "9. Clear the army\r\n"
				+ "0. Quit");
		System.out.println("Enter a Menu Choice: ");
		choice = keyboard.next().charAt(0);
		switch(choice) {
		case '1':
			System.out.println("--Add a Pokemon--");
			System.out.println("Enter Pokemon Name: ");
			name = keyboard.next();
			System.out.println("Enter Pokemon Multiplier: ");
			multiplier = keyboard.nextInt();
			while(multiplier < 0) {
				System.out.println("Multiplier cannot be negative\nEnter Pokemon Multiplier: ");
				multiplier = keyboard.nextInt();
			}//while
			System.out.println("Enter Pokemon Power: ");
			power = keyboard.nextDouble();
			while(power < 0) {
				System.out.println("Power cannot be negative\nEnter Pokemon Power: ");
				power = keyboard.nextInt();
			}//while
			pokeGuy = new PokemonWittmann(name, multiplier, power);
			
			if(added = myList.add(pokeGuy))System.out.println("Pokemon Added To Storage.");
			else System.out.println("Pokemon Not Added.");
			//add pokemon to order
			break;
		case '2':
			//delete a pokemon from the army
			System.out.println("--Delete a Pokemon--");
			System.out.println("Enter Pokemon Name You Want Deleted: ");
			forsaken = keyboard.next();
			removed = myList.remove(forsaken);
			if(removed)System.out.println("Pokemon Removed.");
			else System.out.println("Pokemon Not Deleted.\nCheck Spelling or Pokemon is Not in Storage");
			break;
		case '3':
			//Print each pokemon in the army
			System.out.println("--All Pokemon--");
			myList.print();
			break;
		case '4':
			//search for a user-specified pokemon in the army
			System.out.println("--Search For Specific Pokemon--");
			System.out.println("Enter Pokemon Name To Retrieve: ");
			find = keyboard.next();
			pokeDude = myList.retrieve(find);
			if(pokeDude != null)System.out.println("Pokemon Name: "+ pokeDude.getName()+"\nPokemon Multiplier: "+ pokeDude.getMult()+"\nPokemon Power: "+ pokeDude.getPower());
			else System.out.println(find+" Not Found In Storage.");
			break;

		case '5':
			//get the total power of the pokemon army
			System.out.println("--Calculating Total Power--");
			totalPower = myList.getTotalPower();
			System.out.printf("Total Power For All Pokemon In Storage: %.2f", totalPower);
			System.out.println();
			break;
		case '6':
			//get the bonus power of the pokemon army
			System.out.println("--Calculating Bonus Power--");
			bonusPower = myList.calcBonusPower();
			System.out.printf("Bonus Power For All Pokemon In Storage: %.2f", bonusPower);
			System.out.println();
			break;
		case '7':
			//determine whether the army is empty
			System.out.println("--Checking Storage Size--");
			if(myList.isEmpty())System.out.println("Pokemon Storage Empty.");
			else System.out.println("Storage Not Empty.");
			break;
		case '8':
			//determine whether the army is full
			System.out.println("--Checking Storage Capacity--");
			if(myList.isFull())System.out.println("Pokemon Storage Full.");
			else System.out.println("Not Full.");
			break;
		case '9':
			//clear the army
			System.out.println("--Clearing Storage--");
			myList.clearPokemon();
			break;
		case '0':
			//quit the menu.
			System.out.println("Quit.");
			break;
		default:
			//handles all non-menu inputs.
			System.out.println("Error Try Again.");
		}//Switch case
		}while(choice != '0');//do while
		System.out.println("Goodbye.");
	}//main
}//PokeArmyDemoWittmann
