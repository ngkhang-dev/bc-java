package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleDAO;
import model.Role;

@WebServlet(name = "Role", urlPatterns = "/role-table")
public class RoleServlet extends HttpServlet {
	private RoleDAO roleDAO;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		roleDAO = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(false);
//		
//		if (session == null || session.getAttribute("currentUser") == null) {
//			resp.sendRedirect(req.getContextPath() + "/login");
//			return;
//		}
		
		List<Role> roles = roleDAO.getAll();

		req.setAttribute("roles", roles);

		req.getRequestDispatcher("/views/role-table.jsp").forward(req, resp);
	}
}
