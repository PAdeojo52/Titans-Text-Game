/**Class: Puzzle
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - 
  */

package Room;

import inventory.Usable;
import Entity.Player;
import Main.Main;

public class Puzzle
{
	private boolean solved;
	private String hint, description, puzzleID;
	private String solutionText = "Puzzle Solved";
	private boolean[] locked = {false, false, false, false};
	private Room room = null;
	private String solution;
	
	/**
	  * TODO
	  */
	public Puzzle(Room room, String ID, String newSolution, String description, String hint)
	{
		this.room = room;
		puzzleID = ID;
		this.description = description;
		this.hint = hint;
		solved = false;
		solution = newSolution;
	}
	
	/**
	  * TODO
	  */
	public boolean getSolved()
	{
		return solved;
	}
	
	/**
	  * TODO
	  */
	public void setSolved(Player player)
	{
		solved = true;
		room.setLocked(0, false);
		room.setLocked(1, false);
		room.setLocked(2, false);
		room.setLocked(3, false);
		
		Main.display(solutionText);
		
		solveAction(player);
	}
	
	/**
	  * TODO
	  */
	public String getHint()
	{
		return hint;
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
	public String getID()
	{
		return puzzleID;
	}
	
	public boolean getLocked(int dir)
	{
		return(locked[dir]);
	}
	
	public void setLocked(int dir, boolean isLocked)
	{
		locked[dir] = isLocked;
		room.setLocked(dir, isLocked);
	}
	
	public void setSolutionText(String newText)
	{
		solutionText = newText;
	}
	
	public String getSolution()
	{
		return solution;
	}
	
	public void setSolution(String newSolution)
	{
		solution = newSolution;
	}
	
	public void solveAction(Player player)
	{
		if (puzzleID.equals("P2i"))
		{
			player.addGold(player.getGold());
		}
		
		if (puzzleID.equals("P3r"))
		{
			Usable silverDagger = new Usable(2);
			player.getItem(silverDagger);
		}
	}
}