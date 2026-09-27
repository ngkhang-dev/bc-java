package models;

public class KhoaHoc {
	private int id;
	private String tenKH;
	private String code;

	public KhoaHoc() {
	}

	public KhoaHoc(String tenKH, String code) {
		super();
		this.tenKH = tenKH;
		this.code = code;
	}

	public KhoaHoc(int id, String tenKH, String code) {
		super();
		this.id = id;
		this.tenKH = tenKH;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
