package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestParam", urlPatterns = "/request-param")
public class RequestParam extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String email = req.getParameter("email");
		
		// GET: /request-param?username=ngkhang&email=ngkhang@gmail.com
		System.out.println(userName + " - " + email);

		PrintWriter print = resp.getWriter();
		print.append("<h1>Request Param Page</h1>");
	}

}
