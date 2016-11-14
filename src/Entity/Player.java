package Entity;
import inventory.Item;

import java.util.ArrayList;
import java.util.List;

import Main.Main;

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
	
	public void heal(int healAmount)
	{
		super.setHealth(super.getHealth() + healAmount);
		
		if (super.getHealth() > 100) super.setHealth(100);
		
		Main.display("-- Healed. Health is now " + super.getHealth());
	}
}
