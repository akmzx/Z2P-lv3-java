package com.bms.controller;

import java.io.IOException;

import com.bms.BMS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BookController {

	@FXML
    void btn_back_click(ActionEvent event) throws IOException {
		BMS.changeView("view/Main.fxml");
    }

    @FXML
    void panel_add_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/BookAdd.fxml");
    }

    @FXML
    void panel_edit_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/BookEdit.fxml");
    }

    @FXML
    void panel_list_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/BookList.fxml");
    }

    @FXML
    void panel_search_click(MouseEvent event) throws IOException {
    	BMS.changeView("view/BookSearch.fxml");
    }
}