package inventory;

public class Usable extends Item {

	private int healthRecov = 0;

	private String[] names =
		{
			"Blank",
			"Shining Key",
			"Silver Dagger",
			"Human Skull",
			"Torch",
			"Sunstone",
			"Potion"
		};
	
	public Usable(int useNum)
	{
		super.setName(names[useNum]);
		
		if (useNum == 6) 
			{
				healthRecov = 50;
				setPrice(3);
			}
	}
	
	public int getHealthRecov() {
		return healthRecov;
	}

	public void setHealthRecov(int healthRecov) {
		this.healthRecov = healthRecov;
	}
}
