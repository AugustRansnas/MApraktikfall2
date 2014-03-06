package brokerapplication.facade.ics;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import brokerapplication.eao.ics.ObjectOwnerEAOLocal;
import brokerapplication.eao.ics.RealEstateObjectEAOLocal;
import brokerapplication.ejb.ics.ObjectOwner;
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
}
