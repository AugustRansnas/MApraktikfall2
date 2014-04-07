package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import brokerapplication.ejb.ics.ObjectOwner;

/**
 * Session Bean implementation class ObjectOwnerEAOImpl
 */
@Stateless
public class ObjectOwnerEAOImpl implements ObjectOwnerEAOLocal {
	@PersistenceContext(unitName = "BrokerApplication")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ObjectOwnerEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr) {
		return em.find(ObjectOwner.class, ownerSsnr);
	}

	public ObjectOwner createObjectOwner(ObjectOwner objectOwner) {
		em.persist(objectOwner);
		return objectOwner;
	}

	public ObjectOwner updateObjectOwner(ObjectOwner objectOwner) {
		em.merge(objectOwner);
		return objectOwner;
	}

	public void deleteObjectOwner(String ownerSsnr) {
		ObjectOwner oo = this.findObjectOwnerByOwnerSsnr(ownerSsnr);
		if (oo != null) {
			em.remove(oo);
		}
	}

	public List<ObjectOwner> findAllObjectOwner() {
		TypedQuery<ObjectOwner> query = em.createNamedQuery(
				"ObjectOwner.findAll", ObjectOwner.class);

		List<ObjectOwner> results = query.getResultList();
		return results;
	}

	public List<ObjectOwner> findByName(String name) {
		TypedQuery<ObjectOwner> query = em.createNamedQuery(
				"ObjectOwner.findByName", ObjectOwner.class);

		query.setParameter("name", name);

		List<ObjectOwner> results = query.getResultList();
		return results;
	}

	public List<ObjectOwner> findByPhoneNr(String phoneNr) {
		TypedQuery<ObjectOwner> query = em.createNamedQuery(
				"ObjectOwner.findByPhoneNr", ObjectOwner.class);

		query.setParameter("phoneNr", phoneNr);

		List<ObjectOwner> results = query.getResultList();
		return results;
	}

	public List<ObjectOwner> findByEmail(String email) {
		TypedQuery<ObjectOwner> query = em.createNamedQuery(
				"ObjectOwner.findByEmail", ObjectOwner.class);

		query.setParameter("email", email);

		List<ObjectOwner> results = query.getResultList();
		return results;
	}
}
