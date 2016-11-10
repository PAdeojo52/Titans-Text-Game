/**Class: RoomControl
  * @author Joshua Gerth
  * @version 1.0
  * Course : ITEC 3860
  * Written: 29 October, 2016
  * 
  * 
  * Purpose: - The RoomControl class creates the instances of the Room class that will be used in the
  * 		   TalesOfTitans game.
  */
package room;

public class RoomControl
{
	PuzzleControl pc = new PuzzleControl();
	//Holds the room that the player is currently in
	private Room currentRoom;
	//Array of all the rooms in the game
	private Room[] roomArray = new Room[31];
	private String[] ID = {"M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "C1", "C2", "C3", "F1",
						   "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "T1", "T2", "T3", "T4", "T5",
						   "T6", "T7", "T8", "T9", "T10"};
	//Room descriptions TODO redo descriptions
	private String[] description = 
	{
		"You are at the end of a damp cave. Small shimmers of light creep in from high above. A passage leads to the east.",
			"You are a dark and cramped tunnel. Piles of soot covered earth and block your path, but you can make out a crawlspace to the north.",
		"You are in the channel of a mine shaft. The torches lining the walls are just bright enough to illuminate the area. The channel continues to the east. A crawl space lies to the south.",
	 		"You are surrounded with the veins of excavated minerals. A light shimmers further to the east. The channel continues to the west.",
		 "You are at the entrance of a mine shaft. A wooden door overgrown with Ivy and brambles lies to the north. The shaft forks into southern and western corridors.",
			"The shaft continues to the south. The mine's entrance can be seen to the north.",
		 "You stumble in the darkness. It is too dark to continue without a light.",
			"The shaft makes a sharp turn to the east. You feel a light breeze coming from the north.",
		 "The shaft comes to a stop. The air is stagnant and hot.",
			"Upon entering the Athena you come across an Inn. You enter and can see, and smell, that the Innkeep maintains a small restauraunt. You notice that there are vacancies.",
	 	"Continuing through the city you find an alchemy shop. You enter to examine it's wares.",
	 		"Before leaving the Athena you stop by the town forge which is run by the master blacksmith Siegfried. As you enter his apprentice, Roots, welcomes you. You ask to see their inventory and are surprised to learn that they don't keep much on hand, almost everything is made specifically for the customer by Siegfried himself, but they do have a few things.",
		"You are in a wooded area surrounding a mine. A dusty path continues to the east. To the south lies the mine entrance.",
	 		"You are on a footpath in a dense forest. You can hear the sound of rushing water to the east.",
	 	"A River flows eastbound alongside the trail.",
		 	"A great lake lies at the end of the trail. A clearing in the forest lies to the south.",
		"An ornate stone roadway cuts eastward through the forest. A nearby sign reads \"NORTH: Lake Durnam. EAST: Athena\"",
	 		"You are on the outskirts of a great city. A guard stands at his post, preventing all from entering.",
		"A great tower can be seen rising from the eastern horizon.",
		 	"There is a small clearing in the forest towards the Tower of Babel with a pitch black statue in the middle.",
		"As you approach the Tower of Babel, a Wraith appears holding a shining key. It does not speak but it shrieks as it approaches you slowly.",
	 		"You stand at the bottom floor of the tower. Behind you to the west lies the exit. A staircase can be seen past an awning to the east.",
	 	"An enormous spiral staircase extends upwards. The entrance chamber lies to the west. A holding cell lies to the east.",
		 	"You stand in a decrepit holding cell. The walls are lined with claw marks and other incomprehensible inscriptions. Behind you to the west is the staircase.",
		"You are halfway up the staircase. Chamber rooms lie to the east and west.",
	 		"You find yourself in a what appears to be an observatory west of the central staircase.",
	 	"You enter the eastern chamber. Shelves of ancient tomes line the walls. Each book is written in a strange language completely foreign to you. The central staircase lies to the west.",
		 	"You have reached the top of the tower. A massive door of granite lies directly to the north. You're sure you can see shadows dancing from under the cracks of the door.",
		"You find yourself in what appears to be an observatory overlooking the city. A map of the surrounding area is pinned to the far wall. Several markings are etched onto the map, mysteriously coinciding with the places you have been. The central staircase lies to the east.",
	 		"You enter an expansive armoury crowded with row upon row of weapons and armors. The dust-coated armors, though neglected, shows no sign of deterioration. Unfortunately, these armaments were clearly designed for someone much larger than yourself. The central staircase lies to the west.",
	 	"You cautiously proceed onward through the massive doorway and find yourself in what is likely the final room in the tower. An array of banners, weathered by time, encompass an ornate throne in the center of the chamber. Atop the throne sits Briarios, King of Darkness. Sparing no time, he rises from his throne and prepares for battle."
	};
	//Room shop flags
	private boolean[] isShop = {false, false, false, false, false, false, false, false, false, true,
								true, true, false, false, false, false, false, false, false, false,
								false, false, false, false, false, false, false, false, false, false,
								false};
	
