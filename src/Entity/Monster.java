package Entity ;

public class Monster extends Entity 

{
	private int monsterID;
	
	private String name;
	
	private String description;

	private int aggressiveness;
	
	
	public Monster(int monID,String monName, String monDescription, int monAggressivness)
	{
		monID = this.monsterID;
		monName = this.name;
		monDescription = this.description;
		monAggressivness = this.aggressiveness;
		
		
	}

	public String getName()
	{
		return name;
	}




	public int getMonsterID()
	{
		return monsterID;
	}

	public void setMonsterID(int monsterID)
	{
		this.monsterID = monsterID;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}


/////

	public String getDescription()
	{
		return description;
	}




	public void setDescription(String description)
	{
		this.description = description;
	}




	public int getAggressiveness()
	{
		return aggressiveness;
	}




	public void setAggressiveness(int aggressiveness)
	{
		this.aggressiveness = 100;
	}




	public void initiate(Player yourPlayer) 
	{
		
	
		
		if(getHealth()!= 0)
		{
			super.attack(yourPlayer);
		}

	}

}
