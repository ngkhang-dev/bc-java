package dto;

public class UserListDTO {
	private int id;
	private String email;
	private String fullName;
	private String phone;
	private String roleName;

	public UserListDTO() {

	}

	public UserListDTO(String email, String fullName, String phone, String roleName) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.roleName = roleName;
	}

	public UserListDTO(int id, String email, String fullName, String phone, String roleName) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
