package bai4;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String color = req.getParameter("color");
		String bgColor;
		String nhan;
		if (color == null) {
			bgColor = "#ffffff";
			nhan = "Trắng (mặc định)";
		} else {
			switch (color) {
			case "red":
				bgColor = "#e74c3c";
				nhan = "Đỏ";
				break;
			case "blue":
				bgColor = "#3498db";
				nhan = "Xanh";
				break;
			case "green":
				bgColor = "#2ecc71";
				nhan = "Lá";
				break;
			default:
				bgColor = "#ffffff";
				nhan = "Trắng (mặc định)";
				break;
			}
		}

		req.setAttribute("bgColor", bgColor);
		req.setAttribute("nhan", nhan);

		RequestDispatcher rd = req.getRequestDispatcher("/results/result4.jsp");
		rd.forward(req, resp);
	}
}
