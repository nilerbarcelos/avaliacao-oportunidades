package com.nilerbarcelos.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {

	public void sendEmail(String para, String assunto, String mensagem) throws EmailException {

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.addTo(para);
		email.setFrom("oportunidadesmeuspedidos@gmail.com", "Meus Pedidos - Oportunidades");
		email.setSubject(assunto);
		email.setMsg(mensagem);
		email.setSSLOnConnect(true);
		email.setAuthentication("oportunidadesmeuspedidos@gmail.com", "#meuspedidos#");
		email.send();
	}
}