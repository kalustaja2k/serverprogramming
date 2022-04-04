package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		name = "DeleteCandidates",
		urlPatterns = {"/deletecandidate"}
		)
public class DeleteCandidates extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		// if sessions does not exist, create new one
		HttpSession session = request.getSession();

		String idValue = request.getParameter("Ehdokas_id");

		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);

				Dao dao = new Dao();
				Candidates candidate = dao.getCandidateInfo(id);

				session.setAttribute("candidate", candidate);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/deletecandidates.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/admin.jsp");

		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// Create connection
		Dao dao=new Dao();

		try {
			dao.deleteCandidate(Integer.parseInt(request.getParameter("Ehdokas_id")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}

		dao.close();

		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/");
		//rd.forward(request, response);
		response.sendRedirect("/admin.jsp");
	}
}
