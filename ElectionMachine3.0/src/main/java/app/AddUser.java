/*package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;

@WebServlet(
		name = "AddUser",
		urlPatterns = {"/adduser"}
		)
public class AddUser extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.sendRedirect("index.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		Dao dao = new Dao();
		
		String uname = request.getParameter("username");
		String pword = request.getParameter("password");
		
		// create salt and hashed pw
		String salt = Securityutils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(pword, salt);
		
		dao.addUser(uname, hashpw, salt);
		
		dao.close();
		response.sendRedirect("index.html");
	}

}*/
