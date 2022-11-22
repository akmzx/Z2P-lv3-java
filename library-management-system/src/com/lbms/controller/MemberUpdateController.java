package com.lbms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.LBMS;
import com.lbms.model.DatabaseService;
import com.lbms.model.Member;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MemberUpdateController implements Initializable {

    @FXML
    private ComboBox<String> cbo_year;

    @FXML
    private TextField txt_academic_year;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_roll_no;

    @FXML
    private TextField txt_search_card_id;

    @FXML
    private TextField txt_search_name;
    
    private Member member;
    
    private List<String> yearList = List.of("First Year", "Second Year", "Third Year", "Fourth Year");

    @FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Member.fxml");
    }

    @FXML
    void btn_delete_clicked(ActionEvent event) {
    	try {
        	DatabaseService.deleteMember(member.getCard_id());
        	LBMS.showAlert(AlertType.INFORMATION, "Delete Successful");	
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_update_clicked(ActionEvent event) throws Exception {
    	try {
			var name = txt_name.getText();
			var roll_no = txt_roll_no.getText();
			var year = cbo_year.getSelectionModel().getSelectedItem();
			var academic_year = txt_academic_year.getText();
			
			member.setName(name);
			member.setRoll_no(Integer.parseInt(roll_no));
			member.setYear(year);
			member.setAcademic_year(academic_year);
			
			DatabaseService.updateMember(member);
			LBMS.showAlert(AlertType.INFORMATION, "Update Sucessful");
			
		} catch (Exception e) {
			throw e;
		}
    }

    @FXML
    void img_search_clicked(MouseEvent event) {
    	var card_id = txt_search_card_id.getText();
    	var name = txt_search_name.getText();
    	
    	member = DatabaseService.searchMember(card_id, name);
    	
    	txt_name.setText(member.getName());
    	txt_roll_no.setText(member.getRoll_no() + "");
    	cbo_year.getSelectionModel().select(member.getYear());
    	txt_academic_year.setText(member.getAcademic_year());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbo_year.setItems(FXCollections.observableArrayList(yearList));
	}

}

