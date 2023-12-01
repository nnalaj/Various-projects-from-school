package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessionBean;
import utils.Redirects;

@WebServlet({"/LogoutControl"})
public class LogoutControl
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  Redirects redirector = new Redirects();

  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    HttpSession session = request.getSession(false);
    if (session == null) {
      redirector.redirectToLogin(response);
    }
    SessionBean beanObject = (SessionBean)session.getAttribute("SessionBean");
    beanObject.clear(beanObject);

    redirector.redirectToLogin(response);
  }

  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}