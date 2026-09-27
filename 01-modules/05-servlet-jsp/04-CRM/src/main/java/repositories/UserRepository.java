package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.User;

public class UserRepository {
	public User findByEmail(String email) {

		String query = "SELECT * FROM User WHERE email = ? LIMIT 1";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pre = conn.prepareStatement(query);) {
			pre.setString(1, email);
			ResultSet resultSet = pre.executeQuery();

			if (resultSet.next()) {
				return new User(resultSet.getInt("id"), resultSet.getString("fullName"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("phone"), resultSet.getString("country"),
						resultSet.getInt("role_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<User> getAll() {
		String query = "SELECT * FROM User ORDER BY id DESC";
		List<User> users = new ArrayList<User>();

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pre = conn.prepareStatement(query)) {
			ResultSet resSet = pre.executeQuery();

			while (resSet.next()) {
				User user = new User(resSet.getInt("id"), resSet.getString("fullName"), resSet.getString("email"),
						resSet.getString("password"), resSet.getString("phone"), resSet.getString("country"),
						resSet.getInt("role_id"));

				users.add(user);
			}

			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	public boolean create(User user) {
		String query = """
				INSERT INTO User (email, password, fullName, phone, country, role_id)
				VALUES (?, ?, ?, ?, ?, ?)
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pre = conn.prepareStatement(query)) {

			pre.setString(1, user.getEmail());
			pre.setString(2, user.getPassword());
			pre.setString(3, user.getFullName());
			pre.setString(4, user.getPhone());
			pre.setString(5, user.getCountry());
			pre.setInt(6, user.getRoleId());

			return pre.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
