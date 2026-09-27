package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.AuthService;

@WebServlet(name = "Auth", urlPatterns = { "/login", "/logout" })
public class AuthController extends HttpServlet {
	private final AuthService authService;

	public AuthController() {
		authService = new AuthService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession(false);

		switch (path) {
		case "/login": {
//			if (session != null && session.getAttribute("currentUser") != null) {
//				resp.sendRedirect(req.getContextPath() + "/");
//				return;
//			}

			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			break;
		}
		case "/logout": {
			if (session != null && session.getAttribute("currentUser") != null) {
				session.invalidate();
			}

			resp.sendRedirect(req.getContextPath() + "/login");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession(false);

		switch (path) {
		case "/login": {
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			User user = authService.login(email, password);

			if (user == null) {
				req.setAttribute("error", "Email or Password incorrect");

				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
				return;
			}

			// Hide password
			user.setPassword(null);
			session.setAttribute("currentUser", user);
			session.setMaxInactiveInterval(30 * 60);

			resp.sendRedirect(req.getContextPath() + "/");
			break;
		}
		case "/logout": {
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}

	}
}
