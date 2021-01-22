package br.com.iguana.controller;

import br.com.iguana.dtos.BankAccountTypeDto;
import br.com.iguana.entities.BankAccountType;
import br.com.iguana.services.IBankAccountTypeService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

public class BankAccountTypeController implements IBankAccountTypeController {

    private static final Logger LOGGER = Logger.getLogger(BankAccountTypeController.class);

    @Inject
    private IBankAccountTypeService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Accounts Type.");
        List<BankAccountTypeDto> accountsDto = BankAccountTypeDto.build(service.findAll());
        return Response.ok(accountsDto).build();
    }

    @Override
    public Response getById(Long id) {
        Optional<BankAccountType> bankAccount = service.findById(id);
        if (bankAccount.isPresent()) {
            LOGGER.debug("Found Bank Account Type " + bankAccount.toString());
            BankAccountTypeDto dto = BankAccountTypeDto.build(bankAccount.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank Account Type found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(@Valid BankAccountTypeDto dto, @Context UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank Account Type.");
        BankAccountType BankAccountType = dto.buildEntity();

        service.insert(BankAccountType);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(BankAccountType.id));
        LOGGER.debug("New bank Account Type created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }

    @Override
    public Response update(@Valid BankAccountTypeDto dto) {
        BankAccountType BankAccountType = dto.buildEntity();
        BankAccountType = service.update(BankAccountType);
        LOGGER.debug("Bank Account Type updated with new valued " + BankAccountType.toString());
        return Response.ok().build();
    }

    @Override
    public Response delete(Long id) {
        service.delete(id);
        LOGGER.debug("Bank Account Type deleted with id = " + id);
        return Response.noContent().build();
    }

}
