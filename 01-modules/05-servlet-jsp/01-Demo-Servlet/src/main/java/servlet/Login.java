package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.printf("""
				Username: %s
				Password: %s
				""", username, password);

		// Forward: không thay đổi URL
//		req.setAttribute("username", username);
//		req.getRequestDispatcher("/login-result.jsp").forward(req, resp);
		
		// Redirect: Thay đổi URL
		resp.sendRedirect(req.getContextPath() + "/welcome");
	}
}