package com.nilerbarcelos.comando;

import org.apache.commons.mail.EmailException;

import com.nilerbarcelos.email.Email;

public interface ComandoEmail {

	public void executa(final Email email) throws EmailException;
}