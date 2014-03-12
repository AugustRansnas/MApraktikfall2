package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Local;

import brokerapplication.ejb.ics.RealEstateObject;

@Local
public interface RealEstateObjectEAOLocal {
	public RealEstateObject findRealEstateObjectByObjNr(int objNr);

	public RealEstateObject createRealEstateObject(
			RealEstateObject realEstateObject);

	public RealEstateObject updateRealEstateObject(
			RealEstateObject realEstateObject);

	public void deleteRealEstateObject(int objNr);
	public List<RealEstateObject> findAllRealEstateObjects();
	public List<RealEstateObject> findByAddressRealEstateObjects(String objAddress);
	public List<RealEstateObject> findByCityRealEstateObjects(String objCity);
	public List<RealEstateObject> findByPriceRealEstateObjects(int objPrice);
	public List<RealEstateObject> findByAreaRealEstateObjects(int objArea);
	public List<RealEstateObject> findByRoomsRealEstateObjects(String objRooms);
	public List<RealEstateObject> findByUnitTypeRealEstateObjects(String objUnitType);
}
