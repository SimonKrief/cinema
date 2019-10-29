package fr.gtm.films.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ActeurDAO extends AbstractDAO<Acteur, Long> {

	public ActeurDAO(EntityManagerFactory emf) {
		super(emf, Acteur.class);
	}
	
	public List<Acteur> getAllActeurs(){
		EntityManager em =  getEntityManagerFactory().createEntityManager();
		List<Acteur> acteurs = em.createNamedQuery("Acteur.getAll",Acteur.class)
									.getResultList();
		em.close();
		return acteurs;
	}
	 

}