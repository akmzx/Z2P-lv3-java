package com.lbms.controller;

import java.io.IOException;

import com.lbms.LBMS;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MemberController {

    @FXML
    void pane_list_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberList.fxml");
    }

    @FXML
    void pane_register_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberRegister.fxml");
    }

    @FXML
    void pane_search_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberSearch.fxml");
    }

    @FXML
    void pane_update_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberUpdate.fxml");
    }

    @FXML
    void panel_click_search(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberSearch.fxml");
    }

}
