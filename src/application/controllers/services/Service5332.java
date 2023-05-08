package application.controllers.services;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

import application.dao.S5332Dao_Disaster;
import application.dto.ResultTableDto;
import application.dto.S5332Dto_Disaster;
import application.utils.DateUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Service5332 implements Initializable {

	@FXML
	private TextField lk_info_id, rcv_ymd_hms, seq_no, ocr_ymdhms, point_x, point_y, loc, earth_infm_scle,
			earth_infm_no_ord, earth_infm_ref, earth_infm_cd_stn;
	@FXML
	private Button sendBtn;
	@FXML
	private TableView<ResultTableDto> resultTable;

	S5332Dao_Disaster s5332Dao = new S5332Dao_Disaster();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		rcv_ymd_hms.setText(DateUtils.getCurrentTime());
		ocr_ymdhms.setText(DateUtils.getCurrentTime());

		sendBtn.setOnAction(e -> this.onSend());
	}

	public void onSend() {
		try {
			
			S5332Dto_Disaster data = new S5332Dto_Disaster(lk_info_id.getText(), rcv_ymd_hms.getText(), Integer.parseInt(seq_no.getText()),
					ocr_ymdhms.getText(), Float.parseFloat(point_x.getText()), Float.parseFloat(point_y.getText()), loc.getText(),
					Float.parseFloat(earth_infm_scle.getText()), earth_infm_no_ord.getText(), earth_infm_ref.getText(),
					earth_infm_cd_stn.getText());
			
			boolean result = s5332Dao.insert(data);
			String resultText = result ? "성공" : "실패";

			ObservableList<ResultTableDto> tableData = resultTable.getItems();
			tableData.add(new ResultTableDto(data.getSeq_no(), DateUtils.getCurrentTime(), resultText, data.toString(), "errorMessage"));

			resultTable.setItems(tableData);

			for(ResultTableDto d : tableData) {
				System.out.println(d.getNo());
				System.out.println(d.getCreatedAt());
				System.out.println(d.getResult());
				System.out.println(d.getSendData());
				System.out.println(d.getErrorMessage());
			}
						
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("전송되었습니다.");
			alert.showAndWait();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[Service5332.java -> onSend] error");
			e.printStackTrace();
		}
	}
}