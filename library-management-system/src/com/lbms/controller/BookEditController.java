package com.lbms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.LBMS;
import com.lbms.model.Author;
import com.lbms.model.Book;
import com.lbms.model.Category;
import com.lbms.model.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

public class BookEditController implements Initializable {

	@FXML
	private ComboBox<String> cbo_author;

	@FXML
	private ComboBox<String> cbo_category;
	
	@FXML
    private TextField txt_search;

	@FXML
	private DatePicker publishDate;

	@FXML
	private TextField txt_title;

	List<Category> categoryList;
	List<Author> authorList;
	
	private Book book;

	@FXML
	void btn_add_clicked(ActionEvent event) throws Exception {
		
		collectinfo();
		
		DatabaseService.addBook(book);
		LBMS.showAlert(AlertType.INFORMATION, "Book Added");
	}

	private void collectinfo() {
		var title = txt_title.getText();
		var author_index = cbo_author.getSelectionModel().getSelectedIndex();
		var category_index = cbo_category.getSelectionModel().getSelectedIndex();
		LocalDate publish_date = publishDate.getValue();
		
		if (title.equals("")) {
			LBMS.showAlert(AlertType.ERROR, "Title is required");
		}

		if (author_index == -1) {
			LBMS.showAlert(AlertType.ERROR, "Author is required");
		}
		if (category_index == -1) {
			LBMS.showAlert(AlertType.ERROR, "category is required");
		}
		
		book.setTitle(txt_title.getText());
		book.setAuthor(authorList.get(author_index));
		book.setCategory(categoryList.get(category_index));
		book.setPublish_date(publish_date);
	}

	@FXML
	void btn_back_clicked(ActionEvent event) throws IOException {
		LBMS.changeView("view/Book.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			categoryList = DatabaseService.findAllCategories();
			authorList = DatabaseService.findAllAuthors();

			List<String> authorNames = authorList.stream().map(obj -> obj.getName()).toList();

			List<String> categoryNames = categoryList.stream().map(obj -> obj.getName()).toList();
			
			cbo_author.setItems(FXCollections.observableArrayList(authorNames));
			cbo_category.setItems(FXCollections.observableArrayList(categoryNames));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
    void btn_delete_clicked(ActionEvent event) {
		
		try {
        	DatabaseService.deleteBook(book.getTitle());
        	LBMS.showAlert(AlertType.INFORMATION, "Book Deleted");	
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_update_clicked(ActionEvent event) {
    	try {
    		collectinfo();
    		var title = txt_title.getText();
        	DatabaseService.updateBook(book, title);
        	LBMS.showAlert(AlertType.INFORMATION, "Book Updated");
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void img_search_clicked(MouseEvent event) {
    	var title = txt_search.getText();
    	
    	book = DatabaseService.searchBook(title);
    	
    	txt_title.setText(book.getTitle());
    	cbo_author.getSelectionModel().select(book.getAuthor().getName());
    	cbo_category.getSelectionModel().select(book.getCategory().getName());
    	publishDate.setValue(book.getPublish_date());
    }

}
