package com.octa.helidon;

import io.helidon.security.Principal;
import io.helidon.security.SecurityContext;

import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;


@Path("/hello")
public class HelloResource {

    @GET
    @Path("/")
    @Produces(TEXT_PLAIN)
    public String hello(@Context SecurityContext context) {
        Optional<Principal> userPrincipal = context.userPrincipal();
        return "Hello, " + userPrincipal.get().getName() + "!";
    }

}
