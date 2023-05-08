package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.dto.S5332Dto_Disaster;

public class S5332Dao_Disaster {
	
	public S5332Dao_Disaster() {}
	
	public int insert(S5332Dto_Disaster s5332Dto) {
		int result = 0;
		
		try {
			
			Connection conn = DBConnection.getInstance().getConnection();

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
			System.out.println("[S5332Dao_Disaster.java -> insert] DB 삽입 실패");
		}
		

		return result;
	}
}
