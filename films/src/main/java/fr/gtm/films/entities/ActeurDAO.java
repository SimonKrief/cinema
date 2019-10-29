package fr.gtm.films.entities;

import javax.persistence.EntityManagerFactory;

public class ActeurDAO extends AbstractDAO<Acteur, Long>{

	public ActeurDAO(EntityManagerFactory emf, Class<Acteur> entityClass) {
		super(emf, entityClass);
		// TODO Auto-generated constructor stub
	}


}
