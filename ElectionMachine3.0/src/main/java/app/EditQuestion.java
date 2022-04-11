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
		
		// Create connection
		HttpSession session = request.getSession();
		String idValue = request.getParameter("kysymys_id");
		int id = Integer.parseInt(idValue);
		Dao dao = new Dao();
		Questions questions = dao.getQuestionInfo(id);
		session.setAttribute("question", questions);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/editquestions.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		//Create session
				HttpSession session = request.getSession();
				
			
				Dao dao=new Dao();
				Questions questions = readQuestions(request);
				
				dao.updateQuestion(questions);
				
				dao.close();
				response.sendRedirect("/showquestionsadmin");  // redirect to questions list
	}
	

	private Questions readQuestions(HttpServletRequest request) {
		Questions questions =new Questions();
		questions.setKysymys_id(Integer.parseInt(request.getParameter("kysymys_id")));
		questions.setKysymys(request.getParameter("kysymys"));
		return questions;
	}
}
