package it.proprietarioautomobile.service;

import it.proprietarioautomobile.dao.MyDAOFactory;
import it.proprietarioautomobile.service.automobile.AutomobileService;
import it.proprietarioautomobile.service.automobile.AutomobileServiceImpl;
import it.proprietarioautomobile.service.proprietario.ProprietarioService;
import it.proprietarioautomobile.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {
	// rendiamo le istanze restituite SINGLETON
		private static AutomobileService automobileServiceInstance = null;
		private static ProprietarioService proprietarioServiceInstance = null;

		public static AutomobileService getAutomobileServiceInstance() {
			if (automobileServiceInstance == null) {
				automobileServiceInstance = new AutomobileServiceImpl();
				automobileServiceInstance.setAutomobileDAO(MyDAOFactory.getAutomobileDAOInstance());
			}
			return automobileServiceInstance;
		}

		public static ProprietarioService getProprietarioServiceInstance() {
			if (proprietarioServiceInstance == null) {
				proprietarioServiceInstance = new ProprietarioServiceImpl();
				proprietarioServiceInstance.setProprietarioDAO(MyDAOFactory.getProprietarioDAOInstance());
			}
			return proprietarioServiceInstance;
		}
}
