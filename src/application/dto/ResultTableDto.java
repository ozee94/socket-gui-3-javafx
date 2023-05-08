package application.dto;

public class ResultTableDto {
	
	int no;
	String createdAt;
	String result;
	String sendData;
	String errorMessage;
	
	public ResultTableDto() {
		
	}
	
	public ResultTableDto(int no, String createdAt, String result, String sendData, String errorMessage) {
		this.no = no;
		this.createdAt = createdAt;
		this.result = result;
		this.sendData = sendData;
		this.errorMessage = errorMessage;
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
