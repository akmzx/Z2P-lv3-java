package com.lbms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.LBMS;
import com.lbms.model.DatabaseService;
import com.lbms.model.Member;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberListController implements Initializable {
	
	@FXML
    private TableView<Member> member_table;

    @FXML
    private TableColumn<Member, String> col_academic_year;

    @FXML
    private TableColumn<Member, Integer> col_card_id;

    @FXML
    private TableColumn<Member, LocalDate> col_created_date;

    @FXML
    private TableColumn<Member, LocalDate> col_expired_date;

    @FXML
    private TableColumn<Member, String> col_name;

    @FXML
    private TableColumn<Member, Integer> col_roll_no;

    @FXML
    private TableColumn<Member, String> col_year;

    @FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Member.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_card_id.setCellValueFactory(new PropertyValueFactory<>("card_id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_roll_no.setCellValueFactory(new PropertyValueFactory<>("roll_no"));
		col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
		col_academic_year.setCellValueFactory(new PropertyValueFactory<>("academic_year"));
		col_created_date.setCellValueFactory(new PropertyValueFactory<>("created_date"));
		col_expired_date.setCellValueFactory(new PropertyValueFactory<>("expired_date"));
		
		List<Member> memberList = DatabaseService.findAllMembers();
		
		member_table.setItems(FXCollections.observableArrayList(memberList));
	}

}
