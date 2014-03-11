package brokerapplication.eao.ics;

import javax.ejb.Local;

import brokerapplication.ejb.ics.RealEstateBroker;

@Local
public interface RealEstateBrokerEAOLocal {
	
		public RealEstateBroker findRealEstateBrokerByBrokerSsnr(String brokerSsnr);
			
		public RealEstateBroker createRealEstateBroker(RealEstateBroker reb);
		
		public RealEstateBroker updateRealEstateBroker(RealEstateBroker reb);
		
		public void deleteRealEstateBroker(String brokerSsnr);
	
}
