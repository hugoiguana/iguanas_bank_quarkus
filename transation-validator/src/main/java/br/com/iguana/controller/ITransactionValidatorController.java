package br.com.iguana.controller;

import br.com.iguana.dtos.InternalTransactionValidatorCreateDto;
import br.com.iguana.dtos.InternalTransactionValidatorDto;
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

@Tag(name = "Internal Transaction Validator endpoint")
@Path("v1/bank/internal/transactions")
public interface ITransactionValidatorController {

    @Operation(summary = "Gell all Internal Transactions Validator", description = "Retrieve all Internal Transactions Validator.")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = InternalTransactionValidatorDto.class)))
    @APIResponse(responseCode = "204", description = "No Internal Transactions Validator")
    @GET
    @Produces(APPLICATION_JSON)
    Response all();

    @Operation(summary = "Returns a Internal Transactions Validator for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = InternalTransactionValidatorDto.class)))
    @APIResponse(responseCode = "404", description = "The Internal Transactions Validator is not found for the given identifier")
    @GET
    @Path("/{id}")
    Response getById(@Parameter(description = "Internal Transactions Validator identifier", required = true) @PathParam("id") Long id);

    @Operation(summary = "Validate a Bank Internal Transaction")
    @APIResponse(responseCode = "201"
            , description = "The URI of the created Internal Transaction Validator"
            , content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = InternalTransactionValidatorCreateDto.class))) @Valid InternalTransactionValidatorCreateDto dto
            , @Context UriInfo uriInfo);
}
