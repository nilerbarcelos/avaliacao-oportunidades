package com.nilerbarcelos.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.nilerbarcelos.email.ConhecimentosEnum;
import com.nilerbarcelos.model.Candidato;
import com.nilerbarcelos.model.Conhecimento;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CandidatoControllerTest {

	private Gson gson = new Gson();

	@Autowired
	private MockMvc mockMvc;

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
	public void deveReconhecerFrontEnd() throws Exception {
		String json = gson.toJson(criarCandidatoFrontEnd());
		mockMvc.perform(
				MockMvcRequestBuilders.post("/candidatos").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveReconhecerBackEnd() throws Exception {
		String json = gson.toJson(criarCandidatoBackEnd());
		mockMvc.perform(
				MockMvcRequestBuilders.post("/candidatos").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveReconhecerMobile() throws Exception {
		String json = gson.toJson(criarCandidatoMobile());
		mockMvc.perform(
				MockMvcRequestBuilders.post("/candidatos").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveReconhecerGenerico() throws Exception {
		String json = gson.toJson(criarCandidatoGenerico());
		mockMvc.perform(
				MockMvcRequestBuilders.post("/candidatos").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveReconhecerAsTresEspecialidades() throws Exception {
		String json = gson.toJson(criarCandidatoParaAsTresEspecialidades());
		mockMvc.perform(
				MockMvcRequestBuilders.post("/candidatos").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
