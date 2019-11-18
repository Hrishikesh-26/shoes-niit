package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user;


@WebServlet("/register")
public class register extends HttpServlet
{
      
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		user user=new user();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoes", "root", "root");
	        PreparedStatement ps=con.prepareStatement("insert into user (username,email,password) values (?,?,?);");
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassword());
	        ps.executeUpdate();
	        con.close();
	        resp.sendRedirect("login.jsp");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
    }
}
