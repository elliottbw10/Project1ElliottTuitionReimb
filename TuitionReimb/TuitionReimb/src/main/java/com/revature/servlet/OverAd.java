package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.TuitionDao;

/**
 * Servlet implementation class OverAd
 */
public class OverAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverAd() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get");
		ObjectMapper mapper = new ObjectMapper();
		TuitionDao td = new TuitionDao();
		String id = request.getParameter("Userid");
		PrintWriter pw = response.getWriter();
		String vgJSON;
		try {
			vgJSON = mapper.writeValueAsString(td.getAmtbyID(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(vgJSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getParameter("formNum");
		String dec = request.getParameter("desType");
		String res = request.getParameter("res");
		String cost = request.getParameter("cost");
		String type =request.getParameter("classType");
		String nameU = request.getParameter("nameU");
		int formNum = Integer.parseInt(form);
		int costy = Integer.parseInt(cost);
		
		if(dec.equals("Approve")) {
			TuitionDao td = new TuitionDao();
			try {
				td.ApproveBen(formNum, costy, type, nameU);
				System.out.println("app");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(dec.equals("Deny")) {
			TuitionDao td = new TuitionDao();
			try {
				td.Deny(formNum,res);
				System.out.println("den");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
