package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

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

}
