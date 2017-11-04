package menu;

import java.util.Scanner;

public class Menu 
{
	private Scanner input;
	private boolean isInt = false;
	private int selection;
	
	
	   public Menu() {
		
		
		while(isInt == false){
		Scanner input = new Scanner(System.in);	

		System.out.println("Enter one of the following numbers: ");
		System.out.println("1 - Single Player");
		System.out.println("2 - Two Players");
		System.out.println("3 - Settings");
		System.out.println("4 - Exit");
		System.out.println("> Enter a number below: " );	
		
		try
			{
			selection = input.nextInt();
			isInt = true;
			}
		catch(Exception e)
			{
			System.out.println("Invalid selection");
			isInt = false;
			}
		}
		
		switch (selection)
		{
		case 1:
			System.out.print("Call single player class");
			break;
		
		case 2:
			System.out.print("Call two player class");
			break;
		
		case 3:
			System.out.print("Call setting class");
			break;
		
		case 4:
			System.out.print("Thanks For Playing");
			System.exit(-1);
		break;
		default:
			System.out.println("Number is out of bounds");
			System.exit(-1);
		}
	}
}
	

