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

	public List<RealEstateObject> findAllRealEstateObjects();

	public List<RealEstateObject> findByAddressRealEstateObjects(
			String objAddress);

	public List<RealEstateObject> findByCityRealEstateObjects(String objCity);

	public List<RealEstateObject> findByPriceRealEstateObjects(int objPrice);

	public List<RealEstateObject> findByAreaRealEstateObjects(int objArea);

	public List<RealEstateObject> findByRoomsRealEstateObjects(String objRooms);

	public List<RealEstateObject> findByUnitTypeRealEstateObjects(
			String objUnitType);
	
	public List<RealEstateObject> findByObjectOwner(String ownerSsnr);
	
	public List<RealEstateObject> findByObjectBroker(String brokerSsnr);

	// RealEstateBroker
	public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr);

	public RealEstateBroker createRealEstateBroker(RealEstateBroker reb);

	public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb);

	public void deleteRealEstateBroker(String brokerSsnr);

	public List<RealEstateBroker> findAllRealEstateBrokers();

	public List<RealEstateBroker> findRealEstateBrokersByName(String name);

	public List<RealEstateBroker> findRealEstateBrokersByAddress(String address);

	public List<RealEstateBroker> findRealEstateBrokersByCity(String city);

	public List<RealEstateBroker> findRealEstateBrokersByPhoneNr(String phoneNr);

	public List<RealEstateBroker> findRealEstateBrokersByEmail(String email);
}
