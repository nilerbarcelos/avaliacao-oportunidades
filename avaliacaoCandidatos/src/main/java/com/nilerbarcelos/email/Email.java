package com.nilerbarcelos.email;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.nilerbarcelos.comando.ComandoEmail;
import com.nilerbarcelos.model.Candidato;

public class Email {

	private static final String ASSUNTO = "Obrigado por se candidatar";
	private Candidato candidato;

	public Email(Candidato candidato) {
		super();
		this.candidato = candidato;
	}

	public void getEmailsParaEnviar() throws EmailException {
		List<ComandoEmail> emails = new EmailParser(this.candidato).getEmails();
		for (ComandoEmail email : emails) {
			email.executa(this);
		}
	}

	public void enviarEmailBackEnd() throws EmailException {
		String para = candidato.getEmail();
		String assunto = ASSUNTO;
		String mensagem = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Back-End entraremos em contato.";

		new EmailSender().sendEmail(para, assunto, mensagem);
	}

	public void enviarEmailFrontEnd() throws EmailException {
		String para = candidato.getEmail();
		String assunto = ASSUNTO;
		String mensagem = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Front-End entraremos em contato.";

		new EmailSender().sendEmail(para, assunto, mensagem);
	}

	public void enviarEmailMobile() throws EmailException {
		String para = candidato.getEmail();
		String assunto = ASSUNTO;
		String mensagem = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Mobile entraremos em contato.";

		new EmailSender().sendEmail(para, assunto, mensagem);
	}

	public void enviarEmailGenerico() throws EmailException {
		String para = candidato.getEmail();
		String assunto = ASSUNTO;
		String mensagem = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador entraremos em contato.";

		new EmailSender().sendEmail(para, assunto, mensagem);
	}
}
