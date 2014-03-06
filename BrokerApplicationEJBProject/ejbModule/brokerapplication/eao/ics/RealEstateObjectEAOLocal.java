package brokerapplication.eao.ics;

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
}
