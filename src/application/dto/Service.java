package application.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javafx.scene.control.TreeItem;

public enum Service {
	socket("SOCKET", Arrays.asList("119 긴급출동 지원서비스", "사회적 약자 지원서비스", "112 긴급영상 지원서비스")), 
	db("DB", Arrays.asList("재난 상황관리 - 기상특보", "재난 상황관리 - 지진현황")),
	webService("WEB SERVICE", Arrays.asList("112 긴급출동 지원서비스"));

	String service;
	List<String> category;

	private Service(String service, List<String> category) {
		this.service = service;
		this.category = category;
	}

	public static boolean isService(TreeItem<String> service) {
		return Arrays.stream(Service.values()).anyMatch((i) -> i.getService().equals(service.getValue()));
	}
	
	public static Service getServiceByName(String parent, String child) {
		return Arrays.stream(Service.values()).filter((s) -> s.getService().equals(parent)).filter((s)-> s.getCategory().contains(child)).findFirst().orElse(null);
	}

	public String getService() {
		return this.service;
	}

	public List<String> getCategory() {
		return this.category;
	}
}