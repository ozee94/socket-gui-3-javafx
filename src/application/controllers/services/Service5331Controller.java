package application.controllers.services;

import java.net.URL;
import java.util.ResourceBundle;

import application.dao.DBConnection;
import application.dao.S5332Dao_Disaster;
import application.dto.DBInfo;
import application.dto.DBResultMessage;
import application.dto.ResultTableDto;
import application.dto.S5332Dto_Disaster;
import application.utils.AlertUtils;
import application.utils.DateUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Service5331Controller implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void temp() {
		System.out.println("call temp");
	}
}