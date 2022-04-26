package app;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//The URI "/secretservlet" is needed in the filter class of his example application
@WebServlet(urlPatterns = {"/secretservlet"})
public class SecretServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    response.setContentType("text/plain;utf-8");
    PrintWriter out=response.getWriter();
    out.print("Hello! This is a secret servlet");
  }
}