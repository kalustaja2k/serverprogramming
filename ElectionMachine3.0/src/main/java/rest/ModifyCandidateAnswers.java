package rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import rest.Answers;

@WebServlet(urlPatterns = {"/addanswers", "/deleteanswers","/updateanswers","/readanswers","/readtoupdateanswers"})
public class ModifyCandidateAnswers extends HttpServlet {

	 @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<Answers> list=null;
	  switch (action) {
	  case "/addanswers":
		  list=addanswers(request);break; 
		  
	  case "/deleteanswers":
		  String id=request.getParameter("id");
		  list=deleteanswers(request);break;
		  
	  case "/updateanswers":
		  list=updateanswers(request);break;
		  
	  case "/readanswers":
		  list=readanswers(request);break;
		  
	  case "/readtoupdateanswers":
		  Answers a =readtoupdateanswers(request);
		  request.setAttribute("answers", a);
		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/answersupdate.jsp"); 
		  rd.forward(request, response);
		  return;
	  }
	  request.setAttribute("answerslist", list);
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/candidateanswers.jsp"); 
	  rd.forward(request, response);
 }

	private Answers readtoupdateanswers(HttpServletRequest request) {
		String ehdokas_id=request.getParameter("ehdokas_id");
		String kysymys_id=request.getParameter("Kysymys_id");
		String uri = "http://localhost:8080/rest/modifyanswersservice/readtoupdateanswers/"+ehdokas_id+kysymys_id; 
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Answers answers=b.get(Answers.class);
		return answers;
	}

	private List<Answers> addanswers(HttpServletRequest request) {
		//An answers object to send to our web-service 
		Answers a =new Answers(request.getParameter("vastaus"), request.getParameter("kommentti")); 
		System.out.println(a);
		String uri = "http://localhost:8080/rest/modifyanswersservice/addanswers"; 
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of an answers object as JSON string format
		Entity<Answers> e=Entity.entity(a,MediaType.APPLICATION_JSON);
		
		//Creating a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
		
		//Posting data (Entity<ArrayList<Answers>> e) to the given address
		List<Answers> returnedList=b.post(e, genericList);
		return returnedList;
	}
	
	private List<Answers> readanswers(HttpServletRequest request) {
		//String kysymys_id=request.getParameter("Kysymys_id");
		//String ehdokas_id=request.getParameter("ehdokas_id");
		String uri = "http://localhost:8080/rest/modifyanswersservice/readanswers"; 
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Creating a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
		
		List<Answers> returnedList=b.get(genericList);
		return returnedList;
	}
	
	private List<Answers> updateanswers(HttpServletRequest request) {
		//An answers object to send to our web-service 
		Answers a =new Answers(request.getParameter("ehdokas_id"),request.getParameter("kysymys_id"),request.getParameter("vastaus"), request.getParameter("kommentti")); 
		System.out.println(a);
		String uri = "http://localhost:8080/rest/modifyanswersservice/updateanswers"; 
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		
		//Here we create an Entity of a Fish object as JSON string format
		Entity<Answers> e=Entity.entity(a,MediaType.APPLICATION_JSON);
		
		//Creating a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
		
		//Posting data (Entity<ArrayList<Answers>> e) to the given address
		List<Answers> returnedList=b.put(e, genericList);
		return returnedList;
	}
	
	private List<Answers> deleteanswers(HttpServletRequest request) {
		String kysymys_id=request.getParameter("ehdokas_id");
		String ehdokas_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/modifyanswersservice/deleteanswers/"+ehdokas_id+kysymys_id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Creating a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
		
		//Posting data (Entity<ArrayList<Answers>> e) to the given address
		List<Answers> returnedList=b.delete(genericList);
		return returnedList;
	}
}
