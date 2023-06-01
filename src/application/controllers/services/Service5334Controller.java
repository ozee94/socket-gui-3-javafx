package application.controllers.services;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import application.controllers.ResultTableController;
import application.dto.EventResultMessage;
import application.dto.ResultTableDto;
import application.utils.DateUtils;
import application.utils.HttpConnector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Service5334Controller implements Initializable {
		
	private final String URL = "http://10.0.100.138:5334";
	private final String uid = "MTEy6ri06riJ7KeA7JuQ7ISc67mE7Iqk7JmA7J2065Oc7YGQ67iM";
	private String retYmdHms = "";
	private String sendData = "";
	
	@FXML List<TextField> fileNmList;
	@FXML TextField fileID;
	@FXML Button sendBtn;

	@FXML ResultTableController resultTableController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sendBtn.setOnAction(e -> this.onSend());
	}
	
	public void onSend() {
		if(!setFileId()) return ;
		if(!getSituationList()) return ;
		if(!setReceptPrcsOk()) return ;
		if(!setRecvNo()) return ;
	}
	
	public boolean setFileId() {
		boolean result = true;
		try {
			for (TextField fileNm : fileNmList) {
				if(fileNm.getText().length() != 0) {
					URI uri = new URIBuilder(URL + "/setFileId.json")
							.addParameter("callback", "jsonCallback")
							.addParameter("fileId", fileID.getText())
							.addParameter("fileNm", fileNm.getText())
							.build();
					
					EventResultMessage<CloseableHttpResponse, String> sendResult = HttpConnector.getInstance().send(uri);
					CloseableHttpResponse res = sendResult.getResult();
					if(res != null) {
						String json = EntityUtils.toString(res.getEntity(), "UTF-8");
						
						if(res.getStatusLine().getStatusCode() != 200) {
							result = false;
							resultTableController.addRow(new ResultTableDto(
									resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "setFileId", "실패-"+res.getStatusLine().getStatusCode(), "", json));
						}
						System.out.println("[setFileId] " + json);
						res.close();	
					} else {
						resultTableController.addRow(new ResultTableDto(
								resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "setFileId", "실패", "", sendResult.getMessage()));						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean getSituationList() {
		boolean result = true;
		retYmdHms = "";
		sendData = "";
		try {
			URI uri = new URIBuilder(URL + "/getSituationList.json")
					.addParameter("uid", uid)
					.build();	
			
			EventResultMessage<CloseableHttpResponse, String> sendResult = HttpConnector.getInstance().send(uri);
			CloseableHttpResponse res = sendResult.getResult();
			
			if(res != null) {
				String json = EntityUtils.toString(res.getEntity(), "UTF-8");
				
				if(res.getStatusLine().getStatusCode() != 200) {
					result = false;
					resultTableController.addRow(new ResultTableDto(
							resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "setRecvNo", "실패-"+res.getStatusLine().getStatusCode(), "", json));
				}
				
				System.out.println("[setRecvNo] " + json);
				sendData = json;
				
				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(json);
				
				retYmdHms = object.get("retYmdHms").toString();
				
				res.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	public boolean setReceptPrcsOk() {
		boolean result = true;

		try {
			URI uri = new URIBuilder(URL + "/setReceptPrcsOk.json")
					.addParameter("uuid", uid)
					.addParameter("retYmdHms", retYmdHms)
					.build();	
			
			EventResultMessage<CloseableHttpResponse, String> sendResult = HttpConnector.getInstance().send(uri);
			CloseableHttpResponse res = sendResult.getResult();
			
			if(res != null) {
				String json = EntityUtils.toString(res.getEntity(), "UTF-8");
				
				if(res.getStatusLine().getStatusCode() != 200) {
					result = false;
					resultTableController.addRow(new ResultTableDto(
							resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "setReceptPrcsOk", "실패-"+res.getStatusLine().getStatusCode(), "", json));
				}
								
				System.out.println("[setReceptPrcsOk] " + json);

				res.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	public boolean setRecvNo() {
		boolean result = true;

		try {
			URI uri = new URIBuilder(URL + "/setRecvNo.json")
					.addParameter("creNo", fileID.getText())
					.addParameter("recvNo", "T"+DateUtils.getCurrentTime())
					.addParameter("recvYmdHms", DateUtils.getCurrentTime())
					.build();	
			
			EventResultMessage<CloseableHttpResponse, String> sendResult = HttpConnector.getInstance().send(uri);
			CloseableHttpResponse res = sendResult.getResult();
			
			if(res != null) {
				String json = EntityUtils.toString(res.getEntity(), "UTF-8");
				
				if(res.getStatusLine().getStatusCode() != 200) {
					result = false;
					resultTableController.addRow(new ResultTableDto(
							resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "setReceptPrcsOk", "실패-"+res.getStatusLine().getStatusCode(), "", json));
				}
								
				resultTableController.addRow(new ResultTableDto(
						resultTableController.getTableSize()+1, DateUtils.getCurrentTime(), "수집", "성공-"+res.getStatusLine().getStatusCode(), "", json));

				System.out.println("[setReceptPrcsOk] " + json);

				res.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
}