package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		boolean flag = false;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("username".equals(cookie.getName())) {
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			response.sendRedirect("login.html");
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
