package br.com.iguana.controller;

import br.com.iguana.dtos.UserSystemDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "User endpoint")
@Path("v1/bank/backoffice/users")
public interface IUserSystemController {

    @Operation(summary = "Gell all Users", description = "Retrieve all Users.")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class)))
    @APIResponse(responseCode = "204", description = "No Bank Users")
    @GET
    @Produces(APPLICATION_JSON)
    Response all();

    @Operation(summary = "Returns a Bank User for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class)))
    @APIResponse(responseCode = "404", description = "The Bank User is not found for the given identifier")
    @GET
    @Path("/{id}")
    Response getById(@Parameter(description = "Bank Users identifier", required = true) @PathParam("id") Long id);

    @Operation(summary = "Creates a valid User")
    @APIResponse(responseCode = "201"
            , description = "The URI of the created User"
            , content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class))) @Valid UserSystemDto dto
            , @Context UriInfo uriInfo);

    @Operation(summary = "Updates an existing Bank User")
    @APIResponse(responseCode = "200", description = "The updated Bank User", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class)))
    @PUT
    Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserSystemDto.class))) @Valid UserSystemDto dto);

    @Operation(summary = "Deletes an existing Bank User")
    @APIResponse(responseCode = "204", description = "The Bank User has been successfully deleted")
    @DELETE
    @Path("/{id}")
    Response delete(@Parameter(description = "Bank User identifier", required = true) @PathParam("id") Long id);
}
