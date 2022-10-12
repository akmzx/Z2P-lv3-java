package com.bms.controller;

import java.io.IOException;

import com.bms.BMS;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	@FXML
    void author_click(MouseEvent event) throws IOException {
		BMS.changeView("view/Author.fxml");
    }

    @FXML
    void book_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/Book.fxml");
    }

    @FXML
    void category_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/Category.fxml");
    }

}
