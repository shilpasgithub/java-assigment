

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import test.Database;
/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			String storedpassword = Database.passwordCheck(username);
			if(storedpassword==null)
	        {
	        	response.setContentType("text/html");	
				out.println("User Not Found");
				RequestDispatcher rd = request.getRequestDispatcher("/File.html");
				rd.include(request, response);
	        }
			if(password.equals(storedpassword)) {
				String[] array = Database.getinfo(username);
			    RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
			    	request.setAttribute("username", array[0]);
			    	request.setAttribute("bio",array[1] );
					rd.forward(request, response);
			}else {
				response.setContentType("text/html");
				out.println("Password Not Correct");
				RequestDispatcher rd = request.getRequestDispatcher("/File.html");
				rd.include(request, response);
			}
		} catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
