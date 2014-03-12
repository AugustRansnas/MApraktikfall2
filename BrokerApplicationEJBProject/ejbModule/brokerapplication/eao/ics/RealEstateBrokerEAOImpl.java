package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import brokerapplication.ejb.ics.RealEstateBroker;

/**
 * Session Bean implementation class RealEstateBrokerEAOImpl
 */
@Stateless
public class RealEstateBrokerEAOImpl implements RealEstateBrokerEAOLocal {
	@PersistenceContext(unitName = "BrokerApplication")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RealEstateBrokerEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr) {
		return em.find(RealEstateBroker.class, brokerSsnr);
	}

	public RealEstateBroker createRealEstateBroker(RealEstateBroker reb) {
		em.persist(reb);
		return reb;
	}

	public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb) {
		em.merge(reb);
		return reb;
	}

	public void deleteRealEstateBroker(String brokerSsnr) {
		RealEstateBroker reb = this
				.findRealEstateBrokerByBrokerSsnr(brokerSsnr);
		if (reb != null) {
			em.remove(reb);
		}

	}

	public List<RealEstateBroker> findAllRealEstateBrokers() {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findAll", RealEstateBroker.class);

		List<RealEstateBroker> result = query.getResultList();
		return result;
	}

	public List<RealEstateBroker> findRealEstateBrokersByName(String name) {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findByName", RealEstateBroker.class);

		query.setParameter("name", name);

		List<RealEstateBroker> results = query.getResultList();
		return results;
	}

	public List<RealEstateBroker> findRealEstateBrokersByAddress(String address) {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findByAddress", RealEstateBroker.class);

		query.setParameter("address", address);

		List<RealEstateBroker> results = query.getResultList();
		return results;
	}

	public List<RealEstateBroker> findRealEstateBrokersByCity(String city) {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findByCity", RealEstateBroker.class);

		query.setParameter("city", city);

		List<RealEstateBroker> results = query.getResultList();
		return results;
	}

	public List<RealEstateBroker> findRealEstateBrokersByPhoneNr(String phoneNr) {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findByPhoneNr", RealEstateBroker.class);

		query.setParameter("phoneNr", phoneNr);

		List<RealEstateBroker> results = query.getResultList();
		return results;
	}

	public List<RealEstateBroker> findRealEstateBrokersByEmail(String email) {
		TypedQuery<RealEstateBroker> query = em.createNamedQuery(
				"RealEstateBroker.findByEmail", RealEstateBroker.class);

		query.setParameter("email", email);

		List<RealEstateBroker> results = query.getResultList();
		return results;
	}

}
