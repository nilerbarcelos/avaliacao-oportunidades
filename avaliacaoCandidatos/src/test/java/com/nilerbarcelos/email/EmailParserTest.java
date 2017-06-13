package com.nilerbarcelos.email;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.nilerbarcelos.comando.ComandoEmail;
import com.nilerbarcelos.comando.ComandoEmailBackEnd;
import com.nilerbarcelos.comando.ComandoEmailFrontEnd;
import com.nilerbarcelos.comando.ComandoEmailGenerico;
import com.nilerbarcelos.comando.ComandoEmailMobile;
import com.nilerbarcelos.model.Candidato;
import com.nilerbarcelos.model.Conhecimento;

public class EmailParserTest {

	private Candidato criarCandidatoFrontEnd() {
		Candidato candidato = new Candidato();
		candidato.setNome("Joao Silva");
		candidato.setEmail("joaosilva@silva.com");
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.HTML, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.CSS, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.JAVASCRIPT, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.PYTHON, 5));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.DJANGO, 5));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.IOS, 4));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.ANDROID, 1));

		return candidato;
	}

	private Candidato criarCandidatoBackEnd() {
		Candidato candidato = new Candidato();
		candidato.setNome("Joao Silva");
		candidato.setEmail("joaosilva@silva.com");
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.HTML, 2));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.CSS, 3));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.JAVASCRIPT, 5));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.PYTHON, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.DJANGO, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.IOS, 0));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.ANDROID, 1));

		return candidato;
	}

	private Candidato criarCandidatoMobile() {
		Candidato candidato = new Candidato();
		candidato.setNome("Joao Silva");
		candidato.setEmail("joaosilva@silva.com");
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.HTML, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.CSS, 4));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.JAVASCRIPT, 2));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.PYTHON, 9));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.DJANGO, 2));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.IOS, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.ANDROID, 8));

		return candidato;
	}

	private Candidato criarCandidatoGenerico() {
		Candidato candidato = new Candidato();
		candidato.setNome("Joao Silva");
		candidato.setEmail("joaosilva@silva.com");
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.HTML, 2));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.CSS, 3));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.JAVASCRIPT, 6));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.PYTHON, 5));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.DJANGO, 1));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.IOS, 2));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.ANDROID, 8));

		return candidato;
	}

	private Candidato criarCandidatoParaAsTresEspecialidades() {
		Candidato candidato = new Candidato();
		candidato.setNome("Joao Silva");
		candidato.setEmail("joaosilva@silva.com");
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.HTML, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.CSS, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.JAVASCRIPT, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.PYTHON, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.DJANGO, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.IOS, 8));
		candidato.adicionarConhecimentos(criarConhecimento(ConhecimentosEnum.ANDROID, 8));

		return candidato;
	}

	private Conhecimento criarConhecimento(ConhecimentosEnum tecnologia, Integer nivel) {
		Conhecimento conhecimento = new Conhecimento();
		conhecimento.setTecnologia(tecnologia);
		conhecimento.setNivel(nivel);

		return conhecimento;
	}

	@Test
	public void deveReconhecerFrontEnd() {
		EmailParser emailParser = new EmailParser(criarCandidatoFrontEnd());
		List<ComandoEmail> emails = emailParser.getEmails();

		assertEquals(emails.size(), 1);
		assertTrue(emails.get(0) instanceof ComandoEmailFrontEnd);
	}

	@Test
	public void deveReconhecerBackEnd() {
		EmailParser emailParser = new EmailParser(criarCandidatoBackEnd());
		List<ComandoEmail> emails = emailParser.getEmails();

		assertEquals(emails.size(), 1);
		assertTrue(emails.get(0) instanceof ComandoEmailBackEnd);
	}

	@Test
	public void deveReconhecerMobile() {
		EmailParser emailParser = new EmailParser(criarCandidatoMobile());
		List<ComandoEmail> emails = emailParser.getEmails();

		assertEquals(emails.size(), 1);
		assertTrue(emails.get(0) instanceof ComandoEmailMobile);
	}

	@Test
	public void deveReconhecerGenerico() {
		EmailParser emailParser = new EmailParser(criarCandidatoGenerico());
		List<ComandoEmail> emails = emailParser.getEmails();

		assertEquals(emails.size(), 1);
		assertTrue(emails.get(0) instanceof ComandoEmailGenerico);
	}

	@Test
	public void deveReconhecerAsTresEspecialidades() {
		EmailParser emailParser = new EmailParser(criarCandidatoParaAsTresEspecialidades());
		List<ComandoEmail> emails = emailParser.getEmails();

		assertEquals(emails.size(), 3);
		assertTrue(emails.get(0) instanceof ComandoEmailFrontEnd);
		assertTrue(emails.get(1) instanceof ComandoEmailBackEnd);
		assertTrue(emails.get(2) instanceof ComandoEmailMobile);
	}
}
