package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		String name = request.getParameter("sname");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String phone = request.getParameter("mobile");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","harisatyam");
			PreparedStatement pst = con.prepareStatement("insert into StudentDemo(Sname, email, course, mobile) values (?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2, email);
			pst.setString(3, course);
			pst.setString(4, phone);
			
			int x = pst.executeUpdate();
			
			if(x>0)
			{
				out.println("<h1>Successfully Registered!!!</h1>");
			}
			else
			{
				out.println("<h1>Some Techincal Error</h1>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
