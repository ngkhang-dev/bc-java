package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import dto.UserListDTO;
import model.User;

public class UserRepository {
	public User findByEmail(String email) {

		String query = "SELECT * FROM User WHERE email = ? LIMIT 1";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pre = conn.prepareStatement(query);) {
			pre.setString(1, email);
			ResultSet resultSet = pre.executeQuery();

			if (resultSet.next()) {
				return new User(
						resultSet.getInt("id"),
						resultSet.getString("fullName"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("phone"),
						resultSet.getString("country"),
						resultSet.getInt("role_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public User findById(int id) throws SQLException {

		String query = "SELECT * FROM User WHERE id = ?";

		try (Connection conn = DBConnection.getConnection()) {
			if (conn == null) {
				throw new SQLException("Connect to DB failed");
			}

			try (PreparedStatement pre = conn.prepareStatement(query)) {
				pre.setInt(1, id);

				try (ResultSet resultSet = pre.executeQuery()) {
					if (resultSet.next()) {
						return new User(
								resultSet.getInt("id"),
								resultSet.getString("fullName"),
								resultSet.getString("email"),
								resultSet.getString("password"),
								resultSet.getString("phone"),
								resultSet.getString("country"),
								resultSet.getInt("role_id"));
					} else {
						return null;
					}
				}
			}
		}
	}

	public List<UserListDTO> getAll() {
		String query = "SELECT u.id, u.fullName, u.phone, r.role_name FROM User u "
				+ "INNER JOIN Role r ON u.role_id = r.id ORDER BY id DESC";
		List<UserListDTO> users = new ArrayList<UserListDTO>();

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pre = conn.prepareStatement(query)) {
			ResultSet resSet = pre.executeQuery();

			while (resSet.next()) {
				UserListDTO user = new UserListDTO(
						resSet.getInt("id"),
						resSet.getString("email"),
						resSet.getString("fullName"),
						resSet.getString("phone"),
						resSet.getString("role_name"));

				users.add(user);
			}
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

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pre = conn.prepareStatement(query)) {

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

	public List<UserListDTO> userPaging(String keyword, int size, int index) {
		List<UserListDTO> users = new ArrayList<UserListDTO>();

		String query = "SELECT u.id, u.fullName, u.phone, r.role_name FROM User u "
				+ "INNER JOIN Role r ON u.role_id = r.id "
				+ "WHERE u.fullName LIKE ? "
				+ "OR u.email LIKE ? "
				+ "LIMIT ? OFFSET ?";

		try (Connection conn = DBConnection.getConnection()) {

			if (conn == null) {
				throw new SQLException("Connect SQL error");
			}

			try (PreparedStatement pre = conn.prepareStatement(query)) {
				String searchKeyword = "%" + keyword + "%";

				pre.setString(1, searchKeyword);
				pre.setString(2, searchKeyword);
				pre.setInt(3, size);
				pre.setInt(4, size * (index - 1));

				try (ResultSet resSet = pre.executeQuery()) {
					while (resSet.next()) {
						UserListDTO user = new UserListDTO(
								resSet.getInt("id"),
								resSet.getString("email"),
								resSet.getString("fullName"),
								resSet.getString("phone"),
								resSet.getString("role_name"));

						users.add(user);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}

	public int countUser(String keyword) throws SQLException {
		String query = "SELECT COUNT(*) FROM User u "
				+ "INNER JOIN Role r ON u.role_id = r.id "
				+ "WHERE u.fullName LIKE ? "
				+ "OR u.email LIKE ?";

		try (Connection conn = DBConnection.getConnection()) {
			if (conn == null) {
				throw new SQLException("Connect SQL error");
			}

			try (PreparedStatement pre = conn.prepareStatement(query)) {
				String searchKeyword = "%" + keyword + "%";

				pre.setString(1, searchKeyword);
				pre.setString(2, searchKeyword);

				try (ResultSet resSet = pre.executeQuery()) {
					resSet.next();

					return resSet.getInt(1);
				}
			}
		}
	}

	public boolean deleteById(int id) throws SQLException {
		String sql = "DELETE FROM User WHERE id = ?";

		try (Connection conn = DBConnection.getConnection()) {
			if (conn == null) {
				throw new SQLException("Connect to DB failed");
			}

			try (PreparedStatement pre = conn.prepareStatement(sql)) {
				pre.setInt(1, id);

				return pre.executeUpdate() == 1;
			}
		}
	}

	public boolean update(User user) throws SQLException {
		String sql = "UPDATE User SET "
				+ "email=?, fullName=?, phone=?, country=?, role_id=? "
				+ "WHERE id = ?";

		try (Connection conn = DBConnection.getConnection()) {
			if (conn == null) {
				throw new SQLException("Connect to DB failed");
			}

			try (PreparedStatement pre = conn.prepareStatement(sql)) {
				pre.setString(1, user.getEmail());
				pre.setString(2, user.getFullName());
				pre.setString(3, user.getPhone());
				pre.setString(4, user.getCountry());
				pre.setInt(5, user.getRoleId());
				pre.setInt(6, user.getId());

				return pre.executeUpdate() == 1;
			}
		}
	}
}
