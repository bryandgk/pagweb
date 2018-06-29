package controller.facturas;
import model.entity.Facturar;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmf.entity.PMF;

@SuppressWarnings("serial")

public class BillControllerBill extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select  from " + Facturar.class.getName();
		List<Facturar> listas = (List<Facturar>) pm.newQuery(query).execute();
		req.setAttribute("listas", listas);
		req.getRequestDispatcher("/WEB-INF/Views/Factura/index.jsp").forward(req, resp);
		pm.close();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/WEB-INF/Views/Factura/index.jsp").forward(req, resp);
		
	}


}
