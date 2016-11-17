package Main;
/**Class: 
  * @author Kevin Stevens
  * @version 1.0
  * Course : 
  * Written: 
  * 
  * 
  * Purpose: - 
  */

import inventory.Coin;
import inventory.Item;
import inventory.Usable;
import inventory.Weapon;

import java.util.ArrayList;
import java.util.Iterator;

import Entity.Player;
import Room.ItemPuzzle;
import Room.Riddle;
import Room.Room;
import Room.RoomControl;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;

public class Main extends Application
{
	private TextPane txt = new TextPane();
	private Timeline mainLoopCheck;
	
	public static String currentRoom = "S1";

	private Room currentRoomObject;
	
	private Player player = new Player();
	
	private static String displayText = "";
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	public void start(Stage primaryStage)
	{
		Scene scene = new Scene(txt, 500, 500);
		primaryStage.setTitle("Tales of Titans");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		txt.setStyle("-fx-background-color: black");
		txt.requestFocus();
		
		Room mainMenu = new Room("S1",
				"Welcome to Tales of Titans!\n\nType Start to begin!",
				false, null);
		rooms.add(mainMenu);
		
		Room deathScreen = new Room("D1",
				"-- You have died. Game Over.",
				false, null);
		rooms.add(deathScreen);
		
		Room victoryScreen = new Room("V1",
				"Congratulations! You have defeated Briarios! You are victorious!",
				false, null);
		rooms.add(victoryScreen);
		
		RoomControl rc = new RoomControl(rooms, player);
		currentRoom = "S1";
		//currentRoom = "T1";
		setRoom(currentRoom);
		
		mainLoopCheck = new Timeline(
				new KeyFrame(Duration.millis(5), e -> mainLoop()));
		mainLoopCheck.setCycleCount(Timeline.INDEFINITE);
		mainLoopCheck.play();
		
		Usable newPotion = new Usable(6);
		player.addItem(newPotion);
		
		player.addGold(3);
		
		//player.setHealth(9999999);
	}
	
