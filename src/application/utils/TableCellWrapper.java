package application.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import application.dto.ResultTableDto;
import javafx.scene.control.Hyperlink;
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
					setStyle("-fx-padding: 5 5 5 5;");						
					setGraphic(text);
				}
			}
		};
	}
	
	public static TableCell<ResultTableDto, String> wrappingWithHyperLink() {
		return new TableCell<ResultTableDto, String>() {
			
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty) {
					setText(null);
					setStyle("");
				} else {
					try {
						JSONParser parser = new JSONParser();
						JSONObject object = (JSONObject) parser.parse(item);
						
						JSONArray jsonArray = (JSONArray) object.get("retData");
						JSONObject retDataObject = (JSONObject) jsonArray.get(0);
						
						JSONArray imageSetArray = (JSONArray) retDataObject.get("imageSet");

						Hyperlink[] hyperlinks = new Hyperlink[imageSetArray.size()];
						for(int i = 0; i < imageSetArray.size(); i++) {
							Hyperlink hyperlink = new Hyperlink();
//							result += (((JSONObject)imageSetArray.get(i)).get("file_id") + ".png" + "\n");
						}
									
//						result = "[ID] "+ retDataObject.get("EVT_OCR_NO") + "\n" + result;
						
//						hyperlink.setText(item);
//						setGraphic(hyperlink);									
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}

				}
			}
		};
	}
}