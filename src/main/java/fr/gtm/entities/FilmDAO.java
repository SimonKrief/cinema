package fr.gtm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
@Singleton
public class FilmDAO extends AbstractDAO<Film, Long> {


	
	@PersistenceContext(name="cinema") private EntityManager em;

	public FilmDAO() {
		super(Film.class);
	}


	
	public List<Film> getAllFilms() {
		return em.createNamedQuery("Film.all", Film.class).getResultList();
	}
	
	
	

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
