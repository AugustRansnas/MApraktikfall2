package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Local;

import brokerapplication.ejb.ics.ObjectOwner;

@Local
public interface ObjectOwnerEAOLocal {
	public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr);

	public ObjectOwner createObjectOwner(ObjectOwner objectOwner);

	public ObjectOwner updateObjectOwner(ObjectOwner objectOwner);

	public void deleteObjectOwner(String ownerSsnr);
	
	public List<ObjectOwner> findAllObjectOwner(); 
	
	public List<ObjectOwner> findByName(String name); 
	
	public List<ObjectOwner> findByPhoneNr(String phoneNr); 
	
	public List<ObjectOwner> findByEmail(String email); 


}
