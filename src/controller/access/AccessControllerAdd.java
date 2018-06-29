package controller.access;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.entity.Access;
import model.entity.Resources;
import model.entity.Role;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {
	private boolean status = false;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String res = req.getParameter("rol");
		if(res!=null){
			String rol = req.getParameter("rol");
			String resource = req.getParameter("resource");
			status = true;
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Access us = new Access(
					rol , 
					resource , 
					status);
			
			try{
				resp.sendRedirect("/access");
				pm.makePersistent(us);
			}finally {
				pm.close();
			}
		}
		else{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select  from " + Role.class.getName();
			List<Role> roles = (List<Role>) pm.newQuery(query).execute();
	
			String query2 = "select  from "+ Resources.class.getName();
			List<Resources> resource = (List<Resources>) pm.newQuery(query2).execute();
			
			req.setAttribute("resource", resource);
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp").forward(req, resp);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		req.getRequestDispatcher("../WEB-INF/Views/Access/add.jsp").forward(req, resp);
	
		/*PersistenceManager pm = PMF.get().getPersistenceManager();
		String rol = req.getParameter("rol");
		String src = req.getParameter("resource");	
		status= true;
		Access b = new Access(rol,src,status);
		try {
			pm.makePersistent(b);

		} catch (Exception e) {
			e.printStackTrace();
		}		*/
		resp.sendRedirect("/access");
	}
}
