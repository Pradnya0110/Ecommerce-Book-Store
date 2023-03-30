

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/BookSearch")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		PrintWriter out=response.getWriter();
		String isbn=request.getParameter("s1");
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded...");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","pradnya","pradnya");
		
		out.println("connection created...");
		
		Statement st=con.createStatement();
		//ResultSet rs=st.executeQuery("select * from book where isbn="+isbn+"");
		ResultSet rs=st.executeQuery("select * from books where ISBN="+isbn+"");
		System.out.println("record searched...");
		
		while(rs.next())
		{
		out.println(rs.getInt(1)+" " +rs.getString(2)+" "+ rs.getString(3)+" "+rs.getInt(4));
		}
		
		}
		
		catch(Exception s)
		{
			s.printStackTrace();
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
