package br.serpro.gov.microstrategy.novosiafi.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.DemoiselleException;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.serpro.gov.microstrategy.novosiafi.business.SecurityBC;

@ViewController
public class LoginMB {

	private String login;
	private String password;

	@Inject
	private SecurityBC securityBC;
	
	@Inject
	private MessageContext messageContext;
	
	public String login() {

		if (this.securityBC.login(this.login, this.password)) {

			return "./index.xhtml";

		} else {

			messageContext.add("Login/Senha inválido!");
			return null;

		}

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
