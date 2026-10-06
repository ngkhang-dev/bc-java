package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final static String url = "jdbc:mysql://localhost:3307/CRM"
			+ "?useUnicode=true"
			+ "$characterEncoding=UTF-8";
	private final static String username = "root";
	private final static String password = "Root@1234";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
