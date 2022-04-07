package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;

@WebServlet(
		name = "AddCandidate",
		urlPatterns = { "/addcandidate" }
		)
public class AddCandidate extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
System.out.println("hei");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		//rd.include(request,  response);;
		
		// Read parameters to Model
				Candidates candidate=readCandidates(request);
			
				// Create connection
				Dao dao=new Dao();
				
				// Save value and query total list
				dao.saveCandidate(candidate);
				ArrayList<Candidates> list=dao.readAllCandidates();
				
				// print output and close connection
				//printCandidatesList(out, list);
				dao.close();
		
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addcandidate.jsp");
				rd.forward(request, response);
				//out.println("<br><a href='./showcandidatesadmin.jsp'>Takaisin</a>");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("moi");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addcandidate.jsp");
				rd.forward(request, response);
				//out.println("<br><a href='./form.html'>Back to form</a>");
	}
	
	private Candidates readCandidates(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidates candidate=new Candidates();
		candidate.setEhdokas_id(request.getParameter("ehdokas_id"));
		candidate.setSukunimi(request.getParameter("sukunimi"));
		candidate.setEtunimi(request.getParameter("etunimi"));
		candidate.setPuolue(request.getParameter("puolue"));
		candidate.setKotikunta(request.getParameter("kotipaikkakunta"));
		candidate.setIka(request.getParameter("ika"));
		candidate.setEhdolle(request.getParameter("miksi_eduskuntaan"));
		candidate.setEdistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidate.setAmmatti(request.getParameter("ammatti"));
		return candidate;
	}
	
	/*private void printCandidatesList(PrintWriter out, ArrayList<Candidates> list) {
		out.println("<ul>");
		for (Candidates c:list) {
			out.println("<li>"+c);
		}
		out.println("</ul>");
	}*/
}