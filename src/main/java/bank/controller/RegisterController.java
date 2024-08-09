package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accNo = Integer.parseInt(request.getParameter("accNo"));
		String accFname =request.getParameter("fName");
		String accUname =request.getParameter("uName");
		String accPassword =request.getParameter("password");
		float accBal = Integer.parseInt(request.getParameter("accBal"));
		
		Register regmodel = new Register(accNo, accFname, accUname, accPassword, accBal);
		List<Register> reglst = new ArrayList<Register>();
		reglst.add(regmodel);
		
		RegisterDao rdao =new RegisterDaoImpl();
		int i= rdao.createRecord(reglst);
		
		if(i>0) {
			response.sendRedirect("LoginView.html");
			
		}
		else {
			response.sendRedirect("Error.html");
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<table>");
		pw.println("<tr><td>"+regmodel.getAccNo()+"</td><td>"+regmodel.getfName()+"</td><td>"+regmodel.getuName()+"</td><td>"+regmodel.getPassword()+"</td><td>"+regmodel.getAccBal()+"</td></tr>");
		pw.println("</table>");
		
		pw.println("<a href='Home.html' >home</a>");
	}

}
