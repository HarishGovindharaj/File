package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signuppage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("newusername");
			String newpass = request.getParameter("newpassword");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatable", "root", "0000");
			PreparedStatement ps = con.prepareStatement("insert into logintable (name, password) values (?, ?)");
			ps.setString(1, username);
			ps.setString(2, newpass);
			ps.executeUpdate();
			//pw.write("<h1>Your account was created</h1>");
			response.sendRedirect("login.html");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
