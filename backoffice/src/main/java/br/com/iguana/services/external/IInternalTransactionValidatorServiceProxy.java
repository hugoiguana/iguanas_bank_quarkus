package br.com.iguana.services.external;

import br.com.iguana.services.external.Dtos.InternalTransactionValidatorCreateDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/bank/internal/transactions")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface IInternalTransactionValidatorServiceProxy {

    @POST
    Response create(InternalTransactionValidatorCreateDto dto);

}
