package application.controllers.services;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import application.constants.CService;
import application.controllers.ResultTableController;
import application.dao.DBConnection;
import application.dao.S5332Dao_Disaster;
import application.dto.DBInfo;
import application.dto.EventResultMessage;
import application.dto.ResultTableDto;
import application.dto.Service;
import application.dto.services.S5332Dto_ELIKMAEARTHINFM;
import application.utils.AlertUtils;
import application.utils.DateUtils;
import application.utils.SocketClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Service5335Controller implements Initializable {

	@FXML private TextField hostname, port;
	@FXML private TextField transmission_code, receive_code, sender_id, case_number,
		occurrence_date, occurrence_location, longitude, latitude, designated_law_code,
		accident_grade, accident_type;

	@FXML private ComboBox<String> progress_code;
	
	@FXML ResultTableController resultTableController;

	@FXML private Button sendBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress_code.getItems().addAll("10-상황발생", "40-정보변경", "50-상황처리", "91-종료");
//		progress_code.getItems().addAll("10-상황발생", "40-정보변경", "91-종료");
		progress_code.getSelectionModel().select("10-상황발생");
		
		occurrence_date.setText(DateUtils.getCurrentTime());
		
		sendBtn.setOnAction(e -> this.onSend());	
	}
	
	public void onSend() {
		// 소켓 연결에 필요한 접속 정보 세팅 및 연결
		SocketClient socket = SocketClient.getInstance();
		socket.setSocketInfo(hostname.getText(), Integer.parseInt(port.getText()));
		EventResultMessage<Socket, String> socketResult = socket.connect();		
		
		if(socketResult.getResult() == null) { 	
			System.out.println("[Service5335Controller.java -> onSend()] 연결 실패");
			resultTableController.addRow(new ResultTableDto(Service.socket, resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "연결", "실패", "", socketResult.getMessage()));
			return ;
		}

		String now = DateUtils.getCurrentTime();
		String body = case_number.getText() + CService.SEPERATOR + accident_grade.getText() + CService.SEPERATOR + accident_type.getText() + CService.SEPERATOR
				+ longitude.getText() + CService.SEPERATOR + latitude.getText() + CService.SEPERATOR
				+ occurrence_location.getText() + CService.SEPERATOR + designated_law_code.getText() + CService.SEPERATOR 
				+ occurrence_date.getText() + CService.SEPERATOR + sender_id.getText() + CService.SEPERATOR + ";";

		String header = "10" + progress_code.getValue().toString().substring(0, 2) + now + transmission_code.getText() + receive_code.getText() + now + String.format("%010d", body.length() + 48);
		String data = (header + body);
		
		System.out.println(data);
		
		try {
			EventResultMessage<Boolean, String> result = socket.sendData(data);
			resultTableController.addRow(new ResultTableDto(Service.socket, resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), progress_code.getValue().toString().substring(progress_code.getValue().toString().length() - 2), result.getResult() ? "성공" : "실패", data, result.getMessage()));
		} catch (IOException e) {
			System.out.println("[Service5335Controller.java -> onSend()] 소켓 데이터 전송 시 실패");
			resultTableController.addRow(new ResultTableDto(Service.socket, resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), progress_code.getValue().toString().substring(progress_code.getValue().toString().length() - 2), "실패", data, e.getMessage()));				
			System.out.println(e.getMessage());
		}	
	}
}