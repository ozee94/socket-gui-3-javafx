package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static DBConnection instance = null;
	
	public DBConnection() {}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gs_service", "oooaaa", "dhwldus1!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[DBConnection.java -> connect] DB 연결 실패");
			e.printStackTrace();
		}
		return conn;
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