	/**
	  * This method is the RoomControl Constructor. It's purpose is to populate the rooms in the
	  * roomArray with an ID, description, and shop flag, and to link the rooms together. The
	  * Constructor also assigns Monsters and Puzzles to the rooms, as well as Items to the rooms
	  * inventories.  
	  */
	public RoomControl()
	{
		//Populate roomArray
		for(byte index = 0; index < ID.length; index++)
		{
			roomArray[index] = new Room(ID[index], description[index], isShop[index]);
		}
		//Link rooms
		//Mine Area
		//M1
		roomArray[0].setEast(roomArray[1]);
		//M2
		roomArray[1].setWest(roomArray[0]);
		roomArray[1].setNorth(roomArray[2]);
		//M3
		roomArray[2].setSouth(roomArray[1]);
		roomArray[2].setEast(roomArray[3]);
		roomArray[2].setPuzzle(pc.getPuzzleArray()[4]);
		//M4
		roomArray[3].setWest(roomArray[2]);
		roomArray[3].setEast(roomArray[4]);
		//M5
		roomArray[4].setWest(roomArray[3]);
		roomArray[4].setSouth(roomArray[5]);
		roomArray[4].setNorth(roomArray[12]);
		//M6
		roomArray[5].setNorth(roomArray[4]);
		roomArray[5].setSouth(roomArray[6]);
		//M7
		roomArray[6].setNorth(roomArray[5]);
		roomArray[6].setSouth(roomArray[7]);
		roomArray[6].setPuzzle(pc.getPuzzleArray()[7]);
		//M8
		roomArray[7].setNorth(roomArray[6]);
		roomArray[7].setEast(roomArray[8]);
		//M9
		roomArray[8].setWest(roomArray[7]);
		roomArray[8].setPuzzle(pc.getPuzzleArray()[5]);
		
		//Forest Area
		//F1
		roomArray[12].setSouth(roomArray[4]);
		roomArray[12].setEast(roomArray[13]);
		//F2
		roomArray[13].setWest(roomArray[12]);
		roomArray[13].setEast(roomArray[14]);
		//F3
		roomArray[14].setWest(roomArray[13]);
		roomArray[14].setEast(roomArray[15]);
		//F4
		roomArray[15].setWest(roomArray[14]);
		roomArray[15].setSouth(roomArray[16]);
		//F5
		roomArray[16].setNorth(roomArray[15]);
		roomArray[16].setEast(roomArray[17]);
		//F6
		roomArray[17].setWest(roomArray[16]);
		roomArray[17].setEast(roomArray[9]);
		roomArray[17].setPuzzle(pc.getPuzzleArray()[6]);
		//F7
		roomArray[18].setWest(roomArray[10]);
		roomArray[18].setEast(roomArray[19]);
		//F8
		roomArray[19].setWest(roomArray[18]);
		roomArray[19].setEast(roomArray[20]);
		roomArray[19].setPuzzle(pc.getPuzzleArray()[1]);
		//F9
		roomArray[20].setWest(roomArray[19]);
		roomArray[20].setEast(roomArray[21]);
		
		//City Area
		//C1
		roomArray[9].setWest(roomArray[17]);
		roomArray[9].setEast(roomArray[10]);
		roomArray[9].setPuzzle(pc.getPuzzleArray()[2]);
		//C2
		roomArray[10].setWest(roomArray[9]);
		roomArray[10].setNorth(roomArray[11]);
		roomArray[10].setEast(roomArray[18]);
		//C3
		roomArray[11].setSouth(roomArray[10]);
		roomArray[11].setPuzzle(pc.getPuzzleArray()[3]);
		
		//Tower Area
		//T1
		roomArray[21].setWest(roomArray[20]);
		roomArray[21].setEast(roomArray[22]);
		//T2
		roomArray[22].setWest(roomArray[21]);
		roomArray[22].setNorth(roomArray[24]);
		roomArray[22].setEast(roomArray[23]);
		//T3
		roomArray[23].setWest(roomArray[22]);
		//T4
		roomArray[24].setSouth(roomArray[22]);
		roomArray[24].setWest(roomArray[25]);
		roomArray[24].setEast(roomArray[26]);
		roomArray[24].setNorth(roomArray[27]);
		//T5
		roomArray[25].setEast(roomArray[24]);
		//T6
		roomArray[26].setWest(roomArray[24]);
		//T7
		roomArray[27].setSouth(roomArray[24]);
		roomArray[27].setWest(roomArray[28]);
		roomArray[27].setEast(roomArray[29]);
		roomArray[27].setNorth(roomArray[30]);
		//T8
		roomArray[28].setEast(roomArray[27]);
		//T9
		roomArray[29].setWest(roomArray[27]);
		//T10
		roomArray[30].setSouth(roomArray[27]);
		
		//Assign the currentRoom to the first room
		currentRoom = roomArray[0];
		
		//TODO change for final version
		System.out.println(currentRoom.getID() + "\n-- " + currentRoom.getDescription());
		
		//TODO add monsters, puzzles, and items
	}
	
