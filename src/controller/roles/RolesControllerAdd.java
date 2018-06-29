package controller.roles;

import java.io.IOException;


import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Role;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class RolesControllerAdd extends HttpServlet{

	private boolean status = true;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String res = req.getParameter("rol");
		if(res != null){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String rol = req.getParameter("rol");
			Role roles = new Role(rol,status);
			try{
				resp.sendRedirect("/roles");
				pm.makePersistent(roles);
			}finally {
				pm.close();
			}
		}
		else{
			req.getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp").forward(req, resp);
		}
	}

}
