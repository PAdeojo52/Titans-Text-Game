package Entity;

import java.util.Random;

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
	private int health;
	private int strength;
	//Construct
	public Entity()
	{
		this.health = health;
		this.strength = strength;
	}

	//getters and setters
	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	
	
	//methods
	public void attack(Entity target)
	{
		int playerCurrentStrenth = getStrength();
		
		//This will need to be changed to the players actual buff
		
		int playersWeaponBuff = 5;
		
		
		final double MAX_PERCENTAGE = 100;
		
		double percentageCheck;
		boolean percentageBool;
		Random attackRandom = new Random();
		
		double perctangeRandom = Math.random() * .9;
		
		double finalValuePercentage = (perctangeRandom * 100) + playersWeaponBuff + playerCurrentStrenth;
		
		if(finalValuePercentage > MAX_PERCENTAGE)
		{
			finalValuePercentage = 100;
		}
		
		if( finalValuePercentage > 70)
		{
			int hitpoint = getStrength() + playersWeaponBuff;
			
			
			int targetHealth = target.getHealth();
			
			int targetHealthUpdate = targetHealth - hitpoint;
			
			
		}
		else
		{
			//the player misses
			//insert player miss method later
		}
		
		
		
		
		
	}
	
	
	
	
	

}
