package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHOIX")
public class Choix {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String valeur;

	@ManyToOne
	@JoinColumn(name = "idChoix", nullable = false)
	private Vote vote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Choix(Long id, String valeur, Vote vote) {
		super();
		this.id = id;
		this.valeur = valeur;
		this.vote = vote;
	}

	public Choix() {
		super();
	}

}
