package Entity;

import inventory.Item;
import inventory.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Main.Main;

/**
 * Class: Entity.java
 * 
 * @author Peter Adeojo
 * @version 1.0
 *          <p>
 * Course : ITEC 3150 Spring 2016 
 * Written: Oct 10, 2016
 * 
 * 
 *  This class – This class describes the common attributes and methods
 *          of the Entity.java
 * 
 *  Purpose: – ******
 */

public class Entity
{
	//Attributes
	protected int health;
	protected int strength;
	protected String name;
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	protected Weapon equipment;
	//Construct
	public Entity()
	{
		this.health = 100;
		this.strength = 3;
	}

	//getters and setters
	//gets the healt value
	public int getHealth()
	{
		return health;
	}

	//sets the healths value
	public void setHealth(int health)
	{
		this.health = health;
	}

	//get strength value
	public int getStrength()
	{
		return strength;
	}


	//sets the strength value
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	
	public String getName()
	{
		return name;
	}

	public ArrayList<Item> getInv()
	{
		return inventory;
	}
	
	public void addItem(Item newItem)
	{
		inventory.add(newItem);
	}
	
	//methods
	public void attack(Entity target)
	{
		int attackPower = strength;
		
		target.setHealth(target.getHealth() - attackPower);
		
		if (target.getHealth() < 0)
		{
			target.setHealth(0);
		}
		
		Main.display("-- " + name + " deals " + attackPower + " damage! " + target.getName() + "'s health is now " + target.getHealth() + "!");
	}
}
