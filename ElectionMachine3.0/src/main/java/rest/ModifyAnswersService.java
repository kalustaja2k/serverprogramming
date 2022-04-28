package rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.Answers;


@Path("/modifyanswersservice")
public class ModifyAnswersService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("electionmachine3.0"); 
	@GET
	@Path("/readanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answers> readAnswers() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Answers> list=em.createQuery("select a from Answers a").getResultList();		//CHANGE LATER
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
	@PUT
	@Path("/updateanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answers> updateAnswers(Answers answers) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a =em.find(Answers.class, answers.getKysymys_id());
	//	Answers a =em.find(Answers.class, answers.getEhdokas_id()); DOES THIS NEED 2 IF SENTENCES ????????
		if (a!=null) {
			em.merge(answers);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readAnswers() of this service
		List<Answers> list=readAnswers();		
		return list;
	}	
	@DELETE
	@Path("/deleteanswers/{id}")									//WE HAVE 2 ID'S ?????
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answers> deleteAnswers(@PathParam("id") int id) { //WE HAVE 2 ID'S ?????
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a=em.find(Answers.class, id);  					//WE HAVE 2 ID'S ????? 
		if (a!=null) {
			em.remove(a);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readAnswers() of this service
		List<Answers> list=readAnswers();		
		return list;
	}	
	@GET
	@Path("/readtoupdateanswers/{id}")  				//WE HAVE 2 ID'S ?????
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Answers readToUpdateAnswers(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answers a =em.find(Answers.class, id);
		em.getTransaction().commit();
		return a;
	}	
}
