package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "thoiSu", urlPatterns = "/thoi-su")
public class ThoiSu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Gửi dữ liệu cho jsp
		req.setAttribute("title", "Thời sự hôm nay");
		req.setAttribute("category", "Thời sự");
		req.setAttribute("description", "Cập nhật thông tin thời sự mới nhất");
		req.setAttribute("author", "Nguyễn Khang");
		req.setAttribute("publishDate", "22/09/2026");

		// Gửi yêu cầu cho file thoi-su.jsp
		req.getRequestDispatcher("/thoi-su.jsp").forward(req, resp);
	}

}
