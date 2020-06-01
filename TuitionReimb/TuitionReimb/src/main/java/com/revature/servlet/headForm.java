package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.empForm;
import com.revature.dao.TuitionDao;

/**
 * Servlet implementation class headForm
 */
public class headForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public headForm() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get");
		System.out.println(BLog.userName);
		ObjectMapper mapper = new ObjectMapper();
		TuitionDao td = new TuitionDao();
		int id = mapper.readValue(request.getParameter("formid"), Integer.class);
		System.out.println(id);
		PrintWriter pw = response.getWriter();
		String frJSON;
		try {
			frJSON = mapper.writeValueAsString(td.getFormbyBID(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(frJSON);
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
		TuitionDao td = new TuitionDao();
		try {
			td.insertForm(ef);
			PrintWriter pw = response.getWriter();
			pw.write("Form Added");
			pw.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
