package it.proprietarioautomobile.dao.proprietario;

import it.proprietarioautomobile.dao.IBaseDAO;
import it.proprietarioautomobile.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {
	public int contaProprietariConAutomobiliImmatricolateDopo(int anno) throws Exception;
}
