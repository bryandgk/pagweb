package controller.resources;

import java.io.IOException;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Resources;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class ResourcesControllerDelete extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Resources.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		try{
			Resources us = pm.getObjectById(Resources.class,k);
			if(us!=null){
				Long id = us.getId();
				pm.deletePersistent(us);
				resp.sendRedirect("/resources");
				pm.close();
			}
		}catch (JDOObjectNotFoundException e) {
			resp.sendRedirect("/resources");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/resources");
	}
}
