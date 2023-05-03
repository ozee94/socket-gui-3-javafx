package application.controllers.services;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Service5332 implements Initializable{

	@FXML private TextField lk_info_id, rcv_ymd_hms, seq_no, ocr_ymdhms, loc, point_x, point_y, earth_infm_scle, earth_infm_no_ord, earth_infm_ref, earth_infm_cd_stn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
		String now = format.format(new Date());
		
		rcv_ymd_hms.setText(now);
		ocr_ymdhms.setText(now);
	
	}

}
