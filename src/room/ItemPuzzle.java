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

public class ItemPuzzle extends Puzzle
{
	/*
	 * TODO
	 */
	public ItemPuzzle(String puzzleHint, String description, String ID, Object solution)
	{														//Change solution from Object to Item
		super(puzzleHint, description, ID, solution);
	}

	/*
	 * TODO
	 * @Override
	 */
	public Object getSolution() //Don't think we actually need this
	{
		return super.getSolution();
	}

}
