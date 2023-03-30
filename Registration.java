

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 PrintWriter out=response.getWriter();
			String uname=request.getParameter("r1");
			String mob=request.getParameter("r2");
			String addr=request.getParameter("r3");
		    String mail=request.getParameter("r4");
		    String psw=request.getParameter("r5");
		    String cpsw=request.getParameter("r6");
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("driver loaded...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","pradnya","pradnya");
			
			out.println("connection created...");
			PreparedStatement st=con.prepareStatement("insert into Registration(uname,mob,addr,mail,psw,cpsw) values(?,?,?,?,?,?)");
			
			st.setString(1,uname);	
			st.setString(2,mob);	
			st.setString(3,addr);	
			st.setString(4,mail);
			st.setString(5,psw);
			st.setString(6,cpsw);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
