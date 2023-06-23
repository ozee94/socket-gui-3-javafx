package application.dto;

public class ResultTableDto {
	
	Service serviceType;
	int no;
	String createdAt;
	String type;
	String result;
	String sendData;
	String errorMessage;
	
	public ResultTableDto() {
		
	}
	
	public ResultTableDto(Service serviceType, int no, String createdAt, String type, String result, String sendData, String errorMessage) {
		this.serviceType = serviceType;
		this.no = no;
		this.createdAt = createdAt;
		this.type = type;
		this.result = result;
		this.sendData = sendData;
		this.errorMessage = errorMessage;
	}
	
	public Service getServiceType() {
		return serviceType;
	}

	public void setServiceType(Service serviceType) {
		this.serviceType = serviceType;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSendData() {
		return sendData;
	}

	public void setSendData(String sendData) {
		this.sendData = sendData;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
