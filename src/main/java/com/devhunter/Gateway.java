package com.devhunter;

import org.jboss.logging.Logger;

import com.devhunter.Account.AccountHandler;
import com.devhunter.Payload.LoginRequest;
import com.devhunter.Payload.GatewayResponse;
import com.devhunter.Payload.WellInfoRequest;

import io.quarkus.runtime.Startup;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
        LoginRequest defaultAccount = new LoginRequest("admin", "admin");
        accountHandler.addUser(defaultAccount.getUsername(), defaultAccount.getPlaintextPassword());
        logger.info("Default Test User Created: " + defaultAccount.toJsonString());
    }

    /**
     * route a GUI request to login
     * 
     * @param username
     * @param plaintextPassword
     * @return
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public GatewayResponse login(LoginRequest account) {
        if (accountHandler.tryLogin(account.getUsername(), account.getPlaintextPassword())) {
            return new GatewayResponse(true, "Login Success");
        } else {
            return new GatewayResponse(false, "Login Failed");
        }
    }

    /**
     * route a GUI request for Well Management
     * 
     * @param username
     * @param plaintextPassword
     * @return
     */
    @POST
    @Path("/well")
    @Produces(MediaType.APPLICATION_JSON)
    public GatewayResponse wellManagementRequest(WellInfoRequest wellInfo) {
        logger.info("Routing Well Request: " + wellInfo.toJsonString());
        return new GatewayResponse(true, "WellInfo received");
    }
}
