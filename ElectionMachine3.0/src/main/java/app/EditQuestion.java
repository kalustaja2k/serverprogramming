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
import app.Questions;

@WebServlet(
		name = "EditQuestion",
		urlPatterns = {"/editquestion"}
		)
public class EditQuestion extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("Kysymys_id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
			
				Dao dao = new Dao();
				Questions question = dao.getQuestionInfo(id);
				
				session.setAttribute("question", question);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editquestions.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("/showquestions.jsp");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		Dao dao=new Dao();
		Questions question = readQuestions(request);
		
		dao.updateQuestions(question);
		
		dao.close();

		response.sendRedirect("/showquestions.jsp"); 
	}
	

	private Question readQuestions(HttpServletRequest request) {
		Question questions =new Question();
		questions.setKysymys_id(Integer.parseInt(request.getParameter("Kysymys_id")));
		questions.setKysymys(request.getParameter("Kysymys"));
		return questions;
	}
}

