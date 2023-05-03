package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.models.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;

public class PanelViewController implements Initializable {

	@FXML Pane panel5331, panel5332, panel5333, panel5334, panel5335;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		panel5331.setVisible(false);
		panel5332.setVisible(false);
		panel5333.setVisible(false);
		panel5334.setVisible(false);
		panel5335.setVisible(false);
	}

	
	public void handlePanel(TreeItem<String> selectedPanel) {
		if(selectedPanel == null) return ;
		String parent = selectedPanel.getParent().getValue();
		String child = selectedPanel.getValue();
	
		Service s =  Service.getServiceByName(parent, child);
		setPanel(s.toString());
	}
	public void setPanel(String serviceType) {
		panel5331.setVisible(false);
		panel5332.setVisible(false);
		panel5333.setVisible(false);
		panel5334.setVisible(false);
		panel5335.setVisible(false);
		
		
		switch (serviceType) {
		case "S5331":
			panel5331.setVisible(true);			
			break;
		case "S5332":
			panel5332.setVisible(true);
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