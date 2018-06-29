package controller.users;

import java.io.IOException;

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
public class UserControllerView extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm= PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(User.class.getSimpleName(), Long.parseLong(req.getParameter("userId")));
		User us = pm.getObjectById(User.class,k);
		req.setAttribute("user", us);
		req.getRequestDispatcher("/WEB-INF/Views/Users/view.jsp").forward(req, resp);
		pm.close();
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/users");
	}


}
