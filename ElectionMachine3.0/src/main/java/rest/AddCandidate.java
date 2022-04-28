package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet(
		name = "AddCandidate",
		urlPatterns = { "/addcandidate" }
		)
public class AddCandidate extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		
		// Read parameters to Model
				Candidates candidate=readCandidates(request);
			
				// Create connection
				Dao dao=new Dao();
				
				// Save value and query total list
				dao.saveCandidate(candidate);
				ArrayList<Candidates> list=dao.readAllCandidates();
				
				dao.close(); //close connection
		
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addcandidate.jsp");
				rd.forward(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addcandidate.jsp");
				rd.forward(request, response);
	}
	
	private Candidates readCandidates(HttpServletRequest request) {
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
	
}