package fr.gtm.films.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import  fr.gtm.films.entities.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilmDAOTest {
	
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

	}
	
	

	
	
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
