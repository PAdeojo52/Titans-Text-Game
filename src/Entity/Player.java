package Entity;
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
	private List<Integer> inv;
	
	
	

	public void move()
	{
		//RoomID + 1
		//Hopefully the room ID will be linear as to not make it to confusing
	}
	
	public void use(Usable useItem)
	{
		//Will enact the potion
	}
	
	public void equip(Inventory  newWeapon) 
	{
		inv.add(newWeapon);

	}

	public void get(Inventory  newItem) 
	{

	}

	public void buy(Inventory  newItem) 
	{

	}

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
