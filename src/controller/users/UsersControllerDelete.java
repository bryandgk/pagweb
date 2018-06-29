package controller.users;

import java.io.IOException;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.User;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class UsersControllerDelete extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		try{
			User us = pm.getObjectById(User.class,k);
			if(us!=null){
				//Long id = us.getId();
				pm.deletePersistent(us);
				resp.sendRedirect("/users");
				pm.close();
			}
		}catch (JDOObjectNotFoundException e) {
			resp.sendRedirect("/users");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/users");
	}
}
