package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myproject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = null;
			pw=response.getWriter();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatable", "root", "0000");
			String name = request.getParameter("username");
			String pass = request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("select name from logintable where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Cookie cookie = new Cookie ("username", name);
				response.addCookie(cookie);
				pw.write("<h1>Login Successful...</h1>");
				}
			else {
				pw.write("<h1>Login Failed...Try Again...</h1>");
				RequestDispatcher  rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
