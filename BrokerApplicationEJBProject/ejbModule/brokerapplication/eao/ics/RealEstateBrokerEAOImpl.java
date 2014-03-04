package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RealEstateBrokerEAOImpl
 */
@Stateless
public class RealEstateBrokerEAOImpl implements RealEstateBrokerEAOLocal {
	@PersistenceContext(unitName="BrokerApplication")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public RealEstateBrokerEAOImpl() {
        // TODO Auto-generated constructor stub
    }

}
