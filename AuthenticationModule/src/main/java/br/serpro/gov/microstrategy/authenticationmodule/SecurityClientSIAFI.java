package br.serpro.gov.microstrategy.authenticationmodule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecurityClientSIAFI {

	private static final String SSO_URL = "SSO_URL";
	private static final String PROPERTIES_FILE_NAME = "ssoesm";

	private static String ssoURL;

	static {

		ResourceBundle props = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
		ssoURL = (String) props.getObject(SSO_URL);

	}

	public static Boolean isLogged(String token) {

		try {

			URL url = new URL(ssoURL + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {

				return "true".equalsIgnoreCase(output);
				
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return false;

	}

}
