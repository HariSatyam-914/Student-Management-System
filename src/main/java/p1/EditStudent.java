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
import java.sql.ResultSet;


@WebServlet("/editstudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 1. INSERT THE HTML BOILERPLATE AND TAILWIND CDN HERE
		out.println("<html>");
		out.println("<head>");
		out.println("  <title>Modify Student</title>");
		out.println("  <script src='https://cdn.tailwindcss.com'></script>"); // Tailwind Loaded!
		out.println("</head>");
		out.println("<body class='bg-gray-50'>"); // Gives a clean gray background to the entire page
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","harisatyam");
			
			PreparedStatement ps = con.prepareStatement("Select * from StudentDemo where Sid = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
			{
				String name = rs.getString("Sname");
				String email = rs.getString("email");
				String course = rs.getString("course");
				String mobile = rs.getString("mobile");
				
				out.println("<div class='max-w-md mx-auto mt-12 p-8 bg-white rounded-xl shadow-lg border border-gray-100'>");
				out.println("  <h2 class='text-2xl font-bold text-gray-800 mb-6 text-center'>Modify Student Profile</h2>");
				out.println("  <form action='updatestudent' method='POST' class='space-y-5'>");

				// Hidden Key
				out.println("    <input type='hidden' name='sid' value='" + id + "'>");

				// Input Field Groups
				out.println("    <div>");
				out.println("      <label class='block text-xs font-bold text-gray-600 uppercase mb-1'>Full Name</label>");
				out.println("      <input type='text' name='Sname' value='" + name + "' class='w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500'>");
				out.println("    </div>");

				out.println("    <div>");
				out.println("      <label class='block text-xs font-bold text-gray-600 uppercase mb-1'>Email Address</label>");
				out.println("      <input type='email' name='email' value='" + email + "' class='w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500'>");
				out.println("    </div>");

				out.println("    <div>");
				out.println("      <label class='block text-xs font-bold text-gray-600 uppercase mb-1'>Enrolled Course</label>");
				out.println("      <input type='text' name='course' value='" + course + "' class='w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500'>");
				out.println("    </div>");

				out.println("    <div>");
				out.println("      <label class='block text-xs font-bold text-gray-600 uppercase mb-1'>Mobile Number</label>");
				out.println("      <input type='text' name='mobile' value='" + mobile + "' class='w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500'>");
				out.println("    </div>");

				// Buttons Group
				out.println("    <div class='flex items-center justify-between pt-2'>");
				out.println("      <a href='readstudentdata' class='text-sm text-gray-600 hover:text-gray-900 font-medium underline'>Cancel</a>");
				out.println("      <button type='submit' class='bg-indigo-600 text-white px-5 py-2 rounded-md font-semibold text-sm hover:bg-indigo-700 shadow-md transition-all'>Save Changes</button>");
				out.println("    </div>");

				out.println("  </form>");
				out.println("</div>");
			}
			else
			{
				out.println("<h2 class='text-center text-red-500 text-xl font-bold mt-10'>Student not found!!!</h2>");
			}
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// 2. CLOSE THE HTML STRUCTURE TAGS HERE AT THE END
		out.println("</body>");
		out.println("</html>");		
	}

	

}
