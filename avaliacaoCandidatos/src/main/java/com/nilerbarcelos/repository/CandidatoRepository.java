package com.nilerbarcelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nilerbarcelos.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
	
}