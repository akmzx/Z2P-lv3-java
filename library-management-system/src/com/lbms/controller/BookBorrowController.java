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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookBorrowController implements Initializable {

    @FXML
    private TableView<Book> book_table;

    @FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

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
    private TextField txt_title;
    
    List<Category> categoryList;
	List<Author> authorList;

    @FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Book.fxml");
    }

    @FXML
    void btn_borrow_clicked(ActionEvent event) {
    	Book book = book_table.getSelectionModel().getSelectedItem();
    	
    	if (book.getAvailable().equals("N")) {
    		LBMS.showAlert(AlertType.ERROR, "The Book is already borrowed");
    	} else if (LBMS.LoginMember.getBorrowedBook() != null) {
    		LBMS.showAlert(AlertType.ERROR, "You already borrowed");
    	} else {
    		DatabaseService.borrowBook(book);
    	}
    }

    @FXML
    void img_search_clicked(MouseEvent event) {
    	var title = txt_title.getText();
    	var author = cbo_author.getSelectionModel().getSelectedItem();
		var category = cbo_category.getSelectionModel().getSelectedItem();
		
		List<Book> list = DatabaseService.searchBook(author, category, title);
    	
    	book_table.setItems(FXCollections.observableArrayList(list));
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

}
