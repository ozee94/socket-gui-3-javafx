package application.dto.services;

/**
 * @author oooaaa
 *
 */
public class S5332Dto_ELIKMAINFORM {
	String lk_info_id;
	String rcv_ymd_hms;
	int seq_no;
	String kma_ymdhms;
	float kma_seq_no;
	String kma_title;
	String kma_stat_ctnt;
	String kma_sect_area;
	String kma_pw_vl;
	String kma_cd_stn;
	
	
	public S5332Dto_ELIKMAINFORM() {}
	
	public S5332Dto_ELIKMAINFORM(String lk_info_id, String rcv_ymd_hms, int seq_no, String kma_ymdhms, float kma_seq_no,
			String kma_title, String kma_stat_ctnt, String kma_sect_area, String kma_pw_vl, String kma_cd_stn) {
		this.lk_info_id = lk_info_id;
		this.rcv_ymd_hms = rcv_ymd_hms;
		this.seq_no = seq_no;
		this.kma_ymdhms = kma_ymdhms;
		this.kma_seq_no = kma_seq_no;
		this.kma_title = kma_title;
		this.kma_stat_ctnt = kma_stat_ctnt;
		this.kma_sect_area = kma_sect_area;
		this.kma_pw_vl = kma_pw_vl;
		this.kma_cd_stn = kma_cd_stn;
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
	public String getKma_ymdhms() {
		return kma_ymdhms;
	}
	public void setKma_ymdhms(String kma_ymdhms) {
		this.kma_ymdhms = kma_ymdhms;
	}
	public float getKma_seq_no() {
		return kma_seq_no;
	}
	public void setKma_seq_no(float kma_seq_no) {
		this.kma_seq_no = kma_seq_no;
	}
	public String getKma_title() {
		return kma_title;
	}
	public void setKma_title(String kma_title) {
		this.kma_title = kma_title;
	}
	public String getKma_stat_ctnt() {
		return kma_stat_ctnt;
	}
	public void setKma_stat_ctnt(String kma_stat_ctnt) {
		this.kma_stat_ctnt = kma_stat_ctnt;
	}
	public String getKma_sect_area() {
		return kma_sect_area;
	}
	public void setKma_sect_area(String kma_sect_area) {
		this.kma_sect_area = kma_sect_area;
	}
	public String getKma_pw_vl() {
		return kma_pw_vl;
	}
	public void setKma_pw_vl(String kma_pw_vl) {
		this.kma_pw_vl = kma_pw_vl;
	}
	public String getKma_cd_stn() {
		return kma_cd_stn;
	}
	public void setKma_cd_stn(String kma_cd_stn) {
		this.kma_cd_stn = kma_cd_stn;
	}

	@Override
	public String toString() {
		return "[lk_info_id=" + lk_info_id + ", rcv_ymd_hms=" + rcv_ymd_hms + ", seq_no=" + seq_no
				+ ", kma_ymdhms=" + kma_ymdhms + ", kma_seq_no=" + kma_seq_no + ", kma_title=" + kma_title
				+ ", kma_stat_ctnt=" + kma_stat_ctnt + ", kma_sect_area=" + kma_sect_area + ", kma_pw_vl=" + kma_pw_vl
				+ ", kma_cd_stn=" + kma_cd_stn + "]";
	}	
}
