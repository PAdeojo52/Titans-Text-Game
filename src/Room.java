/**Class: 
  * @author Joshua Gerth
  * @version 1.0
  * Course : 
  * Written: 
  * 
  * 
  * Purpose: - 
  */

package talesOfTitans;

import java.util.ArrayList;

public class Room //extends DescribedObject
{

	private boolean isShop;
	private String description, roomID;
	private ArrayList inv = new ArrayList(); //Set ArrayList type to Item
	private Room north = null, south = null, east = null, west = null;
	
	/**
	  * TODO
	  */
	public Room(String ID, String description, boolean shop)
	{
		roomID = ID;
		this.description = description;
		isShop = shop;
	}
	
	/**
	  * TODO
	  */
	public boolean getIsShop()
	{
		return isShop;
	}
	
	/**
	  * TODO
	  */
	public String getID()
	{
		return roomID;
	}
	
	/**
	  * TODO
	  */
	public String getDescription()
	{
		return description;
	}
	
	/**
	  * TODO
	  */
	public ArrayList getInv()
	{
		return inv;
	}
	
	/**
	  * TODO
	  */
	public void addInv(Object newItem) //Change Object to Item
	{
		inv.add(newItem);
	}
	
	/**
	  * TODO
	  */
	public void removeInv(Object item) //Change Object to Item
	{
		inv.remove(item);
	}

	/**
	  * @return north
	  */
	public Room getNorth()
	{
		return north;
	}

	/**
	  * @param north
	  */
	public void setNorth(Room north)
	{
		this.north = north;
	}

	/**
	 * @return south
	 */
	public Room getSouth()
	{
		return south;
	}

	/**
	  * @param south
	  */
	public void setSouth(Room south)
	{
		this.south = south;
	}

	/**
	  * @return east
	  */
	public Room getEast()
	{
		return east;
	}

	/**
	  * @param east
	  */
	public void setEast(Room east)
	{
		this.east = east;
	}

	/**
	  * @return the west
	  */
	public Room getWest()
	{
		return west;
	}

	/**
	  * @param west the west to set
	  */
	public void setWest(Room west)
	{
		this.west = west;
	}
}
