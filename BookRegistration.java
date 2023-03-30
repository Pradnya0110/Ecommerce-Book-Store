

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookRegistration
 */
@WebServlet("/BookRegistration")
public class BookRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		 PrintWriter out=response.getWriter();
			String isbn=request.getParameter("t1");
			String b_name=request.getParameter("t2");
			String a_name =request.getParameter("t3");
		String price=request.getParameter("t4");
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("driver loaded...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","pradnya","pradnya");
			
			out.println("connection created...");
			PreparedStatement st=con.prepareStatement("insert into Books(isbn,b_name,a_name,price) values(?,?,?,?)");
			
			st.setString(1,isbn);	
			st.setString(2,b_name);	
			st.setString(3,a_name);	
			st.setString(4,price);
			int rs=st.executeUpdate();
			
			if(rs !=0)
			{
				System.out.println("added successfully...");
			}
			else 
				System.out.println("data not added.....");
			}
		
			catch(Exception s)
			{
				s.printStackTrace();
			} 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
