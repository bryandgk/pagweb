package controller.facturas;
import model.entity.Facturar;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import pmf.entity.PMF;

@SuppressWarnings("serial")
public class BillControllerUpdate extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Facturar.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Facturar r = pm.getObjectById(Facturar.class, k);
		
		req.setAttribute("facturas", r);
		
		req.getRequestDispatcher("/WEB-INF/Views/Factura/update.jsp").forward(req, resp);
		pm.close();
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Facturar.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Facturar r = pm.getObjectById(Facturar.class, k);
		
		String codigoProd = req.getParameter("codigoProd");
		int cantidad = Integer.parseInt(req.getParameter("cantidad"));
		String descripcion = req.getParameter("descripcion");
		float precioProducto = Float.parseFloat(req.getParameter("precioProducto"));
		float total;
		total = cantidad*precioProducto;
		total = (float) (Math.round(total*10)*0.1);
		
		r.setCodigoPro(codigoProd);
		r.setCantidad(cantidad);
		r.setDescripcion(descripcion);
		r.setPrecioUnidad(precioProducto);
		r.setTotal(total);
		
		resp.sendRedirect("/facturas");
		pm.close();
		
		
	}
		
}
