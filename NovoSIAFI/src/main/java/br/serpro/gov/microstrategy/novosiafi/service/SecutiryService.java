package br.serpro.gov.microstrategy.novosiafi.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.serpro.gov.microstrategy.novosiafi.business.SecurityBC;

@Path("/security")
public class SecutiryService {

	@Inject
	private SecurityBC securityBC; 
	
    @GET
    @Path("/isLogged/{token}")
    @Produces("application/json")
    public String isLoged(@PathParam("token") String token) {
    	
    	return this.securityBC.isLogged(token).toString();
    	
    }
	
}
