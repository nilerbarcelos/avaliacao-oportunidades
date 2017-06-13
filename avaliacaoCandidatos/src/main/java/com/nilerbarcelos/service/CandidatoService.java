package com.nilerbarcelos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilerbarcelos.model.Candidato;
import com.nilerbarcelos.repository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	CandidatoRepository candidatoRepository;
	
	public Candidato cadastrar(Candidato candidato) {
		return candidatoRepository.save(candidato);
	}
}
