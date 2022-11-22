package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    void pane_book_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/Book.fxml");
    }

    @FXML
    void pane_member_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/Member.fxml");
    }
    
    @FXML
    void pane_librarian_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/Librarian.fxml");
    }
    
    @FXML
    void pane_author_clicked(MouseEvent event) throws IOException {
    	if (LBMS.LoginLibrarian == null) {
    		LBMS.showAlert(AlertType.INFORMATION, "Please Login First");
    		LBMS.changeView("view/LibrarianLogin.fxml");
    	}
    	else {
    		LBMS.changeView("view/Author.fxml");
    	}
    	
    }
}
