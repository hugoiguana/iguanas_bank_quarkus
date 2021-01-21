package br.com.iguana.controller;

import br.com.iguana.dtos.BankAccountCreateDto;
import br.com.iguana.dtos.BankAccountTypeDto;
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

@Tag(name = "Bank Account Type endpoint")
@Path("v1/bank/backoffice/account/type")
public interface IBankAccountTypeController {

    @Operation(summary = "Gell all Accounts Type", description = "Retrieve all Accounts Type.")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountTypeDto.class)))
    @APIResponse(responseCode = "204", description = "No Bank Accounts Type")
    @GET
    @Produces(APPLICATION_JSON)
    Response all();

    @Operation(summary = "Returns a Bank Account Type for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountTypeDto.class)))
    @APIResponse(responseCode = "404", description = "The Bank Account Type is not found for the given identifier")
    @GET
    @Path("/{id}")
    Response getById(@Parameter(description = "Bank Accounts Type identifier", required = true) @PathParam("id") Long id);

    @Operation(summary = "Creates a valid Account Type")
    @APIResponse(responseCode = "201"
            , description = "The URI of the created Account Type"
            , content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountTypeDto.class))) @Valid BankAccountTypeDto dto
            , @Context UriInfo uriInfo);

    @Operation(summary = "Updates an existing Bank Account Type")
    @APIResponse(responseCode = "200", description = "The updated Bank Account Type", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountTypeDto.class)))
    @PUT
    Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountTypeDto.class))) @Valid BankAccountTypeDto dto);


    @Operation(summary = "Deletes an existing Bank Account Type")
    @APIResponse(responseCode = "204", description = "The Bank Account Type has been successfully deleted")
    @DELETE
    @Path("/{id}")
    Response delete(@Parameter(description = "Bank Account Type identifier", required = true) @PathParam("id") Long id);

}
