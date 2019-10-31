package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;

import fr.gtm.entities.Film;
import fr.gtm.entities.FilmDAO;
import fr.gtm.entities.FilmDTO;

@Singleton
public class FilmService {
	@EJB
//	@Inject
	private FilmDAO dao;

	@Deprecated
	public List<Film> getAllFilms() {
		return dao.getAllFilms();
	}

	public List<FilmDTO> getAllFilmsDto() {
		List<FilmDTO> dtos = new ArrayList<FilmDTO>();
		List<Film> films = dao.getAllFilms();
		for (Film film : films) {
			dtos.add(new FilmDTO(film));
		}

		return dtos;
		// la methode des grands:
//		return getAllFilms().stream().map(FilmDTO::new).collect(Collectors.toList());
	}
	
	public Film getFilmById(Long id) {
		return dao.findById(id);
	}

}
