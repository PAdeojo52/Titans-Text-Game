import java.util.ArrayList;

/**Class: 
  * @author Joshua Gerth
  * @version 1.0
  * Course : 
  * Written: 
  * 
  * 
  * Purpose: - 
  */
//package talesOfTitans;

public class RoomControl
{
	//Tester variable
	int moves; //Remove from final program
	
	//Holds the room that the player is currently in
	Room currentRoom;
	//Array of all the rooms in the game
	Room[] roomArray = new Room[30];
	String[] ID = {"M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "C1", "C2", "C3", "F1", "F2",
				   "F3", "F4", "F5", "F6", "F7", "F8", "F9", "T1", "T2", "T3", "T4", "T5", "T6", "T7",
				   "T8", "T9", "T10"};
	//Room descriptions
	String[] description = 
		{"You are at the end of a damp cave. Small shimmers of light creep in from high above. A passage leads to the east.",
		 "You are a dark and cramped tunnel. Piles of soot covered earth and block your path, but you can make out a crawlspace to the north.",
		 "You are in the channel of a mine shaft. The torches lining the walls are just bright enough to illuminate the area. The channel continues to the west. A crawl space lies to the south.",
		 "You are surrounded with the veins of excavated minerals. A light shimmers further to the east. The channel continues to the west.",
		 "You are at the entrance of a mine shaft. A wooden door overgrown with Ivy and brambles lies to the north. The shaft forks into southern and western corridors.",
		 "The shaft continues to the south. The mine’s entrance can be seen to the north.",
		 "You stumble in the darkness. It is too dark to continue without a light.",
		 "The shaft makes a sharp turn to the east.",
		 "The shaft comes to a stop. The air is stagnant and hot.",
		 "The Inn should allow the player to take a rest for the night for a small number of gold coins. The Inn should also sell cheap food that can be eaten to recover health. The Inn should be run with an Innkeeper that the player has to interact with the Innkeeper in order to buy food or a night at the Inn.",
		 "This shop is run by an old alchemist who spends his free time creating magic potions with different attributes.",
		 "The Forge is run by a master blacksmith(Siegfried) and his apprentice(Roots). The blacksmith is a master at his work so he does not deal with customers because he is too busy making the finest swords in Athena. Roots does all of the business as he has a silver tongue that can barter up any trader.",
		 "You are in a wooded area surrounding a mine. A dusty path continues to the east. To the south lies the mine entrance.",
		 "You are on a footpath in a dense forest. You can hear the sound of rushing water to the.",
		 "A River flows eastbound alongside the trail.",
		 "A great lake lies at the end of the trail. A clearing in the forest lies to the south.",
		 "An ornate stone roadway cuts eastward through the forest. A nearby sign reads “NORTH: Lake Durnam. EAST: Athena�",
		 "You are on the outskirts of a great city. A guard stands at his post, preventing all from entering.",
		 "A great tower can be seen rising from the western horizon.",
		 "There is a small clearing in the forest towards the Tower of Babel with a pitch black statue in the middle.",
		 "As you approach the Tower of Babel, a Wraith appears holding a shining key. It does not speak but it shrieks as it approaches you slowly.",
		 "You stand at the bottom floor of the tower. Behind you to the west lies the exit. A staircase can be seen past an awning to the east.",
		 "An enormous spiral staircase extends upwards. The entrance chamber lies to the west. A holding cell lies to the east.",
		 "You stand in a decrepit holding cell. The walls are lined with claw marks and other incomprehensible inscriptions. Behind you to the west is the staircase.",
		 "You are halfway up the staircase. Chamber rooms lie to the east and west.",
		 "You find yourself in a what appears to be an observatory west of the central staircase.",
		 "You enter the eastern chamber. Shelves of ancient tomes line the walls. Each book is written in a strange language completely foreign to you. The central staircase lies to the west.",
		 "You have reached the top of the tower. A massive door of granite lies directly to the north. You’re sure you can see shadows dancing from under the cracks of the door.",
		 "You find yourself in what appears to be an observatory overlooking the city. A map of the surrounding area is pinned to the far wall. Several markings are etched onto the map, mysteriously coinciding with the places you have been. The central staircase lies to the east.",
		 "You enter an expansive armoury crowded with row upon row of weapons and armors. The dust-coated armors, though neglected, shows no sign of deterioration.Unfortunately, these armaments were clearly designed for someone much larger than yourself. The central staircase lies to the east.",
		 "You cautiously proceed onward through the massive doorway and find yourself in what is likely the final room in the tower. An array of banners, weathered by time, encompass an ornate throne in the center of the chamber. Atop the throne sits Briarios, King of Darkness. Sparing no time, he rises from his throne and prepares for battle."};
	//Room shop flags
	boolean[] isShop = {false, false, false, false, false, false, false, false, false, true, true, true,
						false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false};
	
