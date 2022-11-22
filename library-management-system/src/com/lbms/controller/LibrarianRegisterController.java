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

public class LibrarianRegisterController {

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_nrcno;

    @FXML
    private PasswordField pw_password;

    @FXML
    private TextField txt_phone;

    @FXML
    void btn_register_clicked(ActionEvent event) {
    	try {
			var name = txt_name.getText();
			var email = txt_email.getText();
			var password = pw_password.getText();
			var nrcno = txt_nrcno.getText();
			var phone = txt_phone.getText();
			
			if (name.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Name is required");
			}
			
			if (email.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Email is required");
			}
			
			if (password.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Password is required");
			}
			
			if (nrcno.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "NRC No is required");
			}
			
			if (phone.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Phone Number is required");
			}
			
			var librarian = new Librarian();
			librarian.setName(name);
			librarian.setEmail(email);
			librarian.setPassword(password);
			librarian.setNrcno(nrcno);
			librarian.setPhone(phone);
			
			DatabaseService.addLibrarian(librarian);
			
			LBMS.showAlert(AlertType.INFORMATION, "Register Successful");
			LBMS.changeView("view/LibrarianLogin.fxml");
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void label_login_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/LibrarianLogin.fxml");
    }

}
