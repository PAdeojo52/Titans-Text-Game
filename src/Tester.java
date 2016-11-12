//package talesOfTitans;

import java.util.Scanner;

public class Tester 
{

	static String input = "";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		RoomControl rc = new RoomControl();
		
		do
		{
			input = keyboard.nextLine();
			rc.move(input);
		}while(rc.moves < 10);
		
		System.out.println("Done");
	}

}
