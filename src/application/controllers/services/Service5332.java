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

public class Service5332 implements Initializable {

	@FXML private TextField dbHostname;
	@FXML private TextField dbPort;
	@FXML private TextField dbName;
	@FXML private TextField dbUsername;
	@FXML private PasswordField dbPassword;
	
	@FXML private TextField lk_info_id;
	@FXML private TextField rcv_ymd_hms;
	@FXML private TextField seq_no, ocr_ymdhms;
	@FXML private TextField point_x;
	@FXML private TextField point_y;
	@FXML private TextField loc;
	@FXML private TextField earth_infm_scle;
	@FXML private TextField earth_infm_no_ord;
	@FXML private TextField earth_infm_ref;
	@FXML private TextField earth_infm_cd_stn;

	@FXML private Button sendBtn;
	
	@FXML private TableView<ResultTableDto> resultTable;
	@FXML private TableColumn<ResultTableDto, String> no;
	@FXML private TableColumn<ResultTableDto, String> createdAt;
	@FXML private TableColumn<ResultTableDto, String> result;
	@FXML private TableColumn<ResultTableDto, String> sendData;
	@FXML private TableColumn<ResultTableDto, String> errorMessage;
	

	S5332Dao_Disaster s5332Dao = new S5332Dao_Disaster();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		no.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("no"));
		createdAt.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("createdAt"));
		result.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("result"));
		sendData.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("sendData"));
		errorMessage.setCellValueFactory(new PropertyValueFactory<ResultTableDto, String>("errorMessage"));
		
		rcv_ymd_hms.setText(DateUtils.getCurrentTime());
		ocr_ymdhms.setText(DateUtils.getCurrentTime());

		sendBtn.setOnAction(e -> this.onSend());
	}

	public void onSend() {
		try {
			DBConnection.getInstance().setDBInfo(new DBInfo(dbHostname.getText(), dbPort.getText(), dbName.getText(), dbUsername.getText(), dbPassword.getText()));
			
			S5332Dto_Disaster data = new S5332Dto_Disaster(lk_info_id.getText(), rcv_ymd_hms.getText(), Integer.parseInt(seq_no.getText()),
					ocr_ymdhms.getText(), Float.parseFloat(point_x.getText()), Float.parseFloat(point_y.getText()), loc.getText(),
					Float.parseFloat(earth_infm_scle.getText()), earth_infm_no_ord.getText(), earth_infm_ref.getText(),
					earth_infm_cd_stn.getText());
			
			DBResultMessage<Boolean, String> result = s5332Dao.insert(data);
			String resultText = result.getResult() ? "성공" : "실패";

			ObservableList<ResultTableDto> tableData = resultTable.getItems();
			tableData.add(new ResultTableDto(tableData.size()+1, DateUtils.getCurrentTime(), resultText, data.toString(), result.getMessage()));

			resultTable.setItems(tableData);
					
			AlertUtils.getIntance().show(Alert.AlertType.INFORMATION, "전송 되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[Service5332.java -> onSend] error");
			e.printStackTrace();
		}
	}
}