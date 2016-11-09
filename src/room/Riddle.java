/**Class: 
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - 
  */

package room;

public class Riddle extends Puzzle
{

	public Riddle(String puzzleHint, String description, String ID, Object solution)
	{
		super(puzzleHint, description, ID, solution);
	}
	
	/*
	 * TODO
	 * @Override
	 */
	public String getSolution() //Don't think we actually need this
	{
		return (String)super.getSolution();
	}
}
