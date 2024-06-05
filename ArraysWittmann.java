//Adam Wittmann
//Prog5Wittmann
//February 22, 2024
//This program helps with statistics of arrays.
//input: Menu option, input letters or grades.
//Output: prints average of grade, highest and lowest grade; prints grades as a percent and letter value; prints lowest number in array and how many times it appears.
//I certify that this is entirely my own work.
import java.util.Scanner;

public class ArraysWittmann {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		//Initialize Variables in Main
		int choice = Integer.MIN_VALUE;
		
		do 
		{
			System.out.println("Select an option:");
			System.out.println("1) Handle Grades\n2) Grade a Quiz\n3) How Many Mins?\n0) Quit");
			choice = keyboard.nextInt();
			switch(choice) 
			{
			case 1:
				System.out.println("Input 10 grades: ");
				double[] gradeStats = handleGrades();
				System.out.println("Highest Grade:"+gradeStats[0]);
				System.out.println("Lowest Grade:"+gradeStats[1]);
				System.out.println("Average Grade:"+gradeStats[2]);
				keyboard.nextLine();
				break;
			case 2:
				calculateQuiz();
				//prompt for multiple choice
				break;
			case 3:
				howManyMins();
				//read up to 10 ints into array
				break;
			case 0:
				System.out.println("Quit");
				break;
			default:
				System.out.println("Invalid input. Try again:");
				break;
			}//switch
		}while(choice != 0);//do while loop
		System.out.println("Finished.");
	}//Main
	//Method handleGrades prompts the user to input 10 double grades and calls methods: calculateHigh, calculateLow, and calculateAvg
	//This method returns the 3 values (high,low,avg) in an array to main where they are printed out.
	public static double[] handleGrades()
	{
		int i =0;
		double nums[] = new double[10];
	    double high = Double.MIN_VALUE;
	    double low = Double.MAX_VALUE;
	    double average = 0;
	    for(i = 0; i < nums.length; i++)
		{
			System.out.println("Enter grade "+(i+1)+":");
			nums[i] = keyboard.nextDouble();
		}//For
		high = calculateHigh(nums);
		low = calculateLow(nums);
		average = calculateAvg(nums);
		return new double[]{high, low, average};
	}//handleGrades Method
	//Method calculateHigh recieves the nums array from handleGrades and calculates the highest number in the array and returns it
	public static double calculateHigh(double[]numListHigh)
	{
		double highNum = Double.MIN_VALUE;
		int i = 0;
		for(i = 0; i < numListHigh.length; i++)
		{
			if(highNum < numListHigh[i])
				highNum = numListHigh[i];
		}//for
		return highNum;
	}//calculateHigh
	//Method calculateLow recieves the nums array from handleGrades and finds the minimum value in the array and returns it
	public static double calculateLow(double[]numListLow)
	{
		double lowNum = Double.MAX_VALUE;
		int i = 0;
		for(i = 0; i < numListLow.length; i++)
		{
			if(lowNum > numListLow[i])
				lowNum = numListLow[i];
		}//for
		return lowNum;
	}//calculateLow
	//Method calculateAvg recieves the nums array from handleGrades, computes the average and then returns it
	public static double calculateAvg(double[]numListAvg)
	{
		double sum = 0;
		double avg = 0;
		int i = 0;
		for(i = 0; i < numListAvg.length; i++)
		{
			sum += numListAvg[i];
		}//for
		avg = sum/numListAvg.length;
		return avg;
	}//calculateAvg
	//Method calculateQuiz takes the input for a quiz to be graded and the answer key for the same quiz, it stores the input separately in arrays that are passed to 
	//scoreQuiz helper method, the number of correct answers is returned and computed into a percentage, which is then printed and converted to a letter grade
	public static void calculateQuiz()
	{
		int i = 0;
		char grades[] = new char[12];
		char key[] = new char[12];
		double percentage = 0;
		int score = 0;
		String letterGrade = "";
		System.out.println("First enter the answers for the quiz, and then you will be prompted for the answer key.");
	    for(i = 0; i < grades.length; i++)
		{
			System.out.println("Enter Answer for Question "+(i+1)+":");
			grades[i] = keyboard.next().toLowerCase().charAt(0);
			while(!(grades[i] == 'a' || grades[i] == 'b' || grades[i] == 'c' || grades[i] == 'd'))
			{
				System.out.println("Invalid, valid inputs: A, B, C, D");
				System.out.println("Enter Answer for Question "+(i+1)+":");
				grades[i] = keyboard.next().toLowerCase().charAt(0);
			}//while
		}//for
	    for(i = 0; i < key.length; i++)
		{
			System.out.println("Enter Answer Key for Question "+(i+1)+":");
			key[i] = keyboard.next().toLowerCase().charAt(0);
			while(!(key[i] == 'a' || key[i] == 'b' || key[i] == 'c' || key[i] == 'd'))
			{
				System.out.println("Invalid, valid inputs: A, B, C, D");
				System.out.println("Enter Answer key for Question "+(i+1)+":");
				key[i] = keyboard.next().toLowerCase().charAt(0);
			}//While
		}//for
	    score = scoreQuiz(grades,key);
	    percentage = ((double)score/12) * 100;
	    if(percentage > 100)
	    	percentage = 100;
	    
		System.out.printf("Grade as percent: %.2f%%", percentage);
		System.out.println();
		if (percentage >= 90) 
	        letterGrade = "A";
	     else if (percentage >= 88 && percentage <= 89.99) 
	        letterGrade = "A-";
	     else if (percentage >= 85 && percentage <= 87.99) 
	    	letterGrade =  "B+";
	     else if (percentage >= 80 && percentage <= 84.99) 
	    	letterGrade = "B";
	     else if (percentage >= 78 && percentage <= 79.99) 
	    	letterGrade = "B-";
	     else if (percentage >= 75 && percentage <= 77.99) 
	    	letterGrade = "C+";
	     else if (percentage >= 70 && percentage <= 74.99) 
	    	letterGrade = "C";
	     else if (percentage >= 68 && percentage <= 69.99) 
	    	letterGrade = "C-";
	  	else if (percentage >= 65 && percentage <= 67.99) 
	    	letterGrade = "D+";
	    else if (percentage >= 60 && percentage <= 64.99) 
	    	letterGrade = "D";
	    else 
	    	letterGrade = "F";
	    
		System.out.println("Letter Grade: "+letterGrade);
		keyboard.nextLine();
	    return;
	}//CalculateQuiz Method
	//scoreQuiz method calculates the score of the quiz and then returns the score to calculateQuiz Method
	public static int scoreQuiz(char[] studentAns, char[] quizKey)
	{
		int i = 0;
		int score = 0;
	    for(i = 0; i < studentAns.length; i++)
	    {
	    	if (studentAns[i] == quizKey[i])
	    		score++;
	    }//for
	    return score;
	}//Method scoreQuiz
	//HowManyMins first accepts a list of up to 10 integers and then stops when a negative number is input. This method calls minTrack which calculates what the lowest number and number of ocurrances.
	public static void howManyMins()
	{
		int ints[] = new int[10];
		int i = 0;
		int currentNum = 0;
		int length = 0;
		System.out.println("This option will calculate the lowest number in an array and how many times it appears.");
		System.out.println("Enter Positive Integers, Negative Integer to Quit:");
		while(!(currentNum < 0) && (i < ints.length))
		{
			currentNum = keyboard.nextInt();
			if(currentNum >= 0)
			{
				ints[i] = currentNum;
				length++;
			}//if
			i++;
			}//while
		minTrack(ints, length);
		keyboard.nextLine();
	}//howManyMins
	//minTrack Method calculates how many times the lowest number in an array appears and prints the lowest number and how many times it appeared.
	public static void minTrack(int[] integers, int size)
	{
		int minimum = Integer.MAX_VALUE;
		int i = 0;
		int occurrences = 0;
		for(i = 0; i < size; i++)
		{
			if(minimum > integers[i])
			{
				minimum = integers[i];
				occurrences =1;
			}//if
			else if (minimum == integers[i])
				occurrences++;
			System.out.print(integers[i] + "  ");
		}//for
		if(minimum == Integer.MAX_VALUE)
			System.out.println("No Values entered.");
		else
			System.out.println("\nMinimum: "+minimum+"\nOccurrences: "+occurrences);
	}//minTrack method
}//class
