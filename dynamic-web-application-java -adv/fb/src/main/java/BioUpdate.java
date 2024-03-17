

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test.Database;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Servlet implementation class BioUpdate
 */
@WebServlet("BioUpdate")
public class BioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BioUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String bioNew = request.getParameter("bio");
        try {
        	Database.newbio(username, bioNew);
        	String[] array = Database.getinfo(username);
        	request.setAttribute("username", array[0]);
	    	request.setAttribute("bio",array[1] );
            RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
            rd.forward(request, response);
		} catch(SQLException|ClassNotFoundException e) {
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
