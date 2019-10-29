package fr.gtm.films.entities;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;

public class FilmDAO extends AbstractDAO<Film,Long>{

	public FilmDAO(EntityManagerFactory emf) {
		super(emf, Film.class);
	}

}
