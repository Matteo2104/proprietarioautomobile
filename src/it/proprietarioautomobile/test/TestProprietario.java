package it.proprietarioautomobile.test;

import java.util.List;

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
			
			testListProprietario(proprietarioService);

			testUpdateProprietario(proprietarioService);
			
			testGetProprietario(proprietarioService);
			
			testRemoveProprietario(proprietarioService);

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
	
	private static void testListProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testListProprietario ........");
		
		Proprietario appenaInserito = new Proprietario("matteo", "scarcella");
		proprietarioService.inserisciNuovo(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		List<Proprietario> listaDiProprietari = proprietarioService.listAllProprietari();
		if (listaDiProprietari.size() < 1) 
			throw new RuntimeException("non è stato possibile stampare tutti i record");

		System.out.println("........ FINE testListProprietario: successo ........");
	}
	
	private static void testUpdateProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testUpdateProprietario ........");
		
		Proprietario appenaInserito = new Proprietario("matteo", "scarcella");
		proprietarioService.inserisciNuovo(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		appenaInserito.setCognome("rossi");
		proprietarioService.aggiorna(appenaInserito);
		if (!appenaInserito.getCognome().equals("rossi"))
			throw new RuntimeException("non è stato possibile eseguire l'aggiornamento del record");

		System.out.println("........ FINE testUpdateProprietario: successo ........");
	}
	
	private static void testGetProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testGetProprietario ........");
		
		Proprietario appenaInserito = new Proprietario("matteo", "scarcella");
		proprietarioService.inserisciNuovo(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		Proprietario trovatoConId = proprietarioService.caricaSingoloProprietario(appenaInserito.getId());
		if (trovatoConId.getId() != appenaInserito.getId())
			throw new RuntimeException("non è stato possibile caricare il record");

		System.out.println("........ FINE testGetProprietario: successo ........");
	}
	
	private static void testRemoveProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testRemoveProprietario ........");
		
		Proprietario appenaInserito = new Proprietario("matteo", "scarcella");
		proprietarioService.inserisciNuovo(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		List<Proprietario> primaDellaRemove = proprietarioService.listAllProprietari();
		proprietarioService.rimuovi(appenaInserito);
		List<Proprietario> dopoLaRemove = proprietarioService.listAllProprietari();
		
		if (primaDellaRemove.size() == dopoLaRemove.size())
			throw new RuntimeException("non è stato possibile eliminare il record");

		System.out.println("........ FINE testRemoveProprietario: successo ........");
	}
}
