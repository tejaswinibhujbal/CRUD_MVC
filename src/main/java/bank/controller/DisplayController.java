package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class DisplayController
 */
@WebServlet("/DisplayController")
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		RegisterDao rdao=new RegisterDaoImpl();
		List<Register> rlst=rdao.displayAll();
		System.out.println("1");
		PrintWriter p=response.getWriter();
		p.println("<table border='3px' bgcolor='blue'>");
		
		for(Register r:rlst) {
			p.print("<tr><td>"+r.getAccNo()+r.getfName()+"</td><td>"+r.getuName()+"</td><td>"+r.getPassword()+"</td><td>"+r.getAccBal()+"</td></tr>");
		}
		p.println("</table>");
		*/
		RegisterDao rdao=new RegisterDaoImpl();
		List<Register> rlst=rdao.displayAll();
		PrintWriter p=response.getWriter();

		 p.println("<html>");
	        p.println("<head>");
	        p.println("<title>Display All Records</title>");
	        p.println("<style>");
	        p.println("table { width: 100%; border-collapse: collapse; }");
	        p.println("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
	        p.println("th { background-color: #007bff; color: white; }");
	        p.println("</style>");
	        p.println("</head>");
	        p.println("<body>");
	        p.println("<table>");
	        p.println("<tr><th>Account Number</th><th>First Name</th><th>User Name</th><th>Password</th><th>Account Balance</th></tr>");
	        for (Register r : rlst) {
	            p.println("<tr><td>" + r.getAccNo() + "</td><td>" + r.getfName() + "</td><td>" + r.getuName() + "</td><td>" + r.getPassword() + "</td><td>" + r.getAccBal() + "</td></tr>");
	        }
	        p.println("</table>");
	        p.println("</body>");
	        p.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
