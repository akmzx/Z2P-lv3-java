package com.bms;
	
import java.io.IOException;

import com.bms.model.User;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class BMS extends Application {
	
	static Stage original_stage;
	public static User loginUser = new User();
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Book.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Book Management System");
			primaryStage.setResizable(false);
			primaryStage.show();
			original_stage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAlert(AlertType type, String message) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setContentText(message);
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	public static void changeView(String inputfile) throws IOException {
		Parent root = FXMLLoader.load(BMS.class.getResource(inputfile));
		var scene = new Scene(root);
		original_stage.hide();
		original_stage.setScene(scene);
		original_stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}