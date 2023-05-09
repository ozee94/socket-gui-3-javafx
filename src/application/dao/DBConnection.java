package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import application.dto.DBInfo;
import application.dto.DBResultMessage;

public class DBConnection {
	
	private static DBConnection instance = null;
	
	private DBInfo dbInfo = null;
	
	public DBConnection() {}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public void setDBInfo(DBInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	public DBResultMessage<Connection, String> getConnection() {
		Connection conn = null;
		String message = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + dbInfo.getDbHostname() + ":" + dbInfo.getDbPort() + "/" + dbInfo.getDbName(), dbInfo.getDbUsername(), dbInfo.getDbPassword());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[DBConnection.java -> connect] DB 연결 실패");
			message = e.getMessage();
		}
		return new DBResultMessage<>(conn, message);
	}
	
	public void disconnect(AutoCloseable... autoCloseables) {
		try {
			for(AutoCloseable ac : autoCloseables)
			if(ac != null) {
				ac.close();
			} else {
				System.out.println("[DBConnection.java -> disconnect] Connection이 할당되지 않았습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB 해제 실패");
			e.printStackTrace();
		}
	}
}	