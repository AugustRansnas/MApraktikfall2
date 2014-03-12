package brokerapplication.facade.ics;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import brokerapplication.eao.ics.ObjectOwnerEAOLocal;
import brokerapplication.eao.ics.RealEstateBrokerEAOLocal;
import brokerapplication.eao.ics.RealEstateObjectEAOLocal;
import brokerapplication.ejb.ics.ObjectOwner;
import brokerapplication.ejb.ics.RealEstateBroker;
import brokerapplication.ejb.ics.RealEstateObject;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private ObjectOwnerEAOLocal objectOwnerEAO;
	@EJB
	private RealEstateObjectEAOLocal realEstateObjectEAO;
	@EJB
	private RealEstateBrokerEAOLocal realEstateBrokerEAO;
	@EJB
	private ObjectOwnerEAOLocal ObjectOwnerEAO;

	/**
	 * Default constructor.
	 */
	public Facade() {
		// TODO Auto-generated constructor stub
	}

	// ObjectOwner
	public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr) {
		return objectOwnerEAO.findObjectOwnerByOwnerSsnr(ownerSsnr);
	}

	public ObjectOwner createObjectOwner(ObjectOwner objectOwner) {
		return objectOwnerEAO.createObjectOwner(objectOwner);
	}

	public ObjectOwner updateObjectOwner(ObjectOwner objectOwner) {
		return objectOwnerEAO.updateObjectOwner(objectOwner);
	}

	public void deleteObjectOwner(String ownerSsnr) {
		objectOwnerEAO.deleteObjectOwner(ownerSsnr);
	}
	
	public List<ObjectOwner> findAllObjectOwner() { 
		 return ObjectOwnerEAO.findAllObjectOwner(); 
		 } 
	
	public List<ObjectOwner> findObjectOwnerByName(String name) { 
		 return ObjectOwnerEAO.findByName(name); 
		 } 
	
	public List<ObjectOwner> findObjectOwnerByPhoneNr(String phoneNr) { 
		 return ObjectOwnerEAO.findByPhoneNr(phoneNr); 
		 }
	
	public List<ObjectOwner> findObjectOwnerByEmail(String email) { 
		 return ObjectOwnerEAO.findByEmail(email); 
		 }

	// RealEstateObject
	public RealEstateObject findRealEstateObjectByObjNr(int objNr) {
		return realEstateObjectEAO.findRealEstateObjectByObjNr(objNr);
	}

	public RealEstateObject createRealEstateObject(
			RealEstateObject realEstateObject) {
		return realEstateObjectEAO.createRealEstateObject(realEstateObject);
	}

	public RealEstateObject updateRealEstateObject(
			RealEstateObject realEstateObject) {
		return realEstateObjectEAO.updateRealEstateObject(realEstateObject);
	}

	public void deleteRealEstateObject(int objNr) {
		realEstateObjectEAO.deleteRealEstateObject(objNr);
	}

	//RealEstateBroker
	public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr) {
		return realEstateBrokerEAO.findRealEstateBrokerByBrokerSsnr(brokerSsnr);
	}

	public RealEstateBroker createRealEstateBroker(RealEstateBroker reb) {
		return realEstateBrokerEAO.createRealEstateBroker(reb);
	}

	public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb) {
		return realEstateBrokerEAO.updateRealEstateBroker(reb);
	}

	public void deleteRealEstateBroker(String brokerSsnr) {
		realEstateBrokerEAO.deleteRealEstateBroker(brokerSsnr);
	}

	
}
