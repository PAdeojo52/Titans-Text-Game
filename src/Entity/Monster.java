package Entity ;

public class Monster extends Entity 

{
	//Basic Attributes
	private int monsterID;
	
	private String name;
	
	private String description;

	private int aggressiveness;
	
	
	//monster cobstructor
	public Monster(int monID,String monName, String monDescription, int monAggressivness)
	{
		monID = this.monsterID;
		monName = this.name;
		monDescription = this.description;
		monAggressivness = this.aggressiveness;
		
		
	}

	//gets the name
	public String getName()
	{
		return name;
	}




	//gets the id
	public int getMonsterID()
	{
		return monsterID;
	}

	//sets the id
	public void setMonsterID(int monsterID)
	{
		this.monsterID = monsterID;
	}

	//set the name
	public void setName(String name)
	{
		this.name = name;
	}


/////

	//gets its decription
	public String getDescription()
	{
		return description;
	}




	//sets the description
	public void setDescription(String description)
	{
		this.description = description;
	}




	//gets the aggressivness
	public int getAggressiveness()
	{
		return aggressiveness;
	}




	//Sets aggressivnes. May need to delete this. Aggressivness is an overall redundant method and attribute
	public void setAggressiveness(int aggressiveness)
	{
		this.aggressiveness = 100;
	}



//Starts combat with the player
	public void initiate(Player yourPlayer) 
	{
		
		if(getHealth()!= 0)
		{
			super.attack(yourPlayer);
		}

	}

}
