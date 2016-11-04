package Inventory;

public class Usable extends Item {

	private int healthRecov;
	private boolean usable;

	public boolean isUsable() {
		return usable;
	}

	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	public int getHealthRecov() {
		return healthRecov;
	}

	public void setHealthRecov(int healthRecov) {
		this.healthRecov = healthRecov;
	}

	

}
