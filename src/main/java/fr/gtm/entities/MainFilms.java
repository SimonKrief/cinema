package fr.gtm.entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainFilms {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("films");
//		FilmDAO filmDAO = new FilmDAO(emf);
		FilmDAO filmDAO = new FilmDAO();

		Film film = filmDAO.findById(10L);
		System.out.println(film.getTitre());
		for(Role r : film.getRoles().keySet()) {
			System.out.println(r.getRole()+" : "+film.getRoles().get(r).getNom());
		}
//		emf.close();
	}

}
