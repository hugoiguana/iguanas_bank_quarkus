package br.com.iguana.controller;

import br.com.iguana.dtos.BankInternalOperationDto;
import br.com.iguana.entities.BankInternalOperation;
import br.com.iguana.services.IBankInternalOperationService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

public class BankInternalOperationController implements IBankInternalOperationController {

    private static final Logger LOGGER = Logger.getLogger(BankInternalOperationController.class);

    @Inject
    private IBankInternalOperationService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Internal Operations.");
        List<BankInternalOperationDto> operationsDtos = BankInternalOperationDto.build(service.findAll());
        return Response.ok(operationsDtos).build();
    }

    @Override
    public Response getById(Long id) {
        Optional<BankInternalOperation> operationOpt = service.findById(id);
        if (operationOpt.isPresent()) {
            LOGGER.debug("Found Bank Internal Operation " + operationOpt.toString());
            BankInternalOperationDto dto = BankInternalOperationDto.build(operationOpt.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank Internal Operation found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(@Valid BankInternalOperationDto dto, UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank Internal Operation.");

        BankInternalOperation operation = dto.buildEntity();
        service.insert(operation);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(operation.id));
        LOGGER.debug("New Bank Internal Operation created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }
}
