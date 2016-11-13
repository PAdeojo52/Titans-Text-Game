package inventory;

import java.util.ArrayList;

public class Weapon extends Item {

	private int strength;

	private int type;

	private String[] combatVerbs;

	private ArrayList<Weapon> weapons;

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

	public void addWeapon(Weapon weap) {
		weapons.add(weap);
	}

	/*
	 * In battle if the player decides to 'pick up' a weapon that is available
	 * then this method could be called. and it adds it to the weapons array.
	 * three types of weapons: bow (1), spear(2), sword (3).
	 */
	public void pickUpItem(Weapon weap) {
		weapons.add(weap);
	}

	public String pickUpWeapon(String str) {
		if (TextPane.getInput.equals("Pick up") || TextPane.getInput.equals("pick up")
				|| TextPane.getInput.equals("Pickup") || TextPane.getInput.equals("pickup")) {
			pickUpItem(weapon);
		}
	}

}