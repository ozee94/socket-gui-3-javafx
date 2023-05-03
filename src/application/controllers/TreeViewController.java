package application.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.models.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// 초기화보다 생성자가 우선 호출
public class TreeViewController implements Initializable {

	@FXML
	private TreeView<String> treeView;
	
	private final Node rootIcon = new ImageView(
			new Image(getClass().getResourceAsStream("/resources/images/category.png")));
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TreeItem<String> rootItem = new TreeItem<String>("root");

		for (Service service : Service.values()) {
			TreeItem<String> serviceItem = new TreeItem<String>(service.getService());
			serviceItem.setExpanded(true);

			List<String> tempService = service.getCategory();
			for (int j = 0; j < tempService.size(); j++) {
				TreeItem<String> item = new TreeItem<String>(tempService.get(j));
				serviceItem.getChildren().add(item);
			}

			rootItem.getChildren().add(serviceItem);
		}

		treeView.setRoot(rootItem);
		treeView.setShowRoot(false);

		treeView.getSelectionModel().selectedItemProperty().addListener((observavle, oldValue, newValue) -> {
			if (!Service.isService(newValue)) {
				ControllerMediator.getInstance().getPanelViewController().handlePanel(newValue);
			}
		});
	}
}