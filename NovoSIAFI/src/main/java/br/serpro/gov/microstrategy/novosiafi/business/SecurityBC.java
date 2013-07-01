package br.serpro.gov.microstrategy.novosiafi.business;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;

@BusinessController
@ApplicationScoped
@Named
public class SecurityBC {
	
	private static final String NONE = "NONE";
	private static final String TOKEN_KEY = "123456";
	
	private static ArrayList<String> authenticatedUsers;
	private static String userLogged;
	
	@PostConstruct
	public void init() {
		authenticatedUsers = new ArrayList<String>();
		userLogged = NONE;
	}

	public boolean login(String login, String password) {
		
		if (login != null && password != null && login.equalsIgnoreCase(password)) {
			
			authenticatedUsers.add(login);
			userLogged = login;
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public Boolean isLogged(String token) {
		
		// Desencriptando token para gerar usuário...
		String usuario = token.replace(TOKEN_KEY, "");
		
		return authenticatedUsers.contains(usuario);
		
	}
	
	public String generateToken() {

		// Encriptando usuário para gerar token...
		return userLogged + TOKEN_KEY;
		
	}
	
}
