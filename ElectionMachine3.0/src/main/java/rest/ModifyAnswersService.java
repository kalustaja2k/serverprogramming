package rest;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import rest.Answers;


@Path("/modifyanswersservice")
public class ModifyAnswersService {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("electionmachine3.0"); 
	@GET
	@Path("/readanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAllAnswers() {
		List<Answers> list= readAnswers();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candidateanswers.jsp");
		request.setAttribute("answerslist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public List<Answers> readAnswers() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Answers> list=em.createQuery("select a from Answers a").getResultList();		
		em.getTransaction().commit();
		return list;
		
	}	
	@POST
	@Path("/addanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answers> addAnswers(Answers answers) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(answers);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readAnswers() of this service
		List<Answers> list=readAnswers();		
		return list;
	}	
	
	@POST
	@Path("/updateanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAnswers(Answers answers) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a =em.find(Answers.class, answers.getEhdokas_id());
		//Answers a =em.find(Answers.class, answers.getKysymys_id()); 
		if (a!=null) {
			em.merge(answers);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readAnswers() of this service
//		List<Answers> list=readAnswers();		
//		return list;
		readAllAnswers();
	}	
	
	
	@GET
	@Path("/deleteanswers/{kysymys_id}")									
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAnswers(@PathParam("kysymys_id") int id) { 
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a=em.find(Answers.class, id);  					
		if (a!=null) {
			em.remove(a);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readAnswers() of this service
		request.setAttribute("answers", a);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/deleteanswer.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@GET
	@Path("/readtoupdateanswers/{kysymys_id}")  				
	@Produces(MediaType.APPLICATION_JSON)
	public void readToUpdateAnswers(@PathParam("kysymys_id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a =em.find(Answers.class, id);
		em.getTransaction().commit();
		
		request.setAttribute("answers", a);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answersupdate.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	}	

