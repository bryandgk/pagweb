package controller.access;

import java.io.IOException;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Access;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class AccessControllerDelete extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Access.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		try{
			Access us = pm.getObjectById(Access.class,k);
			if(us!=null){
				//Long id = us.getId();
				pm.deletePersistent(us);
				resp.sendRedirect("/access");
				pm.close();
			}
		}catch (JDOObjectNotFoundException e) {
			resp.sendRedirect("/access");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/access");
	}
}
