package schoolmanagement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagement.entity.Principal;

@WebServlet("/saveprinci")
public class SavePrincipal extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	       String id = req.getParameter("id") ;
    	      String  name =  req.getParameter("name") ;
    	     String email =   req.getParameter("email") ;
    	     String password  = req.getParameter("password") ;
    	     
    	     Principal p = new Principal() ;
    	     p.setId(Integer.parseInt(id));
    	     p.setEmail(email);
    	     p.setName(name);
    	     p.setPassword(password);
    	     
    	     EntityManagerFactory emf = Persistence.createEntityManagerFactory("sudarshan") ;
    	     EntityManager em = emf.createEntityManager() ;
    	     EntityTransaction et = em.getTransaction() ;
    	     
    	     et.begin(); 
    	     em.persist(p);
    	     et.commit();
    	     
    	     PrintWriter pw = resp.getWriter() ;
    	     pw.write("account created");
    	     
    	     RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
    	     rd.include(req, resp);
    	     resp.setContentType("text/html");
    }
}