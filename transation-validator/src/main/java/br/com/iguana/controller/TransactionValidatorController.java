package br.com.iguana.controller;


import br.com.iguana.dtos.InternalTransactionValidatorCreateDto;
import br.com.iguana.dtos.InternalTransactionValidatorDto;
import br.com.iguana.entities.InternalTransactionValidator;
import br.com.iguana.service.IInternalTransactionValidatorService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

public class TransactionValidatorController implements ITransactionValidatorController {

    private static final Logger LOGGER = Logger.getLogger(TransactionValidatorController.class);

    @Inject
    private IInternalTransactionValidatorService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Internal Transaction Validator.");
        List<InternalTransactionValidatorDto> transactionValidatorDtos = InternalTransactionValidatorDto.build(service.findAll());
        return Response.ok(transactionValidatorDtos).build();
    }

    @Override
    public Response getById(Long id) {
        Optional<InternalTransactionValidator> transactionValidatorOpt = service.findById(id);
        if (transactionValidatorOpt.isPresent()) {
            LOGGER.debug("Found Internal Transaction Validator " + transactionValidatorOpt.toString());
            InternalTransactionValidatorDto dto = InternalTransactionValidatorDto.build(transactionValidatorOpt.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank Internal Transaction Validator with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(@Valid InternalTransactionValidatorCreateDto dto, UriInfo uriInfo) {
        LOGGER.debug("Receiving request to create a new Internal Transaction Validator.");
        InternalTransactionValidator transactionValidator = new InternalTransactionValidator();
        transactionValidator.operationId = dto.getOperationId();

        service.insert(transactionValidator);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(transactionValidator.id));
        LOGGER.debug("New Internal Transaction Validator created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }
}
