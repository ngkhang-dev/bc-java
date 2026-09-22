package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Container giữa các instance servlet
// Chỉ chạy lại các service, method (doGet,...)

@WebServlet(name = "Life Cycle", urlPatterns = "/life-cycle")
public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		// Chạy 1 lần duy nhất khi Class khởi tạo
		System.out.println("1. Constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Chạy 1 lần duy nhất - để khởi tạo/setup các giá trị
		super.init();
		String servletName = config.getServletName();
		System.out.println("2. init()");
		System.out.println(servletName);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3. service()");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. doGet()");
		resp.getWriter().print("<h1>Life Cycle Servlet</h1>");
	}
	
	@Override
	public void destroy() {
		// Chạy stop/restart tomcat
		System.out.println("5. destroy()");
	}
}
