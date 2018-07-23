package edu.ksr.iet.prp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="dateformat",urlPatterns="/date")
public class ParticularDate extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter out=resp.getWriter();
		//out.println("hai");
		RequestDispatcher dispatcher=req.getRequestDispatcher("/givedate.html");
		dispatcher.forward(req, resp);
	}

}


