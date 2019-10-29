package fr.gtm.films.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
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


@Entity@Table(name = "acteurs")
@Access(AccessType.FIELD)
public class Acteur {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_acteur")
	private Long id;
	private String nom;
	private String prenom;
	private String civilite;
	private LocalDate dateDeNaissance;
	private LocalDate dateDeMort;
	@Transient
	@ManyToMany
	@JoinTable(name = "film_acteur", 
	joinColumns=@JoinColumn(name = "fk_acteur"),
	inverseJoinColumns=@JoinColumn(name="fk_film"))
	private Set<Film> films= new HashSet<>();
	

	public Acteur() {
	}


	public Acteur(String nom, String prenom, String civilite, LocalDate dateDeNaissance, LocalDate dateDeMort,
			Set<Film> films) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.dateDeNaissance = dateDeNaissance;
		this.dateDeMort = dateDeMort;
		this.films = films;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCivilite() {
		return civilite;
	}


	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public LocalDate getDateDeMort() {
		return dateDeMort;
	}


	public void setDateDeMort(LocalDate dateDeMort) {
		this.dateDeMort = dateDeMort;
	}


	public Set<Film> getFilms() {
		return films;
	}


	public void setFilms(Set<Film> films) {
		this.films = films;
	}


	public Long getId() {
		return id;
	}

	
	
}
