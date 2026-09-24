package model;

public class User {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String phone;
	private String country;
	private int roleId;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String fullName, String email, String password, String phone, String country, int roleId) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.country = country;
		this.roleId = roleId;
	}

	public User(int id, String fullName, String email, String password, String phone, String country, int roleId) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.country = country;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFirstName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
