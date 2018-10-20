package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="VOTE")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titre;
	
	private String description;

	@OneToMany(mappedBy = "vote", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Choix> choix;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Choix> getChoix() {
		return choix;
	}

	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}

	
	public Vote(Long id, String titre, String description, List<Choix> choix) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.choix = choix;
	}

	public Vote() {
		super();
	}

}
