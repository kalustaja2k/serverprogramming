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
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.Candidates;

@WebServlet(
		name = "EditCandidates",
		urlPatterns = {"/editcandidates"}
		)
public class EditCandidates extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		// Create connection
		HttpSession session = request.getSession();
		String idValue = request.getParameter("ehdokas_id");
		int id = Integer.parseInt(idValue);
		Dao dao = new Dao();
		Candidates candidates = dao.getCandidateInfo(id);
		session.setAttribute("candidate", candidates);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/editcandidates.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		//Create session
				HttpSession session = request.getSession();
				
			
				Dao dao=new Dao();
				Candidates candidates = readCandidates(request);
				
				dao.updateCandidate(candidates);
				
				dao.close();
				response.sendRedirect("/showcandidatesadmin");  // redirect to candidates list
	}
	

	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		candidates.setEtunimi(request.getParameter("etunimi"));
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setPuolue(request.getParameter("puolue"));
		candidates.setKotikunta(request.getParameter("kotipaikkakunta"));
		candidates.setIka(Integer.parseInt(request.getParameter("ika")));
		candidates.setEhdolle(request.getParameter("miksi_eduskuntaan"));
		candidates.setEdistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidates.setAmmatti(request.getParameter("ammatti"));
		
		return candidates;
	}
}
