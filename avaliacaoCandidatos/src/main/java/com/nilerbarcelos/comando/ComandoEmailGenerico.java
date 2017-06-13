package com.nilerbarcelos.comando;

import org.apache.commons.mail.EmailException;

import com.nilerbarcelos.email.Email;

public class ComandoEmailGenerico implements ComandoEmail {

	@Override
	public void executa(Email email) throws EmailException {
		email.enviarEmailGenerico();
	}

}
