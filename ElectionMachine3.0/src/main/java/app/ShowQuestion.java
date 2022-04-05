package app;

import java.io.IOException;
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
		name = "ShowQuestions",
		urlPatterns = {"/showquestions"}
		)
public class ShowQuestion extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Questions> questions = dao.readAllQuestions();
		
		session.setAttribute("allquestions", questions);

		RequestDispatcher rd = request.getRequestDispatcher("jsp/showquestions.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}



private Questions readQuestion(HttpServletRequest request) {
	Questions question=new Questions();
	question.setKysymys_id(Integer.parseInt(request.getParameter("Kysymys_id")));
	question.setKysymys(request.getParameter("Kysymys"));

	return question;
}
}
