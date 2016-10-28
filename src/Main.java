/**Class: 
  * @author Kevin Stevens
  * @version 1.0
  * Course : 
  * Written: 
  * 
  * 
  * Purpose: - 
  */

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	//private TestRoom currentRoomObject;
	private Room currentRoomObject;
	
	private static String displayText = "";
	
	//private ArrayList<TestRoom> rooms = new ArrayList<TestRoom>();
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	public void start(Stage primaryStage)
	{
		Scene scene = new Scene(txt, 500, 500);
		primaryStage.setTitle("Tales of Titans");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		txt.setStyle("-fx-background-color: black");
		txt.requestFocus();
		
		for (int i = 1; i < 5; i++)
		{
			//TestRoom tempRoom = new TestRoom(i);
			//Room tempRoom = new Room(i);
			//rooms.add(tempRoom);
		}
		
		//setRoom(currentRoom);
		
		RoomControl rc = new RoomControl(rooms);
		
		mainLoopCheck = new Timeline(
				new KeyFrame(Duration.millis(5), e -> mainLoop()));
		mainLoopCheck.setCycleCount(Timeline.INDEFINITE);
		mainLoopCheck.play();
	}
	
	public void mainLoop()
	{	
		//displayText = "";
		
		if (displayText.equals("") && currentRoomObject != null)
		{
			setRoom(currentRoom);
			displayText = currentRoomObject.getDescription();
			//displayText = "1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 1234 56789 ";
		}
		
		getObject();
		
		if (currentRoomObject != null && !txt.getInput().equals(""))
		{
			//displayText = displayText + (currentRoomObject.getDescription());
		}
		
		if (displayText.length() > 0) displayText = cropText(displayText);
		
		if (!txt.getInput().equals(""))
		{
			parseText();
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
		
		for (int i = 0; i < newString.length() - 50; i++)
		{
			if (newString.substring(i, i+2).contains("\n"))
			{
				if (!newString.substring(i + 2, i + 48).contains("\n"))
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
	
	private void makeRooms()
	{
		
	}
	
	private void setRoom(String newRoom)
	{
		currentRoom = newRoom;
		getObject();
		display(currentRoomObject.getDescription());
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
	
	private void parseText()
	{
		String tempInput = txt.getInput();
		txt.resetInput();
		
		if (!tempInput.equals(""))
		{
			//txt.changeText(tempInput);
		}
		else
		{
			//txt.changeText("Blarg");
		}
		
		if (tempInput.toLowerCase().contains("attack"))
		{
			//String[] tempStrings = tempInput.split(" ");
			//txt.changeText(tempStrings[1]);
		}
		
		String nothing = "There is nothing in that direction.";
		
		if (tempInput.toLowerCase().contains("north"))
		{
			if (currentRoomObject.getNorth() != null)
			{
				setRoom(currentRoomObject.getNorth().getID());
			}
			else
			{
				display(nothing);
			}
		}
		
		if (tempInput.toLowerCase().contains("east"))
		{
			if (currentRoomObject.getEast() != null)
			{
				setRoom(currentRoomObject.getEast().getID());
			}
			else
			{
				display(nothing);
			}
		}
		
		if (tempInput.toLowerCase().contains("south"))
		{
			if (currentRoomObject.getSouth() != null)
			{
				setRoom(currentRoomObject.getSouth().getID());
			}
			else
			{
				display(nothing);
			}
		}
		
		if (tempInput.toLowerCase().contains("west"))
		{
			if (currentRoomObject.getWest() != null)
			{
				setRoom(currentRoomObject.getWest().getID());
			}
			else
			{
				display(nothing);
			}
		}
	}
}
