package it.proprietarioautomobile.test;

import java.util.List;

import it.proprietarioautomobile.dao.EntityManagerUtil;
import it.proprietarioautomobile.model.Automobile;
import it.proprietarioautomobile.model.Proprietario;
import it.proprietarioautomobile.service.MyServiceFactory;
import it.proprietarioautomobile.service.automobile.AutomobileService;
import it.proprietarioautomobile.service.proprietario.ProprietarioService;

public class TestProprietario {
	public static void main(String[] args) {
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {

			// CRUD del ProprietarioDAO
			testInsertProprietario(proprietarioService);
			
			testListProprietario(proprietarioService);

			testUpdateProprietario(proprietarioService);
			
			testGetProprietario(proprietarioService);
			
			testRemoveProprietario(proprietarioService);
			
			
			// CRUD di AutomobileDAO
			testInsertAutomobile(automobileService);
			
			testListAutomobile(automobileService);
			
			testUpdateAutomobile(automobileService);
			
			testGetAutomobile(automobileService);
			
			testRemoveAutomobile(automobileService);
			
			
			
			// funzioni aggiuntive
			testListAllAutomobiliCodFis(automobileService, proprietarioService);
			
			
			//testContaProprietariConAutomobiliImmatricolateDopo(proprietarioService, automobileService);

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

	
	private static void testInsertAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testInsertAutomobile ........");
		
		Automobile appenaInserita = new Automobile("bmw", "serie 3");
		automobileService.inserisciNuova(appenaInserita);
		if (appenaInserita.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		System.out.println("........ FINE testInsertAutomobile: successo ........");
	}
	
	private static void testListAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testListAutomobile ........");
		
		Automobile appenaInserito = new Automobile("bmw", "serie 3");
		automobileService.inserisciNuova(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		List<Automobile> listaDiAutomobili = automobileService.listAllAutomobili();
		if (listaDiAutomobili.size() < 1) 
			throw new RuntimeException("non è stato possibile stampare tutti i record");

		System.out.println("........ FINE testListAutomobile: successo ........");
	}
	
	private static void testUpdateAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testUpdateAutomobile ........");
		
		Automobile appenaInserito = new Automobile("bmw", "serie 3");
		automobileService.inserisciNuova(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		appenaInserito.setModello("serie 4");
		automobileService.aggiorna(appenaInserito);
		if (!appenaInserito.getModello().equals("serie 4"))
			throw new RuntimeException("non è stato possibile eseguire l'aggiornamento del record");

		System.out.println("........ FINE testUpdateAutomobile: successo ........");
	}
	
	private static void testGetAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testGetAutomobile ........");
		
		Automobile appenaInserito = new Automobile("bmw", "serie 3");
		automobileService.inserisciNuova(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		Automobile trovatoConId = automobileService.caricaSingolaAutomobile(appenaInserito.getId());
		if (trovatoConId.getId() != appenaInserito.getId())
			throw new RuntimeException("non è stato possibile caricare il record");

		System.out.println("........ FINE testGetAutomobile: successo ........");
	}
	
	private static void testRemoveAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testRemoveAutomobile ........");
		
		Automobile appenaInserito = new Automobile("bmw", "serie 3");
		automobileService.inserisciNuova(appenaInserito);
		if (appenaInserito.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		List<Automobile> primaDellaRemove = automobileService.listAllAutomobili();
		automobileService.rimuovi(appenaInserito);
		List<Automobile> dopoLaRemove = automobileService.listAllAutomobili();
		
		if (primaDellaRemove.size() == dopoLaRemove.size())
			throw new RuntimeException("non è stato possibile eliminare il record");

		System.out.println("........ FINE testRemoveAutomobile: successo ........");
	}

	
	private static void testContaProprietariConAutomobiliImmatricolateDopo(ProprietarioService proprietarioService, AutomobileService automobileService) throws Exception {
		System.out.println("........ INIZIO testContaProprietariConAutomobiliImmatricolateDopo ........");
		
		// inserisco 2 proprietari
		Proprietario appenaInserito1 = new Proprietario("matteo", "scarcella");
		Proprietario appenaInserito2 = new Proprietario("antonio", "rossi");
		
		proprietarioService.inserisciNuovo(appenaInserito1);
		proprietarioService.inserisciNuovo(appenaInserito2);
	
		// inserisco 3 automobili
		Automobile appenaInserita1 = new Automobile("bmw", 2009, appenaInserito1);
		Automobile appenaInserita2 = new Automobile("alfaromeo", 2005, appenaInserito2);
		Automobile appenaInserita3 = new Automobile("bmw", 2002, appenaInserito2);
		
		automobileService.inserisciNuova(appenaInserita1);
		if (appenaInserita1.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		automobileService.inserisciNuova(appenaInserita2);
		if (appenaInserita2.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		automobileService.inserisciNuova(appenaInserita3);
		if (appenaInserita3.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		
		// eseguo il conteggio
		int conteggio = proprietarioService.contaPropAutoImmDopo(2006);
		if (conteggio < 1)
			throw new RuntimeException("non è stato possibile eseguire il conteggio");
		
		
		System.out.println("........ FINE testContaProprietariConAutomobiliImmatricolateDopo: successo ........");
	}
	
	private static void testListAllAutomobiliCodFis(AutomobileService automobileService, ProprietarioService proprietarioService) throws Exception {
		System.out.println("........ INIZIO testListAllAutomobiliCodFis ........");
		
		// inserisco 2 proprietari
		Proprietario appenaInserito1 = new Proprietario("matteo", "scarcella", "matteocodicefiscale");
		Proprietario appenaInserito2 = new Proprietario("antonio", "rossi", "antoniocodicefiscale");
		Proprietario appenaInserito3 = new Proprietario("lorenzo", "verdi", "matteocodicefiscale");
		
		proprietarioService.inserisciNuovo(appenaInserito1);
		proprietarioService.inserisciNuovo(appenaInserito2);
		proprietarioService.inserisciNuovo(appenaInserito3);
	
		// inserisco 3 automobili
		Automobile appenaInserita1 = new Automobile("bmw", 2009, appenaInserito1);
		Automobile appenaInserita2 = new Automobile("alfaromeo", 2005, appenaInserito2);
		Automobile appenaInserita3 = new Automobile("bmw", 2002, appenaInserito3);
		
		automobileService.inserisciNuova(appenaInserita1);
		if (appenaInserita1.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		automobileService.inserisciNuova(appenaInserita2);
		if (appenaInserita2.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		automobileService.inserisciNuova(appenaInserita3);
		if (appenaInserita3.getId() == null)
			throw new RuntimeException("non è stato possibile inserire un nuovo record");
		
		
		// eseguo la query
		List<Automobile> listaAutomobili = automobileService.listAllAutomobiliCodFis("matteo");
		if (listaAutomobili.size() < 2)
			throw new RuntimeException("non è stato possibile eseguire la query");
		
		
		System.out.println("........ FINE testListAllAutomobiliCodFis: successo ........");
	}
}
