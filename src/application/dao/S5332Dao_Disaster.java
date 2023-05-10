package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.dto.DBResultMessage;
import application.dto.services.S5332Dto_ELIKMAEARTHINFM;
import application.dto.services.S5332Dto_ELIKMAINFORM;

public class S5332Dao_Disaster {
	
	public S5332Dao_Disaster() {}
	
	public DBResultMessage<Boolean, String> insertToELI_KMA_EARTH_INFM(S5332Dto_ELIKMAEARTHINFM s5332Dto) {
		int result = 0;
		String message = "";
		
		try {
			DBResultMessage<Connection, String> dbResult = DBConnection.getInstance().getConnection();
			Connection conn = dbResult.getResult();

			if(conn == null) {
				message = dbResult.getMessage();
				return new DBResultMessage<Boolean, String>(false, message);
			}
			
			String sql = "INSERT INTO ELI_KMA_EARTH_INFM VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, s5332Dto.getLk_info_id()); // 연계정보아이디 
			ps.setString(2, s5332Dto.getRcv_ymd_hms()); // 수신일자시각 
			ps.setInt(3, s5332Dto.getSeq_no()); // 연번 
			ps.setString(4, s5332Dto.getOcr_ymdhms()); // 발생시분초 
			ps.setFloat(5, s5332Dto.getPoint_x()); // 좌표X 
			ps.setFloat(6, s5332Dto.getPoint_y()); // 좌표Y 
			ps.setString(7,s5332Dto.getLoc()); // 위치 
			ps.setFloat(8, s5332Dto.getEarth_infm_scle()); // 지진규모(리히터) 
			ps.setString(9, s5332Dto.getEarth_infm_no_ord()); // 지진등급 
			ps.setString(10, s5332Dto.getEarth_infm_no_ref()); // 지진참고번호 
			ps.setString(11, s5332Dto.getEarth_infm_cd_stn()); // 지진지점번호 
			
			result = ps.executeUpdate();
			
			DBConnection.getInstance().disconnect(ps, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[S5332Dao_Disaster.java -> insert] 지진현황 DB 삽입 실패");
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		
		return new DBResultMessage<>(result > 0, message);
	}
	
	public DBResultMessage<Boolean, String> insertToELI_KMA_INFORM(S5332Dto_ELIKMAINFORM s5332Dto) {
		int result = 0;
		String message = "";
		
		try {
			DBResultMessage<Connection, String> dbResult = DBConnection.getInstance().getConnection();
			Connection conn = dbResult.getResult();

			if(conn == null) {
				message = dbResult.getMessage();
				return new DBResultMessage<Boolean, String>(false, message);
			}
			
			String sql = "INSERT INTO ELI_KMA_INFORM VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setString(1, s5332Dto.getLk_info_id()); // 연계정보아이디 
			ps.setString(2, s5332Dto.getRcv_ymd_hms()); // 수신일자시각 
			ps.setInt(3, s5332Dto.getSeq_no()); // 연번 
			ps.setString(4, s5332Dto.getKma_ymdhms()); // KMA발표일시분
			ps.setFloat(5, s5332Dto.getKma_seq_no()); // KMA발표연번 
			ps.setString(6, s5332Dto.getKma_title()); // KMA발표제목 
			ps.setString(7,s5332Dto.getKma_stat_ctnt()); // KMA발표내용 
			ps.setString(8, s5332Dto.getKma_sect_area()); // KMA지역  
			ps.setString(9, s5332Dto.getKma_pw_vl()); // KMA예비특보 
			ps.setString(10, s5332Dto.getKma_cd_stn()); // KMA지점번호  
			
			result = ps.executeUpdate();
			
			DBConnection.getInstance().disconnect(ps, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[S5332Dao_Disaster.java -> insert] 기상특보 DB 삽입 실패");
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		
		return new DBResultMessage<>(result > 0, message);
	}
}