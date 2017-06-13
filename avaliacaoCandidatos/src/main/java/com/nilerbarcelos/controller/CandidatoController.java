package com.nilerbarcelos.controller;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nilerbarcelos.email.Email;
import com.nilerbarcelos.model.Candidato;
import com.nilerbarcelos.service.CandidatoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class CandidatoController {

	@Autowired
	CandidatoService candidatoService;

	@RequestMapping(method = RequestMethod.POST, value = "/candidatos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidato> cadastrarCandidato(@RequestBody Candidato candidato) {

		try {
			candidato = candidatoService.cadastrar(candidato);
			new Email(candidato).getEmailsParaEnviar();
		} catch (EmailException e) {
			return new ResponseEntity<Candidato>(candidato, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Candidato>(candidato, HttpStatus.OK);
	}
}
