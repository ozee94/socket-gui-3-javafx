package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.controllers.services.Service5331Controller;
import application.controllers.services.Service5332Controller;
import application.dto.Service;
import application.dto.ServiceType.S5332;
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
		panel5331.setVisible(false);
//		panel5332.setVisible(false);
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
		panel5331.setVisible(false);
		panel5332.setVisible(false);
		panel5333.setVisible(false);
		panel5334.setVisible(false);
		panel5335.setVisible(false);
		
		switch (service.toString()) {
		case "S5331":
			panel5331.setVisible(true);			
			break;
		case "S5332":
			panel5332.setVisible(true);
			if(Service.S5332.getCategory().get(0).equals(serviceType)) {
				service5332Controller.changePane(S5332.ELI_KMA_INFORM);				
			} else if (Service.S5332.getCategory().get(1).equals(serviceType)) {
				service5332Controller.changePane(S5332.ELI_KMA_EARTH_INFM);
			}
			break;
		case "S5333":
			panel5333.setVisible(true);			
			break;
		case "S5334":
			panel5334.setVisible(true);
			break;
		case "S5335":
			panel5335.setVisible(true);						
			break;
		default:
			break;
		}	
	}
}