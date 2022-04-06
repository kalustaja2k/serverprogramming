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
import app.Questions;

@WebServlet(
		name = "AddQuestion",
		urlPatterns = { "/addquestion" }
		)
public class AddQuestion extends HttpServlet {
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
				Questions question = readQuestions(request);
						
				Dao dao=new Dao();
							
				dao.saveQuestion(question);
				ArrayList<Questions> list=dao.readAllQuestions();
				
				dao.close();
		
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addquestion.jsp");
				rd.forward(request, response);
	
	}
	
	private Questions readQuestions(HttpServletRequest request) {
		Questions question=new Questions();
		question.setKysymys_id(request.getParameter("Kysymys_id"));
		question.setKysymys(request.getParameter("Kysymys"));
		return question;
	}
	
}