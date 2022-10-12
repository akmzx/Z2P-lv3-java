package com.bms.controller;

import java.io.IOException;

import com.bms.BMS;
import com.bms.model.DatabaseService;
import com.bms.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	
//    	get value from 
    	var email = txt_email.getText();
    	var pass = txt_password.getText();
    	if(email.equals("")) {
    		BMS.showAlert(AlertType.ERROR, "Email is required");
    		return;
    	}
    	
    	if(pass.equals("")) {
    		BMS.showAlert(AlertType.ERROR, "Password is required");
    		return;
    	}
    	
    	User user = DatabaseService.login(email, pass);
    	if(user == null) {// login fail
    		BMS.showAlert(AlertType.ERROR, "Authentication fail");
    	}
    	else {
    		BMS.loginUser = user;
    		BMS.changeView("view/Main.fxml");
    	}
//    	authenticate
    	
    }
}