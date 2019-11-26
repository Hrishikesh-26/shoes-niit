package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.products;

@WebServlet("/AddProductController")
@MultipartConfig(maxFileSize = 999999L)
public class AddProductController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		products products=new products();
		products.setName(req.getParameter("name"));
		products.setCategory(req.getParameter("category"));
		products.setPrice(Float.parseFloat(req.getParameter("price")));
		products.setBrand(req.getParameter("brand"));
		products.setSize(Integer.parseInt(req.getParameter("size")));
		products.setColour(req.getParameter("colour"));
		products.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		products.setDescription(req.getParameter("description"));
		
		Part part=req.getPart("image");
		InputStream is=part.getInputStream();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoes", "root", "hrishi");
			PreparedStatement ps=con.prepareStatement("insert into products (name,category,price,brand,size,colour,quantity,description,image) values(?,?,?,?,?,?,?,?,?);");
			ps.setString(1, products.getName());
			ps.setString(2, products.getCategory());
			ps.setFloat(3, products.getPrice());
			ps.setString(4, products.getBrand());
			ps.setInt(5, products.getSize());
			ps.setString(6, products.getColour());
			ps.setInt(7, products.getQuantity());
			ps.setString(8, products.getDescription());
			ps.setBlob(9, is);
			ps.executeUpdate();
			con.close();
			resp.sendRedirect("index.jsp");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

}
