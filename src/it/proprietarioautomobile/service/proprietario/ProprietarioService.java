package it.proprietarioautomobile.service.proprietario;

import java.util.List;

import it.proprietarioautomobile.dao.proprietario.ProprietarioDAO;
import it.proprietarioautomobile.model.Proprietario;

public interface ProprietarioService {
	public List<Proprietario> listAllProprietari() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Proprietario proprietarioInstance) throws Exception;
	
	
	public int contaPropAutoImmDopo(int anno) throws Exception;

	//per injection
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);
}
