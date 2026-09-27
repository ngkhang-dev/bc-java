package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Role;

@WebServlet(name = "Role", urlPatterns = { "/role", "/role/add" })
public class RoleServlet extends HttpServlet {
	private static List<Role> roles = new ArrayList<Role>();

	static {
		roles.add(new Role(1, "Admin", "Quản trị viên"));
		roles.add(new Role(2, "User", "Người dùng"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/role": {
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/role/index.jsp").forward(req, resp);
			break;
		}
		case "/role/add": {
			req.getRequestDispatcher("/role/add.jsp").forward(req, resp);
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
		case "/role/add": {
			String name = req.getParameter("name");
			String description = req.getParameter("description");

			int id = roles.size() + 1;
			Role newRole = new Role(id, name, description);
			roles.add(newRole);

			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
}
