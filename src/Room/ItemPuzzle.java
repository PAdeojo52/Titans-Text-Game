/**Class: 
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - 
  */

package Room;

public class ItemPuzzle extends Puzzle
{
	private String solutionName;
	
	/*
	 * TODO
	 */
	public ItemPuzzle(Room newRoom, String ID, String solution)
	{
		super(newRoom, ID);
		solutionName = solution;
	}

	public String getSolutionName()
	{
		return solutionName;
	}

}
