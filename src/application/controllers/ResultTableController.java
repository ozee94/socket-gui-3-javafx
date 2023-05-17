package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.dto.ResultTableDto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.utils.TableCellWrapper;


public class ResultTableController implements Initializable {
	
	@FXML private TableView<ResultTableDto> resultTable;
	@FXML private TableColumn<ResultTableDto, String> no;
	@FXML private TableColumn<ResultTableDto, String> createdAt;
	@FXML private TableColumn<ResultTableDto, String> type;
	@FXML private TableColumn<ResultTableDto, String> result;
	@FXML private TableColumn<ResultTableDto, String> sendData;
	@FXML private TableColumn<ResultTableDto, String> errorMessage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		no.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("no"));
		createdAt.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("createdAt"));
		type.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("type"));
		result.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("result"));
		sendData.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("sendData"));
		sendData.setCellFactory(param -> TableCellWrapper.wrapping());
		errorMessage.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("errorMessage"));
		errorMessage.setCellFactory(param -> TableCellWrapper.wrapping());
		
	}
	
	public void addRow(ResultTableDto data) {
		ObservableList<ResultTableDto> tableData = resultTable.getItems();
		tableData.add(data);
		resultTable.setItems(tableData);
		resultTable.refresh();
		resultTable.scrollTo(resultTable.getItems().size() - 1);
	}
	
	public int getTableSize() {
		return resultTable.getItems().size();
	}
}
