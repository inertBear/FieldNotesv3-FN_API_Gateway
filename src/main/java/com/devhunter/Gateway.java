package com.devhunter;

import com.devhunter.Login.LoginHandler;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// fieldNotes.com/gateway/login

@Path("/gateway")
public class Gateway {

    @Inject 
    LoginHandler loginHandler;

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public String login() {
        return loginHandler.tryLogin();
    }
}
