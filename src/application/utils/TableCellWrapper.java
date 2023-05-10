package application.utils;

import application.dto.ResultTableDto;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

public class TableCellWrapper {
	public static TableCell<ResultTableDto, String> wrapping() {
		return new TableCell<ResultTableDto, String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty) {
					setText(null);
					setStyle("");
				} else {
					Text text = new Text(item);
					text.setStyle("-fx-text-alignment:justify;");
					text.wrappingWidthProperty().bind(getTableColumn().widthProperty().subtract(10));
					setGraphic(text);
					setStyle("-fx-padding: 5 5 5 5;");
				}
			}
		};
	}
}