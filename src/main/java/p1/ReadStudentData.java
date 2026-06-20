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
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/readstudentdata")
public class ReadStudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<script src='https://cdn.tailwindcss.com'></script>"); 
	    out.println("<title>Student Management</title>");
	    out.println("</head>");
	    out.println("<body class='bg-gray-50'>"); // Added a global light background tone
	    
	    // --- POINT 3: INSERT THE NAVIGATION BUTTON PORTAL HERE ---
	    out.println("<div class='max-w-6xl mx-auto mt-6 px-6'>");
	    out.println("  <a href='index.html' class='inline-flex items-center bg-white text-gray-700 border border-gray-200 px-4 py-2 rounded-lg text-sm font-semibold hover:bg-gray-50 hover:text-indigo-600 transition-all shadow-sm'>");
	    out.println("    ← Back to Home");
	    out.println("  </a>");
	    out.println("</div>");
	    // ---------------------------------------------------------
	        
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "harisatyam");
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from StudentDemo");
	        
	        // The table layout starts right after your navigation bar
	        out.println("<div class='max-w-6xl mx-auto mt-4 p-6 bg-white rounded-lg shadow-md border border-gray-100'>");
	        out.println("  <h1 class='text-3xl font-bold text-gray-800 mb-6 text-center'>Student Directory</h1>");
	        out.println("  <div class='overflow-x-auto'>");
	        out.println("    <table class='min-w-full bg-white border border-gray-200 rounded-lg'>");
	        out.println("      <thead>");
	        out.println("        <tr class='bg-gray-100 border-b border-gray-200 text-left text-gray-600 text-sm uppercase font-semibold'>");
	        out.println("          <th class='py-3 px-4'>ID</th>");
	        out.println("          <th class='py-3 px-4'>Name</th>");
	        out.println("          <th class='py-3 px-4'>Email</th>");
	        out.println("          <th class='py-3 px-4'>Course</th>");
	        out.println("          <th class='py-3 px-4'>Phone No</th>");
	        out.println("          <th class='py-3 px-4 text-center'>Actions</th>");
	        out.println("        </tr>");
	        out.println("      </thead>");
	        out.println("      <tbody class='text-gray-700 text-sm'>");
	        
	        while(rs.next()) {
	            int id = rs.getInt("sid"); 
	            String name = rs.getString("sname");
	            String email = rs.getString("email");
	            String course = rs.getString("course");
	            String phone = rs.getString("mobile");
	            
	            out.println("<tr class='border-b border-gray-200 hover:bg-gray-50 transition-colors'>");
	            out.println("  <td class='py-3 px-4'>" + id + "</td>");
	            out.println("  <td class='py-3 px-4 font-medium text-gray-900'>" + name + "</td>");
	            out.println("  <td class='py-3 px-4'>" + email + "</td>");
	            out.println("  <td class='py-3 px-4'><span class='bg-blue-100 text-blue-800 text-xs px-2 py-1 rounded font-semibold'>" + course + "</span></td>");
	            out.println("  <td class='py-3 px-4'>" + phone + "</td>");

	            out.println("  <td class='py-3 px-4 text-center space-x-2'>");
	            out.println("    <a href='editstudent?id=" + id + "' class='inline-block bg-indigo-600 text-white px-3 py-1.5 rounded text-xs font-semibold hover:bg-indigo-700 transition-colors shadow-sm'>Edit</a>");
	            out.println("    <a href='deletestudent?id=" + id + "' onclick='return confirm(\"Are you sure?\");' class='inline-block bg-red-500 text-white px-3 py-1.5 rounded text-xs font-semibold hover:bg-red-600 transition-colors shadow-sm'>Delete</a>");
	            out.println("  </td>");
	            out.println("</tr>");
	        }
	        
	        out.println("</tbody>");
	        out.println("</table>");
	        out.println("</div>"); // Closes overflow-x-auto
	        out.println("</div>"); // Closes max-w-6xl card box
	        
	        con.close(); 
	    }
	    catch(Exception e) {
	        e.printStackTrace(out); 
	    }
	    
	    out.println("</body>");
	    out.println("</html>");
		
		
		
		
	}
	

}
