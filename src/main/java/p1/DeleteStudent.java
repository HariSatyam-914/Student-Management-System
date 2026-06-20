package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("Sid"));
//		
//		try
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","harisatyam");
//			
//			PreparedStatement ps = con.prepareStatement("Delete from StudentDemo where Sid=?");
//			ps.setInt(1, id);
//			
//			ps.executeUpdate();
//			
//			con.close();
//			
//			response.sendRedirect("readstudentdata");
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
		
	}
	// Inside DeleteStudent.java
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int id = Integer.parseInt(request.getParameter("id"));
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","harisatyam");
			
			PreparedStatement ps = con.prepareStatement("Delete from StudentDemo where Sid=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
			response.sendRedirect("readstudentdata");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
