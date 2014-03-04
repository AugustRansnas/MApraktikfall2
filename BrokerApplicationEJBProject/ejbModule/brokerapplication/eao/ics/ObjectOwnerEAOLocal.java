package brokerapplication.eao.ics;

import javax.ejb.Local;

import brokerapplication.ejb.ics.ObjectOwner;

@Local
public interface ObjectOwnerEAOLocal {
	public ObjectOwner findObjectOwnerByOwnerSsnr(String ownerSsnr);

	public ObjectOwner createObjectOwner(ObjectOwner objectOwner);

	public ObjectOwner updateObjectOwner(ObjectOwner objectOwner);

	public void deleteObjectOwner(String ownerSsnr);
}
