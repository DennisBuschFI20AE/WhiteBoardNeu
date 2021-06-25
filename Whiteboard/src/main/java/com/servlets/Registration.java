package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.database.Db;
import com.validation.Valid;


@WebServlet("/reg")
public class Registration extends HttpServlet {
	
	private PrintWriter out;
	private Db db;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out = response.getWriter();
		
		if(Login.getSession() == null ) 
		{
			db = new Db();
			String username  = request.getParameter("username");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			System.out.println(password1);
			if(Valid.isPasswordValid(password1) && password1!=null&& password1.equals(password2)) 
			{
				if( db.getUser(username, password1) != null) 
				{
					db.addUser(username, password1);
					out.append("Du hast dich erfolgreich registriert");
				}
			}
			else 
			{
				out.append("Noe");
			}
		}
		else 
		{
			out.append("Du bist bereits registriert!");
		}
	}

}
