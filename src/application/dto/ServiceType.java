package application.dto;

public class ServiceType {
	public enum SOCKET {
		S_119, // 119긴급출동 지원서비스
		S_WEAK, // 사회적약자 지원서비스
		S_112, // 112긴급영상 지원서비스
	}
	public enum DB {
		ELI_KMA_INFORM, // 재난 상황관리 - 기상특보
		ELI_KMA_EARTH_INFM, // 재난 상황관리 - 지진현황		
	}
	
	public enum WEBSERVICE {
		S_112, // 112긴급출동 지원서비스
	}
}