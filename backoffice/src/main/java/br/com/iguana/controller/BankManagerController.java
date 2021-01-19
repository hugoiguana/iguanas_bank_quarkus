package br.com.iguana.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import br.com.iguana.dtos.BankManagerDto;
import br.com.iguana.entities.BankManager;
import br.com.iguana.enums.Gender;
import br.com.iguana.services.BankManagerService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Manager endpoint")
@Path("v1/bank/backoffice/managers")
public class BankManagerController {

    private static final Logger LOGGER = Logger.getLogger(BankManagerController.class);

    @Inject
    private BankManagerService service;


    @Operation(summary = "Gell all managers", description = "Retrieve all managers.")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankManagerDto.class)))
    @APIResponse(responseCode = "204", description = "No Bank managers")
    @GET
    @Produces(APPLICATION_JSON)
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Managers.");
        return Response.ok(service.findAll()).build();
    }

    @Operation(summary = "Returns a Bank Manager for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankManagerDto.class)))
    @APIResponse(responseCode = "404", description = "The Bank Manager is not found for the given identifier")
    @GET
    @Path("/{id}")
    public Response getBook(@Parameter(description = "Bank Manager identifier", required = true) @PathParam("id") Long id) {
        Optional<BankManager> bankManager = service.findById(id);
        if (bankManager.isPresent()) {
            LOGGER.debug("Found Bank Manager " + bankManager.toString());
            BankManagerDto dto = BankManagerDto.build(bankManager.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank Manager found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Creates a valid BankManager")
    @APIResponse(responseCode = "201"
            , description = "The URI of the created BankManager"
            , content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    public Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankManagerDto.class))) @Valid BankManagerDto dto
            , @Context UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank Manager.");

        BankManager bankManager = dto.buildEntity();

        service.insert(bankManager);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(bankManager.id));
        LOGGER.debug("New bank manager created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }


    @Operation(summary = "Updates an existing Bank Manager")
    @APIResponse(responseCode = "200", description = "The updated Bank Manager", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankManagerDto.class)))
    @PUT
    public Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankManagerDto.class))) @Valid BankManagerDto dto) {
        BankManager bankManager = dto.buildEntity();
        bankManager = service.update(bankManager);
        LOGGER.debug("Bank Manager updated with new valued " + bankManager.toString());
        return Response.ok().build();
    }

    @Operation(summary = "Deletes an existing Bank Manager")
    @APIResponse(responseCode = "204", description = "The Bank Manager has been successfully deleted")
    @DELETE
    @Path("/{id}")
    public Response delete(@Parameter(description = "Bank Manager identifier", required = true) @PathParam("id") Long id) {
        service.delete(id);
        LOGGER.debug("Bank Manager deleted with id = " + id);
        return Response.noContent().build();
    }

}
