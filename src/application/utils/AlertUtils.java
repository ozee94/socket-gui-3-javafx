package application.utils;

import javafx.scene.control.Alert;

public class AlertUtils {
	private static AlertUtils instance = null;
	private Alert alert = new Alert(Alert.AlertType.INFORMATION);
	
	public static AlertUtils getIntance() {
		if(instance == null) {
			instance = new AlertUtils();
		}
		return instance;
	}
	
	public void show(Alert.AlertType type, String message) {
		alert.setAlertType(type);
		alert.setTitle("");
		alert.setHeaderText(message);
		alert.showAndWait();
	}	
}
