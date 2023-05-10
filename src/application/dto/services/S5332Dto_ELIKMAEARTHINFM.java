package application.dto.services;

public class S5332Dto_ELIKMAEARTHINFM {
	String lk_info_id;
	String rcv_ymd_hms;
	int seq_no;
	String ocr_ymdhms;
	float point_x;
	float point_y;
	String loc;
	float earth_infm_scle;
	String earth_infm_no_ord;
	String earth_infm_no_ref;
	String earth_infm_cd_stn;
	
	public S5332Dto_ELIKMAEARTHINFM() {}
	
	public S5332Dto_ELIKMAEARTHINFM(String lk_info_id, String rcv_ymd_hms, int seq_no, String ocr_ymdhms, float point_x,
			float point_y, String loc, float earth_infm_scle, String earth_infm_no_ord, String earth_infm_no_ref,
			String earth_infm_cd_stn) {
		super();
		this.lk_info_id = lk_info_id;
		this.rcv_ymd_hms = rcv_ymd_hms;
		this.seq_no = seq_no;
		this.ocr_ymdhms = ocr_ymdhms;
		this.point_x = point_x;
		this.point_y = point_y;
		this.loc = loc;
		this.earth_infm_scle = earth_infm_scle;
		this.earth_infm_no_ord = earth_infm_no_ord;
		this.earth_infm_no_ref = earth_infm_no_ref;
		this.earth_infm_cd_stn = earth_infm_cd_stn;
	}
	
	public String getLk_info_id() {
		return lk_info_id;
	}
	public void setLk_info_id(String lk_info_id) {
		this.lk_info_id = lk_info_id;
	}
	public String getRcv_ymd_hms() {
		return rcv_ymd_hms;
	}
	public void setRcv_ymd_hms(String rcv_ymd_hms) {
		this.rcv_ymd_hms = rcv_ymd_hms;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public String getOcr_ymdhms() {
		return ocr_ymdhms;
	}
	public void setOcr_ymdhms(String ocr_ymdhms) {
		this.ocr_ymdhms = ocr_ymdhms;
	}
	public float getPoint_x() {
		return point_x;
	}
	public void setPoint_x(float point_x) {
		this.point_x = point_x;
	}
	public float getPoint_y() {
		return point_y;
	}
	public void setPoint_y(float point_y) {
		this.point_y = point_y;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public float getEarth_infm_scle() {
		return earth_infm_scle;
	}
	public void setEarth_infm_scle(float earth_infm_scle) {
		this.earth_infm_scle = earth_infm_scle;
	}
	public String getEarth_infm_no_ord() {
		return earth_infm_no_ord;
	}
	public void setEarth_infm_no_ord(String earth_infm_no_ord) {
		this.earth_infm_no_ord = earth_infm_no_ord;
	}
	public String getEarth_infm_no_ref() {
		return earth_infm_no_ref;
	}
	public void setEarth_infm_no_ref(String earth_infm_no_ref) {
		this.earth_infm_no_ref = earth_infm_no_ref;
	}
	public String getEarth_infm_cd_stn() {
		return earth_infm_cd_stn;
	}
	public void setEarth_infm_cd_stn(String earth_infm_cd_stn) {
		this.earth_infm_cd_stn = earth_infm_cd_stn;
	}

	@Override
	public String toString() {
		return "[lk_info_id=" + lk_info_id + ", rcv_ymd_hms=" + rcv_ymd_hms + ", seq_no=" + seq_no
				+ ", ocr_ymdhms=" + ocr_ymdhms + ", point_x=" + point_x + ", point_y=" + point_y + ", loc=" + loc
				+ ", earth_infm_scle=" + earth_infm_scle + ", earth_infm_no_ord=" + earth_infm_no_ord
				+ ", earth_infm_no_ref=" + earth_infm_no_ref + ", earth_infm_cd_stn=" + earth_infm_cd_stn + "]";
	}
	
}
