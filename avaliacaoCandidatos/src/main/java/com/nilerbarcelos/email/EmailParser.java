package com.nilerbarcelos.email;

import java.util.ArrayList;
import java.util.List;

import com.nilerbarcelos.comando.ComandoEmail;
import com.nilerbarcelos.comando.ComandoEmailBackEnd;
import com.nilerbarcelos.comando.ComandoEmailFrontEnd;
import com.nilerbarcelos.comando.ComandoEmailGenerico;
import com.nilerbarcelos.comando.ComandoEmailMobile;
import com.nilerbarcelos.model.Candidato;
import com.nilerbarcelos.model.Conhecimento;

public class EmailParser {

	private Candidato candidatoAvaliado;

	public EmailParser(Candidato candidato) {
		this.candidatoAvaliado = candidato;
	}

	public List<ComandoEmail> getEmails() {
		return analisaConhecimentos(candidatoAvaliado);
	}

	private List<ComandoEmail> analisaConhecimentos(Candidato candidatoAvaliado) {
		List<ConhecimentosEnum> conhecimentosAprovados = new ArrayList<>();

		for (Conhecimento conhecimento : candidatoAvaliado.getConhecimentos()) {
			if (conhecimento.getNivel() >= 7) {
				conhecimentosAprovados.add(conhecimento.getTecnologia());
			}
		}
		return getEmailASerEnviado(conhecimentosAprovados);
	}

	private List<ComandoEmail> getEmailASerEnviado(List<ConhecimentosEnum> conhecimentosAprovados) {
		List<ComandoEmail> emails = new ArrayList<>();

		if (isFrontEnd(conhecimentosAprovados)) {
			emails.add(new ComandoEmailFrontEnd());
		}
		if (isBackEnd(conhecimentosAprovados)) {
			emails.add(new ComandoEmailBackEnd());
		}
		if (isMobile(conhecimentosAprovados)) {
			emails.add(new ComandoEmailMobile());
		}
		if (emails.isEmpty()) {
			emails.add(new ComandoEmailGenerico());
		}

		return emails;
	}

	private boolean isMobile(List<ConhecimentosEnum> conhecimentosAprovados) {
		return conhecimentosAprovados.contains(ConhecimentosEnum.IOS)
				&& conhecimentosAprovados.contains(ConhecimentosEnum.ANDROID);
	}

	private boolean isBackEnd(List<ConhecimentosEnum> conhecimentosAprovados) {
		return conhecimentosAprovados.contains(ConhecimentosEnum.PYTHON)
				&& conhecimentosAprovados.contains(ConhecimentosEnum.DJANGO);
	}

	private boolean isFrontEnd(List<ConhecimentosEnum> conhecimentosAprovados) {
		return conhecimentosAprovados.contains(ConhecimentosEnum.HTML)
				&& conhecimentosAprovados.contains(ConhecimentosEnum.CSS)
				&& conhecimentosAprovados.contains(ConhecimentosEnum.JAVASCRIPT);
	}
}
