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
import javafx.scene.control.cell.PropertyValueFactory;

public class BookListController implements Initializable{

	@FXML
    private TableView<Book> book_table;

    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, Integer> col_code;

    @FXML
    private TableColumn<Book, String> col_created_by;

    @FXML
    private TableColumn<Book, Double> col_price;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	BMS.changeView("view/Book.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_code.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
		List<Book> bookList = DatabaseService.findAllBook();
		
		book_table.setItems(FXCollections.observableArrayList(bookList));
	}
}