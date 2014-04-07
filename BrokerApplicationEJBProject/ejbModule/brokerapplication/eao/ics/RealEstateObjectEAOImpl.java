package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import brokerapplication.ejb.ics.ObjectOwner;
import brokerapplication.ejb.ics.RealEstateBroker;
import brokerapplication.ejb.ics.RealEstateObject;

/**
 * Session Bean implementation class RealEstateObjectEAOImpl
 */
@Stateless
public class RealEstateObjectEAOImpl implements RealEstateObjectEAOLocal {
	@PersistenceContext(unitName = "BrokerApplication")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RealEstateObjectEAOImpl() {

	}

	public RealEstateObject findRealEstateObjectByObjNr(int objNr) {
		return em.find(RealEstateObject.class, objNr);
	}

	public RealEstateObject createRealEstateObject(
			RealEstateObject realEstateObject) {
		em.persist(realEstateObject);
		return realEstateObject;
	}

	public RealEstateObject updateRealEstateObject(
			RealEstateObject realEstateObject) {
		em.merge(realEstateObject);
		return realEstateObject;
	}

	public void deleteRealEstateObject(int objNr) {
		RealEstateObject reo = em.find(RealEstateObject.class, objNr);
		if (reo != null) {
			em.remove(reo);
		}
	}

	public List<RealEstateObject> findAllRealEstateObjects() {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findAll", RealEstateObject.class);
		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByAddressRealEstateObjects(
			String objAddress) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjAddress", RealEstateObject.class);

		query.setParameter("objAddress", objAddress);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByCityRealEstateObjects(String objCity) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjCity", RealEstateObject.class);

		query.setParameter("objCity", objCity);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByPriceRealEstateObjects(int objPrice) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjPrice", RealEstateObject.class);

		query.setParameter("objPrice", objPrice);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByAreaRealEstateObjects(int objArea) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjArea", RealEstateObject.class);

		query.setParameter("objArea", objArea);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByRoomsRealEstateObjects(String objRooms) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjRooms", RealEstateObject.class);

		query.setParameter("objRooms", objRooms);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByUnitTypeRealEstateObjects(
			String objUnitType) {
		TypedQuery<RealEstateObject> query = em.createNamedQuery(
				"RealEstateObject.findByObjUnitType", RealEstateObject.class);

		query.setParameter("objUnitType", objUnitType);

		List<RealEstateObject> results = query.getResultList();
		return results;
	}

	public List<RealEstateObject> findByObjectOwner(String ownerSsnr) {

		ObjectOwner oo = em.find(ObjectOwner.class, ownerSsnr);
		if (oo != null) {
			TypedQuery<RealEstateObject> query = em.createNamedQuery(
					"RealEstateObject.findByObjOwner", RealEstateObject.class);

			query.setParameter("objectOwner", oo);
			List<RealEstateObject> results = query.getResultList();
			return results;
		}
		return null;

	}

	public List<RealEstateObject> findByObjectBroker(String brokerSsnr) {
		
		RealEstateBroker reb = em.find(RealEstateBroker.class, brokerSsnr);
			
		if(reb != null){
			TypedQuery<RealEstateObject> query = em.createNamedQuery(
					"RealEstateObject.findByObjBroker", RealEstateObject.class);

			query.setParameter("realEstateBroker", reb);

			List<RealEstateObject> results = query.getResultList();
			return results;
		}
		return null;		
	}
}
