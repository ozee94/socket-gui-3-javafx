package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainController  implements Initializable {

	@FXML
	private PanelViewController panelViewController;
	@FXML 
	private TreeViewController treeViewController;

	public MainController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
		ControllerMediator.getInstance().setPanelViewController(panelViewController);
		ControllerMediator.getInstance().setTreeViewController(treeViewController);
	}
}