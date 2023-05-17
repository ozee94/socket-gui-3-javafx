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

//	@FXML Pane panel5331, panel5332, panel5333, panel5334, panel5335;
	@FXML Pane socketPane, panel5332, panel5334;
	
	@FXML SocketViewController socketViewController;
	
	@FXML Service5331Controller service5331Controller;
	@FXML Service5332Controller service5332Controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ControllerMediator.getInstance().setSocketViewController(socketViewController);

//		panel5331.setVisible(false);
		panel5332.setVisible(false);
//		panel5333.setVisible(false);
		panel5334.setVisible(false);
//		panel5335.setVisible(false);
	}

	public void handlePanel(TreeItem<String> serviceType) {
		if(serviceType == null) return ;
		String parent = serviceType.getParent().getValue();
		String child = serviceType.getValue();
	
		Service service =  Service.getServiceByName(parent, child);
		setPanel(service, child);
	}
	
	public void setPanel(Service service, String serviceType) {
		socketPane.setVisible(false);
		panel5332.setVisible(false); // 재난상황 지원서비스
		panel5334.setVisible(false); // 112긴급출동 지원서비스
		
		switch (service.toString()) {
		case "socket":
			socketPane.setVisible(true);
			if(Service.socket.getCategory().get(0).equals(serviceType)) {
				socketViewController.changePane(ServiceType.SOCKET.S_119);
			} else if (Service.socket.getCategory().get(1).equals(serviceType)) {
				socketViewController.changePane(ServiceType.SOCKET.S_WEAK);
			} else if (Service.socket.getCategory().get(2).equals(serviceType)) {
				socketViewController.changePane(ServiceType.SOCKET.S_112);
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
//			panel5333.setVisible(true);			
			break;
		default:
			break;
		}	
	}
}