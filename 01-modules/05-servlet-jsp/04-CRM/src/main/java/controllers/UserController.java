package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDAO;
import dto.CreateUserDTO;
import services.UserService;

@WebServlet(name = "UserController", urlPatterns = { "/user-table", "/user-add" })
public class UserController extends HttpServlet {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/user-table":
			req.setAttribute("users", userService.getAll());
			req.getRequestDispatcher("/views/user-table.jsp").forward(req, resp);
			break;
		case "/user-add":
			req.setAttribute("roles", new RoleDAO().getAll());
			req.getRequestDispatcher("/views/user-add.jsp").forward(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/user-add":
			CreateUserDTO dto = new CreateUserDTO(req.getParameter("fullName"), req.getParameter("email"),
					req.getParameter("password"), req.getParameter("phone"), req.getParameter("country"),
					Integer.parseInt(req.getParameter("roleId")));

			String error = userService.create(dto);
			
			if (error == null) {
				req.setAttribute("error", null);
				resp.sendRedirect(req.getContextPath() + "/user-add?created=1");
				return;
			}
			
			req.setAttribute("roles", new RoleDAO().getAll());
			req.setAttribute("error", error);
			req.getRequestDispatcher("/views/user-add.jsp").forward(req, resp);
			return;
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
}
