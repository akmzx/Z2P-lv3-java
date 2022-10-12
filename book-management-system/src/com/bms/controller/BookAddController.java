package com.bms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.bms.BMS;
import com.bms.model.Author;
import com.bms.model.Book;
import com.bms.model.Category;
import com.bms.model.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BookAddController implements Initializable{

	@FXML
	private ComboBox<String> cbo_author;

	@FXML
	private ComboBox<String> cbo_category;

	@FXML
	private TextField txt_code;

	@FXML
	private TextField txt_price;

	@FXML
	private TextField txt_title;
	
	List<Category> categoryList;
	List<Author> authorList;
	@FXML
	void btn_add_click(ActionEvent event) {
		try {
//			get data from UI
			var code = txt_code.getText();
			var author_index = cbo_author.getSelectionModel().getSelectedIndex();
			var category_index = cbo_category.getSelectionModel().getSelectedIndex();
			var price = txt_price.getText().equals("") ? "0" : txt_price.getText(); // "" or 123
			if(code.equals("")) {
				BMS.showAlert(AlertType.ERROR, "Code number is required");
				return;
			}
			if(author_index == -1) {
				BMS.showAlert(AlertType.ERROR, "Author is required");
				return;
			}
			if(category_index == -1) {
				BMS.showAlert(AlertType.ERROR, "category is required");
				return;
			}
//			create new book obj
			var book = new Book();
			book.setPrice(Double.parseDouble(price));
			book.setTitle(txt_title.getText());
			book.setId(Integer.parseInt(code));
			book.setAuthor(authorList.get(author_index));
			book.setCategory(categoryList.get(category_index));
			
//			save to database
			DatabaseService.saveBook(book);
			BMS.showAlert(AlertType.INFORMATION, "Success");
			
//			initial state
			txt_code.setText("");
			txt_title.setText("");
			txt_price.setText("");
			cbo_author.getSelectionModel().clearSelection();
			cbo_category.getSelectionModel().clearSelection();
		} catch (Exception e) {
			BMS.showAlert(AlertType.ERROR, e.getMessage());
		}
		
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		BMS.changeView("view/Book.fxml");
	}

	@FXML
	void btn_reset_click(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		categoryList = DatabaseService.findAllCategories();
		authorList = DatabaseService.findAllAuthors();
		
		List<String> authorNames = authorList.stream()
											.map(obj -> obj.getName())
											.toList();
		
		List<String> categoryNames = categoryList.stream()
													.map(obj -> obj.getName())
													.toList();
		
		cbo_author.setItems(FXCollections.observableArrayList(authorNames));
		cbo_category.setItems(FXCollections.observableArrayList(categoryNames));
	}
	
	
}
