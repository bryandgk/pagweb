package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.PMF;
import model.entity.Role;
import model.entity.User;

@SuppressWarnings("serial")
public class UserControllerUpdate extends HttpServlet{

	private boolean gender;
	private boolean status = true;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		User user = pm.getObjectById(User.class, k);
		String query = "select  from " + Role.class.getName();
		List<Role> roles = (List<Role>) pm.newQuery(query).execute();
		req.setAttribute("roles", roles);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/Views/Users/update.jsp").forward(req, resp);
		pm.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();	
		Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		User us = pm.getObjectById(User.class, k);

		String rol = req.getParameter("rol");
		String correo = req.getParameter("correo");
		String sexo = req.getParameter("gender");
		if(sexo.equals("masculino"))
			gender = true;
		else
			gender = false;

		us.setEmail(correo);
		us.setRole(rol);
		us.setGender(gender);
		us.setStatus(status);

		resp.sendRedirect("/users");
		pm.close();

	}

}
