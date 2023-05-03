package application.models;

import java.util.Arrays;
import java.util.List;

import javafx.scene.control.TreeItem;

public enum Service {
	S5331("119 긴급출동 지원서비스", Arrays.asList("11", "21")), 
	S5332("재난 상황관리 지원서비스", Arrays.asList("12", "22")),
	S5333("사회적 약자 지원서비스", Arrays.asList("13", "23")), 
	S5334("112 긴급출동 지원서비스", Arrays.asList("14", "24")),
	S5335("112 긴급영상 지원서비스", Arrays.asList("15", "25"));

	String service;
	List<String> category;

	private Service(String service, List<String> category) {
		this.service = service;
		this.category = category;
	}

	public static boolean isService(TreeItem<String> service) {
		return Arrays.stream(Service.values()).anyMatch((i) -> i.getService().equals(service.getValue()));
	}

	public String getService() {
		return this.service;
	}

	public List<String> getCategory() {
		return this.category;
	}
}