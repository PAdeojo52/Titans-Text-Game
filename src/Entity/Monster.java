package Entity ;

public class Monster extends Entity 

{
	//Basic Attributes
	private int monsterID;
	
	private String description;

	private int aggressiveness;
	
	private String[] names =
		{
			"Wraith",
			"Slime",
			"Goblin",
			"Orc",
			"Giant",
			"Ent",
			"Mercenary",
			"Briarios"
		};
	
	private String[] descriptions =
		{
			"-- The wraith floats in the air. Your attacks seem to do nothing.",
			"-- A gooey slime stands in your path.",
			"-- The goblin holds a battle axe.",
			"-- The orc holds a sword and a shield.",
			"-- The giant is minding his own business. Maybe he'll leave you alone if you leave him alone.",
			"-- A giant tree monster.",
			"-- The mercenary is fast and wields two swords.",
			"-- Briarios himself. You must defeat him!"
		};
	
	private int[] strengths = 
		{
			10,
			1,
			4,
			5,
			9,
			7,
			6,
			9
		};
	
	private int[] hps =
		{
			9999,
			5,
			10,
			15,
			50,
			45,
			30,
			100
		};
	
	private int[] aggros =
		{
			50,
			50,
			75,
			75,
			0,
			20,
			100,
			100
		};
	
	
	//monster cobstructor
	public Monster(int monID)
	{
		monsterID = monID;
		name = names[monID];
		health = hps[monID];
		strength = strengths[monID];
		aggressiveness = aggros[monID];
		description = descriptions[monID];
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
