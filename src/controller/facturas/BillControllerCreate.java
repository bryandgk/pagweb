package controller.facturas;
import model.entity.Facturar;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pmf.entity.PMF;


@SuppressWarnings("serial")
public class BillControllerCreate extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String res = req.getParameter("codigoProd");
		if(res!=null){
			String codigoProducto = req.getParameter("codigoProd");
			int cantidad = Integer.parseInt(req.getParameter("cantidad"));
			String descripcion = req.getParameter("descripcion");
			float precioProducto = Float.parseFloat(req.getParameter("precioProducto"));
			float total;
			total = cantidad*precioProducto;
			total = (float) (Math.round(total*10)*0.1);

			PersistenceManager pm = PMF.get().getPersistenceManager();

			Facturar a = new Facturar(
					codigoProducto,
					cantidad,
					descripcion,
					precioProducto,
					total);
			try{
				resp.sendRedirect("/facturas");
				pm.makePersistent(a);
			}
			finally {
				pm.close();
			}
		}
		else{
			req.getRequestDispatcher("/WEB-INF/Views/Factura/create.jsp").forward(req, resp);
		}

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
		req.getRequestDispatcher("/WEB-INF/Views/Factura/create.jsp").forward(req, resp);
	}
}
