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
		"A pitch black statue stands before you with a shape of a dark prince of Daedric descent. The eyes glow red as you look into its face. The statue is holding its hand out in your direction above a fountain of water. A description under the prince says: \"A prince of safe passage if you give the right offering.\"",
			"Looking around the Inn you see a group of people gathered in one of the corners around one person, whatever's going on over there sounds exciting. You ask the innkeeper what's going on and he responds \"Just a bunch of idiots gambling away there life savings to the local hustler, Grodd.\" You thank him, and decide to go try your luck.",
			//If you win, he doubles your money, and if you lose you lose your bet. The game may be played up to five times.",
		"Before you can leave the forge you are stopped by a strange man laughing and speaking in riddles. He breafly takes a break from his foolishness to introduce himself as Roots and to offer you a challenge, solve his riddle and he'll give you a powerful weapon. You agree.\n\"The King has an army of soldiers\nThat hiss and fly\nThey wear masks of feathers\nAnd blood that  ____\"",
			"There is an odd drawing on the wall in the shape of a triangle. It appears to be hollowed out like there was something that used to go in the crevice.",
		"You stand above your unknown assailant, victorious. As you approach he asks for mercy, but he has proved to be quite dangerous. You think for a moment about how you should proceed.",
			"The guard watches the road diligently, denying entry to passerby.",
		"You can't see a thing in this darkness. Continuing in these conditions would be far too dangerous."
	};
	private String[] hint = 
	{
		"The prince requires a stone of sunlight that you obtain from a merchant in the city.",
		//Above is done
		"You notice Grodd glancing at your coin purse before grabbing his rocks. It's almost as if he's visually weighing it.",
		"It sounds like the riddle rhymes.",
		"It looks like there is a lever inside.",
		"You think long and hard about what to do.",
		"Hours at this post have made this guard weary. He can't keep his guard up forever...",
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