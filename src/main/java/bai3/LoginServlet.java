package bai3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");

		System.out.println(username);
		String password = req.getParameter("password");

		String status = "admin".equals(username) && "123".equals(password) ? "success" : "error";

		req.setAttribute("trangThai", status);
		req.setAttribute("tenDangNhap", username);

		RequestDispatcher rd = req.getRequestDispatcher("/results/result3.jsp");
		rd.forward(req, resp);
	}
}
