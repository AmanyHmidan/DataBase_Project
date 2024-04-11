package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private Button B1;
	@FXML
	private TextField UserNameTextField;
	@FXML
	private PasswordField PassWordTextField;
	
	private Stage stage ;
	private Scene scene ;
	private Parent root ;

	// Event Listener on Button.onAction
	public void chooseField(ActionEvent event) throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	// Event Listener on Button[#B1].onAction
	@FXML
	public void LoginButton(ActionEvent event) {
		// TODO Autogenerated
		 String username = UserNameTextField.getText();
	        String password = PassWordTextField.getText();

	        if (username.equals("12345") && password.equals("Admain")) {
	            // Credentials are correct, proceed to Main2
	            try {
	                // Get the reference to the current stage
	                Stage stage = (Stage) UserNameTextField.getScene().getWindow();

	                // Load the FXML file for Main2 scene
	                Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));

	                // Create a new scene with the loaded FXML file
	                Scene scene = new Scene(root);

	                // Set the new scene on the stage
	                stage.setScene(scene);

	                System.out.println("Login successful. Switching to Main2...");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            // Credentials are incorrect, show an alert
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Login Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Invalid username or password. Please try again.");
	            alert.showAndWait();
	        }
	}
}

