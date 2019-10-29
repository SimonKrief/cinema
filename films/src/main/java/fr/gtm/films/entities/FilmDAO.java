package fr.gtm.films.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FilmDAO extends AbstractDAO<Film, Long> {

	public FilmDAO(EntityManagerFactory emf) {
		super(emf, Film.class);
	}

//	private List<String> getListString(String namedQuery) {
//		EntityManager em = getEntityManagerFactory().createEntityManager();
//		List<String> liste = em.createNamedQuery(namedQuery, String.class).getResultList();
//		em.close();
//		return liste;
//	}
//
//	private List<Film> getAllFilms(String namedQuery, String paramName, String paramValue) {
//		EntityManager em = getEntityManagerFactory().createEntityManager();
//		List<Film> films = em.createNamedQuery(namedQuery, Film.class).setParameter(paramName, paramValue)
//				.getResultList();
//		em.close();
//		return films;
//	}

	public List<Film> getAllFilms() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Film> films = em.createNamedQuery("Film.getAll", Film.class).getResultList();
		em.close();
		return films;
	}

	public List<Film> getFilmsByRealisateur(String realisateur) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Film> films = em.createNamedQuery("Film.getByRealisateur", Film.class).setParameter("realisateur", realisateur).getResultList();
		em.close();
		return films;
	}

}
