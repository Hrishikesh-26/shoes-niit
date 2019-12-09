package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.products;


@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		products products=new products();
		products.setProductid(Integer.parseInt(request.getParameter("productid")));
		products.setName(request.getParameter("name"));
		products.setPrice(Float.parseFloat(request.getParameter("price")));
		products.setCategory(request.getParameter("category"));
		products.setBrand(request.getParameter("brand"));
		products.setSize(Integer.parseInt(request.getParameter("size")));
		products.setColour(request.getParameter("colour"));
		products.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		products.setDescription(request.getParameter("description"));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://35.232.120.71/shoes", "root", "root");
			PreparedStatement ps=con.prepareStatement("update products set name=?,price=?,category=?,brand=?,size=?,colour=?,quantity=?,description=? where productid=?");
			
			
			ps.setString(1, products.getName());
			ps.setFloat(2, products.getPrice());
			ps.setString(3,products.getCategory());
			ps.setString(4, products.getBrand());
			ps.setInt(5, products.getSize());
			ps.setString(6, products.getColour());
			ps.setInt(7, products.getQuantity());
			ps.setString(8, products.getDescription());
			ps.setInt(9, products.getProductid());
			ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			
		}
		
		
	}

}
