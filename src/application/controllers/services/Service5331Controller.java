package application.controllers.services;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.constants.CService;
import application.utils.DateUtils;
import application.utils.SocketClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Service5331Controller implements Initializable {

	@FXML private TextField hostname, port;
	@FXML private TextField transmission_code, receive_code, event_name, secondary_event_name,
			designated_law_code, occurrence_location, longitude, latitude, sender_id;
	@FXML private ComboBox<String> progress_code;

	@FXML
	private Button sendBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress_code.getItems().addAll("10-상황발생", "40-정보변경", "50-해제", "91-종료");
		progress_code.getSelectionModel().select("10-상황발생");
		
		
		sendBtn.setOnAction(e -> this.onSend());
	}

	public void onSend() {
		// 소켓 연결에 필요한 접속 정보 세팅 및 연결
		SocketClient socket = SocketClient.getInstance();
		socket.setSocketInfo(hostname.getText(), Integer.parseInt(port.getText()));
		socket.connect();
		
		if(!socket.isConnected()) {
			System.out.println("[Service5331Controller.java -> onSend()] 연결 실패");
			return ;
		}
			
		
		// send data setting 
		String now = DateUtils.getCurrentTime();
		String body = "T" + now + CService.SEPERATOR + event_name.getText() + CService.SEPERATOR
				+ secondary_event_name.getText() + CService.SEPERATOR + longitude.getText() + CService.SEPERATOR
				+ latitude.getText() + CService.SEPERATOR + occurrence_location.getText() + CService.SEPERATOR
				+ designated_law_code.getText() + CService.SEPERATOR + sender_id.getText() + ";";

		String header = "10" + progress_code.getValue().toString().substring(0, 2) + now + transmission_code.getText() + receive_code.getText() + now + String.format("%010d", body.length() + 48);
		
		try {
			socket.sendData((header + body));
		} catch (IOException e) {
			System.out.println("[Service5331Controller.java -> onSend()] 소켓 데이터 전송 시 실패");
			System.out.println(e.getMessage());
		}
		
	}
}