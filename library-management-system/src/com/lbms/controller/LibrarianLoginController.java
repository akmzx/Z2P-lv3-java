package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;
import com.lbms.model.DatabaseService;
import com.lbms.model.Librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

public class LibrarianLoginController {

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField pw_password;

    @FXML
    void btn_login_clicked(ActionEvent event) throws IOException {
    	var email = txt_email.getText();
    	var password = pw_password.getText();
    	
    	if (email.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "Email is required");
    	}
    	
    	if (password.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "Password is required");
    	}
    	
    	Librarian librarian = DatabaseService.LoginLibrarian(email, password);
    	
    	if (librarian == null) {
    		LBMS.showAlert(AlertType.ERROR, "Authentication Fails");
    		return;
    	} 
    	else {
    		LBMS.LoginLibrarian = librarian;
    		LBMS.changeView("view/Main.fxml");
    	}
    }

    @FXML
    void label_register_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/LibrarianRegister.fxml");
    }

}

