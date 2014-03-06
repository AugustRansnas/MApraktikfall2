package org.ics.ejb.brokerapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrokerApplicationServlet
 */
@WebServlet("/BrokerApplicationServlet")
public class BrokerApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BrokerApplicationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Lab1</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");

		out.println("<h2>ObjectOwner</h2>");

		out.println("</body></html>");

	}

}
