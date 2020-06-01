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
import com.revature.beans.empForm;
import com.revature.dao.TuitionDao;


public class EmpForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EmpForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get");
		ObjectMapper mapper = new ObjectMapper();
		TuitionDao td = new TuitionDao();
		int id = mapper.readValue(request.getParameter("formid"), Integer.class);
		PrintWriter pw = response.getWriter();
		String frJSON;
		try {
			frJSON = mapper.writeValueAsString(td.getFormbyID(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(frJSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN post of emp form");
		empForm ef = null;
		ObjectMapper mapper = new ObjectMapper();
		ef = mapper.readValue(request.getInputStream(), empForm.class);
		//System.out.println(ef);
		TuitionDao td = new TuitionDao();
		try {
			td.insertForm(ef);
			PrintWriter pw = response.getWriter();
			pw.write("Form Added");
			pw.close();
//			RequestDispatcher rd = request.getRequestDispatcher("empHome.html");
//			rd.forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
