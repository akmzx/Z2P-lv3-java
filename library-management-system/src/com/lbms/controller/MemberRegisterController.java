package com.lbms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.lbms.LBMS;
import com.lbms.model.DatabaseService;
import com.lbms.model.Member;
import com.lbms.model.MyConnection;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MemberRegisterController implements Initializable{

    @FXML
    private ComboBox<String> cbo_year;

    @FXML
    private TextField txt_academic_year;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_roll_no;
    
    private List<String> yearList = List.of("First Year", "Second Year", "Third Year", "Fourth Year");


    @FXML
    void btn_signUp_clicked(ActionEvent event) {
    	try {
			var name = txt_name.getText();
			var roll_no = txt_roll_no.getText();
			var year = (String)cbo_year.getSelectionModel().getSelectedItem();
			var academic_year = txt_academic_year.getText();
			
			if (name.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Name is required");
				return;
			}
			
			if (roll_no.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Roll No is required");
				return;
			}
			
			if (year.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Year is required");
			}
			
			if (academic_year.equals("")) {
				LBMS.showAlert(AlertType.ERROR, "Acedemic Year is required");
				return;
			}
			
			var member = new Member();
			member.setName(name);
			member.setRoll_no(Integer.parseInt(roll_no));
			member.setYear(year);
			member.setAcademic_year(academic_year);
			
			DatabaseService.registerMember(member);
			
			try(var con = MyConnection.createConnection()) {
				var sql = "SELECT * FROM members WHERE name = ? AND roll_no = ?";
				var pstm = con.prepareStatement(sql);
				pstm.setString(1, name);
				pstm.setInt(2, Integer.parseInt(roll_no));
				
				var rs = pstm.executeQuery();
				if (rs.next()) {
					member = new Member();
					member.setCard_id(rs.getInt("card_id"));
					member.setName(rs.getString("name"));
					member.setRoll_no(rs.getInt("roll_no"));
					member.setYear(rs.getString("year"));
					member.setAcademic_year(rs.getString("academic_year"));
					member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
					member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			LBMS.showAlert(AlertType.INFORMATION, "Register Successful\nYour Card ID Number is " + member.getCard_id());
			LBMS.changeView("view/MemberLogin.fxml");
		} catch (Exception e) {
			LBMS.showAlert(AlertType.ERROR, e.getMessage());
		}
    }
    
    @FXML
    void btn_back_clicked(ActionEvent event) throws IOException {
    	LBMS.changeView("view/Member.fxml");
    }
    
    @FXML
    void label_login_clicked(MouseEvent event) throws IOException {
    	LBMS.changeView("view/MemberLogin.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbo_year.setItems(FXCollections.observableArrayList(yearList));
	}

}
