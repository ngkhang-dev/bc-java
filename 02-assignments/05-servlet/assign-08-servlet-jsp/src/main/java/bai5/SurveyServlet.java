package bai5;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String[] soThich = req.getParameterValues("hobby");

		req.setAttribute("tenNguoiDung", (username == null || username.isEmpty()) ? "bạn" : username);
		req.setAttribute("soThich", soThich);

		RequestDispatcher rd = req.getRequestDispatcher("/results/result5.jsp");
		rd.forward(req, resp);
	}
}
