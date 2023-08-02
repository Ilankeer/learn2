package Task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/Project5")
public class Project5 extends HttpServlet {

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String a=request.getParameter("N");
 String b=request.getParameter("M");
 String c=request.getParameter("E");
 String d=request.getParameter("P");
 
Chottabean ik=new Chottabean();
 ik.setA(a);
 String F= ik.getA();
 ik.setB(b);
 String G= ik.getB();
 ik.setC(c);
 String H= ik.getC();
 ik.setD(d);
 String I= ik.getD();
 try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {

	e1.printStackTrace();
}
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lap","root","ilan6666Il@n");
		PreparedStatement pr=con.prepareStatement("insert into top values(?,?,?,?) ");
		pr.setString(1, F);
		pr.setString(2, G);
		pr.setString(3, H);
		pr.setString(4, I);
		int rs=pr.executeUpdate();
		if(rs>0)
		{
			response.sendRedirect("Project1.jsp");
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
