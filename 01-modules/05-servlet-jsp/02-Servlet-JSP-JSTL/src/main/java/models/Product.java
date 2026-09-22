package models;

public class Product {
	private int id;
	private String ten;
	private double gia;
	private String hinhAnh;

	public Product() {
	}

	public Product(int id, String ten, double gia, String hinhAnh) {
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
}
