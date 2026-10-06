package services;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import dto.CreateUserDTO;
import dto.UserListDTO;
import model.User;
import repositories.UserRepository;

public class UserService {
	private final UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public List<UserListDTO> getAll() {
		List<UserListDTO> users = userRepository.getAll();

		return users;
	}

	public User getById(int id) throws SQLException {
		return userRepository.findById(id);
	}

	public String create(CreateUserDTO dto) {
		if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()
				|| dto.getPassword() == null || dto.getPassword().trim().isEmpty()
				|| dto.getFullName() == null || dto.getFullName().trim().isEmpty()
				|| dto.getPhone() == null || dto.getPhone().trim().isEmpty()) {
			return "Email, Password, Full name, and Phone is not empty";
		}

		if (userRepository.findByEmail(dto.getEmail()) != null) {
			return "Email is existing";
		}

		String hashPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12));

		User newUser = new User(
				dto.getEmail().trim(),
				hashPassword,
				dto.getFullName(),
				dto.getPhone(),
				dto.getCountry(),
				dto.getRoleId());

		return userRepository.create(newUser) ? null : "Create new user failed";
	}

	public List<UserListDTO> getUserPaging(String keyword, int size, int index) {
		List<UserListDTO> users = userRepository.userPaging(keyword, size, index);
		return users;
	}

	public int countUser(String keyword) throws SQLException {
		return userRepository.countUser(keyword);
	}

	public String deleteById(int id) throws SQLException {
		try {
			boolean isSuccess = userRepository.deleteById(id);

			return isSuccess ? null : "Not found user";
		} catch (SQLException e) {
			// TODO: handle exception
			return "User is processing task";
		}
	}

	public String update(User user) throws SQLException {
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().trim().isEmpty()
				|| user.getFullName() == null || user.getFullName().trim().isEmpty()
				|| user.getPhone() == null || user.getPhone().trim().isEmpty()) {
			return "Email, Password, Full name, and Phone is not empty";
		}

		if (userRepository.findByEmail(user.getEmail()) != null) {
			return "Email is exiting";
		}

		try {
			boolean isSuccess = userRepository.update(user);

			return isSuccess ? null : "Update failed";
		} catch (SQLException e) {
			// TODO: handle exception
			return "Update failed";
		}
	}
}
