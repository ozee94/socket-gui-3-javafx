package application.dto;

public class DBInfo {
	
	String dbHostname;
	String dbPort;
	String dbName;
	String dbUsername;
	String dbPassword;
	
	public DBInfo() {}

	public DBInfo(String dbHostname, String dbPort, String dbName, String dbUsername, String dbPassword) {
		this.dbHostname = dbHostname;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	public String getDbHostname() {
		return dbHostname;
	}


	public void setDbHostname(String dbHostname) {
		this.dbHostname = dbHostname;
	}


	public String getDbPort() {
		return dbPort;
	}


	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}


	public String getDbName() {
		return dbName;
	}


	public void setDbName(String dbName) {
		this.dbName = dbName;
	}


	public String getDbUsername() {
		return dbUsername;
	}


	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}


	public String getDbPassword() {
		return dbPassword;
	}


	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
}