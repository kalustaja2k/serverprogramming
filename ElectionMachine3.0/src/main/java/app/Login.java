package app;

import javax.servlet.http.HttpServlet;

import app.User;

import app.dao.Dao;

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(
		name = "Login",
		urlPatterns = {"/login"}
		)
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String email = request.getParameter("email");
	        String password = request.getParameter("salasana");
	         
	        
	        Dao dao = new Dao();
	        try {
	            User user = dao.checkLogin(email, password);
	            String destPage = "/jsp/login.jsp";
	             
	            if (user != null) {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", user);
	                destPage = "addcandidate.jsp"; //this needs to be changed later
	            } else {
	                String message = "Käyttäjätunnus tai salasana väärin";
	                request.setAttribute("message", message);
	            }
	             
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	             
	        } catch (SQLException | ClassNotFoundException ex) {
	            throw new ServletException(ex);
	        }
	    }
}
	
	  
