package room;

import java.util.Scanner;

public class Tester 
{	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		RoomControl rc = new RoomControl();
		
		String input = "", location = "";
		
		do
		{
			input = keyboard.nextLine();
			location  = rc.move(input);
		}while(!location.equals("T10"));
		
		System.out.println("Done");
	}
}