	/**
	  * The move method takes the user's input and uses it to change the instance of the Room class that
	  * the player currently occupies. Valid inputs are: North or N; South or S; East or E; and West or W.
	  * All other input results in an error being thrown. Input is not case sensitive. Upon valid input,
	  * and the room located in the desired direction not being null, the method reassigns the
	  * currentRoom to the one specified and displays its description.
	  * @param userInput
	  * @return moves
	  */
	public String move(String userInput)
	{
		//Move based on userInput
		if(userInput.equalsIgnoreCase("North") || userInput.equalsIgnoreCase("N"))
		{
			if(currentRoom.getNorth() != null)
			{
				currentRoom = currentRoom.getNorth();
			}
			else
			{
				System.out.println("There is nothing in that direction");
			}
		}
		else if(userInput.equalsIgnoreCase("South") || userInput.equalsIgnoreCase("S"))
		{
			if(currentRoom.getSouth() != null)
			{
				currentRoom = currentRoom.getSouth();
			}
			else
			{
				System.out.println("There is nothing in that direction");
			}
		}
		else if(userInput.equalsIgnoreCase("East") || userInput.equalsIgnoreCase("E"))
		{
			if(currentRoom.getEast() != null)
			{
				currentRoom = currentRoom.getEast();
			}
			else
			{
				System.out.println("There is nothing in that direction");
			}
		}
		else if(userInput.equalsIgnoreCase("West") || userInput.equalsIgnoreCase("W"))
		{
			if(currentRoom.getWest() != null)
			{
				currentRoom = currentRoom.getWest();
			}
			else
			{
				System.out.println("There is nothing in that direction");
			}
		}
		else//Change for final version
		{
			System.out.println("Unexpected input");
		}
		//TODO
		//if(!currentRoom.getID().equals("M7") ||
		  //(currentRoom.getID().equals("M7") && !player.getInv().contains("torch")))
		{
			System.out.println(currentRoom.getID() + "\n-- " + currentRoom.getDescription());
		}
		/*
		 * else
		 * {
		 * 		System.out.println("-- With the torch you are able to see deeper into the shaft. It looks like the southern part of this mine experienced a small cave-in, which explains all of the debris that you were tripping on earlier.");
		 * }
		 */
		
		return currentRoom.getID();
	}
}