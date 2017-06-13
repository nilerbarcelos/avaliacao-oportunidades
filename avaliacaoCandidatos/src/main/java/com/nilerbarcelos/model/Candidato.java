package com.nilerbarcelos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Candidato {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;

	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<Conhecimento> conhecimentos;

	public Candidato() {
		super();
		this.conhecimentos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public List<Conhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void adicionarConhecimentos(Conhecimento conhecimento) {
		this.conhecimentos.add(conhecimento);
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", email=" + email + ", conhecimentos=" + conhecimentos + "]";
	}

}
