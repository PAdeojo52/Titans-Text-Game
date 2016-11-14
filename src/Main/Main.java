package main;
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

import java.util.ArrayList;
import java.util.Iterator;

import Entity.Player;
import room.ItemPuzzle;
import room.Riddle;
import room.Room;
import room.RoomControl;
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
	
	public static String currentRoom = "M1";

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
		
		RoomControl rc = new RoomControl(rooms);
		
		mainLoopCheck = new Timeline(
				new KeyFrame(Duration.millis(5), e -> mainLoop()));
		mainLoopCheck.setCycleCount(Timeline.INDEFINITE);
		mainLoopCheck.play();
		
		Usable newPotion = new Usable(6);
		player.getItem(newPotion);
	}
	
	public void mainLoop()
	{	
		//displayText = "";
		
		if (displayText.equals("") && currentRoomObject != null)
		{
			setRoom(currentRoom);
			//displayText = currentRoomObject.getDescription();
		}
		
		Iterator<Item> i = player.getInv().iterator();
		
		while(i.hasNext())
		{
			Item i2 = i.next();
			
			if (i2 instanceof Coin)
			{
				player.addGold();
				i.remove();
			}
		}
		
		getObject();
		
		if (displayText.length() > 0) displayText = cropText(displayText);
		
		if (!txt.getInput().equals(""))
		{
			parseText(txt.getInput());
			txt.resetInput();
		}
		
		while (countLines(displayText) > 15)
		{
			displayText = displayText.substring(displayText.indexOf("\n") + 1);
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
		
		if (currentRoomObject.getInv().size() > 0)
		{
			display("-- Items you can see");
			for (int i = 0; i < currentRoomObject.getInv().size(); i++)
			{
				display("- " + currentRoomObject.getInv().get(i).getName());
			}
		}
		
		display(currentRoomObject.getLocked(0) + "");
		display(currentRoomObject.getLocked(1) + "");
		display(currentRoomObject.getLocked(2) + "");
		display(currentRoomObject.getLocked(3) + "");
	}
	
	private void setRoom(String newRoom)
	{
		currentRoom = newRoom;
		getObject();
		display(currentRoomObject.getDescription());
		
		if (currentRoomObject.getMonster() != null)
		{
			display(currentRoomObject.getMonster().getDescription());
			
			if (Math.random() * 100 < currentRoomObject.getMonster().getAggressiveness())
			{
				currentRoomObject.getMonster().attack(player);
			}
		}
		
		if (currentRoomObject.getInv().size() > 0)
		{
			display("-- Items you can see");
			for (int i = 0; i < currentRoomObject.getInv().size(); i++)
			{
				display("- " + currentRoomObject.getInv().get(i).getName());
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
	
	private void parseText(String input)
	{
		String tempInput = input;
		
		boolean recognized = false;
		
		if (tempInput.toLowerCase().contains("attack") && !recognized)
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
					currentRoomObject.killMonster(player);
				}
			}
			else
			{
				display("-- There is nothing to attack.");
			}
			
			recognized = true;
		}
		
		String nothing = "-- Can't go that direction.";
		
		if ((tempInput.toLowerCase().contains("north")
				|| tempInput.equalsIgnoreCase("n"))
				&& !recognized)
		{
			if (currentRoomObject.getNorth() != null && !currentRoomObject.getLocked(0))
			{
				setRoom(currentRoomObject.getNorth().getID());
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
			else
			{
				display(nothing);
			}
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("look") && !recognized)
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
					+ "\n - Inventory");
			
			recognized = true;
		}
		
		if (tempInput.toLowerCase().contains("get") && !recognized)
		{
			int startIndex = tempInput.toLowerCase().indexOf("get") + 4;
			
			String getItemName = tempInput.toLowerCase().substring(startIndex);
			
			boolean itemGotten = false;
			
			ArrayList<Item> currentInv = currentRoomObject.getInv();
			
			if (currentInv.size() > 0 && !currentRoomObject.getIsShop())
			{
				for (int i = 0; i < currentInv.size(); i++)
				{
					if (currentInv.get(i).getName().toLowerCase().equals(getItemName))
					{
						display("-- Got " + currentInv.get(i).getName());
						player.getItem(currentInv.get(i));
						currentInv.remove(i);
						
						itemGotten = true;
					}
				}
			}
			
			if (!itemGotten)
			{
				display("No item to get");
			}
			
			recognized = true;
		}
		
		if ((tempInput.toLowerCase().contains("inventory")
				|| tempInput.toLowerCase().equals("inv")
				|| tempInput.toLowerCase().equals("i"))
				&& !recognized)
		{
			display("-- Inventory");
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
						
						if (i3.getName().toLowerCase().equals(ip.getSolutionName().toLowerCase()))
						{
							ip.setSolved();
							itemUsed = true;
						}
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
		
		if (!recognized)
		{
			if (currentRoomObject.getPuzzle() != null
					&& currentRoomObject.getPuzzle() instanceof Riddle)
			{
				Riddle r = (Riddle) currentRoomObject.getPuzzle();
				
				if (tempInput.toLowerCase().equals(r.getSolution()))
				{
					r.setSolved();
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