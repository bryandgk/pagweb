package controller.products;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

import model.entity.Access;
import model.entity.Resources;
import pmf.entity.PMF;
@SuppressWarnings("serial")
public class ProductsControllerIndex extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle==null){
			req.getRequestDispatcher("/WEB-INF/Views/Errors/error1.jsp").forward(req, resp);

		}
		else{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select from "+ model.entity.User.class.getName()+
					" where email=='"+uGoogle.getEmail()+"'" +
					" && status==true";
			List<model.entity.User> uSearch = (List<model.entity.User>) pm.newQuery(query).execute();
			if(uSearch.isEmpty()){
				req.getRequestDispatcher("/WEB-INF/Views/Errors/error1.jsp").forward(req, resp);
			}
			else{
				System.out.println(req.getServletPath());
				String query2 = "select from "+Resources.class.getName()+
						" where name=='"+req.getServletPath()+"'"+
						" && status==true";
				List<Resources> rSearch = (List<Resources>) pm.newQuery(query2).execute();
				if(rSearch.isEmpty()){
					req.getRequestDispatcher("/WEB-INF/Views/Errors/error1.jsp").forward(req, resp);
				}
				else{
					String query3 = "select from "+Access.class.getName()+
							" where id=="+uSearch.get(0).getId()+
							" && id=="+rSearch.get(0).getId()+
							" && status==true";
					List<Resources> aSearch = (List<Resources>) pm.newQuery(query3).execute();
					if(aSearch.isEmpty()){
						req.getRequestDispatcher("/WEB-INF/Views/Errors/error1.jsp").forward(req, resp);
					}
					else{
						req.getRequestDispatcher("/WEB-INF/Views/Products/index.jsp").forward(req, resp);
						
					}
				}
			}
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
		
		
}
