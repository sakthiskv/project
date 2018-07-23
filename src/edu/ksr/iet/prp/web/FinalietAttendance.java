package edu.ksr.iet.prp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.business.IETAttendance;
@WebServlet(name="saveattn",urlPatterns="/sakthi")
public class FinalietAttendance extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	String date=req.getParameter("date");
	System.out.println(date);
	//System.out.println(date.length());
  //  System.out.println(date);
    List<String> studentidlist= new ArrayList<String>();
    IETAttendance attendace = new IETAttendance();
	List<String> s=attendace.Attendance(studentidlist,date);
	for(String id:s)
	{
		out.println("<h1>"+id+"</h1>");
	}
	
}
}
