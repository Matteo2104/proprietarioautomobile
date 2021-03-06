package it.proprietarioautomobile.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.proprietarioautomobile.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		proprietarioInstance = entityManager.merge(proprietarioInstance);
	}

	@Override
	public void insert(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(proprietarioInstance);
	}

	@Override
	public void delete(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(proprietarioInstance));
	}

	
	
	
	@Override
	public long contaProprietariConAutomobiliImmatricolateDopo(int anno) throws Exception {
		TypedQuery<Long> query = entityManager.createQuery("select count(distinct p) from Proprietario p join p.automobili a where a.annoImmatricolazione > ?1", Long.class);
		query.setParameter(1, anno);
		return query.getSingleResult();
	}
}