	public void mainLoop()
	{		
		if (displayText.equals("") && currentRoomObject != null)
		{
			setRoom(currentRoom);
		}
		
		Iterator<Item> i = player.getInv().iterator();
		
		while(i.hasNext())
		{
			Item i2 = i.next();
			
			if (i2 instanceof Coin)
			{
				player.addGold(1);
				i.remove();
			}
		}
		
		getObject();
		
		if (displayText.length() > 0) displayText = cropText(displayText);
		
		if (!txt.getInput().equals(""))
		{
			if (!currentRoomObject.getID().equals("S1")
					&& !currentRoomObject.getID().equals("D1")
					&& !currentRoomObject.getID().equals("V1"))
			{
				parseText(txt.getInput());
			}
			else
			{
				parseTextStart(txt.getInput());
			}
			
			txt.resetInput();
		}
		
		while (countLines(displayText) > 15)
		{
			displayText = displayText.substring(displayText.indexOf("\n") + 1);
		}
		
		if (player.getHealth() < 1 && !currentRoom.equals("D1"))
		{
			clearScreen();
			setRoom("D1");
		}
		
		txt.changeText(displayText);
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public static void display(String newText)
	{
		displayText = displayText + "\n" + newText;
		
	}
	
	private void clearScreen()
	{
		displayText = "";
	}
	
	private String cropText(String cropString)
	{
		String newString = cropString;
		
		for (int i = 1; i < newString.length() - 50; i++)
		{
			if (!newString.substring(i-1, i+1).contains("\n"))
			{
				if (!newString.substring(i, i + 50).contains("\n"))
				{
					int lastSpace = newString.substring(i + 2, i + 50).lastIndexOf(" ") + i + 2;
					
					newString = newString.substring(0, lastSpace) + "\n" + newString.substring(lastSpace + 1);
					
				}
			}
		}
		
		return newString;
	}
	
	public int countLines(String testString)
	{
		int numLines = 0;
		int nextIndex = 0;
		String testStringCount = testString;
		
		while (testStringCount.indexOf("\n") > -1)
		{
			nextIndex = testStringCount.indexOf("\n") + 1;
			numLines ++;
			testStringCount = testStringCount.substring(nextIndex);
		}
		
		return numLines;
	}
	
	private void look()
	{
		display(currentRoomObject.getDescription());
		
		if (currentRoomObject.getMonster() != null)
		{
			display(currentRoomObject.getMonster().getDescription());
		}
		
		if (currentRoomObject.getPuzzle() != null)
		{
			display(currentRoomObject.getPuzzle().getDescription());
		}
		
		if (currentRoomObject.getInv().size() > 0)
		{
			display("-- Items you can see");
			
			String invString = "";
			
			for (int i = 0; i < currentRoomObject.getInv().size(); i++)
			{
				invString = invString + "-" + currentRoomObject.getInv().get(i).getName() + " ";
			}
			
			display(invString);
		}
	}
	
	private void setRoom(String newRoom)
	{
		currentRoom = newRoom;
		getObject();
		look();
		
		if (currentRoomObject.getMonster() != null)
		{
			if (Math.random() * 100 < currentRoomObject.getMonster().getAggressiveness())
			{
				currentRoomObject.getMonster().attack(player);
			}
		}
	}
	
	private void getObject()
	{
		for (Room r : rooms)
		{
			if (r.getID() == currentRoom)
			{
				currentRoomObject = r;
			}
		}
	}
	
	private void parseTextStart(String input)
	{
		if (input.toLowerCase().equals("start"))
		{
			currentRoom = "M1";
			setRoom(currentRoom);
			getObject();
		}
	}
	
	private void parseText(String input)
	{
		String tempInput = input;
		
		int tempInt = 0;
		
		boolean recognized = false;
		
		if ((tempInput.toLowerCase().contains("attack")
				|| tempInput.equalsIgnoreCase("a"))
				&& !recognized)
		{
			if (currentRoomObject.getMonster() != null)
			{
				player.attack(currentRoomObject.getMonster());
				
				if (currentRoomObject.getMonster().getHealth() > 0)
				{
					currentRoomObject.getMonster().attack(player);
				}
				else
				{
					if (currentRoomObject.getMonster().getMonsterID() != 7)
					{
						currentRoomObject.killMonster(player);
					}
					else
					{
						clearScreen();
						setRoom("V1");
					}
				}
			}
			else
			{
				display("-- There is nothing to attack.");
			}
			
			recognized = true;
		}
		
		String nothing = "-- Can't go that direction.";
		String roomLocked = "-- Something is preventing you from going that way.";
		
		if ((tempInput.toLowerCase().contains("north")
				|| tempInput.equalsIgnoreCase("n"))
				&& !recognized)
		{
			if (currentRoomObject.getNorth() != null && !currentRoomObject.getLocked(0))
			{
				setRoom(currentRoomObject.getNorth().getID());
			}
			else if (currentRoomObject.getNorth() != null && currentRoomObject.getLocked(0))
			{
				display(roomLocked);
			}
			else
			{
				display(nothing);
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("east")
				|| tempInput.equalsIgnoreCase("e"))
				&& !recognized)
		{
			if (currentRoomObject.getEast() != null && !currentRoomObject.getLocked(1))
			{
				setRoom(currentRoomObject.getEast().getID());
			}
			else if (currentRoomObject.getEast() != null && currentRoomObject.getLocked(1))
			{
				display(roomLocked);
			}
			else
			{
				display(nothing);
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("south") 
				|| tempInput.equalsIgnoreCase("s"))
				&& !recognized)
		{
			if (currentRoomObject.getSouth() != null && !currentRoomObject.getLocked(2))
			{
				setRoom(currentRoomObject.getSouth().getID());
			}
			else if (currentRoomObject.getSouth() != null && currentRoomObject.getLocked(2))
			{
				display(roomLocked);
			}
			else
			{
				display(nothing);
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("west") 
				|| tempInput.equalsIgnoreCase("w"))
				&& !recognized)
		{
			if (currentRoomObject.getWest() != null && !currentRoomObject.getLocked(3))
			{
				setRoom(currentRoomObject.getWest().getID());
			}
			else if (currentRoomObject.getWest() != null && currentRoomObject.getLocked(3))
			{
				display(roomLocked);
			}
			else
			{
				display(nothing);
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("look")
				|| tempInput.equalsIgnoreCase("l"))
				&& !recognized)
		{
			look();
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("help") && !recognized)
		{
			display("-- Try these commands: "
					+ "\n - North/South/East/West "
					+ "\n - Look"
					+ "\n - Attack"
					+ "\n - Get (item)"
					+ "\n - Buy (item)"
					+ "\n - Use (item)"
					+ "\n - Equip (weapon)"
					+ "\n - Inventory"
					+ "\n - Hint");
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("get ")
				|| tempInput.toLowerCase().contains("take "))
				&& !recognized)
		{
			int startIndex = tempInput.toLowerCase().indexOf(" ") + 1;
			
			String getItemName = tempInput.toLowerCase().substring(startIndex);
			
			boolean itemGotten = false;
			
			ArrayList<Item> currentInv = currentRoomObject.getInv();
			
			if (currentInv.size() > 0 && !currentRoomObject.getIsShop())
			{
				for (int i = 0; i < currentInv.size(); i++)
				{
					if (currentInv.get(i).getName().toLowerCase().equals(getItemName))
					{
						player.getItem(currentInv.get(i));
						currentInv.remove(i);
						
						itemGotten = true;
					}
				}
			}
			
			if (!itemGotten && !currentRoomObject.getIsShop())
			{
				display("-- No item to get");
			}
			
			if (currentRoomObject.getIsShop())
			{
				display("-- This is a shop, ya gotta pay for that!");
			}
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("buy ") && !recognized)
		{
			int startIndex = tempInput.toLowerCase().indexOf("buy") + 4;
			
			String getItemName = tempInput.toLowerCase().substring(startIndex);
			
			boolean itemGotten = false;
			
			ArrayList<Item> currentInv = currentRoomObject.getInv();
			
			if (currentInv.size() > 0 && currentRoomObject.getIsShop())
			{
				boolean itemBought = false;
				
				Iterator<Item> i = currentRoomObject.getInv().iterator();
				
				while(i.hasNext() && !itemBought)
				{
					Item i2 = i.next();
					
					if (i2.getName().toLowerCase().equals(getItemName))
					{
						
						if (player.buyItem(i2))
						{
							i.remove();
						}
						
						itemBought = true;
					}
				}
			}
			
			if (!itemGotten && !currentRoomObject.getIsShop())
			{
				display("-- No item to buy.");
			}
			
			if (!currentRoomObject.getIsShop())
			{
				display("-- You don't need to pay for that. Just get it.");
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("inventory")
				|| tempInput.toLowerCase().equals("inv")
				|| tempInput.toLowerCase().equals("i"))
				&& !recognized)
		{
			display("-- Inventory");
			display("- Health: " + player.getHealth());
			display("- " + player.getGold() + " gold");
			
			for (int i = 0; i < player.getInv().size(); i++)
			{
				display("- " + player.getInv().get(i).getName());
			}
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("use ") && !recognized)
		{
			String useItem = tempInput.toLowerCase().substring(4);
			
			boolean itemUsed = false;
			boolean inInventory = false;
			
			Iterator<Item> i = player.getInv().iterator();
			
			while(i.hasNext() && !itemUsed)
			{
				Item i2 = i.next();
				
				if (i2 instanceof Usable && i2.getName().toLowerCase().equals(useItem))
				{
					Usable i3 = (Usable) i2;
					
					if (i3.getHealthRecov() > 0)
					{
						player.heal(i3.getHealthRecov());
						i.remove();
						itemUsed = true;
					}
					
					if (currentRoomObject.getPuzzle() != null
							&& currentRoomObject.getPuzzle() instanceof ItemPuzzle)
					{
						ItemPuzzle ip = (ItemPuzzle) currentRoomObject.getPuzzle();
						
						if (i3.getName().toLowerCase().equals(ip.getSolution().toLowerCase()))
						{
							ip.setSolved(player);
							itemUsed = true;
						}
					}
					
					if (currentRoomObject.getMonster() != null
							&& currentRoomObject.getMonster().getMonsterID() == 0
							&& i3.getName().equals("Silver Dagger"))
					{
						display("-- The silver dagger vanquished the wraith!");
						currentRoomObject.killMonster(player);
						
						itemUsed = true;
					}
					
					inInventory = true;
				}
			}
			
			if (!inInventory)
			{
				display("-- Item name not recognized.");
			}
			else if (inInventory && !itemUsed)
			{
				display("-- Cannot use that item right now.");
			}
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("equip ") && !recognized)
		{
			String useItem = tempInput.toLowerCase().substring(6);
			
			boolean inInventory = false;
			
			Iterator<Item> i = player.getInv().iterator();
			
			while(i.hasNext())
			{
				Item i2 = i.next();
				
				if (i2 instanceof Weapon && i2.getName().toLowerCase().equals(useItem))
				{
					Weapon i3 = (Weapon) i2;
					
					player.setEquipment(i3);
					
					display("-- Equipped " + i3.getName());
					
					inInventory = true;
				}
			}
			
			if (!inInventory)
			{
				display("-- Item name not recognized.");
			}
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("hint") && !recognized)
		{
			if (currentRoomObject.getPuzzle() != null)
			{
				display(currentRoomObject.getPuzzle().getHint());
			}
			else
			{
				display("-- No puzzle is present.");
			}
			
			recognized = true;
		}
		
		if (!recognized)
		{
			if (currentRoomObject.getPuzzle() != null
					&& currentRoomObject.getPuzzle() instanceof Riddle)
			{
				Riddle r = (Riddle) currentRoomObject.getPuzzle();
				
				if (tempInput.toLowerCase().equals(r.getSolution().toLowerCase()))
				{
					r.setSolved(player);
					recognized = true;
				}
			}
			
			if (!recognized)
			{
				display("-- Command not recognized.");
			}
		}
	}
}