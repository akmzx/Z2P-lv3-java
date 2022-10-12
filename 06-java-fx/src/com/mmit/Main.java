package com.mmit;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	
	private static Stage original_stage;
	@Override
	public void start(Stage primaryStage) {
		try {
//			1
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//			2 add to scene
			Scene scene = new Scene(root);
//			3 add scene obj to stage
			primaryStage.setScene(scene);
//			call show() to display
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setTitle("Employee Registration");
			original_stage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(String inputFile) throws IOException {
		Parent root = FXMLLoader.load(Main.class.getResource(inputFile));
		
		Scene new_scene = new Scene(root);
		
		original_stage.hide();
		
		original_stage.setScene(new_scene);
		
		original_stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
