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
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

import model.user;

@WebServlet("/login")
public class login extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		user user=new user();
		
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://35.232.120.71/shoes", "root", "root");
			PreparedStatement ps=con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();
			
			HttpSession hs=req.getSession();
			if(rs.next())
			{
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				hs.setAttribute("user", user);
				resp.sendRedirect("addproduct.jsp");
			}
			
	        
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		
		
		
		
		
        
	}
}
