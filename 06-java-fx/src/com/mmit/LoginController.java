package com.mmit;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    void btn_login_click(ActionEvent event) {

    }

    @FXML
    void lbl_register_click(MouseEvent event) throws IOException {
    	Main.changeScene("Sample.fxml");
    }
}
