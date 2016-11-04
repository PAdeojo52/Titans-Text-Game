/**Class: Puzzle
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - 
  */

package room;

public class Puzzle
{
	private boolean solved;
	private String hint, description, puzzleID;
	private Object solution, guess;
	
	/**
	  * TODO
	  */
	public Puzzle(String ID, String description, String puzzleHint, Object solution)
	{
		puzzleID = ID;
		this.description = description;
		this.solution = solution;
		hint = puzzleHint;
		solved = false;
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
	public void setSolved(boolean done) //Don't think we actually need this
	{
		solved = done;
	}
	
	/**
	  * TODO
	  */
	public Object getGuess() //Don't think we actually need this
	{
		return guess;
	}
	
	/**
	  * TODO
	  */
	public void setGuess(Object userInput)
	{
		guess = userInput;
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
	
	/**
	  * TODO
	  */
	public Object getSolution() //Don't think we actually need this
	{
		return solution;
	}
	
	/**
	  * TODO
	  */
	private void checkCorrect()
	{
		if(guess.equals(solution))
		{
			solved = true;
		}
	}
}