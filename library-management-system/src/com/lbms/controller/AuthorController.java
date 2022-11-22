package com.lbms.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.lbms.LBMS;
import com.lbms.model.Author;
import com.lbms.model.DatabaseService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AuthorController {

    @FXML
    private DatePicker date_birthday;

    @FXML
    private TextField txt_city;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_search;

    @FXML
    void btn_add_clicked(ActionEvent event) throws Exception {
    	var author = new Author();
    	author = getAuthorInfo();
    	
    	DatabaseService.addAuthor(author);
    	LBMS.showAlert(AlertType.INFORMATION, "Author Added");
    }

    private Author getAuthorInfo() {
    	var name = txt_name.getText();
    	var city = txt_city.getText();
    	LocalDate birthday = date_birthday.getValue();
    	
    	if (name.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "Name is required");
    	}
    	
    	if (city.equals("")) {
    		LBMS.showAlert(AlertType.ERROR, "City is required");
    	}
    	
    	if (birthday == null) {
    		LBMS.showAlert(AlertType.ERROR, "Birthday is required");
    	}
    	
    	var author = new Author();
    	author.setName(name); 
    	author.setCity(city);
    	author.setBirthday(birthday);
    	
    	return author;
	}

	@FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Main.fxml");
    }

    @FXML
    void btn_delete_clicked(ActionEvent event) {
    	var author = new Author();
    	author = getAuthorInfo();
    	
    	try {
			DatabaseService.deleteAuthor(author);
			LBMS.showAlert(AlertType.INFORMATION, "Author Deleted");
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, "Author does not exist");
		}
    }

    @FXML
    void btn_update_clicked(ActionEvent event) throws Exception {
    	var author = new Author();
    	author = getAuthorInfo();
    	
    	DatabaseService.updateAuthor(author);
    	
    	LBMS.showAlert(AlertType.INFORMATION, "Author Updated");
    }

    @FXML
    void img_search_clicked(MouseEvent event) {
    	try {
    		var name = txt_search.getText();
        	
        	Author author = DatabaseService.searchAuthor(name);
        	
        	txt_name.setText(author.getName());
        	txt_city.setText(author.getCity());
        	date_birthday.setValue(author.getBirthday());
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, "Author does not found");
		}
    	
    }

}
