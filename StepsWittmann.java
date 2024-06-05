//Prog6Wittmann
//February 29, 2024
//This program takes user input to adjust and calculate characteristics of the steps 
//input: From other code.
//Output: Draws steps.
//I certify that this is entirely my own work.
public class StepsWittmann {
	private int myStepWidth;
	private int myNumSteps;
	private char myFillStyle;
	
	public StepsWittmann()
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//null constructor
	public StepsWittmann(int newStepWidth, int newNumSteps, char newFillStyle)
	{
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}//full constructor
	//Getters
	public int getStepWidth()
	{
		return myStepWidth;
	}//getStepWidth (getter)
	public int getNumSteps()
	{
		return myNumSteps;
	}//getNumSteps (getter)
	public char getFillStyle()
	{
		return myFillStyle;
	}//getFillStyle (getter)
	//Setters
	public void setStepWidth(int newStepWidth)
	{
		myStepWidth = newStepWidth;
	}//setStepWidth (setter)
	public void setNumSteps(int newNumSteps)
	{
		myNumSteps = newNumSteps;
	}//setNumSteps (setter)
	public void setFillStyle(char newFillStyle)
	{
		myFillStyle = newFillStyle;
	}//setFillStyle (setter)
	//method calcArea accepts the number of steps and step width as parameters, and then calculates the, and returns it.
	public int calcArea(int numSteps, int stepWidth) {
		//initialize local variables
		int area = 0;
		int i = 1;
		for(i = 1; i <= numSteps; i++) 
		{
			area += (stepWidth) * i;
		}//for
		return area;
	}//calcArea Method
	//method drawSteps prints out the steps using the fillStyle, number of steps, and step width provided.
	public void drawSteps() {
		//initialize local variables
		int step = 1;
		int wide = 0;
		for(step = 1; step <= myNumSteps; step++) 
		{
			for(wide = 0; wide < myStepWidth * step; wide++)
			{
				System.out.print(myFillStyle);
			}//for l
			System.out.println();
			
		}//for i
	}//drawSteps method
	//method drawThickSteps prints out the steps, but the width of the step is used to print out a height of the step.
	public void drawThickSteps() {
		//initialize local variables
		int step = 1;
		int width = 0;
		int girth = 0;
		for(step = 1; step <= myNumSteps; step++) 
		{
			for(girth = 0;  girth < myStepWidth; girth++)
				{
					for(width = 0; width < myStepWidth * step; width++)
					{
					System.out.print(myFillStyle);
					}//for width
				System.out.println();
				
				}//for girth
		}//for step
	}//drawThickSteps method
	public String toString()
	{
		return "Step Width: " + myStepWidth + "\nNumber of Steps: " + myNumSteps + "\nFill Style: " + myFillStyle;
		           

	}//toString method, returns an update of the variables and assignments
}//StepsWittmann Class
