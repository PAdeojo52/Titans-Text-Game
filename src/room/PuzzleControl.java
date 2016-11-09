/**Class: PuzzleControl
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - 
  */

package room;

public class PuzzleControl
{
	private Puzzle[] puzzleArray = new Puzzle[8];
	private String[] puzzleID = {"P1", "P2", "P3", "P4", "P5", "P6", "P7"};
	private String[] description = 
	{
		"A pitch black statue stands before you with a shape of a dark prince of Daedric descent. The eyes glow red as you look into its face. The statue is holding its hand out in your direction above a fountain of water. A description under the prince says: â€œA prince of safe passage if you give the right offering.â€�",
			"The player can gamble against Grodd, a local at the Inn who likes to hustle new patrons. You must guess how many rocks he has in his right hand. If you win, he doubles your money and if you lose, you lose your bet. The game may be played up to five times.",
		"Roots is a jokester and likes to make jokes and riddles. If the player guesses the answer to Rootsâ€™ riddle, then the player will receive a silver dagger that is needed to kill a wraith.\nâ€œThe King has an army of soldiers\nThat hiss and fly\nThey wear masks of feathers\nAnd blood that  ____â€�",
			"There is an odd drawing on the wall in the shape of a triangle. It appears to be hollowed out like there was something that used to go in the crevice.",
		"After you defeat the mercenary in the mines, you can either kill him or spare him.",
			"The guard watches the road diligently, denying entry to passerby.",
		"You canâ€™t see a thing in this darkness. Continuing in these conditions would be far too dangerous."
	};
	private String[] hint = 
	{
		"The prince requires a stone of sunlight that you obtain from a merchant in the city.",
		"Number of rocks = player gold",
		"It sounds like the riddle rhymes",
		"It looks like there is a lever inside",
		"No hint for P5",
		"Hours at this post have made this guard weary. He canâ€™t keep his guard up forever...",
		"Perhaps there is a light source nearby."
	};
	private String[] solution = 
	{
		"player.getInv().contains('Sunstone');",
		"player.getGold()",
		"Dries",
		"Reach into the triangle and unlock a hatch that will open the door to the next room",
		"Sparing the mercenary will make him your friend and he will assist you in the city to obtain a sun stone.",
		"input.equalsIgnoreCase('Wait')",
		"player.getInv().contains('Torch');"
	};
	
	/**
	  * 
	  */
	public PuzzleControl()
	{
		for(byte index = 0; index < puzzleID.length; index++)
		{
			puzzleArray[index] = new Puzzle(puzzleID[index], description[index], hint[index], solution[index]);
		}
	}
	
	/**
	  * 
	  */
	public Puzzle[] getPuzzleArray()
	{
		return puzzleArray;
	}
}