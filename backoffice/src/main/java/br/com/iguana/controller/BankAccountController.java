package br.com.iguana.controller;

import br.com.iguana.dtos.BankAccountCreateDto;
import br.com.iguana.dtos.BankAccountDto;
import br.com.iguana.dtos.BankAccountDto;
import br.com.iguana.entities.BankAccount;
import br.com.iguana.entities.BankAccount;
import br.com.iguana.services.BankAccountService;
import br.com.iguana.services.BankAccountService;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class BankAccountController implements IBankAccountController {

    private static final Logger LOGGER = Logger.getLogger(BankAccountController.class);

    @Inject
    private BankAccountService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Accounts.");
        List<BankAccountDto> accountsDto = BankAccountDto.build(service.findAll());
        return Response.ok(accountsDto).build();
    }

    @Override
    public Response getById(@Parameter(description = "Bank Accounts identifier", required = true) @PathParam("id") Long id) {
        Optional<BankAccount> bankAccount = service.findById(id);
        if (bankAccount.isPresent()) {
            LOGGER.debug("Found Bank Account " + bankAccount.toString());
            BankAccountDto dto = BankAccountDto.build(bankAccount.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank Account found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountCreateDto.class))) @Valid BankAccountCreateDto dto
            , @Context UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank Account.");
        BankAccount BankAccount = BankAccountCreateDto.buildToInsert(dto);

        service.insert(BankAccount);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(BankAccount.id));
        LOGGER.debug("New bank Account created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }

    @Override
    public Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = BankAccountCreateDto.class))) @Valid BankAccountCreateDto dto) {
        BankAccount BankAccount = BankAccountCreateDto.buildToUpdate(dto);
        BankAccount = service.update(BankAccount);
        LOGGER.debug("Bank Account updated with new valued " + BankAccount.toString());
        return Response.ok().build();
    }

    @Override
    public Response delete(@Parameter(description = "Bank Account identifier", required = true) @PathParam("id") Long id) {
        service.delete(id);
        LOGGER.debug("Bank Account deleted with id = " + id);
        return Response.noContent().build();
    }

}
