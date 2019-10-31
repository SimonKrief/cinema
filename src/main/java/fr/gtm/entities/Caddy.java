package fr.gtm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;

//@Singleton
//@Stateful
//@StatefulTimeout(unit = TimeUnit.MINUTES, value = 10)
@SessionScoped
public class Caddy implements Serializable {
	private FilmDTO dto;

	private static final Logger LOG = Logger.getLogger("CINEMA");
	private double selectionPrix;

	private List<FilmDTO> selectionFilm = new ArrayList<FilmDTO>();
	private HashMap<FilmDTO, Integer> FilmQuantite = new HashMap<FilmDTO, Integer>();

	public HashMap<FilmDTO, Integer> getFilmQuantite() {
		return FilmQuantite;
	}

	public void setFilmQuantite(HashMap<FilmDTO, Integer> filmQuantite) {
		FilmQuantite = filmQuantite;
	}

	public void addFilmDto(FilmDTO dto) {
//		FilmQuantite.put(dto, ++); incrementer le hashmap
		if (FilmQuantite.containsKey(dto)) {
			Integer oldValue = FilmQuantite.get(dto);
			FilmQuantite.put(dto, oldValue + 1);
		} else {
			FilmQuantite.put(dto, 1);
		}
		selectionFilm.add(dto);
	}

	public void removeFilmDto(FilmDTO dto) {
//		FilmQuantite.put(dto, ++); decrementer le hashmap
		Integer oldValue = FilmQuantite.get(dto);
		if (oldValue == null) {
			FilmQuantite.put(dto, 0);
		} else {
			FilmQuantite.put(dto, oldValue - 1);
		}
		selectionFilm.add(dto);
	}

	public Caddy() {
		LOG.info("Caddy - Constructeur : " + this);
	}

	@PostConstruct
	public void postConstruct() {
		LOG.info("Caddy - postConstruct() : " + this);
	}

	@PreDestroy
	public void preDestoy() {
		LOG.info("Caddy - preDestoy() : " + this);
	}

	@Remove
	public void remove() {
		LOG.info("Caddy - remove() : " + this);
	}

//	public void addFilmDto(FilmDTO dto) {
//		selectionFilm.add(dto);	
//	}

	public double prixTotal() {
		double p = 0;
		for (FilmDTO f : selectionFilm) {
			p += f.getPrixHT();
		}
		this.selectionPrix = p;
		return p;
	}

	public double getSelectionPrix() {
		return selectionPrix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FilmQuantite == null) ? 0 : FilmQuantite.hashCode());
		result = prime * result + ((dto == null) ? 0 : dto.hashCode());
		result = prime * result + ((selectionFilm == null) ? 0 : selectionFilm.hashCode());
		long temp;
		temp = Double.doubleToLongBits(selectionPrix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caddy other = (Caddy) obj;
		if (FilmQuantite == null) {
			if (other.FilmQuantite != null)
				return false;
		} else if (!FilmQuantite.equals(other.FilmQuantite))
			return false;
		if (dto == null) {
			if (other.dto != null)
				return false;
		} else if (!dto.equals(other.dto))
			return false;
		if (selectionFilm == null) {
			if (other.selectionFilm != null)
				return false;
		} else if (!selectionFilm.equals(other.selectionFilm))
			return false;
		if (Double.doubleToLongBits(selectionPrix) != Double.doubleToLongBits(other.selectionPrix))
			return false;
		return true;
	}




}
