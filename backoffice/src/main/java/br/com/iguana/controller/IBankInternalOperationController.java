package br.com.iguana.controller;

import br.com.iguana.dtos.BankAccountDto;
import br.com.iguana.dtos.BankInternalOperationDto;
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

@Tag(name = "Bank Internal Operation endpoint")
@Path("v1/bank/backoffice/internal/operations")
public interface IBankInternalOperationController {

    @Operation(summary = "Gell all Internal Operations", description = "Retrieve all Internal Operations.")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankInternalOperationDto.class)))
    @APIResponse(responseCode = "204", description = "No Bank Internal Operations")
    @GET
    @Produces(APPLICATION_JSON)
    Response all();

    @Operation(summary = "Returns a Bank Internal Operation for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankInternalOperationDto.class)))
    @APIResponse(responseCode = "404", description = "The Bank Internal Operation is not found for the given identifier")
    @GET
    @Path("/{id}")
    Response getById(@Parameter(description = "Bank Internal Operations identifier", required = true) @PathParam("id") Long id);

    @Operation(summary = "Creates a valid Bank Internal Operation")
    @APIResponse(responseCode = "201"
            , description = "The URI of the created Bank Internal Operation"
            , content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    Response create(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankInternalOperationDto.class))) @Valid BankInternalOperationDto dto
            , @Context UriInfo uriInfo);

}
