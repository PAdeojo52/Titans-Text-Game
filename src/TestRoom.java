
public class TestRoom extends DescribedObject
{
	private int roomID;
	private int[] exits = new int[4];
	
	
	public TestRoom(int newRoomID)
	{
		roomID = newRoomID;
		
		description = roomID + " ROOM NUMBER " + roomID;
		
		for (int i = 0; i < exits.length; i++)
		{
			exits[i] = -1;
		}
		
		switch (roomID)
		{
		case 1:
			exits[0] = 2;
			break;
		case 2:
			exits[3] = 3;
			exits[1] = 4;
			exits[2] = 1;
			break;
		case 3:
			exits[1] = 2;
			break;
		case 4:
			exits[3] = 2;
			break;
		}
	}
	
	public int getNextRoom(int direction)
	{
		return(exits[direction]);
	}
	
	public int getID()
	{
		return roomID;
	}
}