	/**
	  * This method is the RoomControl Constructor. It's purpose is to populate the rooms in the
	  * roomArray with an ID, description, and shop flag, and to link the rooms together. The
	  * Constructor also assigns Monsters and Puzzles to the rooms, as well as Items to the rooms
	  * inventories.  
	  */
	public RoomControl(ArrayList<Room> rooms)
	{
		//Populate roomArray
		for(byte index = 0; index < ID.length - 1; index++)
		{
			roomArray[index] = new Room(ID[index], description[index], isShop[index]);
			rooms.add(roomArray[index]);
		}
		//Link rooms
		//Mine Area
		roomArray[0].setEast(roomArray[1]);
		
		roomArray[1].setWest(roomArray[0]);
		roomArray[1].setNorth(roomArray[2]);
		
		roomArray[2].setSouth(roomArray[1]);
		roomArray[2].setEast(roomArray[3]);
		
		roomArray[3].setWest(roomArray[2]);
		roomArray[3].setEast(roomArray[4]);
		
		roomArray[4].setWest(roomArray[3]);
		roomArray[4].setSouth(roomArray[5]);
		roomArray[4].setNorth(roomArray[12]);
		
		roomArray[5].setNorth(roomArray[4]);
		roomArray[5].setSouth(roomArray[6]);
		
		roomArray[6].setNorth(roomArray[5]);
		roomArray[6].setSouth(roomArray[7]);
		
		roomArray[7].setNorth(roomArray[6]);
		roomArray[7].setEast(roomArray[8]);
		
		roomArray[8].setWest(roomArray[7]);
		
		//Forest Area
		roomArray[12].setSouth(roomArray[4]);
		roomArray[12].setEast(roomArray[13]);
		
		roomArray[13].setWest(roomArray[12]);
		roomArray[13].setEast(roomArray[14]);	
		
		//TODO finish linking rooms, add monsters, puzzles, and items
		
		//Assign the currentRoom to the first room
		currentRoom = roomArray[0];
	}
	
	/**
	  * 
	  * @param userInput
	  * @return moves
	  */
	public int move(String userInput)
	{
		moves++;//Variable will be used by the Tester class to terminate execution
		//Move based on userInput
		if(userInput.equalsIgnoreCase("North") || userInput.equalsIgnoreCase("N"))
		{
			if(currentRoom.getNorth() != null)
			{
				currentRoom = currentRoom.getNorth();
				System.out.println(currentRoom.getID() + "\n" + currentRoom.getDescription() + "\n" +
									currentRoom.getIsShop());
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
				System.out.println(currentRoom.getID() + "\n" + currentRoom.getDescription() + "\n" +
						currentRoom.getIsShop());
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
				System.out.println(currentRoom.getID() + "\n" + currentRoom.getDescription() + "\n" +
						currentRoom.getIsShop());
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
				System.out.println(currentRoom.getID() + "\n" + currentRoom.getDescription() + "\n" +
						currentRoom.getIsShop());
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
		
		return moves;
	}

}
