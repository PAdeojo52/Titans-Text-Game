package inventory;

public class Coin extends Item {

	private int value = 1;

	public Coin()
	{
		super.setName("Gold coin");
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

	

}
