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
System.out.println("hei");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		//rd.include(request,  response);;
		
		// Read parameters to Model
				Questions question=readQuestions(request);
			
				// Create connection
				Dao dao=new Dao();
				
				// Save value and query total list
				dao.saveQuestion(question);
				ArrayList<Questions> list=dao.readAllQuestions();
				
				// print output and close connection
				//printCandidatesList(out, list);
				dao.close();
		
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addquestion.jsp");
				rd.forward(request, response);
				//out.println("<br><a href='./form.html'>Back to form</a>");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("moi");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/addquestion.jsp");
				rd.forward(request, response);
				//out.println("<br><a href='./form.html'>Back to form</a>");
	}
	
	private Questions readQuestions(HttpServletRequest request) {
		Questions question=new Questions();
		question.setKysymys_id(request.getParameter("kysymys_id"));
		question.setKysymys(request.getParameter("kysymys"));
		return question;
	}
	
}
