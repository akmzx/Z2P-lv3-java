package com.lbms;
	
import java.io.IOException;

import com.lbms.model.DatabaseService;
import com.lbms.model.Librarian;
import com.lbms.model.Member;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;

public class LBMS extends Application {
	
	static Stage original_stage;
	public static Member LoginMember = null;
	public static Librarian LoginLibrarian = null;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Library Management System");
			primaryStage.setResizable(false);
			primaryStage.show();
			original_stage = primaryStage;
			
			DatabaseService.deleteExpiredMember();
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
		Parent root = FXMLLoader.load(LBMS.class.getResource(inputfile));
		var scene = new Scene(root);
		original_stage.hide();
		original_stage.setScene(scene);
		original_stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
