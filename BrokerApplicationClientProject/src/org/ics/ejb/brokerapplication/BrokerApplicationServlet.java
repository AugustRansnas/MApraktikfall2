package org.ics.ejb.brokerapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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

		String url = null;
		// Get hidden field
		String operation = request.getParameter("operation");

		if (operation.equals("getOptions")) {
			this.getOptions(request);
			url = "/HTML/ShowObjects.jsp";
		}

		/*
		 * OBJECTOWNERS
		 */
		if (operation.equals("searchowner")) {
			String selection = request.getParameter("selectOwner");
			String input = request.getParameter("ownerInput");
			this.searchOwner(selection, input, request);
			url = "/HTML/ShowOwner.jsp";
		}

		else if (operation.equals("showowners")) {
			this.showOwner(request);
			url = "/HTML/ShowOwner.jsp";
		}

		else if (operation.equals("administrateowner")) {
			String pressedButton = request.getParameter("adminowner");
			url = this.administrateOwner(pressedButton, request);
		}

		else if (operation.equals("getAllOwners")) {
			this.showOwner(request);
			url = "/HTML/ShowOwner.jsp";
		}

		/*
		 * BROKERS
		 */
		else if (operation.equals("searchbroker")) {
			String selection = request.getParameter("selectedAttribute");
			String input = request.getParameter("input");
			this.searchBroker(selection, input, request);
			url = "/HTML/ShowBroker.jsp";
		} else if (operation.equals("showbrokers")) {
			this.showBrokers(request);
			url = "/HTML/ShowBroker.jsp";
		} else if (operation.equals("adminbroker")) {	
			String pressedButton = (String) request.getParameter("adminbroker");
			url = this.administrateBroker(pressedButton, request);

		}

		/*
		 * OBJECTS
		 */
		else if (operation.equals("searchobjects")) {
			String selection = (String) request.getParameter("objectSelect");
			this.searchObject(selection, request);
			this.getOptions(request);
			url = "/HTML/ShowObjects.jsp";
		} else if (operation.equals("showobjects")) {
			this.getOptions(request);
			this.showObjects(request);
			url = "/HTML/ShowObjects.jsp";
		} else if (operation.equals("administrateobjects")) {
			String pressedButton = request.getParameter("adminobject");
			this.getOptions(request);
			url = this.administrateObject(pressedButton, request);			
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * OWNER METHODS Search for owners with differnt searchterms
	 * 
	 * @param String
	 *            selection, String input
	 * @return void
	 */
	private void searchOwner(String selection, String input,
			HttpServletRequest request) {
		List<ObjectOwner> ooList = new ArrayList<ObjectOwner>();

		switch (selection) {

		case "ownerSsnr":
			ObjectOwner oo = facade.findObjectOwnerByOwnerSsnr(input);

			if (oo != null) {
				ooList.add(oo);
			}
			break;
		case "email":
			ooList = facade.findObjectOwnerByEmail(input);
			break;
		case "name":
			ooList = facade.findObjectOwnerByName(input);
			break;
		case "phoneNr":
			ooList = facade.findObjectOwnerByPhoneNr(input);
			break;
		}

		if (ooList != null) {
			request.setAttribute("ObjectOwner", ooList);
		}
	}

	/**
	 * Shows all owners
	 * 
	 * @param none
	 * @return void
	 */
	private void showOwner(HttpServletRequest request) {
		List<ObjectOwner> ooList = new ArrayList<ObjectOwner>();
		ooList = facade.findAllObjectOwner();
		if (ooList != null) {
			request.setAttribute("AllObjectOwners", ooList);
		}
	}

	/**
	 * Add,update and delete owner
	 * 
	 * @param String
	 *            pressedButton
	 * @return
	 * @return void
	 */
	private String administrateOwner(String pressedButton,
			HttpServletRequest request) {

		String ownerSsnr = (String) request.getParameter("ownerSsnr");
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String phoneNbr = (String) request.getParameter("phoneNbr");
		ObjectOwner oo = new ObjectOwner();

		switch (pressedButton) {

		case "Lägg till":
			oo.setEmail(email);
			oo.setOwnerSsnr(ownerSsnr);
			oo.setName(name);
			oo.setPhoneNr(phoneNbr);
			try {
				facade.createObjectOwner(oo);
			} catch (Exception e) {
				String feedback = "En ägare kunde inte läggas till. Kontrollera dina inmatade värden. En ägare kan inte läggas till om den redan existerar.";
				request.setAttribute("feedback", feedback);				
				return "/HTML/Error.jsp";
			}

			return "/HTML/ShowOwner.jsp";			
			
		case "Uppdatera":
			oo = facade.findObjectOwnerByOwnerSsnr(ownerSsnr);
			if (oo != null) {
				oo.setEmail(email);
				oo.setName(name);
				oo.setPhoneNr(phoneNbr);
				try {
					facade.updateObjectOwner(oo);
				} catch (Exception e) {
					String feedback = "En ägare kunde inte uppdateras. Kontrollera dina inmatade värden.";
					request.setAttribute("feedback", feedback);
					return "/HTML/Error.jsp";
				}
				return "/HTML/ShowOwner.jsp";
			}

			break;
		case "Ta bort":
			try {
				facade.deleteObjectOwner(ownerSsnr);
				return "/HTML/ShowOwner.jsp";
			} catch (Exception e) {
				String feedback = "En ägare kunde inte tas bort. Kontrollera dina inmatade värden. Om en ägare äger ett objekt måste objektet tas bort först.";
				request.setAttribute("feedback", feedback);	
				return "/HTML/Error.jsp";
			}
		}
		return "/HTML/ShowOwner.jsp";
	}

	/**
	 * BROKER METHODS Search for a broker with different searchterms
	 * 
	 * @param String
	 *            selection,String input
	 * @return void
	 */
	private void searchBroker(String selection, String input,
			HttpServletRequest request) {

		ArrayList<RealEstateBroker> brokerList = new ArrayList<RealEstateBroker>();

		switch (selection) {

		case "brokerSsnr":
			RealEstateBroker tmpBroker = facade
					.findRealEstateBrokerByBrokerSsnr(input);
			if (tmpBroker != null) {
				brokerList.add(tmpBroker);
			}
			break;
		case "brokerAddress":
			brokerList = (ArrayList<RealEstateBroker>) facade
					.findRealEstateBrokersByAddress(input);
			break;
		case "city":
			brokerList = (ArrayList<RealEstateBroker>) facade
					.findRealEstateBrokersByCity(input);
			break;
		case "email":
			brokerList = (ArrayList<RealEstateBroker>) facade
					.findRealEstateBrokersByEmail(input);
			break;
		case "name":
			brokerList = (ArrayList<RealEstateBroker>) facade
					.findRealEstateBrokersByName(input);
			break;
		case "phoneNr":
			brokerList = (ArrayList<RealEstateBroker>) facade
					.findRealEstateBrokersByPhoneNr(input);
			break;
		}
		if (brokerList != null) {
			request.setAttribute("broker", brokerList);
		}
	}

	/**
	 * Shows all brokers
	 * 
	 * @param none
	 * @return void
	 */
	private void showBrokers(HttpServletRequest request) {
		List<RealEstateBroker> allBrokers = facade.findAllRealEstateBrokers();
		if (allBrokers != null) {
			request.setAttribute("AllBrokers", allBrokers);
		}
	}

	/**
	 * Add,update and delete broker
	 * 
	 * @param String
	 *            pressedButton
	 * @return void
	 */
	private String administrateBroker(String pressedButton,
			HttpServletRequest request) {

		String brokerSsnr = request.getParameter("brokerSsnr");
		String brokerAddress = request.getParameter("brokerAddress");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String phoneNr = request.getParameter("phoneNbr");
		String pw = request.getParameter("password");

		RealEstateBroker tmpBroker = new RealEstateBroker();
		
		switch (pressedButton) {

		case "Lägg till":
			tmpBroker.setBrokerSsnr(brokerSsnr);
			tmpBroker.setBrokerAddress(brokerAddress);
			tmpBroker.setCity(city);
			tmpBroker.setEmail(email);
			tmpBroker.setName(name);
			tmpBroker.setPhoneNr(phoneNr);
			tmpBroker.setPw(pw);
			try {
				facade.createRealEstateBroker(tmpBroker);
			} catch (Exception e) {
				String feedback = "En mäklare kunde inte läggas till. Kontrollera dina inmatade värden. En mäklare kan inte läggas till om den redan existerar.";
				request.setAttribute("feedback", feedback);				
				return "/HTML/Error.jsp";
			}
			break;
		case "Uppdatera":
			tmpBroker.setBrokerSsnr(brokerSsnr);
			tmpBroker.setBrokerAddress(brokerAddress);
			tmpBroker.setCity(city);
			tmpBroker.setEmail(email);
			tmpBroker.setName(name);
			tmpBroker.setPhoneNr(phoneNr);
			tmpBroker.setPw(pw);
			try {				
				facade.updateRealEstateBroker(tmpBroker);
			} catch (Exception e) {
				String feedback = "En mäklare kunde inte uppdateras. Kontrollera dina inmatade värden. ";
				request.setAttribute("feedback", feedback);
				return "/HTML/Error.jsp";
			}
			break;
		case "Ta bort":
			try {
				facade.deleteRealEstateBroker(brokerSsnr);
			} catch (Exception e) {
				String feedback = "En mäklare kunde inte tas bort. Kontrollera dina inmatade värden. Om en mäklare ansvarar för ett objekt måste objektet tas bort först.";
				request.setAttribute("feedback", feedback);
				return "/HTML/Error.jsp";
			}
			break;
		}
		return "/HTML/ShowBroker.jsp";
	}

	/**
	 * OBJECT METHODS Search for a object with different searchterms
	 * 
	 * @param String
	 *            selection
	 * @return void
	 */
	private void searchObject(String selection, HttpServletRequest request) {

		ArrayList<RealEstateObject> allObjects = new ArrayList<RealEstateObject>();
		switch (selection) {

		case "objNr":
			String theObjNr = request.getParameter("searchInput");
			int objNr = Integer.parseInt(theObjNr);
			RealEstateObject reo = facade.findRealEstateObjectByObjNr(objNr);
			if (reo != null) {
				allObjects.add(reo);
			}
			break;
		case "objAdress":
			String objAddress = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByAddressRealEstateObjects(objAddress);
			break;
		case "objArea":
			String theObjArea = request.getParameter("searchInput");
			int objArea = Integer.parseInt(theObjArea);
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByAreaRealEstateObjects(objArea);
			break;
		case "objCity":
			String objCity = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByCityRealEstateObjects(objCity);
			break;
		case "objPrice":
			String theObjPrice = request.getParameter("searchInput");
			int objPrice = Integer.parseInt(theObjPrice);
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByPriceRealEstateObjects(objPrice);
			break;
		case "objRooms":
			String objRooms = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByRoomsRealEstateObjects(objRooms);
			break;
		case "objUnitType":
			String objUnitType = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByUnitTypeRealEstateObjects(objUnitType);
			break;
		case "objOwner":
			String ownerSsnr = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByObjectOwner(ownerSsnr);
			break;
		case "objBroker":
			String brokerSsnr = request.getParameter("searchInput");
			allObjects = (ArrayList<RealEstateObject>) facade
					.findByObjectBroker(brokerSsnr);
			break;
		}
		if (allObjects != null) {
			request.setAttribute("allObjects", allObjects);
		}
	}

	/**
	 * Shows all objects
	 * 
	 * @param none
	 * @return void
	 */
	private void showObjects(HttpServletRequest request) {
		List<RealEstateObject> allObjects = facade.findAllRealEstateObjects();
		request.setAttribute("AllObjects", allObjects);
	}

	/**
	 * Add,update and delete objects
	 * 
	 * @param String
	 *            pressedButton
	 * @return
	 * @return void
	 */
	private String administrateObject(String pressedButton,
			HttpServletRequest request) {

		int objNr = Integer.parseInt(request.getParameter("objNr"));
		String objAddress = (String) request.getParameter("objAddress");
		String thisObjArea = request.getParameter("objArea");
		int objArea = 0;
		if (!thisObjArea.equals("")) {
			objArea = Integer.parseInt(thisObjArea);
		}
		String objCity = (String) request.getParameter("objCity");
		String objInfo = (String) request.getParameter("objInfo");
		String thisObjPrice = request.getParameter("objPrice");
		int objPrice = 0;
		if (!thisObjPrice.equals("")) {
			objPrice = Integer.parseInt(thisObjPrice);
		}
		String objRooms = (String) request.getParameter("objRooms");
		String objUnitType = (String) request.getParameter("objType");
		String ownerSsnr = (String) request.getParameter("ownerSsnr");
		String brokerSsnr = (String) request.getParameter("brokerSsnr");
		String objImage = (String) request.getParameter("uploadField");
		RealEstateObject tmpObject = new RealEstateObject();

		switch (pressedButton) {

		case "Lägg till":
			System.out.println("lägger till********************************************");
			tmpObject.setObjNr(objNr);
			tmpObject.setObjAddress(objAddress);
			tmpObject.setObjArea(objArea);
			tmpObject.setObjCity(objCity);
			tmpObject.setObjInfo(objInfo);
			tmpObject.setObjPrice(objPrice);
			tmpObject.setObjRooms(objRooms);
			tmpObject.setObjUnitType(objUnitType);
			tmpObject.setObjImage(objImage);

			ObjectOwner tmpObjectOwner = facade
					.findObjectOwnerByOwnerSsnr(ownerSsnr);
			if (tmpObjectOwner != null) {
				tmpObject.setObjectOwner(tmpObjectOwner);
			}
			RealEstateBroker tmpBroker = facade
					.findRealEstateBrokerByBrokerSsnr(brokerSsnr);
			if (tmpBroker != null) {
				tmpObject.setRealEstateBroker(tmpBroker);
			}
			try {
				facade.createRealEstateObject(tmpObject);
			} catch (Exception e) {
				String feedback = "Ett objekt kunde inte läggas till. Kontrollera dina inmatade värden. Ett objekt kan inte läggas till om det redan existerar.";
				request.setAttribute("feedback", feedback);
				return "/HTML/Error.jsp";
			}
			return "/HTML/ShowObjects.jsp";

		case "Uppdatera":
			System.out.println("Uppdaterar********************************************");
			objAddress = (String) request.getParameter("objAddress");
			objArea = Integer.parseInt(request.getParameter("objArea"));
			objCity = (String) request.getParameter("objCity");
			objInfo = (String) request.getParameter("objInfo");
			objPrice = Integer.parseInt(request.getParameter("objPrice"));
			objRooms = (String) request.getParameter("objRooms");
			objUnitType = (String) request.getParameter("objType");
			ownerSsnr = (String) request.getParameter("ownerSsnr");
			brokerSsnr = (String) request.getParameter("brokerSsnr");
			objImage = (String) request.getParameter("uploadField");

			objNr = Integer.parseInt(request.getParameter("objNr"));
			tmpObject = facade.findRealEstateObjectByObjNr(objNr);
			if (tmpObject != null) {
				tmpObject.setObjAddress(objAddress);
				tmpObject.setObjArea(objArea);
				tmpObject.setObjCity(objCity);
				tmpObject.setObjInfo(objInfo);
				tmpObject.setObjPrice(objPrice);
				tmpObject.setObjRooms(objRooms);
				tmpObject.setObjUnitType(objUnitType);
				tmpObject.setObjImage(objImage);

				tmpObjectOwner = facade.findObjectOwnerByOwnerSsnr(ownerSsnr);
				if (tmpObjectOwner != null) {
					tmpObject.setObjectOwner(tmpObjectOwner);
				}
				tmpBroker = facade.findRealEstateBrokerByBrokerSsnr(brokerSsnr);
				if (tmpBroker != null) {
					tmpObject.setRealEstateBroker(tmpBroker);
				}
				try {
					facade.updateRealEstateObject(tmpObject);
				} catch (Exception e) {
					String feedback = "Ett objekt kunde inte uppdateras. Kontrollera dina inmatade värden.";
					request.setAttribute("feedback", feedback);
					return "/HTML/Error.jsp";
				}
			}
			return "/HTML/ShowObjects.jsp";
		case "Ta bort":
			System.out.println("tar bort********************************************");
			objNr = Integer.parseInt(request.getParameter("objNr"));
			tmpObject = facade.findRealEstateObjectByObjNr(objNr);
			if (tmpObject != null) {
				try {
					facade.deleteRealEstateObject(objNr);
					return "/HTML/ShowObjects.jsp";
				} catch (Exception e) {
					String feedback = "Ett objekt kunde inte tas bort. Kontrollera dina inmatade värden.";
					request.setAttribute("feedback", feedback);
					return "/HTML/Error.jsp";
				}
			}
			return "/HTML/ShowObjects.jsp";
		}
		return "/HTML/ShowObjects.jsp";
	}

	private void getOptions(HttpServletRequest request) {

		ArrayList<RealEstateBroker> allBrokers = (ArrayList<RealEstateBroker>) facade
				.findAllRealEstateBrokers();
		ArrayList<ObjectOwner> allOwners = (ArrayList<ObjectOwner>) facade
				.findAllObjectOwner();
		ArrayList<String> allBrokersSsnr = new ArrayList<String>();
		ArrayList<String> allOwnersSsnr = new ArrayList<String>();

		for (RealEstateBroker reb : allBrokers)
			allBrokersSsnr.add(reb.getBrokerSsnr());

		for (ObjectOwner oo : allOwners)
			allOwnersSsnr.add(oo.getOwnerSsnr());

		request.setAttribute("allBrokersSsnr", allBrokersSsnr);
		request.setAttribute("allOwnersSsnr", allOwnersSsnr);

	}
}
