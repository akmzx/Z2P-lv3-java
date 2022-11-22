package com.lbms.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.model.Book;
import com.lbms.model.DatabaseService;

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
    private TableColumn<Book, String> col_available;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, Integer> col_code;

    @FXML
    private TableColumn<Book, String> col_created_by;

    @FXML
    private TableColumn<Book, LocalDate> col_publish_date;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    void btn_back_clicked(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_publish_date.setCellValueFactory(new PropertyValueFactory<>("publish_date"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("librarianName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_available.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		List<Book> bookList = DatabaseService.findAllBooks();
		
		book_table.setItems(FXCollections.observableArrayList(bookList));
		
	}

}

