package br.com.iguana.controller;

import br.com.iguana.dtos.UserSystemDto;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.services.UserSystemService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

public class UserSystemController implements IUserSystemController {

    private static final Logger LOGGER = Logger.getLogger(UserSystemController.class);

    @Inject
    private UserSystemService service;

    @Override
    public Response all() {
        LOGGER.debug("Receiving request to get all Bank Users.");
        List<UserSystemDto> usersDto = UserSystemDto.build(service.findAll());
        return Response.ok(usersDto).build();
    }

    @Override
    public Response getById(Long id) {
        Optional<UserSystem> user = service.findById(id);
        if (user.isPresent()) {
            LOGGER.debug("Found Bank User " + user.toString());
            UserSystemDto dto = UserSystemDto.build(user.get());
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No Bank User found with id " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response create(@Valid UserSystemDto dto, @Context UriInfo uriInfo) {

        LOGGER.debug("Receiving request to create a new Bank User.");

        UserSystem userSystem = dto.buildEntity();

        service.insert(userSystem);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(userSystem.id));
        LOGGER.debug("New bank User created with URI " + builder.build().toString());

        return Response.created(builder.build()).build();
    }

    @Override
    public Response update(@Valid UserSystemDto dto) {
        UserSystem userSystem = dto.buildEntity();
        userSystem = service.update(userSystem);
        LOGGER.debug("Bank User updated with new valued " + userSystem.toString());
        return Response.ok().build();
    }

    @Override
    public Response delete(Long id) {
        service.delete(id);
        LOGGER.debug("Bank User deleted with id = " + id);
        return Response.noContent().build();
    }

}
