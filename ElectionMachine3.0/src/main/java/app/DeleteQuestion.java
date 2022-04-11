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
import app.Questions;

@WebServlet(
		name = "DeleteQuestion",
		urlPatterns = {"/deletequestion"}
		)
public class DeleteQuestion extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		// if sessions does not exist, create new one
		HttpSession session = request.getSession();

		String idValue = request.getParameter("kysymys_id");

		if (idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);

				Dao dao = new Dao();
				Questions question = dao.getQuestionInfo(id);

				session.setAttribute("question", question);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/deletequestions.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("jsp/deletequestions.jsp");

		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// Create connection
		Dao dao=new Dao();

		try {
			dao.deleteQuestion(Integer.parseInt(request.getParameter("kysymys_id")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		dao.close();

		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/");
		//rd.forward(request, response);
		response.sendRedirect("/showquestionsadmin");
	}
}
