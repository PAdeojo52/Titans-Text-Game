import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class TextPane extends Pane
{
	private String txt = "Test";
	private String input = "";
	
	private Label txtLabel;
	
	private TextInputPane txtInput = new TextInputPane();
	
	public TextPane()
	{
		txtLabel = new Label(txt);
		
		txtLabel.setPrefWidth(100);
		txtLabel.setWrapText(true);
		txtLabel.setTranslateX(50);
		txtLabel.setTranslateY(25);
		txtLabel.setPrefWidth(400);
		txtLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16;");
		
		getChildren().add(txtLabel);
		getChildren().add(txtInput);
		
		txtInput.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	                input = txtInput.getTextInput();
	                txtInput.resetTextInput();
	            }
	        }
		});
		
		txtInput.requestFocus();
	}
	
	public void changeText(String newTxt)
	{
		txt = newTxt;
		
		txtLabel.setText(txt);
	}
	
	public String getInput()
	{
		return input;
	}
	
	public void resetInput()
	{
		input = "";
	}
	
	public double checkWidth()
	{
		/*return txtLabel.getLayoutBounds().getWidth();
		Text text = new Text(txtLabel.getText());
		new Scene(new Group(text));
		
		text.applyCss();
		
		return text.getLayoutBounds().getWidth();*/
		
		return 5;
	}
}
