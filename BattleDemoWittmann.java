/**
 * @author AdamWittmann 
 * 
 * Prog11Wittmann
 * 
 * Purpose: This class handles the battle functions
 * 
 * input: the input is the file the user puts in.
 * 
 * Output: The class prints out the result of the battles.
 * 
 * Certificate of authenticity:
 * I certify that this lab is entirely my own work.
 */
import java.util.*;
import java.io.*;


/**
 * BattleDemoWittmann handles all of the battle calculations.
 */
public class BattleDemoWittmann {
	/**
	 * instance variable DEBUG to help debug
	 */
	//Corrected: Turned DEBUG to false
	public static final boolean DEBUG = false;
	/**
	 * Scanner reads the input
	 */
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * Main function that handles all of the calculations 
	 * @param args, param for main
	 */
	public static void main(String[] args) {
		String fileName = null;
		int totalCards = 0;
		int j = 0;
		int games = 0;
		int winner = 0;

		StackWittmann playerOneDisc = new StackWittmann();
		StackWittmann playerTwoDisc = new StackWittmann();
		StackWittmann playerTwo = new StackWittmann();
		StackWittmann playerOne = new StackWittmann();
		PokemonCardWittmann player1Card = null;
		PokemonCardWittmann player2Card = null;
		boolean over = false;

		
		
		

		System.out.println("--Import Pokemon--");
		System.out.println("Enter a file name: ");
		fileName = keyboard.next();
		totalCards = deal(fileName,playerOne, playerTwo);
		while(games < 1000 && !over)
		{
			if((playerOne.isEmpty() && !playerOneDisc.isEmpty())) {
				copy(playerOne, playerOneDisc);
			}//if
			if(playerTwo.isEmpty() && !playerTwoDisc.isEmpty()) {
				copy(playerTwo, playerTwoDisc);
			}//if
			if (playerOne.isEmpty() || playerTwo.isEmpty()) {
	            over = true;
			}//if
			else {
				player1Card = play(playerOne);
				player2Card = play(playerTwo);
				if(DEBUG) {
					System.out.println("Game: "+games);
					System.out.println("Battle");
					System.out.println(player1Card);
					System.out.println("VS");
					System.out.println(player2Card);
				}//if DEBUG
				winner = compare(player1Card, player2Card);
				winPlay(winner, player1Card, player2Card, playerOneDisc, playerTwoDisc);
				games++;
			}//else
		}//while

		printResults(totalCards, games, playerOne, playerTwo, playerOneDisc, playerTwoDisc);
		
	}//Main
	/**
	 * Deal method handles the deal from the imported file.
	 * @param file the file that the user imports
	 * @param p1 player 1 stack
	 * @param p2 player 2 stack
	 * @return pokesInFile the number of pokes in a file.
	 */
	public static int deal(String file, StackWittmann p1, StackWittmann p2)
	{
		PokemonCardWittmann playerOneCard = new PokemonCardWittmann();
		PokemonCardWittmann playerTwoCard = new PokemonCardWittmann();
		int pokesInFile = 0;
		String name = null;
		int multiplier = 0;
		double power = 0;
		int i = 0;
		boolean added = false;
		boolean isPlayerOneTurn = true;

		File inputFile = new File(file);
		//try to input file
		try
		{
			Scanner input = new Scanner(inputFile);
			pokesInFile = input.nextInt();
			for(i = 0; i < pokesInFile; i++) {
				name = input.next();
				multiplier = input.nextInt();
				power = input.nextDouble();
				
				
				//Add to stack
				if (isPlayerOneTurn) {
			        p1.push(new PokemonCardWittmann(name, multiplier, power));
			        isPlayerOneTurn = false;  // Next card goes to Player 2
			        if(DEBUG)
					{
						System.out.println("Player 1 poke "+ (i+1) +" name: "+ name+ " multiplier: "+ multiplier+" power: "+power);
					}//if DEBUG
			    }//if
				else {
			        p2.push(new PokemonCardWittmann(name, multiplier, power));
			        isPlayerOneTurn = true;  // Next card goes back to Player 1
			        if(DEBUG)
					{
						System.out.println("Player 2 poke "+ (i+1) +" name: "+ name+ " multiplier: "+ multiplier+" power: "+power);
					}//if DEBUG
			    }//else
			}//for i
			if(added)System.out.println("Pokemon(s) Added to Storage");
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
		return pokesInFile;
	}//deal
	
	/**
	 * play simulates popping a card from the players stack and in some cases if the main stack is empty the discard stack is copied to the main stack
	 * @param stack the players stack
	 * @param discard the players discard stack
	 * @return the card that is popped from the list
	 */
	public static PokemonCardWittmann play(StackWittmann stack)
	{
		PokemonCardWittmann card = null;
		if(!stack.isEmpty()) {
			card = stack.pop();
		}//if
		return card;
	}//play
	
	/**
	 * compare compares the 2 users cards
	 * @param p1Card player 1s card	
	 * @param p2Card player 2s card
	 * @return 1 if player 1 wins and -1 if player 2 wins and 0 if its a tie.
	 */
	public static int compare(PokemonCardWittmann p1Card, PokemonCardWittmann p2Card) 
	{
		int winner = 0; //p1win = 1 p2=-1 tie = 0
		int p1Mult = 0;
		int p2Mult = 0;
		
		if(p1Card.getPower() > p2Card.getPower()) {
			winner = 1;
		}//if
		else if(p2Card.getPower() > p1Card.getPower()) {
			winner = -1;
		}//else if
		else {
			p1Mult = p1Card.getMulti();
			p2Mult = p2Card.getMulti();
			if(p1Mult > p2Mult) {
				winner = 1;
			}//if
			else if(p1Mult < p2Mult) {
				winner = -1;
			}//else if
			else {
				winner = 0;
			}//else
		}//else
		return winner;
	}//compare
	/**
	 * Handles where the cards go after the user wins
	 * @param player the winner of the battle
	 * @param card1 1st users card
	 * @param card2 2nd users card
	 * @param discard1 player 1 discard
	 * @param discard2 player 2 discard
	 */
	public static void winPlay(int player, PokemonCardWittmann card1, PokemonCardWittmann card2, StackWittmann discard1, StackWittmann discard2)
	{
		//Corrected: No longer has nested if statements because the code will push the winners card(the higher card) first.
		if(player == 1)
		{
				discard1.push(card1);
				discard1.push(card2);
		}//if
		else if(player == -1) {
			discard2.push(card2);
			discard2.push(card1);
		}//if
		else {
			discard1.push(card1);
			discard2.push(card2);
		}//else
	}//winPlay
	/**
	 * copy copies the discard stack to the main stack
	 * @param stack the users main stack
	 * @param discard the users discard stack
	 */
	public static void copy(StackWittmann stack, StackWittmann discard)
	{
		PokemonCardWittmann poke = null;
		StackWittmann temp = new StackWittmann();
		while(!(discard.isEmpty())) {
			poke = discard.pop();
			temp.push(poke);
		}//while
		while(!(temp.isEmpty())) {
			poke = temp.pop();
			stack.push(poke);
		}//while
	}//copy
	/**
	 * countCards counts the cards in a given stack
	 * @param pokeStack the users stack
	 * @return count, how many cards are in the stack
	 */
	public static int countCards(StackWittmann pokeStack)
	{
		int count = 0;
		StackWittmann temp = new StackWittmann();
		PokemonCardWittmann value = null;
		while(!pokeStack.isEmpty())
		{
			value = pokeStack.pop();
			count++;
			temp.push(value);
		}//while
		while(temp.isEmpty() == false)
		{
			value = temp.pop();
			pokeStack.push(value);		
		}//while
		return count;
	}//countCards
	/**
	 * printResults prints the results of the battle
	 * @param numCards how many cards are in the original deck
	 * @param rounds how many rounds the game took
	 * @param p1Deck player ones deck
	 * @param p2Deck player twos deck
	 */
	public static void printResults(int numCards, int rounds, StackWittmann p1Deck, StackWittmann p2Deck, StackWittmann disc1, StackWittmann disc2)
	{
		System.out.println("BATTLE CARD GAME SUMMARY\n=========================");
		System.out.println("The game started with "+numCards+" cards.");
		System.out.println("The game had "+ rounds + " plays.");
		if(countCards(p1Deck) == countCards(p2Deck)) System.out.println("The game ended with no clear winner.");
		else if(p1Deck.isEmpty() || p2Deck.isEmpty())System.out.println("The game ended with a clear winner.");
		System.out.println("Player one's deck ended with: "+ (countCards(p1Deck) + countCards(disc1)) + " pokemon.");
		System.out.println("Player two's deck ended with: "+ (countCards(p2Deck) + countCards(disc2)) +" pokemon.");
		if(countCards(p2Deck) > countCards(p1Deck))System.out.println("The winner was Player Two.");
		else if(countCards(p1Deck) > countCards(p2Deck))System.out.println("The winner was Player One.");
	}//printResults
}//BattleDemo
