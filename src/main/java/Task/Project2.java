package Task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/Project2")
public class Project2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String a=request.getParameter("name");
	String b=request.getParameter("pass");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {

		e1.printStackTrace();
	}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lap","root","ilan6666Il@n");
			PreparedStatement pr=con.prepareStatement("select*from top where Name='"+a+"' and Password='"+b+"' ");
			ResultSet rs=pr.executeQuery();
			if(rs.next())
			{
				response.sendRedirect(" Project3.jsp");
			}
			else
			{
			response.sendRedirect("Project4.jsp");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	 
	}
}
