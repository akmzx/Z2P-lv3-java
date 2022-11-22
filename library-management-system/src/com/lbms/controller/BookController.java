package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class BookController {

    @FXML
    void pane_bookList_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/BookList.fxml");
    }

    @FXML
    void pane_borrow_clicked(MouseEvent event) throws IOException {
    	if (LBMS.LoginMember == null) {
    		LBMS.showAlert(AlertType.INFORMATION, "Please Login First");
    		LBMS.changeView("view/MemberLogin.fxml");
    	} else {
    		LBMS.changeView("view/BookBorrow.fxml");
    	}
    }

    @FXML
    void pane_edit_clicked(MouseEvent event) throws IOException {
    	if (LBMS.LoginLibrarian == null) {
    		LBMS.showAlert(AlertType.INFORMATION, "Please Login First");
    		LBMS.changeView("view/LibrarianLogin.fxml");
    	}
    	else {
    		LBMS.changeView("view/BookEdit.fxml");
    	}
    }

    @FXML
    void pane_return_clicked(MouseEvent event) throws IOException {
    	if (LBMS.LoginMember == null) {
    		LBMS.showAlert(AlertType.INFORMATION, "Please Login First");
    		LBMS.changeView("view/MemberLogin.fxml");
    	} else {
    		LBMS.changeView("view/BookReturn.fxml");
    	}
    }

}

