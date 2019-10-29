package fr.gtm.films.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import  fr.gtm.films.entities.*;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.istack.logging.Logger;

public class FilmDAOTest {
//	private java.util.logging.Logger LOG= new getLO
	@BeforeClass
	public static void before() {
		emf = Persistence.createEntityManagerFactory("films");
	}
	
	@AfterClass
	public static void after() {
		if (emf!=null) {
			emf.close();
		}
	}
	

	private static EntityManagerFactory emf = null;
	@Test
	public void TestFilmDAO() {
		FilmDAO dao = new FilmDAO(emf);
		assertNotNull(dao);
	}
	@Test
	public void TestAllFilms() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> liste = dao.getAllFilms();
		assertNotNull(liste);
//		assertEquals(1, liste.size());

	}
	@Test
	public void getFilmsByRealisateur() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> liste = dao.getFilmsByRealisateur("stanley kubrick");
		assertNotNull(liste);
//		assertEquals(1, liste.size());
	}
	
	@Test
	public void getActeursFilm() {
		FilmDAO dao = new FilmDAO(emf);
		Film film = dao.findById(1L);
		
//		List<Acteur> liste = film.getActeurs();
		Map<String, Acteur> liste = film.getActeurs();
		assertNotNull(liste);
		System.out.println(liste.toString());
//		Acteur acteur = liste.get("astronaute");
//		assertEquals(liste[0], acteur);
		assertTrue(liste.containsKey("astronaute"));
	
	}
	
	@Test
	public void createFilm() {
		FilmDAO dao = new FilmDAO(emf);
		
		List<Film> liste = dao.getAllFilms();
		int avant = liste.size();
		
		
		Film film = new Film();
		film.setTitre("Pupstar");
		Map<String, Acteur> acteurs = new HashMap<String, Acteur>();
		Acteur Pug = new Acteur("Pug", "Daddy","Mr");
		acteurs.put("chien", Pug);
		film.setActeurs(acteurs);
		dao.create(film);
		
		
		List<Film> liste2 = dao.getAllFilms();
		int apres = liste2.size();
		
		assertTrue("chaine"+apres+avant,apres==avant+1);
	}
	
	@Test
	public void deleteFilm() {
		FilmDAO dao = new FilmDAO(emf);
		
		List<Film> liste = dao.getAllFilms();
		int avant = liste.size();
		

		Film toDelete = liste.get(liste.size() - 1);
		dao.delete(toDelete.getId());
		
		
		List<Film> liste2 = dao.getAllFilms();
		int apres = liste2.size();
		
		assertTrue("chaine"+apres+avant,apres==avant-1);
	}
	
//	@Test
//	public void updateFilm() {
//		FilmDAO dao = new FilmDAO(emf);
//		Film toUpdate = dao.getFilmsByName("Pupstar");
//		toUpdate.setDuree(200);
//		assertEquals(200, toUpdate.getDuree());	
//		
//	}
	
	
	

	
	
//	@Test
//	public void testGetTitre() {
//
//		
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetActeurs() {
//		fail("Not yet implemented");
//	}

}
