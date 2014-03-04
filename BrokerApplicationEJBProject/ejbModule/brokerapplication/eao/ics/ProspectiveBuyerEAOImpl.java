package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProspectiveBuyerEAOImpl
 */
@Stateless
public class ProspectiveBuyerEAOImpl implements ProspectiveBuyerEAOLocal {
	@PersistenceContext(unitName="BrokerApplication")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public ProspectiveBuyerEAOImpl() {
        // TODO Auto-generated constructor stub
    }

}
