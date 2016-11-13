package Entity;

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
	//protected List<Item> inventory;
	//protected Item equipment;
	//Construct
	public Entity()
	{
		this.health = 100;
		this.strength = 4;
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


	//methods
	public void attack(Entity target)
	{
		int attackPower = strength;
		
		target.setHealth(target.getHealth() - attackPower);
		
		if (target.getHealth() < 0)
		{
			target.setHealth(0);
		}
		
		Main.display("-- " + name + " deals " + attackPower + " damage! " + target.getName() + " health is now " + target.getHealth() + "!");
		
		/*
		//Players intial strenth
		int playerCurrentStrenth = getStrength();

		//This will need to be changed to the players actual buff. I have set a 
		//defualt of five but this will allow  player weapons and other equipment to play a role int he attack

		int playersWeaponBuff = 5;

		//max percentage that the hit will hit
		final double MAX_PERCENTAGE = 100;
		//Checks the percentage
		//double percentageCheck;
		//Checks if the 
		//boolean percentageBool;

		//Random attackRandom = new Random();

		//give a radom number up to .9
		double perctangeRandom = Math.random() * .9;

		//The random number is multiplied by 100, this pluss the players buff +the players current strength.
		//This is all factored into the final percentage of whether your hit will hit.
		double finalValuePercentage = (perctangeRandom * 100) + playersWeaponBuff + playerCurrentStrenth;


		//For time sake i set this like this, however i may go back and 
		//change it, so that the monsters/ player is more correlated with the max_percentage

		//sets this so the final value can never be more than 100
		if(finalValuePercentage > MAX_PERCENTAGE)
		{
			finalValuePercentage = 100;
		}


		//if FNP is 70 or more the attack will commence. Else they miss
		if( finalValuePercentage >= 70)
		{
			//creates the hitpoints by adding stregth with weapons buff
			int hitpoint = getStrength() + playersWeaponBuff;

			//gets targets health
			int targetHealth = target.getHealth();

			//target life points takes a hit
			int targetHealthUpdate = targetHealth - hitpoint;

			//updates target health.
			target.setHealth(targetHealthUpdate);


		}
		else
		{
			System.out.println("The attack has missed");
		}*/





	}






}
