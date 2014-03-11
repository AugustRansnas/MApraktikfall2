package org.ics.ejb.brokerapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokerapplication.ejb.ics.ObjectOwner;
import brokerapplication.ejb.ics.RealEstateBroker;
import brokerapplication.ejb.ics.RealEstateObject;
import brokerapplication.facade.ics.FacadeLocal;

/**
 * Servlet implementation class BrokerApplicationServlet
 */
@WebServlet("/BrokerApplicationServlet")
public class BrokerApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

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
		out.println("<title>Maklarfirman Webpage</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");

		out.println("<h2>Skapa RealEstateBroker</h2>");

		RealEstateBroker reb = new RealEstateBroker();
		reb.setBrokerAddress("Malmövägen 11");
		reb.setBrokerSsnr("2");
		reb.setCity("Eslö");
		reb.setEmail("andreas.andreasson@hotmail.com");
		reb.setName("Andreas Andreasson");
		reb.setPhoneNr("0723726326");
		reb.setPw("password");

		//facade.createRealEstateBroker(reb);
	

		RealEstateBroker reb1 = facade.findRealEstateBrokerByBrokerSsnr("1");

		out.print("<p>Skapade mäklare:  " + reb1.getName() + " </p>");
		out.print("<p>Adress:  " + reb1.getBrokerAddress() + " </p>");
		out.print("<p>Telnr:  " + reb1.getPhoneNr() + " </p>");

		out.println("<h2>Skapa objectägare</h2>");

		ObjectOwner oo = new ObjectOwner();

		oo.setOwnerSsnr("3");
		oo.setEmail("email");
		oo.setName("name");
		oo.setPhoneNr("123");

		//facade.createObjectOwner(oo);
		ObjectOwner oo1 = facade.findObjectOwnerByOwnerSsnr("3");
		
		out.print("<p>Skapade ägare:  " + oo1.getName() + " </p>");
		out.print("<p>Email:  " + oo1.getEmail() + " </p>");
		out.print("<p>Telnr:  " + oo1.getPhoneNr() + " </p>");
		

		out.println("<h2>RealEstateObject</h2>");

		RealEstateObject reo = new RealEstateObject();
		reo.setObjNr(1);
		reo.setObjAddress("Objekts adress");
		reo.setObjArea(100);
		reo.setObjCity("Objekts stad");
		reo.setObjInfo("inf");
		reo.setObjPrice(1000);
		reo.setObjRooms("2");
		reo.setObjUnitType("hus");
		reo.setObjectOwner(facade.findObjectOwnerByOwnerSsnr("3"));
		reo.setRealEstateBroker(facade.findRealEstateBrokerByBrokerSsnr("1"));

		//facade.createRealEstateObject(reo);
		RealEstateObject reo1 = facade.findRealEstateObjectByObjNr(1);
		
		out.print("<p>Skapade objekt:  " + reo1.getObjAddress() + " </p>");
		out.print("<p>Stad:  " + reo1.getObjCity() + " </p>");
		out.print("<p>Objektnummer:  " + reo.getObjNr() + " </p>");
		
		out.println("</body></html>");

	}

}
