package Entity;
import java.util.ArrayList;
import java.util.List;
import Inventory.*;
/**
 * Class: Player.java
 * 
 * @author Peter Adeojo
 * @version 1.0
 *          <p>
 * Course : ITEC 3150 Spring 2016 
 * Written: Oct 10, 2016
 * 
 * 
 *  This class – This class describes the common attributes and methods
 *          of the Player.java
 * 
 *  Purpose: – ******
 */




public class Player extends Entity
{
	private int gold;
	private List<Item> invetory;
	
	
	

	public void move()
	{
		//RoomID + 1
		//Hopefully the room ID will be linear as to not make it to confusing
	}
	
	public void use(Usable useItem)
	{
		//Will enact the potion
	}
	
	public void equip(Item  newWeapon) 
	{
		

	}

	public void get(Item  newItem) 
	{
		
		invetory.add(newItem);

	}

	public void buy(Item  newItem) 
	{
		
		if(gold - newItem.getPrice()>=0)
		{
			invetory.add(newItem);
			System.out.println("The item has been purchased");
		}
		else
		{
			System.out.println("Insufficient Funds");
		}
		
		

	}
//Cannot be done without the rest of the subsystems.
	public void retreat() 
	{
		
		
	}

	public void look(Rooms  roomID)
	{

	}

	public void examine(Rooms puzzleID) 
	{

	}

	public void examine(Entity monster) 
	{
		
		//returns the examine 

	}

}
