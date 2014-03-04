package brokerapplication.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import brokerapplication.ejb.ics.ObjectOwner;

/**
 * Session Bean implementation class ObjectOwnerEAOImpl
 */
@Stateless
public class ObjectOwnerEAOImpl implements ObjectOwnerEAOLocal {
	@PersistenceContext(unitName="BrokerApplication") 
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public ObjectOwnerEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr){
    	return em.find(ObjectOwner.class, ownerSsnr);
    }

    public ObjectOwner createObjectOwner(ObjectOwner objectOwner){
    	em.persist(objectOwner);
    	return objectOwner;
    }
    
    public ObjectOwner updateObjectOwner(ObjectOwner objectOwner){
    	em.merge(objectOwner);
    	return objectOwner;
    }
    
    public void deleteObjectOwner(String ownerSsnr){
    	ObjectOwner oo = this.findObjectOwnerByOwnerSsnr(ownerSsnr);
    	if(oo != null){
    		em.remove(oo);
    	}
    }
}
