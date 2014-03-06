package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated constructor stub
	}

	@Override
	public RealEstateObject findRealEstateObjectByObjNr(int objNr) {
		// TODO Auto-generated method stub
		return em.find(RealEstateObject.class, objNr);
	}

	@Override
	public RealEstateObject createRealEstateObject(
			RealEstateObject realEstateObject) {
		// TODO Auto-generated method stub
		em.persist(realEstateObject);
		return realEstateObject;
	}

	@Override
	public RealEstateObject updateRealEstateObject(
			RealEstateObject realEstateObject) {
		// TODO Auto-generated method stub
		em.merge(realEstateObject);
		return realEstateObject;
	}

	@Override
	public void deleteRealEstateObject(int objNr) {
		// TODO Auto-generated method stub
		RealEstateObject reo = em.find(RealEstateObject.class, objNr);
		if (reo != null) {
			em.remove(reo);
		}
	}

}
