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

public class Riddle extends Puzzle
{
	private String solution;

	public Riddle(Room room, String ID, String solution, String description, String hint)
	{
		super(room, ID, solution, description, hint);
		this.solution = solution;
	}
	
	public String getSolution()
	{
		return solution;
	}
}