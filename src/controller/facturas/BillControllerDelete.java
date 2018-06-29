package controller.facturas;
import model.entity.Facturar;
import java.io.IOException;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.PMF;

public class BillControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Facturar.class.getSimpleName(), new Long(req.getParameter("facturasId")).longValue());
		try{
			Facturar r = pm.getObjectById(Facturar.class, k);
			if (r !=null){
				Long id = r.getId();
				pm.deletePersistent(r);
				//req.getRequestDispatcher("/facturas").forward(req, resp);
				resp.sendRedirect("/facturas");
				pm.close();
			}
		}catch (JDOObjectNotFoundException e) {
			resp.sendRedirect("/facturas");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/facturas");
	}
}
