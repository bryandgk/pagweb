package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Role;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class RolesControllerUpdate extends HttpServlet{
	private boolean status = true;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Role role = pm.getObjectById(Role.class, k);
		req.setAttribute("role", role);
		req.getRequestDispatcher("/WEB-INF/Views/Roles/update.jsp").forward(req, resp);
		pm.close();
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Role us = pm.getObjectById(Role.class, k);

		String rol = req.getParameter("rol");
		
		us.setRoles(rol);
		
		us.setStatus(status);

		resp.sendRedirect("/roles");
		pm.close();
	}
}
