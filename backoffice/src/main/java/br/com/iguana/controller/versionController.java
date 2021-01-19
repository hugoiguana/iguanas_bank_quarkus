package br.com.iguana.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("version")
public class versionController {

    @GET
    public Response version() {
        return Response.ok("v1").build();
    }

}
