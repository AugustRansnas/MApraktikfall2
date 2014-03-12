package brokerapplication.facade.ics;

import java.util.List;

import javax.ejb.Local;

import brokerapplication.ejb.ics.ObjectOwner;
import brokerapplication.ejb.ics.RealEstateBroker;
import brokerapplication.ejb.ics.RealEstateObject;

@Local
public interface FacadeLocal {
	// ObjectOwner
	public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr);

	public ObjectOwner createObjectOwner(ObjectOwner objectOwner);

	public ObjectOwner updateObjectOwner(ObjectOwner objectOwner);

	public void deleteObjectOwner(String ownerSsnr);

	public List<ObjectOwner> findAllObjectOwner();

	public List<ObjectOwner> findObjectOwnerByName(String name);

	public List<ObjectOwner> findObjectOwnerByPhoneNr(String phoneNr);

	public List<ObjectOwner> findObjectOwnerByEmail(String email);

	// RealEstateObject
	public RealEstateObject findRealEstateObjectByObjNr(int objNr);

	public RealEstateObject createRealEstateObject(
			RealEstateObject realEstateObject);

	public RealEstateObject updateRealEstateObject(
			RealEstateObject realEstateObject);

	public void deleteRealEstateObject(int objNr);

	// RealEstateBroker
	public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr);

	public RealEstateBroker createRealEstateBroker(RealEstateBroker reb);

	public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb);

	public void deleteRealEstateBroker(String brokerSsnr);

}
