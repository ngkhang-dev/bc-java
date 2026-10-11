package bai1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			double a = Double.parseDouble(req.getParameter("a"));
			double b = Double.parseDouble(req.getParameter("b"));
			String op = req.getParameter("op");

			double ketQua;
			if ("-".equals(op)) {
				ketQua = a - b;
			} else {
				op = "+";
				ketQua = a + b;
			}

			req.setAttribute("soA", a);
			req.setAttribute("soB", b);
			req.setAttribute("phepToan", op);
			req.setAttribute("ketQua", ketQua);
			req.setAttribute("loi", false);
		} catch (NumberFormatException | NullPointerException e) {
			req.setAttribute("loi", true);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/results/result1.jsp");
		rd.forward(req, resp);
	}
}
