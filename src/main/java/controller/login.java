package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user;

@WebServlet("/login")
public class login extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		PrintWriter pw=resp.getWriter();
		
		user user=new user();
		
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/shoes", "root", "root");
			
			Statement stmt=con.createStatement();
			
			String sql="select * from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				pw.write("welcome");
			}
			else
			{
				pw.write("error");
			}
	        
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		
		
		
		
		
        
	}
}
