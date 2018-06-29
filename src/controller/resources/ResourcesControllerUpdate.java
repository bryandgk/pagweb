package controller.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.jdo.JDOFatalUserException;
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

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Resources;

import pmf.entity.PMF;
@SuppressWarnings("serial")
public class ResourcesControllerUpdate extends HttpServlet {
	private boolean status = true;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try{
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/web.xml");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ArrayList<String>resource =reso(fullPath);
		Key k = KeyFactory.createKey(Resources.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Resources res = pm.getObjectById(Resources.class, k);

		req.setAttribute("resource", resource);
		req.setAttribute("res", res);
		req.getRequestDispatcher("/WEB-INF/Views/Resources/update.jsp").forward(req, resp);
		}
		catch (JDOFatalUserException e) {
			resp.sendRedirect("/resources");
			
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Resources.class.getSimpleName(), new Long(req.getParameter("userId")).longValue());
		Resources resource = pm.getObjectById(Resources.class, k);

		String res = req.getParameter("resource");
		
		resource.setName(res);
		resource.setStatus(status);
		
		resp.sendRedirect("/resources");
		pm.close();

	}
	public static ArrayList<String> reso (String fullPath){
		ArrayList<String> resos = new ArrayList<>();
		try {					
			InputStream xd =Thread.currentThread().getContextClassLoader().getResourceAsStream("/WEB-INF/web.xml");
			File fXmlFile = new File(fullPath);			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);				

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("servlet-mapping");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String reso= eElement.getElementsByTagName("url-pattern").item(0).getTextContent();
					System.out.println("Url Pattern : " +reso );
					resos.add(reso);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resos;
	}
}
