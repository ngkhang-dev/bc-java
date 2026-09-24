package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<Role> roles = roleDAO.getAll();

		req.setAttribute("roles", roles);
		System.out.println(roles);

		req.getRequestDispatcher("/views/role-table.jsp").forward(req, resp);
	}
}
