/**Class: Room
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - The Room class stores the information that is needed to create a room. A room requires an
  * 		   ID and description, as well as a flag that determines whether or not it is a shop. The
  * 		   room will also have an inventory, stored in an ArrayList of type Item, as well as
  * 		   references to possible surrounding rooms, Monsters, and Puzzles.
  */

package Room;

import inventory.Item;

import java.util.ArrayList;

import Entity.Monster;
import Main.Main;

public class Room //TODO extends DescribedObject
{

	private boolean isShop;
	private String description, roomID;
	private ArrayList<Item> inv = new ArrayList(); //TODO Set ArrayList type to Item
	private Room north = null, south = null, east = null, west = null;
	private Puzzle puzzle = null;
	private Monster monster = null;
	
	/**
	  * This is the Constructor for the Room class. The Constructor accepts a String for the roomID
	  * and description, and sets the corresponding class variables to them, as well as a boolean for
	  * the Room's isShop flag, who's class variable is also set.
	  */
	public Room(String ID, String description, boolean shop, Monster mon)
	{
		roomID = ID;
		this.description = description;
		isShop = shop;
		monster = mon;
	}
	
	public void killMonster()
	{
		Main.display("-- Killed " + monster.getName() + "!");
		monster = null;
	}
	
	/**
	  * Getter method for isShop
	  * @return isShop
	  */
	public boolean getIsShop()
	{
		return isShop;
	}
	
	/**
	  * Getter method for roomID
	  * @return roomID
	  */
	public String getID()
	{
		return roomID;
	}
	
	/**
	  * Getter method for description
	  * @return description
	  */
	public String getDescription()
	{
		return description;
	}
	
	/**
	  * Getter method for inv
	  * @return inv
	  */
	public ArrayList<Item> getInv()
	{
		return inv;
	}
	
	/**
	  * This method allows outside objects to add Items to the room's inventory
	  * @param newItem
	  */
	public void addInv(Item newItem) //TODO Change Object to Item
	{
		inv.add(newItem);
	}
	
	/**
	  * This method allows outside objects to remove Items from the room's inventory
	  * @param item
	  */
	public void removeInv(Item item) //TODO Change Object to Item
	{
		inv.remove(item);
	}

	/**
	  * Getter method for the Room north
	  * @return north
	  */
	public Room getNorth()
	{
		return north;
	}

	/**
	  * Setter method for the Room north
	  * @param north
	  */
	public void setNorth(Room north)
	{
		this.north = north;
	}

	/**
	  * Getter method for the Room south
	  * @return south
	  */
	public Room getSouth()
	{
		return south;
	}

	/**
	  * Setter method for the Room south
	  * @param south
	  */
	public void setSouth(Room south)
	{
		this.south = south;
	}

	/**
	  * Getter method for the Room east
	  * @return east
	  */
	public Room getEast()
	{
		return east;
	}

	/**
	  * Setter method for the Room east
	  * @param east
	  */
	public void setEast(Room east)
	{
		this.east = east;
	}

	/**
	  * Getter method for the Room west
	  * @return west
	  */
	public Room getWest()
	{
		return west;
	}

	/**
	  * Setter method for the Room west
	  * @param west
	  */
	public void setWest(Room west)
	{
		this.west = west;
	}
	
	/**
	  * Setter method for the room's Puzzle
	  * @param puzzle
	  */
	public void setPuzzle(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	
	/**
	  * Setter method for the room's Monster
	  * @param mon
	  */
	public void setMonster(Monster mon)
	{
		monster = mon;
	}
	
	public Monster getMonster()
	{
		return monster;
	}
}