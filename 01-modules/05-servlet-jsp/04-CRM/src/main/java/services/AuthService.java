package services;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import repositories.UserRepository;

public class AuthService {
	private final UserRepository userRepository;

	public AuthService() {
		userRepository = new UserRepository();
	}

	public User login(String email, String password) {
		if (email == null || email.trim() == null
				|| password == null || password.trim() == null) {
			return null;
		}

		User user = userRepository.findByEmail(email);
		if (user == null) {
			return null;
		}

		// Version 1:
		// if (!user.getPassword().equals(password)) {
		// return null;
		// }

		// Version 2: Sử dụng Bcrypt
		boolean isCorrectPassword = BCrypt.checkpw(password, user.getPassword());
		if (!isCorrectPassword) {
			return null;
		}

		return user;
	}
}
