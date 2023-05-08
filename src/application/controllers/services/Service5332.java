package application.controllers.services;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import application.dao.S5332Dao_Disaster;
import application.dto.S5332Dto_Disaster;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Service5332 implements Initializable {

	@FXML
	private TextField lk_info_id, rcv_ymd_hms, seq_no, ocr_ymdhms, point_x, point_y, loc, earth_infm_scle,
			earth_infm_no_ord, earth_infm_ref, earth_infm_cd_stn;
	@FXML
	private Button sendBtn;

	S5332Dao_Disaster s5332Dao = new S5332Dao_Disaster();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
		String now = format.format(new Date());

		rcv_ymd_hms.setText(now);
		ocr_ymdhms.setText(now);

		sendBtn.setOnAction(e -> this.onSend());
	}

	public void onSend() {
		try {
			s5332Dao.insert(new S5332Dto_Disaster(lk_info_id.getText(), rcv_ymd_hms.getText(), Integer.parseInt(seq_no.getText()),
					ocr_ymdhms.getText(), Float.parseFloat(point_x.getText()), Float.parseFloat(point_y.getText()), loc.getText(),
					Float.parseFloat(earth_infm_scle.getText()), earth_infm_no_ord.getText(), earth_infm_ref.getText(),
					earth_infm_cd_stn.getText()));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[Service5332.java -> onSend] error");
			e.printStackTrace();
		}
	}
}