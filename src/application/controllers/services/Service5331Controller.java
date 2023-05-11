package application.controllers.services;

import java.net.URL;
import java.util.ResourceBundle;

import application.constants.CService;
import application.utils.DateUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Service5331Controller implements Initializable {

	@FXML
	private TextField transmission_code, receive_code, event_name, secondary_event_name,
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
		String now = DateUtils.getCurrentTime();
		String body = "T" + now + CService.SEPERATOR + event_name.getText() + CService.SEPERATOR
				+ secondary_event_name.getText() + CService.SEPERATOR + longitude.getText() + CService.SEPERATOR
				+ latitude.getText() + CService.SEPERATOR + occurrence_location.getText() + CService.SEPERATOR
				+ designated_law_code.getText() + CService.SEPERATOR + sender_id.getText() + ";";

		String header = "10" + progress_code.getValue().toString().substring(0, 2) + now + transmission_code.getText() + receive_code.getText() + now + String.format("%010d", body.length() + 48);
		
		/* 
		 * 10 10 2023 05 11 11 34 38 = 14 119 UCP 2023 05 11 11 34 38 0000000173
		 * T20230511113438 구조 교통사고_수정 127.0998121 37.4157335 경기도 성남시 수정구 대왕판교로 825
		 * 한국국제협력단 4113111500 2023 05 11 11 34 38 user119 ;
		 */
	}
}