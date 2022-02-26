package it.proprietarioautomobile.test;

import it.proprietarioautomobile.dao.EntityManagerUtil;
import it.proprietarioautomobile.model.Proprietario;
import it.proprietarioautomobile.service.MyServiceFactory;
import it.proprietarioautomobile.service.automobile.AutomobileService;
import it.proprietarioautomobile.service.proprietario.ProprietarioService;

public class TestProprietario {
	public static void main(String[] args) {
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {

			testInsertProprietario(proprietarioService);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
	
	private static void testInsertProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testInsertProprietario ........");
		
		Proprietario appenaInserito = new Proprietario("matteo", "scarcella");
		proprietarioService.inserisciNuovo(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		System.out.println("........ FINE testInsertProprietario: successo ........");
	}
}
