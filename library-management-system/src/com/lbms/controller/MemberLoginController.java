package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;
import com.lbms.model.DatabaseService;
import com.lbms.model.Member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MemberLoginController {

    @FXML
    private TextField txt_card_id;

    @FXML
    private TextField txt_name;

    @FXML
    void btn_login_clicked(ActionEvent event) throws IOException {
    	var card_id = txt_card_id.getText();
    	var name = txt_name.getText();
    	if (card_id.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "Card ID is required");
    		return;
    	}
    	
    	if (name.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "Name is required");
    		return;
    	}
    	
    	Member member = DatabaseService.login(Integer.parseInt(card_id), name);
    	
    	if (member == null) {
    		LBMS.showAlert(AlertType.ERROR, "Authentication fail");
    		return;
    	} else {
    		LBMS.LoginMember = member;
    		DatabaseService.borrowedBooks();
    		LBMS.changeView("view/Main.fxml");
    	}
    }

    @FXML
    void label_signIn_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberRegister.fxml");
    }

}
