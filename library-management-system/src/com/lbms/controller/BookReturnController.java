package com.lbms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.LBMS;
import com.lbms.model.Book;
import com.lbms.model.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookReturnController implements Initializable {

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
    private TableColumn<Book, LocalDate> col_publish_date;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Book.fxml");
    }

    @FXML
    void btn_return_clicked(ActionEvent event) throws Exception {
    	Book book = book_table.getSelectionModel().getSelectedItem();
    	int selectIndex = book_table.getSelectionModel().getSelectedIndex();
    	if (book.getDue_date().isAfter(LocalDate.now())) {
    		var date = Math.abs(ChronoUnit.DAYS.between(book.getDue_date(), LocalDate.now()) + 1);
    		Integer fees = (int) (date * 100);
    		LBMS.showAlert(AlertType.INFORMATION, "You returned the books " + date + " days late./nThe fine is " + fees + " Kyats.");
    		DatabaseService.fineMember(book, fees);
    	}
    	DatabaseService.returnBook(book);
    	LBMS.showAlert(AlertType.INFORMATION, "Book has been returned");
    	
    	book_table.getItems().remove(selectIndex);
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
		
		List<Book> bookList = DatabaseService.findAllBorrowedBooks();
		
		book_table.setItems(FXCollections.observableArrayList(bookList));
	}

}

