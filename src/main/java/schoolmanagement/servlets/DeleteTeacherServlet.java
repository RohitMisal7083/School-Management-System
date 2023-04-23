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

import schoolmanagement.entity.Student;
import schoolmanagement.entity.Teacher;

@WebServlet("/removeteacher")
public class DeleteTeacherServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sudarshan");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t = em.find(Teacher.class, id);
		
		if(t!=null)
		{
			et.begin();
			em.remove(t);
			et.commit();
			
			
		     PrintWriter pw = resp.getWriter() ;
		     pw.write("Deleted Successfully") ;
		     
		     RequestDispatcher rd = req.getRequestDispatcher("teachermenu.html");
		     rd.include(req, resp) ;
		     resp.setContentType("text/html");
			
		}
		else
		{
			
		     PrintWriter pw = resp.getWriter() ;
		     pw.write("Id not found") ;
		     
		     RequestDispatcher rd = req.getRequestDispatcher("teachermenu.html");
		     rd.include(req, resp) ;
		     resp.setContentType("text/html");
		}
	}
}
