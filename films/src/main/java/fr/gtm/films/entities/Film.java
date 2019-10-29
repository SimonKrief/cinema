package fr.gtm.films.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity@Table(name = "films")
public class Film {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_film")
	private long id;
	private String titre;
	private String realisateur;
	private LocalDate dateSortie;
	private int duree;
	
	@Transient
	private List<Acteur> acteurs;
//	@ManyToMany
//	@JoinTable(name = "film_acteur", 
//	joinColumns=@JoinColumn(name = "fk_filmr"),
//	inverseJoinColumns=@JoinColumn(name="fk_acteurs"))
//	private Set<Film> films= new HashSet<>();
//	private Set<Acteur> acteurs= new HashSet<>();
	


	public Film() {
	}

	public Film(String titre, String realisateur, LocalDate dateSortie, int duree) {
		super();
		this.titre = titre;
		this.realisateur = realisateur;
		this.dateSortie = dateSortie;
		this.duree = duree;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

//	public Set<Film> getFilms() {
//		return films;
//	}
//
//	public void setFilms(Set<Film> films) {
//		this.films = films;
//	}
//
//	public Set<Acteur> getActeurs() {
//		return acteurs;
//	}
//
//	public void setActeurs(Set<Acteur> acteurs) {
//		this.acteurs = acteurs;
//	}
	
	
	

	public long getId() {
		return id;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}



}
