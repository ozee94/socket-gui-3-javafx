package application.controllers.services;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.controllers.ResultTableController;
import application.dao.DBConnection;
import application.dao.S5332Dao_Disaster;
import application.dto.DBInfo;
import application.dto.EventResultMessage;
import application.dto.ResultTableDto;
import application.dto.Service;
import application.dto.ServiceType;
import application.dto.ServiceType.DB;
import application.dto.services.S5332Dto_ELIKMAEARTHINFM;
import application.dto.services.S5332Dto_ELIKMAINFORM;
import application.utils.AlertUtils;
import application.utils.DateUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Service5332Controller implements Initializable {

	@FXML private TextField dbHostname;
	@FXML private TextField dbPort;
	@FXML private TextField dbName;
	@FXML private TextField dbUsername;
	@FXML private PasswordField dbPassword;
	
	@FXML private GridPane earthGridPane;
	@FXML private GridPane rainGridPane;
	
	@FXML private TextField lk_info_id, rcv_ymd_hms, seq_no, ocr_ymdhms, point_x, point_y, loc, earth_infm_scle, earth_infm_no_ord, earth_infm_ref, earth_infm_cd_stn;
	@FXML private TextField lk_info_id2, rcv_ymd_hms2, seq_no2, kma_ymdhms, kma_seq_no, kma_title, kma_stat_ctnt, kma_sect_area, kma_pw_vl, kma_cd_stn;
	
	@FXML private Button sendBtn;
	@FXML private ResultTableController resultTableController;
	
	S5332Dao_Disaster s5332Dao = new S5332Dao_Disaster();
	ServiceType.DB serviceType = DB.ELI_KMA_INFORM;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		earthGridPane.setVisible(false);
		
		rcv_ymd_hms.setText(DateUtils.getCurrentTime());
		ocr_ymdhms.setText(DateUtils.getCurrentTime());
		rcv_ymd_hms2.setText(DateUtils.getCurrentTime());
		kma_ymdhms.setText(DateUtils.getCurrentTime());

		sendBtn.setOnAction(e -> this.onSend());
	}
	
	
	public void changePane(ServiceType.DB serviceType) {
		earthGridPane.setVisible(false);
		rainGridPane.setVisible(false);
		
		this.serviceType = serviceType;

		switch (serviceType) {
			case ELI_KMA_EARTH_INFM:
				earthGridPane.setVisible(true);
				break;
			case ELI_KMA_INFORM:
				rainGridPane.setVisible(true);				
				break;
		}
	}
	
	
	public void onSend() {
		if(dbHostname.getLength() == 0) {
			AlertUtils.getIntance().show(Alert.AlertType.WARNING, "호스트명을 입력해주세요."); return ;
		}

		if(dbPort.getLength() == 0) {
			AlertUtils.getIntance().show(Alert.AlertType.WARNING, "포트번호를 입력해주세요."); return ;
		}

		if(dbName.getLength() == 0) {
			AlertUtils.getIntance().show(Alert.AlertType.WARNING, "데이터베이스명을 입력해주세요."); return ;
		}

		if(dbUsername.getLength() == 0) {
			AlertUtils.getIntance().show(Alert.AlertType.WARNING, "사용자명을 입력해주세요."); return ;
		}
		
		if(dbPassword.getLength() == 0) {
			AlertUtils.getIntance().show(Alert.AlertType.WARNING, "비밀번호를 입력해주세요."); return ;
		}

		try {
			DBConnection.getInstance().setDBInfo(new DBInfo(dbHostname.getText(), dbPort.getText(), dbName.getText(), dbUsername.getText(), dbPassword.getText()));
			String type = "";
			
			if( serviceType == ServiceType.DB.ELI_KMA_EARTH_INFM ) {
				
				type = "지진현황";
				S5332Dto_ELIKMAEARTHINFM data = new S5332Dto_ELIKMAEARTHINFM(lk_info_id.getText(), rcv_ymd_hms.getText(), Integer.parseInt(seq_no.getText()),
						ocr_ymdhms.getText(), Float.parseFloat(point_x.getText()), Float.parseFloat(point_y.getText()), loc.getText(),
						Float.parseFloat(earth_infm_scle.getText()), earth_infm_no_ord.getText(), earth_infm_ref.getText(),
						earth_infm_cd_stn.getText());
				
				EventResultMessage<Boolean, String> result = s5332Dao.insertToELI_KMA_EARTH_INFM(data);
				String resultText = result.getResult() ? "성공" : "실패";

				resultTableController.addRow(new ResultTableDto(Service.db, resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), type, resultText, data.toString(), result.getMessage()));

			} else if ( serviceType == ServiceType.DB.ELI_KMA_INFORM ) {

				type = "기상특보";
				S5332Dto_ELIKMAINFORM data = new S5332Dto_ELIKMAINFORM(lk_info_id2.getText(), rcv_ymd_hms2.getText(), Integer.parseInt(seq_no2.getText()),
						kma_ymdhms.getText(), Float.parseFloat(kma_seq_no.getText()), kma_title.getText(), kma_stat_ctnt.getText(), kma_sect_area.getText(), kma_pw_vl.getText(), kma_cd_stn.getText());
				
				EventResultMessage<Boolean, String> result = s5332Dao.insertToELI_KMA_INFORM(data);
				String resultText = result.getResult() ? "성공" : "실패";

				resultTableController.addRow(new ResultTableDto(Service.db, resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), type, resultText, data.toString(), result.getMessage()));
			
			}

			if (this.serviceType == serviceType.ELI_KMA_EARTH_INFM) {
				lk_info_id.setText((Integer.parseInt(lk_info_id.getText()) + 1) + "");
			} else if (this.serviceType == serviceType.ELI_KMA_INFORM) {
				lk_info_id2.setText((Integer.parseInt(lk_info_id2.getText()) + 1) + "");				
			}
			
			AlertUtils.getIntance().show(Alert.AlertType.INFORMATION, "전송 되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[Service5332.java -> onSend] error");
			e.printStackTrace();
		}
	}
}