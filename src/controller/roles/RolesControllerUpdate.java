package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import model.entity.Role;
import model.entity.User;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class RolesControllerUpdate extends HttpServlet{
	private boolean status = true;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		com.google.appengine.api.users.User uGoogle =UserServiceFactory.getUserService().getCurrentUser();
		String adminMaestro = "bryan96.sc@gmail.com";
		String error;
		if (uGoogle == null){
			error = "necesita iniciar sesion.";
			req.setAttribute("error", error);
			req.getRequestDispatcher("/WEB-INF/Views/Errors/error5.jsp").forward(req, resp);
		} else {
			if (!uGoogle.getEmail().equals(adminMaestro)){
				String queryUsers = "select from "+User.class.getName()+ " where email== '"+uGoogle.getEmail()+"' && status==true";
				List<User> searchUsers = (List<User>) pm.newQuery(queryUsers).execute();
				
				if(searchUsers.isEmpty()){
					req.getRequestDispatcher("/WEB-INF/Views/Errors/error2.jsp").forward(req, resp);
				} else {
					String  admin_1="Administrador";
					Long idRoleAdmin = searchUsers.get(0).getIdRole();
					String queryAdmin = "select from "+Role.class.getName()+" where roles== '"+admin_1+"' && status==true";
					List<Role> searchAdmin = (List<Role>) pm.newQuery(queryAdmin).execute();
					boolean entradaAdmin = searchAdmin.get(0).getId().equals(idRoleAdmin);
					if(searchAdmin.isEmpty()){
						error = "No se encuentra administrador";
						req.setAttribute("error", error);
						req.getRequestDispatcher("/WEB-INF/Views/Errors/error5.jsp").forward(req, resp);
					} else {
						if(entradaAdmin){
							Role role = pm.getObjectById(Role.class, k);
							req.setAttribute("role", role);
							req.getRequestDispatcher("/WEB-INF/Views/Roles/update.jsp").forward(req, resp);
							pm.close();
						}
						else{
							error = "no tiene accesos de administrador";
							req.setAttribute("error", error);
							req.getRequestDispatcher("/WEB-INF/Views/Errors/error5.jsp").forward(req, resp);
						}
					}
				}
			} else {
				Role role = pm.getObjectById(Role.class, k);
				req.setAttribute("role", role);
				req.getRequestDispatcher("/WEB-INF/Views/Roles/update.jsp").forward(req, resp);
				pm.close();
			}
		}
		
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
