package bai2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String loiChao = (name == null || name.trim().isEmpty()) ? "Xin chào bạn!" : "Xin chào, " + name + "!";

		req.setAttribute("loiChao", loiChao);

		RequestDispatcher rd = req.getRequestDispatcher("/results/result2.jsp");
		rd.forward(req, resp);
	}
}
