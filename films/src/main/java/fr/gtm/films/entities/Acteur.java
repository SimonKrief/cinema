package fr.gtm.films.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "date_naissance")
	private LocalDate dateDeNaissance;
	@Column(name = "date_mort")
	private LocalDate dateDeMort;
	
	@Transient
//	@ManyToMany(mappedBy = "acteurs", cascade = CascadeType.ALL)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "film_acteur", 
	joinColumns=@JoinColumn(name = "fk_acteur"),
	inverseJoinColumns=@JoinColumn(name="fk_film"))
//	private Set<Film> films= new HashSet<>();
	private List<Film> films;
	

	public Acteur() {
	}


	public Acteur(String nom, String prenom, String civilite, LocalDate dateDeNaissance, LocalDate dateDeMort) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.dateDeNaissance = dateDeNaissance;
		this.dateDeMort = dateDeMort;

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


//	public Set<Film> getFilms() {
//		return films;
//	}
//
//
//	public void setFilms(Set<Film> films) {
//		this.films = films;
//	}
	
	


	public Long getId() {
		return id;
	}


	public List<Film> getFilms() {
		return films;
	}


	public void setFilms(List<Film> films) {
		this.films = films;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
		result = prime * result + ((dateDeMort == null) ? 0 : dateDeMort.hashCode());
		result = prime * result + ((dateDeNaissance == null) ? 0 : dateDeNaissance.hashCode());
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Acteur other = (Acteur) obj;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
		if (dateDeMort == null) {
			if (other.dateDeMort != null)
				return false;
		} else if (!dateDeMort.equals(other.dateDeMort))
			return false;
		if (dateDeNaissance == null) {
			if (other.dateDeNaissance != null)
				return false;
		} else if (!dateDeNaissance.equals(other.dateDeNaissance))
			return false;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	
	
}
