package inventory;

import java.util.ArrayList;


/*
 * 
 *text file that has all the items
 *item 1, potion, heals this much
 *
 * parse that text file so that when it is called item1 it can be called back.
 * */

public class Item {

	public ArrayList<Item> items;

	private String name;

	private int price;

	private String description;

	private String itemID;
	
	private String[] itemIDs = 
		{
			"I1",
			"I2",
			"I3",
			"I4",
			"I5",
			"I6",
			"I7",
			"E1",
			"E2",
			"E3",
			"E4",
			"E5",
			"E6"
		};
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemID() {
		return itemID;
	}

	/*
	 * The item Id should be pulled from the ArrayList
	 * Perhaps create a compare loop to pull the ID of 
	 * an item that matches the name we are looking for.
	 */
	public void setItemID(String itemID) {
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
	
	public void useItem(boolean usable, int id){
		if(usable){//if true, it means available 
			//Then it should be 
		}
	}
}
