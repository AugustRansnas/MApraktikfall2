package brokerapplication.facade.ics;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import brokerapplication.eao.ics.ObjectOwnerEAOLocal;
import brokerapplication.ejb.ics.ObjectOwner;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private ObjectOwnerEAOLocal objectOwnerEAO;
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    
    public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr){
    	return objectOwnerEAO.findObjectOwnerByOwnerSsnr(ownerSsnr);
    }
    
    public ObjectOwner createObjectOwner(ObjectOwner objectOwner){
    	return objectOwnerEAO.createObjectOwner(objectOwner);
    }
    
    public ObjectOwner updateObjectOwner(ObjectOwner objectOwner){
    	return objectOwnerEAO.updateObjectOwner(objectOwner);
    }
    
    public void deleteObjectOwner(String ownerSsnr){
    	objectOwnerEAO.deleteObjectOwner(ownerSsnr);
    }
}
