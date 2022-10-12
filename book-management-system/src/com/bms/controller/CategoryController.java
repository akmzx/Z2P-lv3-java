package com.bms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.bms.BMS;
import com.bms.model.Category;
import com.bms.model.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoryController implements Initializable{

	@FXML
    private TableColumn<Category, LocalDate> col_created_at;

    @FXML
    private TableColumn<Category, Integer> col_id;

    @FXML
    private TableColumn<Category, String> col_name;

    @FXML
    private TableColumn<Category, LocalDate> col_updated_at;

    @FXML
    private TableView<Category> tbl_category;

    @FXML
    private TextField txt_name;

    @FXML
    void btn_add_click(ActionEvent event) {
    	try {
    		var name = txt_name.getText();
    		if(name.equals("")) {
    			BMS.showAlert(AlertType.ERROR, "Name is required");
    			return;
    		}
    		
//    		save to db
    		DatabaseService.saveCategory(name);
    		BMS.showAlert(AlertType.INFORMATION, "Success");
    		txt_name.setText("");
    		showData();
    	} catch (Exception e) {
			BMS.showAlert(AlertType.ERROR, "Something is wrong");
		}
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	BMS.changeView("view/Main.fxml");
    }

    @FXML
    void btn_update_click(ActionEvent event) throws Exception {
    	try {
    		var name = txt_name.getText();
//        	get current selected item from table
        	var category = tbl_category.getSelectionModel().getSelectedItem();
        	category.setName(name);
        	
        	DatabaseService.updateCategory(category);
        	BMS.showAlert(AlertType.INFORMATION, "Success");
        	
        	showData();
		} catch (Exception e) {
			BMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		define cell value of each column
		col_id.setCellValueFactory(new PropertyValueFactory<>("id")); // getId()
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		col_updated_at.setCellValueFactory(new PropertyValueFactory<>("updated_at"));
		
		showData();
		
//		selected row event
		
		tbl_category.getSelectionModel().selectedItemProperty()
			.addListener(
					(obs, old_select, new_select) -> {
						if(new_select != null) {
							Category selectCategory = tbl_category.getSelectionModel().getSelectedItem();
							txt_name.setText(selectCategory.getName());
						}
					}
			);
		
	}

	private void showData() {
		List<Category> cateList = DatabaseService.findAllCategories();
		tbl_category.setItems(FXCollections.observableArrayList(cateList));
	}
	
	
}