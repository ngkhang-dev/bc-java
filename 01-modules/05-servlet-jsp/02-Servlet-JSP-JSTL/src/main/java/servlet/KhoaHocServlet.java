package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.JDBCConnection;
import models.KhoaHoc;

@WebServlet({ "/khoa-hoc", "/khoa-hoc/add", "/khoa-hoc/edit", "/khoa-hoc/delete" })
public class KhoaHocServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/khoa-hoc": {
			getList(req, resp);
			req.getRequestDispatcher("/khoaHoc/index.jsp").forward(req, resp);
			break;
		}
		case "/khoa-hoc/add": {
			req.getRequestDispatcher("/khoaHoc/add.jsp").forward(req, resp);
			break;
		}
		case "/khoa-hoc/edit": {
			int id = Integer.parseInt(req.getParameter("id"));
			KhoaHoc khoaHoc = null;
			String query = "SELECT * FROM khoa_hoc WHERE id = ?";

			try (Connection conn = JDBCConnection.getConnection();
					PreparedStatement statement = conn.prepareStatement(query);) {

				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					khoaHoc = new KhoaHoc(rs.getInt("id"), rs.getString("tenKH"), rs.getString("code"));
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			req.setAttribute("khoaHoc", khoaHoc);
			req.getRequestDispatcher("/khoaHoc/edit.jsp").forward(req, resp);
			break;
		}
		case "/khoa-hoc/delete": {
			int id = Integer.parseInt(req.getParameter("id"));
			String query = " DELETE FROM khoa_hoc WHERE id = ?";

			try (Connection con = JDBCConnection.getConnection();
					PreparedStatement statement = con.prepareStatement(query)) {
				statement.setInt(1, id);
				statement.executeUpdate();

				resp.sendRedirect(req.getContextPath() + "/khoa-hoc");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/khoa-hoc/add": {
			create(req, resp);
			break;
		}
		case "/khoa-hoc/edit": {
			update(req, resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<KhoaHoc> khoaHocs = new ArrayList<KhoaHoc>();

		String query = "SELECT * FROM khoa_hoc";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);

				ResultSet rs = statement.executeQuery();) {

			while (rs.next()) {
				System.out.println(rs.getString("tenKH"));
				KhoaHoc khoaHoc = new KhoaHoc();

				khoaHoc.setTenKH(rs.getString("tenKH"));
				khoaHoc.setCode(rs.getString("code"));

				khoaHocs.add(khoaHoc);
			}

			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		req.setAttribute("khoaHocs", khoaHocs);
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenKH = req.getParameter("tenKH");
		String code = req.getParameter("code");

		String query = "INSERT INTO khoa_hoc(tenKH, code) VALUES(?, ?)";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, tenKH);
			statement.setString(2, code);

			statement.executeUpdate();

			resp.sendRedirect(req.getContextPath() + "/khoa-hoc");
			req.getRequestDispatcher("/khoaHoc/add.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenKH = req.getParameter("tenKH");
		String code = req.getParameter("code");
		int id = Integer.parseInt(req.getParameter("id"));

		String query = "UPDATE khoa_hoc SET tenKH = ? , code = ? WHERE id = ?";
		try (Connection con = JDBCConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query);) {
			statement.setString(1, tenKH);
			statement.setString(2, code);
			statement.setInt(3, id);

			statement.executeUpdate();
			resp.sendRedirect(req.getContextPath() + "/khoa-hoc");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
