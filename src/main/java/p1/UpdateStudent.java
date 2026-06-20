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


@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("Sid"));
		String name = request.getParameter("Sname");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String mobile = request.getParameter("mobile");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","harisatyam");
			
			PreparedStatement ps = con.prepareStatement("update StudentDemo set Sname=?,email=?,course=?,mobile=? where Sid = ?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, course);
			ps.setString(4,mobile);
			ps.setInt(5, id);
			
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
