package org.ics.ejb.brokerapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokerapplication.ejb.ics.ObjectOwner;
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

		out.println("<h2>ObjectOwner</h2>");

		ObjectOwner objectOwner = facade.findObjectOwnerByOwnerSsnr("123");

		out.print("<p> Name: " + objectOwner.getName()+"</p>");
		out.print("<p> Email: " + objectOwner.getEmail()+"</p>");
		out.print("<p> Phone number: " + objectOwner.getPhoneNr() + " </p>");
		
		out.println("<h2>RealEstateObject</h2>");
		
		RealEstateObject realEstateObject = facade.findRealEstateObjectByObjNr(1);
		
		out.print("<p> Object number: " + realEstateObject.getObjNr()+"</p>");
		out.print("<p> Object address: " + realEstateObject.getObjAddress()+"</p>");
		out.print("<p> Object city: " + realEstateObject.getObjCity() + " </p>");
		out.print("<p> Object price: " + realEstateObject.getObjPrice()+"</p>");
		out.print("<p> Object area: " + realEstateObject.getObjArea()+"</p>");
		out.print("<p> Object rooms: " + realEstateObject.getObjRooms() + " </p>");
		out.print("<p> Object unit type: " + realEstateObject.getObjUnitType()+"</p>");
		out.print("<p> Object info: " + realEstateObject.getObjInfo()+"</p>");
		out.print("<p> Object broker ssnr (ej implementerad ännu): " + " </p>");
		out.print("<p> Object owner ssnr (ej implementerad ännu): " + " </p>");
		out.print("<p> Object image (ej implementerad ännu): " + " </p>");
		
		out.println("<h2>Skapa object och ägare</h2>");
		
		ObjectOwner oo = new ObjectOwner();
		
		oo.setOwnerSsnr("3");
		oo.setEmail("email");
		oo.setName("name");		
		oo.setPhoneNr("123");
		
		//facade.createObjectOwner(oo);
								
		
		RealEstateObject reo = new RealEstateObject();
		reo.setObjNr(2);
		reo.setObjAddress("address");
		reo.setBrokerSsnr("1");
		reo.setObjArea(100);
		reo.setObjCity("city");
		reo.setObjInfo("inf");
		reo.setObjPrice(1000);
		reo.setObjRooms("2");
		reo.setObjUnitType("hus");
		reo.setObjectOwner(facade.findObjectOwnerByOwnerSsnr("3"));
		//facade.createRealEstateObject(reo);
		
		RealEstateObject reo2 = facade.findRealEstateObjectByObjNr(2);
			
		//Hämta en ägares alla objekt
		ObjectOwner oo2 = facade.findObjectOwnerByOwnerSsnr("3");
		Set<RealEstateObject> realEstateObjects = oo2.getRealEstateObjects();		
		Object[] realEstateObjectsArray = realEstateObjects.toArray();
		for(int i = 0; i < realEstateObjects.size(); i++){
			RealEstateObject tmp = (RealEstateObject) realEstateObjectsArray[i];
			out.print("<p>Vår loop objnr:  " + tmp.getObjNr() + " </p>");
			out.print("<p>Vår loop adress:  " + tmp.getObjAddress() + " </p>");
		}
		
		


		out.println("</body></html>");

	}

}
