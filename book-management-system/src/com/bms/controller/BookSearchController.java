package com.bms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.bms.BMS;
import com.bms.model.Book;
import com.bms.model.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookSearchController implements Initializable{

	 @FXML
	    private TableView<Book> book_table;

	    @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, Integer> col_code;

	    @FXML
	    private TableColumn<Book, Double> col_price;

	    @FXML
	    private TableColumn<Book, String> col_title;

	    @FXML
	    private TextField txt_author;

	    @FXML
	    private TextField txt_category;

	    @FXML
	    private TextField txt_title;

	    @FXML
	    void search_click(MouseEvent event) {
	    	var author = txt_author.getText();
	    	var category = txt_category.getText();
	    	var title = txt_title.getText();
	    	
	    	List<Book> list = DatabaseService.searchBook(author, category, title);
	    	
	    	book_table.setItems(FXCollections.observableArrayList(list));
	    }
	    
	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	BMS.changeView("view/Book.fxml");
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_code.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			
		}
}