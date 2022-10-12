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
import javafx.scene.input.MouseEvent;

public class BookEditController implements Initializable{

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
    
    private List<Category> categoryList;
    private List<Author> authorList;
    
    private Book book;
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	BMS.changeView("view/Book.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) throws Exception {
    	
    	try {
        	DatabaseService.deleteById(book.getId());
        	BMS.showAlert(AlertType.INFORMATION, "Success");	
		} catch (Exception e) {
			BMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_edit_click(ActionEvent event) {
    	try {
    		var code = txt_code.getText();
        	var price = txt_price.getText();
        	var title = txt_title.getText();
        	var author_index = cbo_author.getSelectionModel().getSelectedIndex();
        	var cate_index = cbo_category.getSelectionModel().getSelectedIndex();
        	
//        	update
        	book.setPrice(Double.parseDouble(price));
        	book.setTitle(title);
        	book.setAuthor(authorList.get(author_index));
        	book.setCategory(categoryList.get(cate_index));
        	
        	DatabaseService.updateBook(book);
        	BMS.showAlert(AlertType.INFORMATION, "Success");
		} catch (Exception e) {
			BMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_search_click(MouseEvent event) {
    	var code = txt_code.getText();
    	if(code.equals("")) {
    		BMS.showAlert(AlertType.ERROR, "Code number is required");
    		return;
    	}
    	
    	book = DatabaseService.findById(Integer.parseInt(code));
    	if(book == null) {
    		BMS.showAlert(AlertType.WARNING, "Book the given id does not exist");
    	}
    	else {
    		txt_price.setText(book.getPrice() + "");
    		txt_title.setText(book.getTitle());
    		cbo_author.getSelectionModel().select(book.getAuthorName());
    		cbo_category.getSelectionModel().select(book.getCategoryName());
    	}
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