package Inventory;

import java.util.ArrayList;

//TODO
/*
 * 
 *text file that has all the items
 *item 1, potion, heals this much
 *
 * parse that text file so that when it is called item1 it can be called back.
 * */

public class Item {

	private ArrayList<Item> items;

	private String name;

	private int price;

	private String description;

	private int itemID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemID() {
		return itemID;
	}

	/*
	 * The item Id should be pulled from the ArrayList
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	// method to add items to item array
	public void addItem(Item obj) {
		items.add(obj);
	}

	/*
	 * In gameplay if the player decides to 'pick up' an item that is available
	 * then this mthod could be called. and it adds it to the items array.
	 */
	public void pickUpItem(Item obj) {
		items.add(obj);
	}
}
