package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.employee;
import com.revature.dao.TuitionDao;

/**
 * Servlet implementation class HLog
 */
public class HLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HLog() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employee em = TuitionDao.HeadcheckUser(request.getParameter("fName"));
		if((em!=null)&&(request.getParameter("pass").equals(em.getPass()))){
			request.setAttribute("currentEm", em);
			HttpSession sess = request.getSession();
			sess.setAttribute("empid", em.getuName());
			sess.setAttribute("fname", em.getfName());
			sess.setAttribute("balance", em.getAmt());
			RequestDispatcher rd = request.getRequestDispatcher("empHome.html");
			rd.forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("Incorrect Login");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}

}
