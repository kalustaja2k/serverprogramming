package rest;

import javax.servlet.http.HttpServlet;
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

import dao.Dao;
import rest.Candidates;

@WebServlet(
		name = "ShowCandidates",
		urlPatterns = {"/showcandidates"}
		)
public class ShowCandidates extends HttpServlet {
	

	//private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Candidates> candidates = dao.readAllCandidates();
		
		session.setAttribute("allcandidates", candidates);
		
		//direct to show candidates
		RequestDispatcher rd = request.getRequestDispatcher("jsp/showcandidates.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}

}

