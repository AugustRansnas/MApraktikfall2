package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ShowingEAOImpl
 */
@Stateless
public class ShowingEAOImpl implements ShowingEAOLocal {
	@PersistenceContext(unitName="BrokerApplication")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public ShowingEAOImpl() {
        // TODO Auto-generated constructor stub
    }

}
