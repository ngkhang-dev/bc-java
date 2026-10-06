package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDAO;
import dto.CreateUserDTO;
import model.User;
import services.UserService;

@WebServlet(name = "UserController", urlPatterns = { "/user-table", "/user-add", "/user-edit", "/user-delete" })
public class UserController extends HttpServlet {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
			case "/user-table": {
				String keywords = req.getParameter("keywords") != null ? req.getParameter("keywords") : "";
				String pageParam = req.getParameter("page");
				int size = 5;
				int pageIndex = pageParam == null ? 1 : Integer.parseInt(pageParam);

				try {
					int totalRow = userService.countUser(keywords);
					int totalPage = (totalRow + size - 1) / size;

					req.setAttribute("totalPage", totalPage);
					req.setAttribute("page", pageIndex);
					req.setAttribute("users", userService.getUserPaging(keywords, size, pageIndex));

					req.getRequestDispatcher("/views/user-table.jsp").forward(req, resp);
				} catch (SQLException e) {
					throw new ServletException("Not found list user");
				}
				break;
			}
			case "/user-add": {
				req.setAttribute("roles", new RoleDAO().getAll());
				req.getRequestDispatcher("/views/user-add.jsp").forward(req, resp);
				break;
			}
			case "/user-edit": {
				int id;
				try {
					id = Integer.parseInt(req.getParameter("id"));
				} catch (NumberFormatException e) {
					resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

				try {
					User userEdit = userService.getById(id);
					req.setAttribute("userEdit", userEdit);

				} catch (Exception e) {
					return;
				}

				req.setAttribute("roles", new RoleDAO().getAll());
				req.setAttribute("isEdit", true);
				req.getRequestDispatcher("/views/user-add.jsp").forward(req, resp);
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
			case "/user-add": {
				CreateUserDTO dto = new CreateUserDTO(
						req.getParameter("fullName"),
						req.getParameter("email"),
						req.getParameter("password"),
						req.getParameter("phone"),
						req.getParameter("country"),
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
			}
			case "/user-delete": {
				int id;

				try {
					id = Integer.parseInt(req.getParameter("id"));
				} catch (NumberFormatException e) {
					resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

				try {
					String err = userService.deleteById(id);

					if (err == null) {
						resp.sendRedirect(req.getContextPath() + "/user-table?delete=1");
					} else {
						resp.sendRedirect(req.getContextPath() + "/user-table?err=1");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "/user-edit": {
				req.setCharacterEncoding("UTF-8");
				int roleId;
				int id;

				try {
					roleId = Integer.parseInt(req.getParameter("roleId"));
					id = Integer.parseInt(req.getParameter("id"));
				} catch (Exception e) {
					// TODO: handle exception
					req.setAttribute("errors", "RoleId or UserId invalid");
					return;
				}

				User user = new User(
						id,
						req.getParameter("fullName"),
						req.getParameter("email"),
						req.getParameter("password"),
						req.getParameter("phone"),
						req.getParameter("country"),
						roleId);

				try {
					String error = userService.update(user);

					if (error == null) {
						resp.sendRedirect(req.getContextPath() + "user-table");
					} else {
						req.setAttribute("roles", new RoleDAO().getAll());
						req.setAttribute("error", error);
						req.setAttribute("isEdit", true);
						req.setAttribute("userEdit", user);
						req.getRequestDispatcher("/views/user-add.jsp").forward(req, resp);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return;
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
}
