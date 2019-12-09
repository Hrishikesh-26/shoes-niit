package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet 
{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int productid=Integer.parseInt(request.getParameter("productid"));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://35.232.120.71/shoes", "root", "root");
			PreparedStatement ps=con.prepareStatement("delete from products where productid=?");
			ps.setInt(1, productid);
			ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			
		}
		
	}

}
