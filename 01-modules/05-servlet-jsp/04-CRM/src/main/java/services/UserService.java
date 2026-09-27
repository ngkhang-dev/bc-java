package services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import dto.CreateUserDTO;
import model.User;
import repositories.UserRepository;

public class UserService {
	private final UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public List<User> getAll() {
		List<User> users = userRepository.getAll();

		return users;
	}

	public String create(CreateUserDTO dto) {
		if (dto.getEmail() == null || dto.getEmail().trim().isEmpty() || dto.getPassword() == null
				|| dto.getPassword().trim().isEmpty() || dto.getFullName() == null || dto.getFullName().trim().isEmpty()
				|| dto.getPhone() == null || dto.getPhone().trim().isEmpty()) {
			return "Email, Password, Full name, and Phone is not empty";
		}

		if (userRepository.findByEmail(dto.getEmail()) != null) {
			return "Email is existing";
		}

		String hashPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12));

		User newUser = new User(dto.getEmail().trim(), hashPassword, dto.getFullName(), dto.getPhone(),
				dto.getCountry(), dto.getRoleId());

		return userRepository.create(newUser) ? null : "Create new user faild";
	}
}
