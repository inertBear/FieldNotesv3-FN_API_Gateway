package com.devhunter;

import org.jboss.logging.Logger;

import com.devhunter.Account.AccountHandler;

import io.quarkus.runtime.Startup;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Gateway for all connected GUIs. Routes all traffic into and out of the
 * internal services
 */
@Path("/gateway")
public class Gateway {
    private static final Logger logger = Logger.getLogger(Gateway.class);

    @Inject
    AccountHandler accountHandler;

    /**
     * FIXME: Automatic User creation on Startup
     */
    @Startup
    public void addDefaultUser() {
        accountHandler.addUser("admin", "admin");
        logger.info("Default Test User Created: [admin:admin]");
    }

    /**
     * route a GUI request to login
     * 
     * @param username
     * @param plaintextPassword
     * @return
     */
    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("username") String username, @QueryParam("password") String plaintextPassword) {
        if (accountHandler.tryLogin(username, plaintextPassword)) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }
}
