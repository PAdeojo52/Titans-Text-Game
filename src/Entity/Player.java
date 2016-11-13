package Entity;
import inventory.Item;

import java.util.ArrayList;
import java.util.List;

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
	
	
	//Creates a constructor for the player class
	public Player()
	{
		gold = 0;
		name = "Player";
	}

	//Allows the player to move through room
	//Moved to main subsystem
//	public void move()
//	{
//		//RoomID + 1
//		//Hopefully the room ID will be linear as to not make it to confusing
//	}
	
	//If the item in the inv is a potion, it is considered usable.
	//Will allow for user to drink potion
	/*
	public void useItems(Usable useItem)
	{
		//Will enact the potion
		
		useItem.use();
	}
	*/
	
	/*
	//allows the player to equip an item in the enventory.
	public void equipItems(Item  newWeapon) 
	{
		//Checks to see if inv contains the weapon
		if(invetory.contains(newWeapon) )
		{
			//Sends it to equipement
			equipment.add(newWeapon);
		}
		else if(!invetory.contains(newWeapon))
		{
			//Else it tells you do not have it
			System.out.println("You do not currently have this item in your inventory");
		}

		
	}
	*/

	
	//Places item into the users inventory
	public void getItem(Item newItem) 
	{
		//adds item into your inventory
		inventory.add(newItem);
	}
	
	
	/*
	//Allows the user to buy items
	public void buyItems(Item  newItem) 
	{
		//checks players gold to see if there is enough of the amount needed
		if(gold - newItem.getPrice()>=0)
		{
			//if there is it is add to the iventort
			invetory.add(newItem);
			System.out.println("The item has been purchased");
		}
		else
		{
			//if not return this message
			System.out.println("Insufficient Funds");
		}
		
		

	}
	*/
	//Moved to main subsystem
//Cannot be done without the rest of the subsystems.
	/*public void retreat() 
	{
		
		
	}
*/
	
	//Commented this out for now.
	//May not need to be implemented
	/*public void look(Rooms  roomID)
	{

	}

	public void examine(Rooms puzzleID) 
	{

	}

	public void examine(Entity monster) 
	{
		
		//returns the examine 

	}*/
	
	public void death(int healthPoints)
	{
		if(healthPoints<=0)
		{
			System.out.println("Game Over. You have died!");
		}
	}
	
	public int getGold()
	{
		return gold;
	}

	public void addGold()
	{
		gold++;
	}
}
