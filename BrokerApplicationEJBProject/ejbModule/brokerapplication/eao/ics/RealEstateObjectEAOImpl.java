package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RealEstateObjectEAOImpl
 */
@Stateless
public class RealEstateObjectEAOImpl implements RealEstateObjectEAOLocal {
	@PersistenceContext(unitName="BrokerApplication")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public RealEstateObjectEAOImpl() {
        // TODO Auto-generated constructor stub
    }

}
