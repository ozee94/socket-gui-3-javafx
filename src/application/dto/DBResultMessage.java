package application.dto;

public class DBResultMessage <R, M> {
	private R result;
	private M message;
	
	public DBResultMessage(R result, M message) {
		this.result = result;
		this.message = message;
	}

	public R getResult() {
		return result;
	}

	public void setResult(R result) {
		this.result = result;
	}

	public M getMessage() {
		return message;
	}

	public void setMessage(M message) {
		this.message = message;
	}
}