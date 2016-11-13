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

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class TextInputPane extends Pane
{
	private TextField txtInput = new TextField();
	
	private String input = "";
	
	public TextInputPane()
	{
		getChildren().add(txtInput);
		
		txtInput.setTranslateX(50);
		txtInput.setTranslateY(450);
		txtInput.setPrefWidth(400);
		txtInput.setStyle("-fx-text-fill: white;"
				+ "-fx-font-size: 16;"
				+ "-fx-background-color: gray;");
	}
	
	public String getTextInput()
	{
		return txtInput.getText();
	}
	
	public void resetTextInput()
	{
		txtInput.setText("");
		input = "";
	}
}
