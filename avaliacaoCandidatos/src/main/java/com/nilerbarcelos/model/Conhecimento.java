package com.nilerbarcelos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.nilerbarcelos.email.ConhecimentosEnum;

@Entity
public class Conhecimento {
	
	@Id
	@GeneratedValue
	private Integer id;
	private ConhecimentosEnum tecnologia;
	private Integer nivel;
	
	public ConhecimentosEnum getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(ConhecimentosEnum tecnologia) {
		this.tecnologia = tecnologia;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		return "Conhecimento [tecnologia=" + tecnologia + ", nivel=" + nivel + "]";
	}
	
}
