package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Đăng ký với Tomcat: khi có request "/hello"
// Tomcat sẽ quét các tất cả anotaion @WebServlet để tìm urlPatterns tương ứng
// "urlPatterns" property không được trùng
@WebServlet(name = "hello", urlPatterns = "/hello")
// Extends HttpServlet để class trở thành Servlet HTTP
public class Demo extends HttpServlet {

	// GET method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter print = resp.getWriter();

		print.append("Demo Servlet");
	}
}
