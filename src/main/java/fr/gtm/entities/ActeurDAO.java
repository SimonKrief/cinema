package fr.gtm.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public class ActeurDAO extends AbstractDAO<Acteur, Long> {
	
	@PersistenceContext(name="cinema") private EntityManager em;


//	public ActeurDAO(EntityManagerFactory emf) {
//		super(emf, Acteur.class);
//	}
	public ActeurDAO() {
		super(Acteur.class);
	}

//	public List<Acteur> getAll(){
//		EntityManager em = emf.createEntityManager();
//		List<Acteur> acteurs = em.createNamedQuery("Acteur.all",Acteur.class)
//									.getResultList();
//		em.close();
//		return acteurs;
//	}

	public List<Acteur> getAll() {
		return em.createNamedQuery("Acteur.all", Acteur.class).getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
