package inventory;

import java.util.ArrayList;

public class Weapon extends Item {

	private int strength;

	private int type;

	private String[] combatVerbs;

	private String[] names =
		{
			"Blank", "Sword", "Spear", "Bow", "Sword+", "Spear+", "Bow+"
		};
	
	private int[] strengths = {5, 5, 5, 5, 10, 10, 10};
	
	private int[] prices = {0, 0, 0, 0, 7, 7, 7};
	
	public Weapon(int wepNum)
	{
		super.setName(names[wepNum]);
		strength = strengths[wepNum];
		setPrice(prices[wepNum]);
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String[] getCombatVerbs() {
		return combatVerbs;
	}

	public void setCombatVerbs(String[] combatVerbs) {
		this.combatVerbs = combatVerbs;
	}

}