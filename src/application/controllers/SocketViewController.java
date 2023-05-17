package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.dto.ResultTableDto;
import application.dto.ServiceType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public class SocketViewController implements Initializable {

	@FXML Pane panel5331, panel5333, panel5335;
	
	@FXML ResultTableController resultTableController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setAllVisible(false);
	}
	
	public void changePane(ServiceType.SOCKET serviceType) {
		setAllVisible(false);
		switch(serviceType) {
			case S_119:
				panel5331.setVisible(true);
				break;
			case S_WEAK:
				panel5333.setVisible(true);
				break;
			case S_112:
				panel5335.setVisible(true);
				break;
		}
	}
	
	public void setAllVisible(boolean visibie) {
		panel5331.setVisible(visibie);
		panel5333.setVisible(visibie);
		panel5335.setVisible(visibie);
	}
	
	public void addRow(ResultTableDto resultTableDto) {
		resultTableDto.setNo(resultTableController.getTableSize()+1);
		resultTableController.addRow(resultTableDto);
	}
}
