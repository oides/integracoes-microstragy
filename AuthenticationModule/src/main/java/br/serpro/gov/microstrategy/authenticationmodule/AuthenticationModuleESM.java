package br.serpro.gov.microstrategy.authenticationmodule;

import java.util.ResourceBundle;

import com.microstrategy.web.app.AbstractExternalSecurity;
import com.microstrategy.web.app.ExternalSecurity;
import com.microstrategy.web.app.LoginForm;
import com.microstrategy.web.beans.RequestKeys;
import com.microstrategy.web.objects.WebIServerSession;
import com.microstrategy.web.objects.WebObjectsFactory;
import com.microstrategy.web.platform.ContainerServices;

public class AuthenticationModuleESM extends AbstractExternalSecurity {

	private static final String TEST_AUTHENTICATION_PROJECT = "MicroStrategy Tutorial";
	private static final String SSO_TOKEN_NAME = "SSO_TOKEN_NAME";
	private static final String CUSTOM_LOGIN_URL = "CUSTOM_LOGIN_URL";
	
	private static final String PROPERTIES_FILE_NAME = "ssoesm";

	private static String ssoTokenName;
	private static String customLoginURL;

	static {

		ResourceBundle props = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
		ssoTokenName = (String) props.getObject(SSO_TOKEN_NAME);
		ssoTokenName = (String) props.getObject(SSO_TOKEN_NAME);
		customLoginURL = (String) props.getObject(CUSTOM_LOGIN_URL);

	}

	public int handlesAuthenticationRequest(RequestKeys reqKeys, ContainerServices cntSvcs, int reason) {

		String projeto = reqKeys.getValue("Project");
		String token = reqKeys.getValue(ssoTokenName);

		if (TEST_AUTHENTICATION_PROJECT.equalsIgnoreCase(projeto) && SecurityClientSIAFI.isLogged(token)) {

			return ExternalSecurity.COLLECT_SESSION_NOW;

		} else {

			return ExternalSecurity.USE_CUSTOM_LOGIN_PAGE;

		}

	}

	public boolean processMSTRLoginForm(RequestKeys reqKeys, ContainerServices cntSvcs, LoginForm loginForm, int reason) {

		loginForm.setFormStatus(false);

		return true;

	}

	public WebIServerSession getWebIServerSession(RequestKeys reqKeys, ContainerServices cntSvcs) {

		WebIServerSession isess = WebObjectsFactory.getInstance().getIServerSession();

		isess.setServerName("DOADO");
		// isess.setAuthMode(EnumDSSXMLAuthModes.DssXmlAuthStandard);
		isess.setServerPort(0);
		isess.setProjectName(TEST_AUTHENTICATION_PROJECT);
		isess.setLogin("Administrator");
		isess.setPassword("");

		return isess;

	}

	public String getCustomLoginURL(String originalURL, String desiredServer, int desiredPort, String desiredProject) {
		
		return customLoginURL;
		
	}
	
}
