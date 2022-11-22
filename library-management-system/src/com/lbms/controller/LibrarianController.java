package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LibrarianController {

    @FXML
    void pane_login_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/LibrarianLogin.fxml");
    }

    @FXML
    void pane_register_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/LibrarianRegister.fxml");
    }

}
