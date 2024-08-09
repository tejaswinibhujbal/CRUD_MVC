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
import bank.model.Update;

/**
 * Servlet implementation class UpdateCOntroller
 */
@WebServlet("/UpdateCOntroller")
public class UpdateCOntroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCOntroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("1");

	 System.out.println("hello");
	 
	    int accNo; // Default value or you can set it to any other appropriate default value
		String accNoParam = request.getParameter("accNo");
		if(accNoParam != null && !accNoParam.isEmpty()) {
		    accNo = Integer.parseInt(accNoParam);
		    // Your existing code for processing accNo
		} else {
		    // Handle the case when "accNo" parameter is missing or null
		    // For example:
		    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter 'accNo' is missing or null");
		    return; // Stop further processing
		}	    
		
	String uName = request.getParameter("uName");
	   System.out.println("2");
	    // Call the DAO method to retrieve the record
	    RegisterDao dobj = new RegisterDaoImpl();
	    List<Register> rlst = dobj.retriveRecord(accNo);
	    System.out.println("3");

	    PrintWriter pw = response.getWriter();
	    if (rlst != null && !rlst.isEmpty()) {
	        // Assuming only one record is expected
	        Register robj = rlst.get(0);
	        // Update the username
	        robj.setuName(uName);
	        // Call the DAO method to update the record
	        int i = dobj.updateRecord(rlst);
		    System.out.println("Testu");

	        if (i > 0) {
	            pw.println("<h2>Record updated successfully</h2>");
	        } else {
	            response.sendRedirect("Error.html");
	        }
	    } else {
	        response.sendRedirect("Error.html"); // Record not found
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
