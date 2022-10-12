package com.mmit;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SampleController implements Initializable{
	
	@FXML
    private TextArea area_address;

    @FXML
    private ComboBox<String> cbo_position;

    @FXML
    private CheckBox chk_java;

    @FXML
    private CheckBox chk_js;

    @FXML
    private CheckBox chk_php;

    @FXML
    private ToggleGroup radio_group;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_salary;
    
    private List<String> positionList = List.of("Backend Developer", "UI/UX designer", "Frontend Developer");

    @FXML
    void btn_clear_click(ActionEvent event) {

    }

    @FXML
    void btn_register_click(ActionEvent event) {
    	String name = txt_name.getText();
    	int salary = Integer.parseInt(txt_salary.getText());
    	String pass = txt_password.getText();
    	LocalDate dob = txt_birthday.getValue();
    	String address = area_address.getText();
    	String position = (String)cbo_position.getSelectionModel().getSelectedItem();
    	
    	String skillsets = "";
    	if(chk_java.isSelected()) {
    		skillsets += chk_java.getText() + ",";
    	}
    	
    	if(chk_js.isSelected()) {
    		skillsets += chk_js.getText() + ",";
    	}
    	
    	if(chk_php.isSelected()) {
    		skillsets += chk_php.getText() + ",";
    	}
    	
    	
    	RadioButton rad_gender = (RadioButton)radio_group.getSelectedToggle();
    	
    	String gender = rad_gender.getText();
    	
    	System.out.println("Name: " + name);
    	System.out.println("Salary: " + salary);
    	System.out.println("Position: " + position);
    	System.out.println("Gender: " + gender);
    	System.out.println("skillset: " + skillsets);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cbo_position.setItems(FXCollections.observableArrayList(positionList));
	}
	
	@FXML
    void lbl_login_click(MouseEvent event) throws IOException {
		Main.changeScene("Login.fxml");
    }
	
}
