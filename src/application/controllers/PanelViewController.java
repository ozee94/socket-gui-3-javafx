package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.controllers.services.Service5331Controller;
import application.controllers.services.Service5332Controller;
import application.dto.Service;
import application.dto.ServiceType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;

public class PanelViewController implements Initializable {

	@FXML Pane panel5331, panel5332, panel5333, panel5334, panel5335;
	@FXML Service5331Controller service5331Controller;
	@FXML Service5332Controller service5332Controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		panel5331.setVisible(false);
		panel5332.setVisible(false);
		panel5333.setVisible(false);
		panel5334.setVisible(false);
		panel5335.setVisible(false);
	}

	
	public void handlePanel(TreeItem<String> serviceType) {
		if(serviceType == null) return ;
		String parent = serviceType.getParent().getValue();
		String child = serviceType.getValue();
	
		Service service =  Service.getServiceByName(parent, child);
		setPanel(service, child);
	}
	
	public void setPanel(Service service, String serviceType) {
		panel5331.setVisible(false); // 119긴급출동 지원서비스
		panel5332.setVisible(false); // 재난상황 지원서비스
		panel5333.setVisible(false); // 사회적약자 지원서비스
		panel5334.setVisible(false); // 112긴급출동 지원서비스
		panel5335.setVisible(false); // 112긴급영상 지원서비스
		
		switch (service.toString()) {
		case "socket":
//			panel5331.setVisible(true);			
			if(Service.socket.getCategory().get(0).equals(serviceType)) {
				panel5331.setVisible(true);
//				service5332Controller.changePane(ServiceType.DB.ELI_KMA_INFORM);				
			} else if (Service.socket.getCategory().get(1).equals(serviceType)) {
				panel5333.setVisible(true);
//				service5332Controller.changePane(ServiceType.DB.ELI_KMA_EARTH_INFM);
			} else if (Service.socket.getCategory().get(2).equals(serviceType)) {
				panel5335.setVisible(true);
//				service5332Controller.changePane(ServiceType.DB.ELI_KMA_EARTH_INFM);
			}
			break;
		case "db":
			panel5332.setVisible(true);
			if(Service.db.getCategory().get(0).equals(serviceType)) {
				service5332Controller.changePane(ServiceType.DB.ELI_KMA_INFORM);				
			} else if (Service.db.getCategory().get(1).equals(serviceType)) {
				service5332Controller.changePane(ServiceType.DB.ELI_KMA_EARTH_INFM);
			}
			break;
		case "webService":
			panel5333.setVisible(true);			
			break;
		default:
			break;
		}	
	}
}