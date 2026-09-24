package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Role;

public class RoleDAO {
	public List<Role> getAll() {
		List<Role> roles = new ArrayList<Role>();

		String sql = "SELECT * FROM Role";

		try (Connection conn = DBConnection.getConnection();

				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				roles.add(new Role(rs.getInt("id"), rs.getString("role_name"), rs.getString("description")));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return roles;
	}
}
