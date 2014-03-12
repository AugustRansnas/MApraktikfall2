package brokerapplication.eao.ics;

import java.util.List;

import javax.ejb.Local;

import brokerapplication.ejb.ics.RealEstateBroker;

@Local
public interface RealEstateBrokerEAOLocal {

	public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr);

	public RealEstateBroker createRealEstateBroker(RealEstateBroker reb);

	public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb);

	public void deleteRealEstateBroker(String brokerSsnr);

	public List<RealEstateBroker> findAllRealEstateBrokers();

	public List<RealEstateBroker> findRealEstateBrokersByName(String name);

	public List<RealEstateBroker> findRealEstateBrokersByAddress(String address);

	public List<RealEstateBroker> findRealEstateBrokersByCity(String city);

	public List<RealEstateBroker> findRealEstateBrokersByPhoneNr(String phoneNr);

	public List<RealEstateBroker> findRealEstateBrokersByEmail(String email);

}
